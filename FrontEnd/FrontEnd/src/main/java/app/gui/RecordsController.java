package app.gui;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import app.model.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.model.Student;

public class RecordsController extends AppController {

	@FXML
	private Button btnNewRecord;

	@FXML
	private Button btnBuscar;

	@FXML
	private ComboBox<String> cbFrom;

	@FXML
	private ComboBox<String> cbSearch;

	@FXML
	private ComboBox<String> cbTo;

	@FXML
	private TableView<Record> table;

	@FXML
	private TableColumn<Record, String> columnDate;

	@FXML
	private TableColumn<Record, String> columnDetails;

	@FXML
	private TableColumn<Record, Double> columnHours;

	private ObservableList<Record> data;

	private Alert errorAlert;

	private Student student;

	@FXML
	void changeToAddRecords(ActionEvent event) {
		BorderPane mainPane = (BorderPane) getParam("MAIN_SCREEN");
		mainPane.setCenter(loadScene(FXML_ADDRECORD));
	}

	@FXML
	void consultarRegistros(ActionEvent event) {
		Task<List<Record>> task = new Task<List<Record>>() {

			@Override
			protected List<Record> call() throws Exception {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String url = "http://localhost:8080/register/filter/" + student.getId() + "?filtro="
						+ cbSearch.getSelectionModel().getSelectedItem() + "&since="
						+ LocalDate.parse(cbFrom.getSelectionModel().getSelectedItem(), formatter) + "&until="
						+ LocalDate.parse(cbTo.getSelectionModel().getSelectedItem(), formatter);
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("API-KEY", "fctapikey")
						.header("Accept", "application/json").GET().build();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.registerModule(new JavaTimeModule());
				List<FCTRegister> fctRegisters = objectMapper.readValue(response.body(),
						new TypeReference<List<FCTRegister>>() {
						});
				List<Record> records = new ArrayList<>();
				for (FCTRegister fctRegister : fctRegisters) {
					Record record = new Record();
					record.setHours(fctRegister.getNumHours());
					record.setDetails(fctRegister.getDescription());
					record.setDate(fctRegister.getAssociatedDate().getDate().format(formatter));
					record.setIdRegister(fctRegister.getId());
					records.add(record);
				}
				return records;
			}

			@Override
			protected void succeeded() {
				data.setAll(getValue());
			}

			@Override
			protected void failed() {
				errorAlert.setContentText("Error consultando registros");
				errorAlert.showAndWait();
			}

		};
		new Thread(task).start();
	}

	@FXML
	void initialize() {
		cbSearch.getItems().add("TODAS");
		cbSearch.getItems().add("INCOMPLETAS");
		cbSearch.getItems().add("COMPLETAS");

		errorAlert = (Alert) getParam("ERROR_ALERT");

		student = (Student) getParam("STUDENT");

		columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		columnDetails.setCellValueFactory(new PropertyValueFactory<>("details"));
		columnHours.setCellValueFactory(new PropertyValueFactory<>("hours"));

		data = FXCollections.observableArrayList();
		table.setItems(data);

		Task<List<Record>> task = new Task<List<Record>>() {

			@Override
			protected List<Record> call() throws Exception {
				String url = "http://localhost:8080/register/filter/" + student.getId()
						+ "?filtro=TODAS&since=01/01/1999&until=30/12/2040";
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("API-KEY", "fctapikey")
						.header("Accept", "application/json").GET().build();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.registerModule(new JavaTimeModule());
				List<FCTRegister> fctRegisters = objectMapper.readValue(response.body(),
						new TypeReference<List<FCTRegister>>() {
						});
				List<Record> records = new ArrayList<>();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				List<Dates> dates = new ArrayList<>();
				for (FCTRegister fctRegister : fctRegisters) {
					dates.add(fctRegister.getAssociatedDate());
					Record record = new Record();
					record.setHours(fctRegister.getNumHours());
					record.setDetails(fctRegister.getDescription());
					record.setDate(fctRegister.getAssociatedDate().getDate().format(formatter));
					record.setIdRegister(fctRegister.getId());
					records.add(record);
				}
				addParam("DATES", dates);
				return records;
			}

			@Override
			protected void succeeded() {
				data.setAll(getValue());
				ObservableList<String> dates = FXCollections.observableArrayList();
				getValue().forEach(record -> dates.add(record.getDate()));
				;
				cbFrom.setItems(dates);
				cbFrom.setValue(dates.getFirst());
				cbTo.setItems(dates);
				cbTo.setValue(dates.getLast());
				cbSearch.setValue("TODAS");
			}

			@Override
			protected void failed() {
				errorAlert.setContentText("Error añadiendo los registros");
				errorAlert.showAndWait();
			}

		};
		new Thread(task).start();

		table.setOnMouseClicked(event -> {
			if (table.getSelectionModel().getSelectedItem() != null) {
				addParam("RECORD", table.getSelectionModel().getSelectedItem());
				BorderPane mainPane = (BorderPane) getParam("MAIN_SCREEN");
				mainPane.setCenter(loadScene(FXML_RECORD));
			}
		});
	}

}

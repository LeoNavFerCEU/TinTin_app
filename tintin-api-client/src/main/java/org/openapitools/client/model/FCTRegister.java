/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import org.openapitools.client.model.Dates;
import org.openapitools.client.model.Student;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * FCTRegister
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-03T11:33:25.839629300+01:00[Europe/Madrid]", comments = "Generator version: 7.12.0")
public class FCTRegister {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  @javax.annotation.Nullable
  private Long id;

  public static final String SERIALIZED_NAME_ASSOCIATED_STUDENT = "associatedStudent";
  @SerializedName(SERIALIZED_NAME_ASSOCIATED_STUDENT)
  @javax.annotation.Nullable
  private Student associatedStudent;

  public static final String SERIALIZED_NAME_ASSOCIATED_DATE = "associatedDate";
  @SerializedName(SERIALIZED_NAME_ASSOCIATED_DATE)
  @javax.annotation.Nullable
  private Dates associatedDate;

  public static final String SERIALIZED_NAME_NUM_HOURS = "numHours";
  @SerializedName(SERIALIZED_NAME_NUM_HOURS)
  @javax.annotation.Nullable
  private Double numHours;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  @javax.annotation.Nullable
  private String description;

  public FCTRegister() {
  }

  public FCTRegister id(@javax.annotation.Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * FCT ID. Autogenerate on POST requests
   * @return id
   */
  @javax.annotation.Nullable
  public Long getId() {
    return id;
  }

  public void setId(@javax.annotation.Nullable Long id) {
    this.id = id;
  }


  public FCTRegister associatedStudent(@javax.annotation.Nullable Student associatedStudent) {
    this.associatedStudent = associatedStudent;
    return this;
  }

  /**
   * Get associatedStudent
   * @return associatedStudent
   */
  @javax.annotation.Nullable
  public Student getAssociatedStudent() {
    return associatedStudent;
  }

  public void setAssociatedStudent(@javax.annotation.Nullable Student associatedStudent) {
    this.associatedStudent = associatedStudent;
  }


  public FCTRegister associatedDate(@javax.annotation.Nullable Dates associatedDate) {
    this.associatedDate = associatedDate;
    return this;
  }

  /**
   * Get associatedDate
   * @return associatedDate
   */
  @javax.annotation.Nullable
  public Dates getAssociatedDate() {
    return associatedDate;
  }

  public void setAssociatedDate(@javax.annotation.Nullable Dates associatedDate) {
    this.associatedDate = associatedDate;
  }


  public FCTRegister numHours(@javax.annotation.Nullable Double numHours) {
    this.numHours = numHours;
    return this;
  }

  /**
   * Get numHours
   * @return numHours
   */
  @javax.annotation.Nullable
  public Double getNumHours() {
    return numHours;
  }

  public void setNumHours(@javax.annotation.Nullable Double numHours) {
    this.numHours = numHours;
  }


  public FCTRegister description(@javax.annotation.Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @javax.annotation.Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@javax.annotation.Nullable String description) {
    this.description = description;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FCTRegister fcTRegister = (FCTRegister) o;
    return Objects.equals(this.id, fcTRegister.id) &&
        Objects.equals(this.associatedStudent, fcTRegister.associatedStudent) &&
        Objects.equals(this.associatedDate, fcTRegister.associatedDate) &&
        Objects.equals(this.numHours, fcTRegister.numHours) &&
        Objects.equals(this.description, fcTRegister.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, associatedStudent, associatedDate, numHours, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FCTRegister {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    associatedStudent: ").append(toIndentedString(associatedStudent)).append("\n");
    sb.append("    associatedDate: ").append(toIndentedString(associatedDate)).append("\n");
    sb.append("    numHours: ").append(toIndentedString(numHours)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("id");
    openapiFields.add("associatedStudent");
    openapiFields.add("associatedDate");
    openapiFields.add("numHours");
    openapiFields.add("description");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to FCTRegister
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!FCTRegister.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in FCTRegister is not found in the empty JSON string", FCTRegister.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!FCTRegister.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `FCTRegister` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `associatedStudent`
      if (jsonObj.get("associatedStudent") != null && !jsonObj.get("associatedStudent").isJsonNull()) {
        Student.validateJsonElement(jsonObj.get("associatedStudent"));
      }
      // validate the optional field `associatedDate`
      if (jsonObj.get("associatedDate") != null && !jsonObj.get("associatedDate").isJsonNull()) {
        Dates.validateJsonElement(jsonObj.get("associatedDate"));
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!FCTRegister.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'FCTRegister' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<FCTRegister> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(FCTRegister.class));

       return (TypeAdapter<T>) new TypeAdapter<FCTRegister>() {
           @Override
           public void write(JsonWriter out, FCTRegister value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public FCTRegister read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of FCTRegister given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of FCTRegister
   * @throws IOException if the JSON string is invalid with respect to FCTRegister
   */
  public static FCTRegister fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, FCTRegister.class);
  }

  /**
   * Convert an instance of FCTRegister to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


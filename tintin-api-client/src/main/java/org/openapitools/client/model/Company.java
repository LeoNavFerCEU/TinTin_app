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
 * Company
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-03T11:33:25.839629300+01:00[Europe/Madrid]", comments = "Generator version: 7.12.0")
public class Company {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  @javax.annotation.Nullable
  private Long id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  @javax.annotation.Nullable
  private String name;

  public static final String SERIALIZED_NAME_TUTOR_NAME = "tutorName";
  @SerializedName(SERIALIZED_NAME_TUTOR_NAME)
  @javax.annotation.Nullable
  private String tutorName;

  public static final String SERIALIZED_NAME_TUTOR_MAIL = "tutorMail";
  @SerializedName(SERIALIZED_NAME_TUTOR_MAIL)
  @javax.annotation.Nullable
  private String tutorMail;

  public static final String SERIALIZED_NAME_TUTOR_TLFNO = "tutorTlfno";
  @SerializedName(SERIALIZED_NAME_TUTOR_TLFNO)
  @javax.annotation.Nullable
  private String tutorTlfno;

  public static final String SERIALIZED_NAME_ACTIVE = "active";
  @SerializedName(SERIALIZED_NAME_ACTIVE)
  @javax.annotation.Nullable
  private Boolean active;

  public Company() {
  }

  public Company id(@javax.annotation.Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * Company ID. Autogenerate on POST requests
   * @return id
   */
  @javax.annotation.Nullable
  public Long getId() {
    return id;
  }

  public void setId(@javax.annotation.Nullable Long id) {
    this.id = id;
  }


  public Company name(@javax.annotation.Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }

  public void setName(@javax.annotation.Nullable String name) {
    this.name = name;
  }


  public Company tutorName(@javax.annotation.Nullable String tutorName) {
    this.tutorName = tutorName;
    return this;
  }

  /**
   * Get tutorName
   * @return tutorName
   */
  @javax.annotation.Nullable
  public String getTutorName() {
    return tutorName;
  }

  public void setTutorName(@javax.annotation.Nullable String tutorName) {
    this.tutorName = tutorName;
  }


  public Company tutorMail(@javax.annotation.Nullable String tutorMail) {
    this.tutorMail = tutorMail;
    return this;
  }

  /**
   * Get tutorMail
   * @return tutorMail
   */
  @javax.annotation.Nullable
  public String getTutorMail() {
    return tutorMail;
  }

  public void setTutorMail(@javax.annotation.Nullable String tutorMail) {
    this.tutorMail = tutorMail;
  }


  public Company tutorTlfno(@javax.annotation.Nullable String tutorTlfno) {
    this.tutorTlfno = tutorTlfno;
    return this;
  }

  /**
   * Get tutorTlfno
   * @return tutorTlfno
   */
  @javax.annotation.Nullable
  public String getTutorTlfno() {
    return tutorTlfno;
  }

  public void setTutorTlfno(@javax.annotation.Nullable String tutorTlfno) {
    this.tutorTlfno = tutorTlfno;
  }


  public Company active(@javax.annotation.Nullable Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
   */
  @javax.annotation.Nullable
  public Boolean getActive() {
    return active;
  }

  public void setActive(@javax.annotation.Nullable Boolean active) {
    this.active = active;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Company company = (Company) o;
    return Objects.equals(this.id, company.id) &&
        Objects.equals(this.name, company.name) &&
        Objects.equals(this.tutorName, company.tutorName) &&
        Objects.equals(this.tutorMail, company.tutorMail) &&
        Objects.equals(this.tutorTlfno, company.tutorTlfno) &&
        Objects.equals(this.active, company.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, tutorName, tutorMail, tutorTlfno, active);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Company {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tutorName: ").append(toIndentedString(tutorName)).append("\n");
    sb.append("    tutorMail: ").append(toIndentedString(tutorMail)).append("\n");
    sb.append("    tutorTlfno: ").append(toIndentedString(tutorTlfno)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("tutorName");
    openapiFields.add("tutorMail");
    openapiFields.add("tutorTlfno");
    openapiFields.add("active");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Company
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Company.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Company is not found in the empty JSON string", Company.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Company.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Company` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("tutorName") != null && !jsonObj.get("tutorName").isJsonNull()) && !jsonObj.get("tutorName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tutorName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tutorName").toString()));
      }
      if ((jsonObj.get("tutorMail") != null && !jsonObj.get("tutorMail").isJsonNull()) && !jsonObj.get("tutorMail").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tutorMail` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tutorMail").toString()));
      }
      if ((jsonObj.get("tutorTlfno") != null && !jsonObj.get("tutorTlfno").isJsonNull()) && !jsonObj.get("tutorTlfno").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tutorTlfno` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tutorTlfno").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Company.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Company' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Company> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Company.class));

       return (TypeAdapter<T>) new TypeAdapter<Company>() {
           @Override
           public void write(JsonWriter out, Company value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Company read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Company given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Company
   * @throws IOException if the JSON string is invalid with respect to Company
   */
  public static Company fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Company.class);
  }

  /**
   * Convert an instance of Company to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


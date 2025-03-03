# StudentApiSeviceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStudent**](StudentApiSeviceApi.md#getStudent) | **GET** /student/{idStudent} | Get student by ID |


<a id="getStudent"></a>
# **getStudent**
> StudentDto getStudent(idStudent)

Get student by ID

Returns a single student

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StudentApiSeviceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    StudentApiSeviceApi apiInstance = new StudentApiSeviceApi(defaultClient);
    Long idStudent = 56L; // Long | 
    try {
      StudentDto result = apiInstance.getStudent(idStudent);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StudentApiSeviceApi#getStudent");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **idStudent** | **Long**|  | |

### Return type

[**StudentDto**](StudentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


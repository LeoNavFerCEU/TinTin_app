# FctRegisterApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRegister**](FctRegisterApiServiceApi.md#createRegister) | **POST** /register | Add register |
| [**deleteRegister**](FctRegisterApiServiceApi.md#deleteRegister) | **DELETE** /register/{idRegister} | Delete register by ID |
| [**getRegister**](FctRegisterApiServiceApi.md#getRegister) | **GET** /register/{idRegister} | Get register by ID |
| [**getRegisterDates**](FctRegisterApiServiceApi.md#getRegisterDates) | **GET** /register/filter/{idStudent} | Gets registers of a student by ID |


<a id="createRegister"></a>
# **createRegister**
> FCTRegister createRegister(createRegisterRequest)

Add register

Returns added register

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FctRegisterApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    FctRegisterApiServiceApi apiInstance = new FctRegisterApiServiceApi(defaultClient);
    CreateRegisterRequest createRegisterRequest = new CreateRegisterRequest(); // CreateRegisterRequest | 
    try {
      FCTRegister result = apiInstance.createRegister(createRegisterRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FctRegisterApiServiceApi#createRegister");
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
| **createRegisterRequest** | [**CreateRegisterRequest**](CreateRegisterRequest.md)|  | |

### Return type

[**FCTRegister**](FCTRegister.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="deleteRegister"></a>
# **deleteRegister**
> deleteRegister(idRegister)

Delete register by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FctRegisterApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    FctRegisterApiServiceApi apiInstance = new FctRegisterApiServiceApi(defaultClient);
    Long idRegister = 56L; // Long | 
    try {
      apiInstance.deleteRegister(idRegister);
    } catch (ApiException e) {
      System.err.println("Exception when calling FctRegisterApiServiceApi#deleteRegister");
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
| **idRegister** | **Long**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="getRegister"></a>
# **getRegister**
> FCTRegister getRegister(idRegister)

Get register by ID

Returns a single register

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FctRegisterApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    FctRegisterApiServiceApi apiInstance = new FctRegisterApiServiceApi(defaultClient);
    Long idRegister = 56L; // Long | 
    try {
      FCTRegister result = apiInstance.getRegister(idRegister);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FctRegisterApiServiceApi#getRegister");
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
| **idRegister** | **Long**|  | |

### Return type

[**FCTRegister**](FCTRegister.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="getRegisterDates"></a>
# **getRegisterDates**
> List&lt;FCTRegister&gt; getRegisterDates(idStudent, filtro, since, until)

Gets registers of a student by ID

Returns a list of registers concurred between specified dates (It may be empty)

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FctRegisterApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    FctRegisterApiServiceApi apiInstance = new FctRegisterApiServiceApi(defaultClient);
    Long idStudent = 56L; // Long | 
    String filtro = "filtro_example"; // String | 
    LocalDate since = LocalDate.now(); // LocalDate | 
    LocalDate until = LocalDate.now(); // LocalDate | 
    try {
      List<FCTRegister> result = apiInstance.getRegisterDates(idStudent, filtro, since, until);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FctRegisterApiServiceApi#getRegisterDates");
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
| **filtro** | **String**|  | |
| **since** | **LocalDate**|  | |
| **until** | **LocalDate**|  | |

### Return type

[**List&lt;FCTRegister&gt;**](FCTRegister.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


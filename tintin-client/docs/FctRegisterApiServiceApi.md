# FctRegisterApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRegister**](FctRegisterApiServiceApi.md#createRegister) | **POST** /registers |  |
| [**deleteRegister**](FctRegisterApiServiceApi.md#deleteRegister) | **DELETE** /registers/{idRegister} |  |
| [**getNotRegisterDates**](FctRegisterApiServiceApi.md#getNotRegisterDates) | **GET** /registers/notregistered/{idStudent} |  |
| [**getRegisterDates**](FctRegisterApiServiceApi.md#getRegisterDates) | **GET** /registers/registered/{id} |  |


<a id="createRegister"></a>
# **createRegister**
> FCTRegister createRegister(fcTRegister)



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
    FCTRegister fcTRegister = new FCTRegister(); // FCTRegister | 
    try {
      FCTRegister result = apiInstance.createRegister(fcTRegister);
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
| **fcTRegister** | [**FCTRegister**](FCTRegister.md)|  | |

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

<a id="getNotRegisterDates"></a>
# **getNotRegisterDates**
> List&lt;Dates&gt; getNotRegisterDates(idStudent)



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
    try {
      List<Dates> result = apiInstance.getNotRegisterDates(idStudent);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FctRegisterApiServiceApi#getNotRegisterDates");
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

[**List&lt;Dates&gt;**](Dates.md)

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
> List&lt;FCTRegister&gt; getRegisterDates(id)



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
    Long id = 56L; // Long | 
    try {
      List<FCTRegister> result = apiInstance.getRegisterDates(id);
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
| **id** | **Long**|  | |

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


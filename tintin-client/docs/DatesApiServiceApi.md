# DatesApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDates**](DatesApiServiceApi.md#getDates) | **GET** /dates |  |


<a id="getDates"></a>
# **getDates**
> List&lt;Dates&gt; getDates(since, until)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DatesApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    DatesApiServiceApi apiInstance = new DatesApiServiceApi(defaultClient);
    LocalDate since = LocalDate.now(); // LocalDate | 
    LocalDate until = LocalDate.now(); // LocalDate | 
    try {
      List<Dates> result = apiInstance.getDates(since, until);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DatesApiServiceApi#getDates");
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
| **since** | **LocalDate**|  | |
| **until** | **LocalDate**|  | |

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


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


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Dates;
import java.time.LocalDate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DatesApiServiceApi
 */
@Disabled
public class DatesApiServiceApiTest {

    private final DatesApiServiceApi api = new DatesApiServiceApi();

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getDatesTest() throws ApiException {
        LocalDate since = null;
        LocalDate until = null;
        List<Dates> response = api.getDates(since, until);
        // TODO: test validations
    }

}

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
import org.openapitools.client.model.StudentDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for StudentApiSeviceApi
 */
@Disabled
public class StudentApiSeviceApiTest {

    private final StudentApiSeviceApi api = new StudentApiSeviceApi();

    /**
     * Get student by ID
     *
     * Returns a single student
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getStudentTest() throws ApiException {
        Long idStudent = null;
        StudentDto response = api.getStudent(idStudent);
        // TODO: test validations
    }

}

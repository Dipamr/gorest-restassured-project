package com.gorset.crudTest;

import com.gorset.model.UserPojo;
import com.gorset.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCrudTest extends TestBase {
    int idNumber;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
      //  RestAssured.port = 3030;
        RestAssured.basePath = "/public/v2/users";
    }
    @Test//get
    public void test001() {

        given()
                .when()
                .log().all()
                .get()
                .then().log().all().statusCode(200);
    }
    @Test//post
    public void test002(){
        UserPojo pojo = new UserPojo();
        pojo.setName("Aaryan");
        pojo.setEmail("aryan@gmail.com");
        pojo.setGender("male");
        pojo.setStatus("active");

        Response response = given()
                .log().all()
                .header("Authorization","token:abc123")
                .header("Content-Type","application/json")
                .when()
                .body(pojo)
                .post();
       response.then().statusCode(201);
        int idNumber = response.then().extract().path("id");
        System.out.println(idNumber);

    }


}

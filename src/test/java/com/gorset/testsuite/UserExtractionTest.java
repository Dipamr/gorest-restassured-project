package com.gorset.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        //RestAssured.port = 3030;
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }

    @Test//Extract the All Id
    public void test001() {
        ArrayList<Integer>ids = response.extract().path("id");
        int size =ids.size();
        System.out.println("id:"+size);
    }
    @Test//2. Extract the all Names
    public void test002(){
        ArrayList<String>names = response.extract().path("name");
        System.out.println(names);

    }
    @Test//Extract the name of 5th object
    public void test003(){
        String name = response.extract().path("[4].name");
        System.out.println("Name of 5th object is :"+name);
        Assert.assertTrue(true);
    }

    @Test//Extract the names of all object whose status = inactive
    public void test004() {
      ArrayList<String> status = response.extract().path("findAll{it.status=='inactive'}.name");
        System.out.println("The names of inactive status are :" + status);
        Assert.assertTrue(true);
    }
    @Test//5. Extract the gender of all the object whose status = active
    public void test005() {
        ArrayList<String> gender = response.extract().path("findAll{it.status=='active'}.gender");
        System.out.println("The gender whose status are :" + gender);
    }
     @Test//Print the names of the object whose gender = female
    public void test006(){
         ArrayList<String> nameGenderFemale = response.extract().path("findAll{it.gender=='female'}.name");
         System.out.println("The names of gender female are :" + nameGenderFemale);
         Assert.assertTrue(true);
     }
     @Test//Get all the emails of the object where status = inactive
    public void test007(){
         ArrayList<String> emails = response.extract().path("findAll{it.status=='inactive'}.name");
         System.out.println("The emails of inactive status are :" + emails);
         Assert.assertTrue(true);
     }
     @Test//Get the ids of the object where gender = male
    public void test008(){
         ArrayList<Integer> idsGenderMale = response.extract().path("findAll{it.gender=='male'}.id");
         System.out.println("The ids of gender male are :" + idsGenderMale);
         Assert.assertTrue(true);
     }
     @Test//Get all the status
    public void test009(){
         ArrayList<String> allStatus = response.extract().path("status");
         System.out.println("The status are :" + allStatus );
         Assert.assertTrue(true);
     }
     @Test//10. Get email of the object where name = Karthik Dubashi IV
    public void test010(){
        String email = response.extract().path("[5].email");
         System.out.println(email);
         Assert.assertTrue(true);
     }
@Test//Get gender of id = 595548
    public void test011(){
        String gender = response.extract().path("[4].gender");
    System.out.println(gender);
    Assert.assertTrue(true);
}
    }

package com.gorset.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class UserAssertionTest {
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
    @Test//Verify the if the total record is 20
    public void test001() {
        response.body("size", equalTo(10));
    }
    @Test//Verify the if the name of id = 5487 is equal to
    public void test002(){
      response.body("[0].name",equalTo("Triloki Nath Mukhopadhyay"));
    }
    @Test//Check the single ‘Name’ in the Array list (Subhashini Talwar)
    public void test003(){
        Arrays.asList("[5].name",equalTo("Miss Manikya Deshpande"));
    }
    @Test//Check the multiple ‘Names’ in the ArrayList
    public void test004(){
        response.body("[2].name", hasItem("Bhadrak Panicker Ret."));
        response.body("[3].name", hasItem("Lai Rana DC"));
    }
    @Test//Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    public void test005(){
        response.body("[4].email",equalTo("joshi_anshula@sauer.co"));
    }
    @Test//6. Verify the status is “Active” of user name is “Shanti Bhat V”
    public void test006(){
        response.body("[0].status",equalTo("inactive"));

    }
    @Test//7. Verify the Gender = male of user name is “Niro Prajapat”
    public void test007(){
        response.body("[1].gender",equalTo("female"));
    }



    }



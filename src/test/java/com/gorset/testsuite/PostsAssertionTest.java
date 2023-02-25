package com.gorset.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostsAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        //RestAssured.port = 3030;
        response = given()
                .when()
                .get("/public/v2/posts?page=1&per_page=25")
                .then().statusCode(200);
    }
    @Test//Verify the if the total record is 25//in my record coming 10
    public void test001(){
        response.body("size", equalTo(25));
    }
    @Test//Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum//not same data
    public void test002(){
       response.body("[0].title",equalTo("Subito tricesimus ut turba dolorem omnis et creber nihil ceno acquiro clementia."));
    }
    @Test
    public void test003(){
        Arrays.asList("[1].user_id",equalTo(604453));
    }
    @Test
    public void test004(){
        response.body("[0].id",equalTo(20967));
        response.body("[1].id",equalTo(20966));

    }
    @Test
    public void test005(){
        response.body("[8].body",equalTo("Copiose sumptus cotidie. Adopto aut temporibus. Coadunatio adfero voro. Culpa animus terreo. Urbs ter tibi. Spiritus adiuvo attollo. Cursus amitto pecco. Adeo comedo delicate. Testimonium voveo tepesco. Canis deserunt natus. Bonus acceptus dolorum. Coniuratio coma qui. Magni voluptas doloremque. Curiositas valde adficio. Sophismata vorago volutabrum. Umerus adopto tego."));

    }






}

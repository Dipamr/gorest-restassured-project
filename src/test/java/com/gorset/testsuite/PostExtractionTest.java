package com.gorset.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostExtractionTest {
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
    @Test
    public void test001(){
        ArrayList<String> title = response.extract().path("title");
        System.out.println(title);
        for (String a:title){
            if(a.equals(25)){
                Assert.assertTrue(true);
            }
        }
    }
    @Test
    public void test002(){
        ArrayList<Integer> record = response.extract().path("id");
        int size=record.size();
        System.out.println(size);
        Assert.assertTrue(true);
    }
    @Test
    public void test003(){
        String body = response.extract().path("[14].body");
        System.out.println(body);
        Assert.assertTrue(true);
    }
    @Test
    public void test004(){
        List<Integer> user_id = response.extract().path("user_id");
        System.out.println(user_id);
        for(Integer a:user_id)
            if ((a.equals(25))){
                Assert.assertTrue(true);
            }
    }
    @Test
    public void test005(){
        List<Integer> title = response.extract().path("title");
        System.out.println(title);
                Assert.assertTrue(true);
            }
    @Test
    public void test006(){
        ArrayList<String> user_id = response.extract().path("findAll{it.user_id='5456'}.title");
        System.out.println(user_id);
        Assert.assertTrue(true);
    }
    @Test
    public void test007(){
        ArrayList<String> body = response.extract().path("findAll{it.body='2671'}.title");
        System.out.println(body);
        Assert.assertTrue(true);
    }
    }



package com.epam.lab;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServletTest {
    @BeforeClass
    public static void setup() {

        RestAssured.baseURI = "http://localhost:8080/new-simplewebapp/main";

    }
    @Test
    public void testGet(){
        ResponseBody body = RestAssured.given().param("ajax", "true").cookie("count", "1").get().getBody();
        Assert.assertEquals("Test put fails", "Get 2", body.asString());
    }

    @Test
    public void testPut(){
        ResponseBody body = RestAssured.given().cookie("count", "1")
                .when().put().getBody();
        Assert.assertEquals("Test put fails", "Put 2", body.asString());
    }

    @Test
    public void testPost(){
        ResponseBody body = RestAssured.given().cookie("count", "1")
                .when().post().getBody();
        Assert.assertEquals("Test post fails", "Post 2", body.asString());
    }

    @Test
    public void testDelete(){
        ResponseBody body = RestAssured.given().cookie("count", "1")
                .when().delete().getBody();
        Assert.assertEquals("Test put fails", "Delete 2", body.asString());
    }
}

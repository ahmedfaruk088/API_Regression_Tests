package com.testproject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiRegressionTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    // TEST 1: GET - Tüm ürünleri getir, status code 200 olmalı
    @Test
    public void getAllProducts_statusCodeShouldBe200() {
        given()
            .log().all()
        .when()
            .get("/products")
        .then()
            .log().all()
            .statusCode(200)
            .time(lessThan(5000L));
    }

    // TEST 2: GET - Tek ürün getir, değerleri kontrol et
    @Test
    public void getProductById_shouldReturnCorrectProduct() {
        given()
        .when()
            .get("/products/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", equalTo("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"))
            .body("category", equalTo("men's clothing"))
            .body("price", notNullValue())
            .time(lessThan(5000L));
    }

    // TEST 3: GET - Kategorileri getir, liste boş olmamalı
    @Test
    public void getAllCategories_shouldNotBeEmpty() {
        given()
        .when()
            .get("/products/categories")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("$", hasItem("electronics"))
            .body("$", hasItem("jewelery"))
            .time(lessThan(5000L));
    }

    // TEST 4: GET - Kategoriye göre ürün getir
    @Test
    public void getProductsByCategory_shouldReturnElectronics() {
        given()
        .when()
            .get("/products/category/electronics")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("category", everyItem(equalTo("electronics")))
            .time(lessThan(5000L));
    }

    // TEST 5: POST - Yeni ürün oluştur (request body ile)
    @Test
    public void createProduct_shouldReturn201AndContainId() {
        String requestBody = "{\n" +
                "  \"title\": \"Test Ürünü\",\n" +
                "  \"price\": 99.99,\n" +
                "  \"description\": \"Bu bir test ürünüdür.\",\n" +
                "  \"image\": \"https://via.placeholder.com/150\",\n" +
                "  \"category\": \"electronics\"\n" +
                "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .log().all()
        .when()
            .post("/products")
        .then()
            .log().all()
            .statusCode(201)
            .body("id", notNullValue())
            .body("title", equalTo("Test Ürünü"))
            .body("price", equalTo(99.99f))
            .time(lessThan(5000L));
    }

    // TEST 6: POST - Yeni kullanıcı kaydı oluştur (request body ile)
    @Test
    public void createUser_shouldReturn200AndContainId() {
        String requestBody = "{\n" +
                "  \"email\": \"testuser@example.com\",\n" +
                "  \"username\": \"testuser\",\n" +
                "  \"password\": \"test1234\",\n" +
                "  \"name\": {\n" +
                "    \"firstname\": \"Ahmet\",\n" +
                "    \"lastname\": \"Yılmaz\"\n" +
                "  },\n" +
                "  \"phone\": \"05551234567\"\n" +
                "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .log().all()
        .when()
            .post("/users")
        .then()
            .log().all()
            .statusCode(201)
            .body("id", notNullValue())
            .time(lessThan(5000L));
    }
}
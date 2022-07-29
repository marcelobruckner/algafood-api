package com.algaworks.algafood;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaTests {

  @LocalServerPort
  private int port;

  @Before
  public void setUp() {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    RestAssured.port = port;
    RestAssured.basePath = "/cozinhas";
  }

  @Test
  public void deveRetornarStatus200_QuandoConsultarCozinhas() {

    given()
        .accept(ContentType.JSON)
        .when()
        .get()
        .then()
        .statusCode(HttpStatus.OK.value());
  }

  @Test
  public void deveConter6Cozinhas_QuandoConsultarCozinhas() {
    given()
        .accept(ContentType.JSON)
        .when()
        .get()
        .then()
        .body("", Matchers.hasSize(6));
    // .body("nome", Matchers.hasItems("Tailandesa", "Indiana", "Argentina",
    // "Brasileira"));
  }
}

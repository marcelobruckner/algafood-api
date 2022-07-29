package com.algaworks.algafood;

import static io.restassured.RestAssured.given;

import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaTests {

  @LocalServerPort
  private int port;

  @Autowired
  private Flyway flyway;

  @Before
  public void setUp() {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    RestAssured.port = port;
    RestAssured.basePath = "/cozinhas";

    flyway.migrate();
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
  public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
    given()
        .accept(ContentType.JSON)
        .when()
        .get()
        .then()
        .body("", Matchers.hasSize(4));
    // .body("nome", Matchers.hasItems("Tailandesa", "Indiana", "Argentina",
    // "Brasileira"));
  }
}

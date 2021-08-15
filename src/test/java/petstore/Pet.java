// 1 - Pacote
package petstore;

//2 - Bibliotecas

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

//3 - Classe
public class Pet {
    //3.1 - Atributos
    String url = "https://petstore.swagger.io/v2/pet"; //endereço da entidade 'Pet'

    //3.2 - Métodos e Funções
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Incluir - Create - Post
    @Test //Identifica o método/função como teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

    //Sintaxe Gherkin
        //pt: Dado - Quando - Então / en: Given - When - Then

        given()//dado
            .contentType("application/json") //comum em API REST - antigamente era "text/xml"
            .log().all()
            .body(jsonBody)
        .when()//quando
            .post(url)
        .then()//entao
                .log().all()
                .statusCode(200)
        ;
    }

}

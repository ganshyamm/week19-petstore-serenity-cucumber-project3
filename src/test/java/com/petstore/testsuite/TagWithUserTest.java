package com.petstore.testsuite;


import com.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagWithUserTest extends TestBase {
    @WithTag("Store:NEGATIVE")
    @Title("Provide a 404 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
               // .basePath(Path.USER)
                .post("/user")
                .then()
                .statusCode(404)
                .log().all();
    }
    @WithTags({
            @WithTag("Store:SMOKE"),
            @WithTag("Store:POSITIVE")
    })

    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/user")
                .then()
                .statusCode(200)
                .log().all();
    }
    @WithTags({
            @WithTag("Store:SMOKE"),
            @WithTag("Store:NEGATIVE")
    })

    @Title("This test will provide an error code of 400 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/user123")
                .then()
                .statusCode(404)
                .log().all();
    }

}

package com.petstore.productandstoreinfo;


import com.petstore.constants.EndPoints;
import com.petstore.constants.Path;
import com.petstore.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;


public class UserSteps {
    @Step("Create User")
public ValidatableResponse createUser(int id, String username, String firstname, String lastname, String email, String password, int userstatus) {
    UserPojo usersPojo = new UserPojo();
    usersPojo = UserPojo.getUserPojo(id, username, firstname, lastname, email, password, userstatus);

    return SerenityRest.given().log().all()
            .header("Content-Type", "application/json")
            .when()
            .body(usersPojo)
            .post(EndPoints.CREATE_USER)
            .then();

}

    @Step("Get user information by username")
    public ValidatableResponse getUserInfo(String username) {
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .when()
                .get(EndPoints.GET_USER_BY_USERNAME)
                .then();
    }

    @Step("Update User")
    public ValidatableResponse updateUser(int id, String username, String firstname, String lastname, String email, String password, int userstatus) {
        UserPojo usersPojo = new UserPojo();
        usersPojo = UserPojo.getUserPojo(id, username, firstname, lastname, email, password, userstatus);


        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .when()
                .body(usersPojo)
                .put(EndPoints.UPDATE_USER_BY_USERNAME)
                .then();

    }

    @Step("Delete User")
    public ValidatableResponse deleteUser(String username) {

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .when()
                .delete(EndPoints.DELETE_USER_BY_USERNAME)
                .then();

    }

}



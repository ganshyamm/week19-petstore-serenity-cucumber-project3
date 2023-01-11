package com.petstore.productandstoreinfo;


import com.petstore.constants.EndPoints;
import com.petstore.constants.Path;
import com.petstore.model.PetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class PetSteps {
    @Step("Create pet")
    public ValidatableResponse createPet(int id, String name, int cid,  String cname, String photourl, int tid,
                                         String tname, String status){
       PetPojo petPojo = new PetPojo();
        petPojo=petPojo.getPetPojo(id,name,cid,cname,photourl,tid,tname,status);

        return  SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body(petPojo)
                .post(EndPoints.GET_ALL_PET)
                .then();
    }
    @Step("Get Newly Created Pet by id")
    public ValidatableResponse getPetById(int id){
        return  SerenityRest.given().log().all()
                .pathParam("petID",id)
                .when()
                .get(EndPoints.GET_SINGLE_PET_BY_ID)
                .then();


    }
    @Step("Update Pet")
    public ValidatableResponse updatePet(int id, String name, int cid,  String cname, String photourl, int tid,
                                         String tname, String status){
      PetPojo petPojo = new PetPojo();
        petPojo=PetPojo.getPetPojo(id,name,cid,cname,photourl,tid,tname,status);


        return  SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body(petPojo)
                .put(EndPoints.UPDATE_PET_BY_ID)
                .then();

    }
    @Step("Delete Pet")
    public ValidatableResponse deletePet(int id){

        return  SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .pathParam("petID",id)
                .when()
                .delete(EndPoints.DELETE_PET_BY_ID)
                .then();

    }
}

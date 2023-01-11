package com.petstore.testsuite;

import com.petstore.productandstoreinfo.PetSteps;

import com.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UseTestDataFrom("src/test/java/resources/testdata/petinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class PetDataDrivenTest extends TestBase {

    private int id;
    private String name;
    private int cid;
    private String cname;
    private String photourl;
    private int tid;
    private String tname;
    private String status;


    @Steps
    PetSteps petSteps;

    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultiplepets() {

        petSteps.createPet(id,name,cid,cname, photourl,tid,tname, status).statusCode(200);
    }}

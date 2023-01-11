package com.petstore.testsuite;


import com.petstore.productandstoreinfo.UserSteps;
import com.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@UseTestDataFrom("src/test/java/resources/testdata/userinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class UserDataDrivenTest extends TestBase {
    private int Id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private int userstatus;


    @Steps
    UserSteps userSteps;
    @Title("Data driven test for adding multiple user to the store")
    @Test
    public void createMultipleUsers(){
        userSteps.createUser(Id,username,firstname,lastname,email,password,userstatus).statusCode(200);




    }


}

package com.swag.pe.definitions;

import com.swag.pe.steps.login.LoginStep;
import com.swag.pe.steps.validation.ValidationStep;
import com.swag.pe.utilities.website.WebSite;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class LoginDef {
    @Steps
    WebSite url;
    @Steps
    LoginStep login;
    @Steps
    ValidationStep validate;
    @Given("el usuario navega al sitio web")
    public void userNavigateTo(){
    url.navigateTo("https://www.saucedemo.com/");
    }
    @When("ingresa credenciales validas")
    public void userLoginWthValidCredentials(){
        login.typeUsername("standard_user");
        login.typePassword("secret_sauce");
        login.clickLogin();
    }
    @Then("la aplicacion deberia mostrar el modulo principal de productos")
    public void systemShowProductModule(){
        Assert.assertTrue(validate.titleIsVisible());
    }
    @When("ingresa credenciales invalidas")
    public void userLoginWthInvalidCredentials() {
    login.typeUsername("standard_user");
    login.typePassword("123434");
    login.clickLogin();
    }
    @Then("la aplicacion deberia mostrar un mensaje de error")
    public void systemShowErrorMessage(){
        Assert.assertTrue(validate.errorMessageIsDisplayed());
    }

    @When("ingresa el usuario {string} y la clave {string}")
    public void loginWith(String username, String password) {
        login.typeUsername(username);
        login.typePassword(password);
        login.clickLogin();
    }
    @Then("el mensaje de error indica {string}")
    public void verifyError(String expected) {
        Assert.assertEquals(expected, validate.errorMessageText());
    }
}

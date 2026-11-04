package com.swag.pe.steps.validation;

import com.swag.pe.pages.validations.ValidationPage;
import net.serenitybdd.annotations.Step;

public class ValidationStep extends ValidationPage {
    @Step("Validar visualizacion del modulo de productos")
    public Boolean titleIsVisible() {
        return lbl_product.waitUntilVisible().getText().equals("Products");
    }
    @Step("Validar visualizacion del mensaje de error")
    public Boolean errorMessageIsDisplayed(){
        return lbl_errorMessage.isDisplayed();
    }

    @Step("Validar contenido del error")
    public String errorMessageText() {
        return lbl_errorMessage.waitUntilVisible().getText();
    }
}

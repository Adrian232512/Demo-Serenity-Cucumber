package com.swag.pe.definitions;

import com.swag.pe.pages.product.SelectProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ProductsDef {
    @Steps
    SelectProductsPage products;

    @When("agrega productos al carrito de compras")
    public void addProducts() { products.addProducts(); }
    @When("da click en el icono del carrito")
    public void openCart() { products.openCart(); }
    @Then("el sistema deberia listar los productos agregados en el carrito de compras")
    public void verifyProducts() { products.verifyProducts(); }
    @Then("el sistema deberia mostrar la cesta sin productos")
    public void verifyEmptyCart() { products.verifyEmptyCart(); }
    @When("elimina un producto del carrito")
    public void removeProduct() { products.removeProduct(); }
    @Then("el carrito conserva solamente el otro producto")
    public void verifyRemainingProduct() { products.verifyRemainingProduct(); }
    @When("completa la compra con sus datos")
    public void checkout() { products.checkout(); }
    @Then("el sistema muestra la confirmacion de compra exitosa")
    public void verifyConfirmation() { products.verifyConfirmation(); }
}

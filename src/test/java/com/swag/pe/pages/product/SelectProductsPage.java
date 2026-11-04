package com.swag.pe.pages.product;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;

public class SelectProductsPage extends PageObject {
    @Step("Agregar mochila y luz al carrito")
    public void addProducts() {
        $("#add-to-cart-sauce-labs-backpack").click();
        $("#add-to-cart-sauce-labs-bike-light").click();
        Assert.assertEquals("2", $(".shopping_cart_badge").getText());
    }

    @Step("Abrir el carrito")
    public void openCart() {
        $(".shopping_cart_link").click();
        $(".title").waitUntilVisible();
        Assert.assertEquals("Your Cart", $(".title").getText());
    }

    private List<String> productNames() {
        return findAll(By.cssSelector(".cart_item .inventory_item_name"))
                .stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    @Step("Verificar nombres y cantidades del carrito")
    public void verifyProducts() {
        Assert.assertEquals(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light"), productNames());
        findAll(By.cssSelector(".cart_quantity")).forEach(quantity -> Assert.assertEquals("1", quantity.getText()));
    }

    @Step("Verificar carrito vacio")
    public void verifyEmptyCart() {
        Assert.assertTrue("El carrito debe estar vacio", productNames().isEmpty());
        Assert.assertTrue(findAll(By.cssSelector(".shopping_cart_badge")).isEmpty());
    }

    @Step("Eliminar mochila")
    public void removeProduct() { $("#remove-sauce-labs-backpack").click(); }

    @Step("Verificar producto restante")
    public void verifyRemainingProduct() {
        Assert.assertEquals(List.of("Sauce Labs Bike Light"), productNames());
        Assert.assertEquals("1", $(".shopping_cart_badge").getText());
    }

    @Step("Completar checkout y verificar resumen")
    public void checkout() {
        $("#checkout").click();
        $("#first-name").type("Ana");
        $("#last-name").type("Prueba");
        $("#postal-code").type("0000");
        $("#continue").click();
        verifyProducts();
        Assert.assertEquals("Item total: $39.98", $(".summary_subtotal_label").getText());
        $("#finish").click();
    }

    @Step("Verificar confirmacion de compra")
    public void verifyConfirmation() {
        Assert.assertEquals("Thank you for your order!", $(".complete-header").waitUntilVisible().getText());
        Assert.assertTrue(findAll(By.cssSelector(".shopping_cart_badge")).isEmpty());
    }
}

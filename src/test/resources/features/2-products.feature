@Suite @Products
Feature: CP02- Validar carrito de compras
  Background:
    Given el usuario navega al sitio web
    When ingresa credenciales validas

  Scenario: Listar los productos agregados al carrito
    When agrega productos al carrito de compras
    And da click en el icono del carrito
    Then el sistema deberia listar los productos agregados en el carrito de compras

  Scenario: Mostrar el carrito vacio
    When da click en el icono del carrito
    Then el sistema deberia mostrar la cesta sin productos

  Scenario: Quitar un producto del carrito
    When agrega productos al carrito de compras
    And da click en el icono del carrito
    And elimina un producto del carrito
    Then el carrito conserva solamente el otro producto

  Scenario: Completar una compra
    When agrega productos al carrito de compras
    And da click en el icono del carrito
    And completa la compra con sus datos
    Then el sistema muestra la confirmacion de compra exitosa

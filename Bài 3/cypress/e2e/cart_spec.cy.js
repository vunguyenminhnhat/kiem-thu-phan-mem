describe("Cart Test", () => {
  beforeEach(() => {
    cy.visit("https://www.saucedemo.com");
    cy.get("#user-name").type("standard_user");
    cy.get("#password").type("secret_sauce");
    cy.get("#login-button").click();
  });
  it("Should add a product to the cart", () => {
    cy.get(".inventory_item").first().find(".btn_inventory").click();

    cy.get(".shopping_cart_badge").should("have.text", "1");
  });
  it("Should sort products by price low to high", () => {
    cy.get(".product_sort_container").select("lohi");

    cy.get(".inventory_item_price").first().should("have.text", "$7.99");
  });
  it("Should remove product from the cart", () => {
    // Add product
    cy.get(".inventory_item").first().find(".btn_inventory").click();

    // Remove product
    cy.get(".btn_inventory").contains("Remove").click();

    // Verify cart is empty
    cy.get(".shopping_cart_badge").should("not.exist");
  });
  it("Should complete checkout step one successfully", () => {
    // Add product
    cy.get(".inventory_item").first().find(".btn_inventory").click();

    // Go to cart
    cy.get(".shopping_cart_link").click();

    // Click Checkout
    cy.get("#checkout").click();

    // Fill checkout info
    cy.get("#first-name").type("John");
    cy.get("#last-name").type("Doe");
    cy.get("#postal-code").type("12345");

    // Continue
    cy.get("#continue").click();

    // Verify redirect
    cy.url().should("include", "/checkout-step-two.html");
  });
});

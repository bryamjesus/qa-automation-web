package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps {

    private WebDriver driver;

    //Constructor
    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * // El doble asterisco es para documentar
     * Escribir el usuario
     *
     * @param user el usuario
     */

    public void typeUser(String user) {
        WebElement userinputElement = driver.findElement(LoginPage.userInput);
        userinputElement.sendKeys(user);
    }

    /**
     * Escribir el password
     *
     * @param password el password del usuario
     */

    public void typePasswor(String password) {
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer clic en el boton login
     */
    public void login() {
        this.driver.findElement(LoginPage.loginButton).click();
    }
}

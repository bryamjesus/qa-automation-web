package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepsDef {

    private WebDriver driver;
    private Scenario scenario;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Before (order = 0)
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\ESTUDIO\\CURSOS\\NTTDATA\\kk\\qa-lab-selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before (order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Dado("que me encuentro en la página de login e aaucedemo")
    public void que_me_encuentro_en_la_página_de_login_e_aaucedemo() {
        driver.get("https://www.saucedemo.com/");
        screenShot();
    }

    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePasswor(password);
        loginSteps.login();


    }

    @Entonces("valido que deberia aparecer el título e {string}")
    public void valido_que_deberia_aparecer_el_título_e(String expectedtitle) {
        String title = inventorySteps(driver).getTitle();
        Assertions.assertEquals(expectedtitle,title);

    }

    @Y("también valio que al menos exista un item")
    public void también_valio_que_al_menos_exista_un_item() {
        int itemsListSize = inventorySteps(driver).getItemSize();
        screenShot();
        Assertions.assertTrue(itemsListSize > 0, "El tamaños de las lista es: "+ itemsListSize);
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia,"image/png","evidencia");
    }

}

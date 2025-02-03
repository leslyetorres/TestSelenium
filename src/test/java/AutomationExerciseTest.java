import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CommonActionPages;
import pages.HomeAutomationExercisePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomationExerciseTest {
    private WebDriver driver;
    HomeAutomationExercisePage homeAutomationExercisePage;

    @BeforeEach
    public void setUp(){
        homeAutomationExercisePage = new HomeAutomationExercisePage(driver);
        driver = homeAutomationExercisePage.chromeDriverConexion();
        homeAutomationExercisePage.visitarPagina("https://automationexercise.com/");

        assertEquals("Home", homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtMenuSelected));

    }
    @Test
    public void registro(){
        homeAutomationExercisePage.ingresarLoginSignup();
        assertEquals("New User Signup!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtSignUp));
        homeAutomationExercisePage.registro("LESLYE.TORRES20011@GMAIL.COM","LESLYE TORRES");

        assertEquals("ENTER ACCOUNT INFORMATION",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtAccountInformation));
        homeAutomationExercisePage.formularioRegistro("Lt123456",
                                                        "26",
                                                        "8",
                                                        "2000",
                                                        "LESLYE KRISTINA",
                                                        "TORRES CASANOVA",
                                                        "Sofka",
                                                        "Av Trujillo",
                                                        "Calle Arguelles",
                                                        "Canada",
                                                         "Colombia",
                                                          "Medellin y Bogota",
                                                        "09129212",
                                                    "0986744199");
        assertEquals("ACCOUNT CREATED!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtAccountCreated));
        homeAutomationExercisePage.loginAutomatico();
        assertEquals("LESLYE TORRES",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtUserLogged));
        homeAutomationExercisePage.eliminarCuenta();
        assertEquals("ACCOUNT DELETED!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtAccountDeleted));


        homeAutomationExercisePage.esperarTiempo(10);
    }
    @Test
    public void registroEmailExistente(){
        homeAutomationExercisePage.ingresarLoginSignup();
        assertEquals("New User Signup!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtSignUp));
        homeAutomationExercisePage.registro("USUARIO.EXISTENTE@GMAIL.COM","LESLYE TORRES");
        homeAutomationExercisePage.esperarTiempo(10);
        assertEquals("Email Address already exist!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.msgEmailExist));

    }
    @Test
    public void loginExitoso(){
        homeAutomationExercisePage.ingresarLoginSignup();
        assertEquals("Login to your account",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtLogin));
        homeAutomationExercisePage.login("LESLYE.TORRES2000@GMAIL.COM","Lt123456");
        assertEquals("LESLYE TORRES",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtUserLogged));
       /* homeAutomationExercisePage.eliminarCuenta();
        assertEquals("ACCOUNT DELETED!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtAccountDeleted));*/
    }
    @Test
    public void loginNoExitoso(){
        homeAutomationExercisePage.ingresarLoginSignup();
        assertEquals("Login to your account",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.txtLogin));
        homeAutomationExercisePage.login("CORREO-INCORRECTO@GMAIL.COM","Lt123456");
        assertEquals("Your email or password is incorrect!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.msgLoginError));

    }

    @AfterEach
    public void tearDown() {
            driver.quit();

    }
}

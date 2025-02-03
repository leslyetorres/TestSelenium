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

        assertEquals("Automation Exercise", homeAutomationExercisePage.obtenerTitulo());

    }
    @Test
    public void registro(){
        homeAutomationExercisePage.ingresarLoginSignup();
        assertEquals("New User Signup!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.signUp));
        homeAutomationExercisePage.registro("LESLYE.TORRES2001@GMAIL.COM","LESLYE TORRES");

        assertEquals("ENTER ACCOUNT INFORMATION",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.accountInformation));
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
        assertEquals("ACCOUNT CREATED!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.accountCreated));
        homeAutomationExercisePage.eliminarCuenta();
        assertEquals("ACCOUNT DELETED!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.accountDeleted));


        homeAutomationExercisePage.esperarTiempo(10);
    }
    @Test
    public void registroEmailExistente(){
        homeAutomationExercisePage.ingresarLoginSignup();
        assertEquals("New User Signup!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.signUp));
        homeAutomationExercisePage.registro("USUARIO.EXISTENTE@GMAIL.COM","LESLYE TORRES");
        homeAutomationExercisePage.esperarTiempo(10);
        assertEquals("Email Address already exist!",homeAutomationExercisePage.obtenerTexto(homeAutomationExercisePage.mensajeEmailExistente));

    }
    @AfterEach
    public void tearDown() {
            driver.quit();

    }
}

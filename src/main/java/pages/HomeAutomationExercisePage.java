package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomeAutomationExercisePage extends CommonActionPages{
    By cajaNombres = By.xpath("//input[@data-qa='signup-name']");
    By cajaEmail = By.xpath("//input[@data-qa='signup-email']");
    By botonSignUp = By.xpath("//a[@href='/login']");
    By Genero = By.xpath("//input[@id='id_gender2']");
    By cajaPassword = By.xpath("//input[@data-qa='password']");
    By listaDia = By.xpath("//select[@data-qa='days']");
    By listaMes = By.xpath("//select[@data-qa='months']");
    By listaAnio = By.xpath("//select[@data-qa='years']");
    By checkNewsletter = By.xpath("//input[@id='newsletter']");
    By checkOffers = By.xpath("//input[@id='optin']");
    By cajaNombre = By.xpath("//input[@data-qa='first_name']");
    By cajaApellido = By.xpath("//input[@data-qa='last_name']");
    By cajaCompania = By.xpath("//input[@data-qa='company']");
    By cajaDireccion = By.xpath("//input[@data-qa='address']");
    By cajaDireccion2 = By.xpath("//input[@data-qa='address2']");
    By cajaCountry = By.xpath("//select[@data-qa='country']");
    By cajaEstado = By.xpath("//input[@data-qa='state']");
    By cajaCiudad = By.xpath("//input[@data-qa='city']");
    By cajaCodigo = By.xpath("//input[@data-qa='zipcode']");
    By cajaCelular = By.xpath("//input[@data-qa='mobile_number']");
    By botonCreateAccount = By.xpath("//button[@data-qa='create-account']");
    By botonContinuar = By.xpath("//a[@data-qa='continue-button']");
    By botonDeleteAccount = By.xpath("//a[@href='/delete_account']");
    public By signUp = By.xpath("//div[@class='signup-form']//h2");
    public By accountInformation = By.xpath("//div[@class='login-form']//b");
    public By accountCreated = By.xpath("//H2[@data-qa='account-created']");
    public By usuarioLogueado = By.xpath("//li//b");
    public By accountDeleted = By.xpath("//h2//b");
    public By mensajeEmailExistente = By.xpath("//form[@action = '/signup']//p");
    public HomeAutomationExercisePage(WebDriver driver) {
        super(driver);
    }
    public void ingresarLoginSignup(){
        Presionar(botonSignUp);
    }
    public void registro(String email, String nombreCompleto){
        limpiarCajaTexto(cajaNombres);
        limpiarCajaTexto(cajaEmail);
        escribirTexto(cajaEmail,email);
        escribirTexto(cajaNombres,nombreCompleto);
        enviarTexto(cajaEmail);


    }
    public void formularioRegistro(String contrasena, String valordia,String valormes, String valoranio,String nombre,String apellido, String empresa, String address, String address2,String country,String State, String City,String zipcode, String mobileNumber){
        Presionar(Genero);
        escribirTexto(cajaPassword, contrasena);
        seleccionar(listaDia, valordia);
        seleccionar(listaMes, valormes);
        seleccionar(listaAnio, valoranio);
        Presionar(checkNewsletter);
        Presionar(checkOffers);
        escribirTexto(cajaNombre,nombre);
        escribirTexto(cajaApellido,apellido);
        escribirTexto(cajaCompania,empresa);
        escribirTexto(cajaDireccion,address);
        escribirTexto(cajaDireccion2,address2);
        seleccionar(cajaCountry,country);
        escribirTexto(cajaEstado,State);
        escribirTexto(cajaCiudad,City);
        escribirTexto(cajaCodigo,zipcode);
        escribirTexto(cajaCelular,mobileNumber);
        Presionar(botonCreateAccount);
    }
    public void eliminarCuenta(){

        Presionar(botonContinuar);
        Presionar(botonDeleteAccount);
    }

}

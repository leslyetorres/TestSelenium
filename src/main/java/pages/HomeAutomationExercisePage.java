package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomeAutomationExercisePage extends CommonActionPages{
    By btnSignUp = By.xpath("//a[@href='/login']");
    //elementos de flujo de registro
    By boxNames = By.xpath("//input[@data-qa='signup-name']");
    By boxEmail = By.xpath("//input[@data-qa='signup-email']");
    By boxGender = By.xpath("//input[@id='id_gender2']");
    By boxPassword = By.xpath("//input[@data-qa='password']");
    By listDay = By.xpath("//select[@data-qa='days']");
    By listaMonth = By.xpath("//select[@data-qa='months']");
    By listYear = By.xpath("//select[@data-qa='years']");
    By checkNewsletter = By.xpath("//input[@id='newsletter']");
    By checkOffers = By.xpath("//input[@id='optin']");
    By boxFirstName = By.xpath("//input[@data-qa='first_name']");
    By boxSecondName = By.xpath("//input[@data-qa='last_name']");
    By boxCompany = By.xpath("//input[@data-qa='company']");
    By boxAdress = By.xpath("//input[@data-qa='address']");
    By boxAdress2 = By.xpath("//input[@data-qa='address2']");
    By boxCountry = By.xpath("//select[@data-qa='country']");
    By boxEstate = By.xpath("//input[@data-qa='state']");
    By boxCity = By.xpath("//input[@data-qa='city']");
    By boxZipcode = By.xpath("//input[@data-qa='zipcode']");
    By boxMobile = By.xpath("//input[@data-qa='mobile_number']");
    By btnCreateAccount = By.xpath("//button[@data-qa='create-account']");
    By btnContinue = By.xpath("//a[@data-qa='continue-button']");
    By btnDeleteAccount = By.xpath("//a[@href='/delete_account']");

    public By txtMenuSelected = By.xpath("//a[@style='color: orange;']");
    public By txtSignUp = By.xpath("//div[@class='signup-form']//h2");
    public By txtAccountInformation = By.xpath("//div[@class='login-form']//b");
    public By txtAccountCreated = By.xpath("//H2[@data-qa='account-created']");
    public By txtUserLogged = By.xpath("//li//b");
    public By txtAccountDeleted = By.xpath("//h2//b");
    public By msgEmailExist = By.xpath("//form[@action = '/signup']//p");

    //elementos de flujo login
    By boxEmailLogin = By.xpath("//input[@data-qa='login-email']");
    By boxPasswordLogin = By.xpath("//input[@data-qa='login-password']");
    public By txtLogin = By.xpath("//div[@class='login-form']//h2");
    public By msgLoginError = By.xpath("//form[@action = '/login']//p");



    public HomeAutomationExercisePage(WebDriver driver) {
        super(driver);
    }
    public void ingresarLoginSignup(){
        Presionar(btnSignUp);
    }
    public void registro(String email, String name){
        limpiarCajaTexto(boxNames);
        limpiarCajaTexto(boxEmail);
        escribirTexto(boxEmail,email);
        escribirTexto(boxNames,name);
        enviarTexto(boxNames);


    }
    public void formularioRegistro(String password, String valueDay,String valueMonth, String valueYear,String firstName,String secondName, String company, String address, String address2,String country,String State, String City,String zipcode, String mobileNumber){
        Presionar(boxGender);
        escribirTexto(boxPassword, password);
        seleccionar(listDay, valueDay);
        seleccionar(listaMonth, valueMonth);
        seleccionar(listYear, valueYear);
        Presionar(checkNewsletter);
        Presionar(checkOffers);
        escribirTexto(boxFirstName,firstName);
        escribirTexto(boxSecondName,secondName);
        escribirTexto(boxCompany,company);
        escribirTexto(boxAdress,address);
        escribirTexto(boxAdress2,address2);
        seleccionar(boxCountry,country);
        escribirTexto(boxEstate,State);
        escribirTexto(boxCity,City);
        escribirTexto(boxZipcode,zipcode);
        escribirTexto(boxMobile,mobileNumber);
        Presionar(btnCreateAccount);
    }
    public void loginAutomatico(){

        Presionar(btnContinue);
    }
    public void eliminarCuenta(){

        Presionar(btnDeleteAccount);
    }
    public void login(String email,String contrasenia){
        limpiarCajaTexto(boxEmailLogin);
        limpiarCajaTexto(boxPasswordLogin);
        escribirTexto(boxEmailLogin,email);
        escribirTexto(boxPasswordLogin,contrasenia);
        enviarTexto(boxPasswordLogin);
    }


}

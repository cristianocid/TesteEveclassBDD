package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static runner.RunnerTest.prop;

public class HomePage{
    WebDriver driver;
    public HomePage(WebDriver driver)  {
        this.driver = driver;
    }

    public void acessar_aplicacao(){
        driver.get("https://testando.eveclass.com/pt");
    }

    public void clicar_em_comecar_agora(){
        driver.findElement(By.cssSelector(".button-custom:nth-child(4) > .button-text > span > span")).click();
    }

    public void clicar_no_botao_entrar(){
        driver.findElement(By.cssSelector("#support-action > span > span > span")).click();
    }

    public void preencher_email(){
        String email = prop.getProperty("email");
        WebElement inputEmail = driver.findElement(By.cssSelector("input[data-vv-as='Email'][type='Email']"));
        inputEmail.sendKeys(email);
    }

    public void preencher_senha() {
        String senha = prop.getProperty("senha");
        WebElement inputSenha = driver.findElement(By.cssSelector("input[type='password']"));
        inputSenha.sendKeys(senha);
    }

    public void clicar_no_botao_entrar_login() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"auth-panel\"]/div[2]/div/div/div/div/div[2]/div/form/div[2]/button")).click();
        Thread.sleep(2000);
    }

    public void clicar_no_icone_do_usuario() throws InterruptedException {
        driver.findElement(By.cssSelector("div.user-avatar.avatar-initials")).click();
        Thread.sleep(2000);
    }

    public void clicar_no_perfil_do_usuario(){
        driver.findElement(By.cssSelector(".fal.fa-user-circle")).click();
    }

    public void alterar_o_nome_do_usuario(){
        WebElement inputNome = driver.findElement(By.cssSelector("input[data-vv-as='Nome'][type='text']"));
        inputNome.sendKeys(Keys.CONTROL + "a");
        inputNome.sendKeys(Keys.BACK_SPACE);
        inputNome.sendKeys("Cristiano C");
    }

    public void clicar_no_botao_salvar(){
        driver.findElement(By.xpath("//*[@id=\"account-panel\"]/div[2]/div/div/div/div/div[1]/section/form/button")).click();
    }

    public void verificar_alteracao() throws IOException {
        assertThat(driver.findElement(By.id("swal2-title")).getText(), is("Perfil editado com successo!"));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/test/resources/utils/print/evidencia1.png"));
    }

}

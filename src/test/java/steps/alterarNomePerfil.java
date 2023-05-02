package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import runner.RunnerTest;

import java.io.IOException;


public class alterarNomePerfil extends RunnerTest {
     HomePage homepage = new HomePage(driver);

    @Given("que acesso o site Testando Eveclass")
    public void que_acesso_o_site_testando_eveclass() {
        homepage.acessar_aplicacao();
        System.out.println("Passo 1");
    }

    @When("clico no botao Começar Agora")
    public void clico_no_botao_comecar_agora() {
        System.out.println("Passo 2");
        homepage.clicar_em_comecar_agora();
    }

    @When("clico no botao Entrar")
    public void clico_no_botao_entrar() {
        System.out.println("Passo 3");
        homepage.clicar_no_botao_entrar();
    }

    @When("insiro o Email")
    public void insiro_o_email() {
        System.out.println("Passo 4");
        homepage.preencher_email();
    }

    @When("insiro a Senha")
    public void insiro_a_senha() {
        System.out.println("Passo 5");
        homepage.preencher_senha();
    }

    @When("clico no botao Login")
    public void clico_no_botao_login() throws InterruptedException {
        System.out.println("Passo 6");
        homepage.clicar_no_botao_entrar_login();
    }

    @When("clico no icone do Usuario")
    public void clico_no_icone_do_usuario() throws InterruptedException {
        System.out.println("Passo 7");
        homepage.clicar_no_icone_do_usuario();
    }

    @When("clico no nome do Usuario")
    public void clico_no_nome_do_usuario() {
        System.out.println("Passo 8");
        homepage.clicar_no_perfil_do_usuario();
    }

    @When("altero o nome do Usuario")
    public void altero_o_nome_do_usuario() {
        System.out.println("Passo 9");
        homepage.alterar_o_nome_do_usuario();
    }

    @When("clico no botao Salvar")
    public void clico_no_botao_salvar() {
        System.out.println("Passo 10");
        homepage.clicar_no_botao_salvar();
    }

    @Then("exibe o pop up de confirmaçao")
    public void exibe_o_pop_up_de_confirmacao() throws IOException {
        System.out.println("Passo 11");
        homepage.verificar_alteracao();
    }
}

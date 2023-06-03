package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PesquisaPages;


public class PesquisaSteps {
    WebDriver driver;
    PesquisaPages pesquisaPages;
    
    @Dado("que o usuario esta em {string}")
    public void que_o_usuario_esta_em(String url) {
        driver = new ChromeDriver();
        driver.get(url);

    }
    @Quando("pesquisa por {string}")
    public void pesquisa_por(String palavraDaPesquisa) {
        pesquisaPages = new PesquisaPages();
        driver.findElement(By.id(pesquisaPages.barraDePesquisa)).sendKeys(palavraDaPesquisa);
        driver.findElement(By.id(pesquisaPages.barraDePesquisa)).sendKeys(Keys.ENTER);


    }
    @Entao("e retornando um link a pesquisa {string}")
    public void e_retornando_um_link_a_pesquisa(String casaAbril) {
        driver.findElement(By.xpath(pesquisaPages.linkDePesquisa)).isDisplayed();

    }
}

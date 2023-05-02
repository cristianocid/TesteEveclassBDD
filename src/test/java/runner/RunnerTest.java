package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberReport.json","html:target/reports/"},
        features ="src/test/resources/features",
        tags ={"@alterar_nome"},
        glue ={"steps"}
)
public class RunnerTest {
    public static WebDriver driver;
    public static Properties prop = new Properties(); // Cria um objeto Properties
    // Executado antes de tudo
    @BeforeClass
    public static void start () throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        FileInputStream file = new FileInputStream("src/test/resources/config.properties");
        prop.load(file);
        file.close();
    }
    @AfterClass
    // Executado depois de tudo
    public static void stop (){
        driver.quit();
    }
}

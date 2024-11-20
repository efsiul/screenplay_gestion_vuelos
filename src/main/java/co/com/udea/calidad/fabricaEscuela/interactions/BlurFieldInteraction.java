package co.com.udea.calidad.fabricaEscuela.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.steps.Instrumented;

public class BlurFieldInteraction implements Interaction {
    private final Target target;

    public BlurFieldInteraction(Target target) {
        this.target = target;
    }

    public static BlurFieldInteraction on(Target target) {
        return Tasks.instrumented(BlurFieldInteraction.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver();
        WebElement element = target.resolveFor(actor).getElement();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].blur();", element);
    }
}
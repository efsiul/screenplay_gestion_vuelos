package co.com.udea.calidad.fabricaEscuela.stepdefinitions;

import co.com.udea.calidad.fabricaEscuela.questions.DisplayedMessage;
import co.com.udea.calidad.fabricaEscuela.tasks.FillAirplaneFormTask;
import co.com.udea.calidad.fabricaEscuela.userinterfaces.AirplaneRegistrationPageUserinterfaces;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.questions.SelectedStatus;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AirplaneRegistrationStepDefinition {
    private Actor user;

    @Before
    public void config() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("user");
    }

    @Given("I am on the airplane registration page")
    public void iAmConnectedToTheRegistrationPage() {
        user.wasAbleTo(Open.browserOn().thePageNamed("pages.airplaneRegisterUrl"));
    }

    @When("I enter {string} as the airplane type")
    public void iEnterAsTheAirplaneType(String input) {
        user.attemptsTo(
        FillAirplaneFormTask.withAirplaneType(input)
        );
    }

    @When("I enter {string} as the seat capacity")
    public void iEnterAsTheSeatCapacity(String input) {
        user.attemptsTo(
                FillAirplaneFormTask.withSeatCapacity(input)
        );
    }

    @When("I select {string} as the seat distribution")
    public void iSelectAsTheSeatDistribution(String option) {
        user.attemptsTo(
                FillAirplaneFormTask.selectSeatDistribution(option)
        );
    }

    @When("I enter {string} as the airplane ID")
    public void iEnterAsTheAirplaneID(String input) {
        user.attemptsTo(
                FillAirplaneFormTask.withAirplaneID(input)
        );
    }

    @When("I press the register button")
    public void iPressTheRegisterButton() {
        user.attemptsTo(Click.on(AirplaneRegistrationPageUserinterfaces.REGISTER_BUTTON));
    }

    @Then("I should see an error message {string} for the field {string}")
    public void iShouldSeeAnErrorMessageForTheField(String expectedMessage, String field) {
        switch (field) {
            case "airplaneType":
                user.attemptsTo(
                        WaitUntil.the(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_AIRPLANE_TYPE, isVisible())
                                .forNoMoreThan(10).seconds(),
                        Ensure.that(Text.of(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_AIRPLANE_TYPE))
                                .isEqualTo(expectedMessage)
                );
                break;
            case "seatCapacity":
                user.attemptsTo(
                        WaitUntil.the(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_CAPACITY, isVisible())
                                .forNoMoreThan(10).seconds(),
                        Ensure.that(Text.of(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_CAPACITY))
                                .isEqualTo(expectedMessage)
                );
                break;
            case "airplaneID":
                user.attemptsTo(
                        WaitUntil.the(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_AIRPLANE_ID, isVisible())
                                .forNoMoreThan(10).seconds(),
                        Ensure.that(Text.of(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_AIRPLANE_ID))
                                .isEqualTo(expectedMessage)
                );
                break;
        }
    }

    @Then("I should see a success message {string}")
    public void iShouldSeeASuccessMessage(String expectedMessage) {
        user.attemptsTo(
                WaitUntil.the(AirplaneRegistrationPageUserinterfaces.SUCCESS_MESSAGE, isVisible())
                        .forNoMoreThan(10).seconds(),
                Ensure.that(Text.of(AirplaneRegistrationPageUserinterfaces.SUCCESS_MESSAGE)).isEqualTo(expectedMessage)
        );
    }

    @Then("the option {string} should be selected")
    public void theOptionShouldBeSelected(String distribution) {
        user.attemptsTo(
                Ensure.that(
                        AirplaneRegistrationPageUserinterfaces.getSeatDistributionButton(distribution)
                                .resolveFor(user).getAttribute("class")
                ).contains("selected")
        );
    }
}
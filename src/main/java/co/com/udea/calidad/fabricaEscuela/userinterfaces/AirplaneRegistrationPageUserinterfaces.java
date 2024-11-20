package co.com.udea.calidad.fabricaEscuela.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AirplaneRegistrationPageUserinterfaces {
    public static final Target AIRPLANE_TYPE_INPUT = Target.the("Airplane type input")
            .located(By.id("airplaneType"));

    public static final Target SEAT_CAPACITY_INPUT = Target.the("Seat capacity input")
            .located(By.id("seatCapacity"));

    public static final Target AIRPLANE_ID_INPUT = Target.the("Airplane ID input")
            .located(By.id("airplaneId"));

    public static final Target ERROR_MESSAGE_AIRPLANE_TYPE = Target.the("Error message about airplane type")
            .locatedBy("//div[@class='form-group'][1]//small");

    public static final Target ERROR_MESSAGE_CAPACITY = Target.the("Error message about seat capacity")
            .locatedBy("//div[@class='form-group'][2]//small");

    public static final Target ERROR_MESSAGE_AIRPLANE_ID = Target.the("Error message about airplane ID")
            .locatedBy("//div[@class='form-group'][4]//small");

    public static final Target SUCCESS_MESSAGE = Target.the("Success message")
            .locatedBy("//div[contains(@class, 'modal-content')]/p");

    public static Target getSeatDistributionButton(String option) {
        return Target.the("Seat distribution button " + option)
                .located(By.xpath("//button[contains(@class, 'seat-option') and text()='" + option + "']"));
    }

    public static final Target REGISTER_BUTTON = Target.the("Register button")
            .locatedBy("/html/body/div[1]/div/form/div[5]/button");


}
package co.com.udea.calidad.fabricaEscuela.questions;

import co.com.udea.calidad.fabricaEscuela.userinterfaces.AirplaneRegistrationPageUserinterfaces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class DisplayedMessage implements Question<String> {
    private final String field;

    public DisplayedMessage(String field) {
        this.field = field;
    }

    public static DisplayedMessage forAirplaneType() {
        return new DisplayedMessage("airplaneType");
    }

    public static DisplayedMessage forSeatCapacity() {
        return new DisplayedMessage("seatCapacity");
    }

    public static DisplayedMessage forAirplaneID() {
        return new DisplayedMessage("airplaneID");
    }

    public static DisplayedMessage success() {
        return new DisplayedMessage("success");
    }

    @Override
    public String answeredBy(Actor actor) {
        String message = "";
        switch (field) {
            case "airplaneType":
                message = Text.of(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_AIRPLANE_TYPE).answeredBy(actor);
                break;
            case "seatCapacity":
                message = Text.of(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_CAPACITY).answeredBy(actor);
                break;
            case "airplaneID":
                message = Text.of(AirplaneRegistrationPageUserinterfaces.ERROR_MESSAGE_AIRPLANE_ID).answeredBy(actor);
                break;
            case "success":
                message = Text.of(AirplaneRegistrationPageUserinterfaces.SUCCESS_MESSAGE).answeredBy(actor);
                break;
        }
        System.out.println("Mensaje obtenido para " + field + ": " + message);
        return message;
        }
    }


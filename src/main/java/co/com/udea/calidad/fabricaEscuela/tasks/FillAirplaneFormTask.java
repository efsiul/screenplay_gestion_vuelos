package co.com.udea.calidad.fabricaEscuela.tasks;

import co.com.udea.calidad.fabricaEscuela.interactions.BlurFieldInteraction;
import co.com.udea.calidad.fabricaEscuela.userinterfaces.AirplaneRegistrationPageUserinterfaces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FillAirplaneFormTask implements Task {
    private final String input;
    private final String field;

    public FillAirplaneFormTask(String input, String field) {
        this.input = input;
        this.field = field;
    }

    public static FillAirplaneFormTask withAirplaneType(String input) {
        return Tasks.instrumented(FillAirplaneFormTask.class, input, "airplaneType");
    }

    public static FillAirplaneFormTask withSeatCapacity(String input) {
        return Tasks.instrumented(FillAirplaneFormTask.class, input, "seatCapacity");
    }

    public static FillAirplaneFormTask selectSeatDistribution(String option) {
        return Tasks.instrumented(FillAirplaneFormTask.class, option, "seatDistribution");
    }

    public static FillAirplaneFormTask withAirplaneID(String input) {
        return Tasks.instrumented(FillAirplaneFormTask.class, input, "airplaneId");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (field) {
            case "airplaneType":
                actor.attemptsTo(
                        Enter.theValue(input).into(AirplaneRegistrationPageUserinterfaces.AIRPLANE_TYPE_INPUT),
                        BlurFieldInteraction.on(AirplaneRegistrationPageUserinterfaces.AIRPLANE_TYPE_INPUT)
                );
                break;
            case "seatCapacity":
                actor.attemptsTo(
                        Enter.theValue(input).into(AirplaneRegistrationPageUserinterfaces.SEAT_CAPACITY_INPUT),
                        BlurFieldInteraction.on(AirplaneRegistrationPageUserinterfaces.SEAT_CAPACITY_INPUT)
                );
                break;
            case "airplaneId":
                actor.attemptsTo(
                        Enter.theValue(input).into(AirplaneRegistrationPageUserinterfaces.AIRPLANE_ID_INPUT),
                        BlurFieldInteraction.on(AirplaneRegistrationPageUserinterfaces.AIRPLANE_ID_INPUT)
                );
                break;
            case "seatDistribution":
                actor.attemptsTo(
                        Click.on(AirplaneRegistrationPageUserinterfaces.getSeatDistributionButton(input))
                );
                break;
        }
    }
}
package in.practice.automationtesting.certification.tasks.rest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;

import static in.practice.automationtesting.certification.utils.enums.URLEnum.URL_API_PATH_USER;

public class GetUsersTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URL_API_PATH_USER.getValue())
                /*.with(
                        request -> request.header("Content-Type", "application/json")
                .body(new HashMap<String, Object>()))*/

        );
    }

    public static GetUsersTask getUsers() {
        return Tasks.instrumented(GetUsersTask.class);
    }
}

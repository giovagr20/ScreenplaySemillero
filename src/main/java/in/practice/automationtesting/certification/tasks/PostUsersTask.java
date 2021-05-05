package in.practice.automationtesting.certification.tasks;

import in.practice.automationtesting.certification.models.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;

import static in.practice.automationtesting.certification.utils.enums.URLEnum.URL_API_PATH_POST_USER;
import static in.practice.automationtesting.certification.utils.enums.UserEnum.*;

public class PostUsersTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        UserModel user = new UserModel();
        user.set_name(USER_API_POST_NAME.getValue());
        user.set_job(USER_API_POST_JOB.getValue());

        /*HashMap<String, Object> hash = new HashMap<>();

        hash.put("name", USER_API_POST_NAME.getValue());
        hash.put("job", USER_API_POST_JOB.getValue());*/


        actor.attemptsTo(
                Post.to(URL_API_PATH_POST_USER.getValue())
                    .with(request -> request.header("Content-Type", "application/json")
                            .body(user)));
    }

    public static PostUsersTask postUser() {
        return Tasks.instrumented(PostUsersTask.class);
    }
}

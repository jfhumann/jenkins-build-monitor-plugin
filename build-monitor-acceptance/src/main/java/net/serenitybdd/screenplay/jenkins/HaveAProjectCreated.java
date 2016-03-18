package net.serenitybdd.screenplay.jenkins;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.jenkins.tasks.CreateAFreestyleProject;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.jenkins.user_interface.navigation.SidePanel.Back_to_Dashboard;

public class HaveAProjectCreated implements Task {

    public static Task called(String name) {
        return instrumented(HaveAProjectCreated.class, name);
    }

    @Step("{0} creates the '#projectName' project")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CreateAFreestyleProject.called(projectName),
                Click.on(Back_to_Dashboard)
        );
    }

    public HaveAProjectCreated(String projectName) {
        this.projectName = projectName;
    }

    private final String projectName;
}

package ge.automation.hooks;

import io.cucumber.java.Before;

public class hooks {

    @Before
    public void beforeScenario(){
        System.out.println("Before scenario");
    }
}

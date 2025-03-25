package hooks;

import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup() {
        DriverManager.getDriver();
    }

    @After
    public void teardown() {
        DriverManager.closeDriver();
    }

}

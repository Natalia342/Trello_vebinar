import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .email("nataliatalova7@gmail.com")
                .password("1234567$Yy")
                .build();
        app.getUser().initLogin();
        app.getUser().fillLogin(user);
        app.getUser().clickLogin();
        app.getUser().pause(2000);
        app.getUser().fillPassword(user);
        app.getUser().submitPassword();
        app.getUser().pause(2000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.className(".DweEFaF5owOe02 rQ86P0iNikD4I9 Cg0RMJhBknTRbM")));
    }
}

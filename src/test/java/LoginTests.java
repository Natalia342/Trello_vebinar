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
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        app.getUser().fillPassword(user);
        app.getUser().submitPassword();
        app.getUser().pause(2000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.className(".DweEFaF5owOe02 rQ86P0iNikD4I9 Cg0RMJhBknTRbM")));
//       app.getUser().returnToHome();
        app.getUser().logout();
        app.getUser().pause(2000);
    }
    @Test
    public void loginNegativeWrongEmailTest(){
        User user=User.builder().email("hatumtestinggmail.com").password("Hatum21$").build();
        app.getUser().initLogin();
        app.getUser().fillLogin(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        app.getUser().fillPassword(user);
        //app.getUser().submitPassword();
        app.getUser().submitLogin();
        Assert.assertFalse(app.getUser().isLogged());
    //    Assert.assertTrue(app.getUser().getTextFromErrorEmailMessage().contains("There isn't an account for this username") );
        //<p class="error-message">There isn't an account for this username</p>
        app.getUser().returnToHome();

    }
    @Test
    public void loginWrongPassword(){
        User user = User.builder()
                .email("nataliatalova7@gmail.com")
                .password("123456y")
                .build();
        app.getUser().initLogin();
        app.getUser().fillLogin(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        app.getUser().fillPassword(user);
        app.getUser().submitPassword();
    //    app.getUser().submitLogin();
        Assert.assertFalse(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().getTextErrorMessage().contains("Неверный адрес электронной почты и (или) пароль."));
        app.getUser().returnToHome();
    }
}

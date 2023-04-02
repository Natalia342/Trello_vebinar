package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void initLogin() {
        if (isHomePage()) {
            click(By.cssSelector("a[href='/login']"));
        }
    }

    public void fillLogin(User user){//napolnit
String login = user.getEmail();
type(By.id("user"), login);


}
public void submitLogin(){
    click(By.id("login"));
}
public void fillPassword(User user){
        String password= user.getPassword();//
        type(By.id("password"),password);
}
public void submitPassword(){
        click(By.id("login-submit"));
}
    public boolean isLogged(){
        pause(2000);
        return isElementPresent(By.className("OUdAuicP657Tka"));
    }
    public String getTextFromErrorEmailMessage(){
        return wd.findElement(By.cssSelector("p.error-message")).getText();
    }
    public String getTextErrorMessage(){
        return wd.findElement(By.cssSelector("span[class='css-xal9c7'] span")).getText();
    }
    public void logout(){
        //click
        click(By.cssSelector("span[class='DweEFaF5owOe02 rQ86P0iNikD4I9 Cg0RMJhBknTRbM']"));
        //click
        click(By.xpath("//button[@data-testid='account-menu-logout']"));
        //click
        click(By.id("logout-submit"));
    }
}

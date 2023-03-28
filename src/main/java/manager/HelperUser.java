package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void initLogin(){
        click(By.cssSelector("a[href='/login'"));
    }
public void fillLogin(User user){//napolnit
String login = user.getEmail();
type(By.id("user"), login);


}
public void clickLogin(){
    click(By.id("login"));
}
public void fillPassword(User user){
        String password= user.getPassword();//
        type(By.id("password"),password);
}
public void submitPassword(){
        click(By.id("login-submit"));
}

}

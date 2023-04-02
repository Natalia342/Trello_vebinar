package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

 //   public HelperBase() {
 //   }//polimorfizm

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator, String text){
        if(text !=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        return (wd.findElements(locator).size() > 0);
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        FluentWait<WebDriver> wait = new FluentWait<>(wd);
//        wait.withTimeout(Duration.ofSeconds(time));
    }
    public String getTextByLocator(By locator){
        return wd.findElement(locator).getText();

    }
    public boolean isHomePage(){
        String current_url=wd.getCurrentUrl();
        System.out.println(current_url);
        return current_url.equals("https://trello.com/")||current_url.equals("https://trello.com/home");
    }

    public void returnToHome(){
        wd.navigate().to("https://trello.com");
    }

}

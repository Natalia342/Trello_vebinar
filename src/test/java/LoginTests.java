import models.User;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .email("nataliatalova7@gmail.com")
                .password("1234567$Yy")
                .build();

    }
}

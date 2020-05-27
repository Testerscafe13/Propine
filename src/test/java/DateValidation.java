import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

public class DateValidation {
    WebDriver driver;

    @Test(priority = 0)
    public void validTest() {
        dataLocatos ddl = new dataLocatos();
        ddl.open_broswer();
        Selenide.open(ddl.baseurl);
        System.out.println("Verifying the url is opened");
        Boolean VerifyingContentAppears = $(ddl.verifyingText).isDisplayed();
        if (VerifyingContentAppears) {
            System.out.println("We are in the requested page");
            Selenide.sleep(3000);
            System.out.println("Entering the invalid date");
            Date date = new Date();
            $(ddl.enterDate).setValue(date.toString());
            sleep(3000);
            $(ddl.BtnSubmit).click();
            sleep(3000);
            String text = $x("//h3[text()='Results']//following::div").getText();
            System.out.println(text);
            if (text.equalsIgnoreCase("Invalid date")) {
                System.out.println("Testcase for valid date is Pass");
            } else {
                System.out.println("Testcase for valid date is fail");
            }
            //Valid date test
            sleep(3000);
            $(ddl.enterDate).clear();
            $(ddl.enterDate).setValue("10-10-2020");
            sleep(3000);
            $(ddl.BtnSubmit).click();
            sleep(3000);
            text = $x("//h3[text()='Results']//following::div").getText();
            System.out.println(text);
            if (text.equalsIgnoreCase("Invalid date")) {
                System.out.println("Testcase for valid date but its shows Invalid date so its Fail");
            } else {
                System.out.println("Testcase for valid date is Pass");
            }
        } else {
            System.out.println("We are not entered on the requested page");
        }
    ddl.closeBrowser();
    }

}

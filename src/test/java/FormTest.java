import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Dimitry777");
        $("#userEmail").setValue("Dimitry777@mail.ru");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("Piter");
        $("#submit").scrollTo();
        $("#submit").click();

        $("#output #name").shouldHave(text("Dimitry777"));
        $("#output").$("#email").shouldHave(text("Dimitry777"));
        $("#output").$("#currentAddress").shouldHave(text("Moscow"));
        $("#output").$("#permanentAddress").shouldHave(text("Piter"));

//        $("#output").shouldHave(text("Some name"), text("aaa@aa.aa"),
//                text("Some address"), text("Another address"));
    }
}

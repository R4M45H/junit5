package test.qa;

import com.codeborne.selenide.Selenide;
import io.netty.handler.codec.http.cookie.Cookie;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JUnitSimpleTest {

    @DisplayName("Демонстрационный тест")
    @Test
    void simpleTest() {
        Assertions.assertTrue(3 > 2);
    }

    @BeforeEach
    void setUp() {
        open("https://www.google.com");
    }

    @DisplayName("Адрес https://ru.selenide.org должен быть в выдаче гугла по запросу 'Selenide' ")
    @Test
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void simpleSitUrlShouldBePresentInResultsOfSearchInGoogleBySelenideQuery() {
        open("https://www.google.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }


    @DisplayName("Адрес https://qameta.io должен быть в выдаче гугла по запросу 'Allure testops'")
    @Test
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void allureSitUrlShouldBePresentInResultsOfSearchInGoogleByAllureQuery() {
        open("https://qameta.io ");
        $("[name=q]").setValue("Allure test ops").pressEnter();
        $("[id=search]").shouldHave(text("https://qameta.io"));
    }



}

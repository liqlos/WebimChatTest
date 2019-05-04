package ru.webim.testng.tests;

import ru.webim.pages.*;
import ru.webim.pages.OperatorRatePage;
import ru.webim.webtestsbase.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.webim.pages.DepartmentListPage;
import ru.webim.pages.UserDataPage;
import ru.webim.pages.WebimChatDemoPage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

//main класс теста

public class PageObjectTest {

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true); //запускаем браузер
    }


    @Test
    public void webimTest() throws InterruptedException {
        String name = "name";
        String email = "abs@gmail.com";
        String phone = "+79535138122";
        String message = "Мое сообщение";
        String localDir = System.getProperty("user.dir"); //локальный путь до папки проекта
        String file = localDir + "\\src\\test\\resources\\attachfile.txt"; //путь к файлу для загрузки

        WebimChatDemoPage webimChatDemoPage = new WebimChatDemoPage();
        webimChatDemoPage.openChat();   //открываем чат

        DepartmentListPage departmentListPage = new DepartmentListPage();
        departmentListPage.clickOnFirstDepartment();//выбираем первый отдел

        UserDataPage userDataPage = new UserDataPage();
        userDataPage.personalDataFieldsFill(name,phone,email);  //заполняем поля данными
        userDataPage.acceptPersonalData();
        userDataPage.sendMessage(message);         //отправляем сообщение



        webimChatDemoPage.openChatActions(); // кликаем на chat actions

        webimChatDemoPage.uploadFile(file); //загружаем файл

        webimChatDemoPage.operatorRateAction(); //нажимаем кнопку оценить оператора из chat actions

        OperatorRatePage operatorRatePage = new OperatorRatePage();
        operatorRatePage.rateOperator();  //ставим оценку оператору

        webimChatDemoPage.closeChat();//закрываем чат
    }


    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}

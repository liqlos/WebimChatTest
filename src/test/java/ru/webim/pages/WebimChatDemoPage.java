package ru.webim.pages;

import ru.webim.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;

//начальный экран с кнопкой открытия и первым окном чата
public class WebimChatDemoPage extends BasePage {

    private static final String PAGE_URL = "https://demo-pro.webim.ru";

    @FindBy(className = "webim-html-button-main")  //кнопка открытия чата
    private WebElement chatOpenButton;

    @FindBy(className = "webim-chat")          //окно чата
    private WebElement webimChat;

    @FindBy(name = "message") //поле ввода сообщения
    private WebElement messageField;

    @FindBy(xpath = "//*[@id=\"webim_chat\"]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/ul/li[2]/label/input") //элемент для загрузки файла
    private WebElement webimFileupload;

    @FindBy(className = "webim-control-block") //кнопка закрытия чата
    private WebElement chatCloseButton;

    @FindBy(className = "webim-file_visitor-message") //сообщение с файлом в чате
    private WebElement visitorFile;

    @FindBy(className = "webim-actions-button") //кнопка открытия chat actions
    private WebElement openChatActionsButton;

    @FindBy(className = "webim-close-action") //кнопка закрытия chat actions
    private WebElement closeChatActionsButton;

    @FindBy(className = "webim-chat-action-upload") //кнопка "Загрузить файл"
    private WebElement uploadButton;

    @FindBy(className = "webim-chat-action-rate") //кнопка "Оценить оператора"
    private WebElement operatorRateButton;

    public WebimChatDemoPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isOpened() {   //признак загруженности страницы - отображение поля ввода пароля
        return chatOpenButton.isDisplayed();
    }

    public void openChat() {
        chatOpenButton.click();                     //открываем чат
        Assert.assertTrue(webimChat.isDisplayed()); //проверяем открытие чата
    }

    public void closeChat(){
        chatCloseButton.click();                     //закрываем чат
        Assert.assertFalse(webimChat.isDisplayed()); //проверяем закрытие чата
    }

    public void openChatActions(){
        openChatActionsButton.click();
    } //открыть chat actions

    public void closeChatActions(){
        closeChatActionsButton.click();
    } //закрыть chat actions

    public void operatorRateAction(){
        operatorRateButton.click();
    } //нажать кнопку "оценить оператора"

    public void uploadFile(String file) {
        webimFileupload.sendKeys(file);//загружаем файл
        File f = new File(file);       //создаем файловую переменную для использования getName
        Assert.assertTrue(visitorFile.getText().contains(f.getName())); //проверяем что сообщение с файлом содержит имя файла
    }



}

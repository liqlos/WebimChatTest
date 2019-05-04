package ru.webim.pages;

import ru.webim.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

//экран с полями для данных пользователя

public class UserDataPage extends BasePage {
    //сначала использовал локаторы по name, но с ними тест выполнялся не всегда
    //появлялась ошибка element is not attached to the page document

    @FindBy(xpath = "(//input[@name='name'])[2]") //поле "Имя"
    private WebElement nameField;

    @FindBy(xpath = "(//input[@name='phone'])[2]") //поле "Телефон"
    private WebElement phoneField;

    @FindBy(xpath=("(//input[@name='email'])[2]")) //поле "email"
    private WebElement emailField;

    @FindBy(xpath = "(//textarea[@name='message'])[2]") //поле ввода сообщения
    private WebElement messageField;

    @FindBy(className = "webim-visitor-message") //элемент, содержащий сообщение
    private WebElement visitorMessage;

    @FindBy(xpath = "(//input[@name='processing-personal-data-checkbox'])[2]") //чекбокс согласия на обработку ПД
    private WebElement personalDataCheckbox;

    @FindBy(xpath = "//div[4]/button") //кнопка отправки сообщения
    private WebElement sendMessageButton;

    public UserDataPage() {
        super(false);
    }

    @Override
    public boolean isOpened() {   //признак загруженности  - отображение поля ввода email
        return emailField.isDisplayed();
    }

    @Override
    protected void openPage() {
    }

    public void personalDataFieldsFill(String name, String phone, String email){
        nameField.sendKeys(name);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);
    }

    public void acceptPersonalData() {  //соглашаемся на обработку ПД
        personalDataCheckbox.click();
    }

    public void sendMessage(String message){
        messageField.sendKeys(message);
        sendMessageButton.click();
        Assert.assertTrue(visitorMessage.getText().contains(message)); // проверяем отправку сообщения
    }

}

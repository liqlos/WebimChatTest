package ru.webim.pages;

import ru.webim.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//экран оценки оператора

public class OperatorRatePage extends BasePage {

    @FindBy (className = "webim-rate-error") //табличка "нет оператора для выставления оценки"
    private WebElement operatorRateErrorAlert;

    @FindBy (className = "webim-ico-rate-unchecked")  // звездочка оценки оператора
    private WebElement operatorRateStar;

    @FindBy (css = ".webim-js-button-style")  //кнопка отправки оценки оператора
    private WebElement operatorRateSendButton;

    @FindBy (css = ".webim-rate-block .webim-action")     //кнопка закрытия окна оценки оператора
    private WebElement operatorRateCloseButton;

    public OperatorRatePage() {
        super(false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isOpened() {
        return operatorRateStar.isDisplayed();

    }

    public void rateOperator(){        //cтавим оценку оператору
        if(!operatorRateErrorAlert.isDisplayed()){  //если не отображается сообщение "Нет оператора для выставления оценки"
            operatorRateStar.click();       //кликаем на звездочку
            operatorRateSendButton.click();       //кликаем отправить
        }
        else operatorRateCloseButton.click();
    }


}

package ru.webim.pages;

import ru.webim.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//экран списка отделов

public class DepartmentListPage extends BasePage {

    @FindBy(className = "webim-department") //первый отдел в списке отделов
    private WebElement webimDepartment;

    public DepartmentListPage() {
        super(false);
    }

    @Override
    public boolean isOpened() {   //признак открытия списка отделов
        return webimDepartment.isDisplayed();
    }
    @Override
    protected void openPage() {
    }

    public void clickOnFirstDepartment(){      //кликаем на первый отдел
        webimDepartment.click();
    }


}

package org.example.pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Full name')]/following-sibling::div")
    private SelenideElement fullNameInAdditionalInfo;

    @FindBy(css = "div.mdc-card h2")
    private SelenideElement fullNameInAvatarSection;

    @FindBy(css = "div.mdc-card div.mdc-card__action-icons button[title='More options']")
    private  SelenideElement editIconInAvatarSection;

    @FindBy(xpath = "//form[@id='update-item']//span[contains(text(), 'New Avatar')]/following-sibling::input")
    private SelenideElement newAvatarFieldOnEditingPopup;

    @FindBy(xpath = "//form[@id='update-item']//span[contains(text(), 'Birthdate')]/following-sibling::input")
    private SelenideElement birthdateField;
    @FindBy(css = "form#update-item button")
    private SelenideElement buttonSave;

    @FindBy(xpath= "//h2[@id='profileForm-title']/../button")
    private SelenideElement buttonClose;

    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Date of birth')]/following-sibling::div")
    private SelenideElement fullDateOfBirth;




    public void clickEditIconInAvatarSection(){
        editIconInAvatarSection.shouldBe(visible).click();
    }

    public void uploadPictureFileToAvatarField(String filePath){
        newAvatarFieldOnEditingPopup.shouldBe(visible).uploadFile(new File(filePath));
    }

    public String getAvatarInputValueOnSettingPopup(){
        String inputValue = newAvatarFieldOnEditingPopup.getValue();
        return Objects.requireNonNull(inputValue)
                .substring(inputValue.lastIndexOf("\\") + 1);
    }

    public String getFullNameInAdditionalInfo() {
        return fullNameInAdditionalInfo.shouldBe(visible).text();
    }

    public String getFullNameInAvatarSection() {
        return fullNameInAvatarSection.shouldBe(visible).text();
    }

    public void typeBirthdateInField(String data) {
        birthdateField.shouldBe(visible).sendKeys(data);
    }

    public void clickEditSaveBirthdate(){
        buttonSave.shouldBe(visible).click();
    }

    public void clickCloseEditingProfileWindow(){
        buttonClose.shouldBe(visible).click();
    }

    public String getFullBirtdateInAdditionalInfo() {
        return fullDateOfBirth.shouldBe(visible).text();
    }


}

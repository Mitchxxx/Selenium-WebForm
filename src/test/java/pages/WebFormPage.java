package pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class WebFormPage {
        WebDriver driver = DriverManager.getDriver();
        // Locators for the Web form elements
        public By textInputField = By.id("my-text-id");
        public By passwordField = By.name("my-password");
        public By textAreaField = By.name("my-textarea");
        public By readOnly = By.name("my-readonly");
        public By disabled = By.name("my-disabled");
        public By checkbox1 = By.id("my-check-1");
        public By checkbox2 = By.id("my-check-2");
        public By radioButton1 = By.id("my-radio-1");
        public By radioButton2 = By.id("my-radio-2");
        public By select = By.cssSelector("select[name='my-select']");
        public By dataList = By.cssSelector("input[list='my-options']");
        public By submitButton = By.cssSelector("button[type='submit']");
        public By myDate = By.cssSelector("input[name='my-date']");


        public void inputText(String text) {
                driver.findElement(textInputField).sendKeys(text);
        }

        public void inputPassword(String text) {
                driver.findElement(passwordField).sendKeys(text);
        }

        public void inputTextArea(String text) {
                driver.findElement(textAreaField).sendKeys(text);
        }

        public void submit() {
                driver.findElement(submitButton).click();
        }

        public void assertReadOnly(String text) {
                String actualText = driver.findElement(readOnly).getAttribute("value");
                assert actualText.equals(text);
        }

        public void selectDropDownByText(String text) {
                WebElement dropdown =  driver.findElement(select);
                Select dropDownSelect = new Select(dropdown);
                dropDownSelect.selectByVisibleText(text);
        }

        public void selectFromDataList(String value) {
                WebElement inputField = driver.findElement(dataList);
                inputField.sendKeys(value);
                String selectedValue = inputField.getAttribute("value");
                assert selectedValue.equals(value);
        }

        public void checkBox(String box) {
                WebElement checkBox =  driver.findElement(By.id("my-check-" + box));
                if (!checkBox.isSelected()){
                        checkBox.click();
                }
        }

        public void radioButton(String option) {
                WebElement radioButton =  driver.findElement(By.id("my-radio-" + option));
                radioButton.click();
        }

        public void datePicker(String date) {
                WebElement datePicker =  driver.findElement(myDate);
                datePicker.sendKeys(date);

        }



}

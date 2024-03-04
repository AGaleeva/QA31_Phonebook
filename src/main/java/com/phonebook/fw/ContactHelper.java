package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        // 2 - enter name
        type(By.cssSelector("input:nth-child(1)"), contact.getFirstName());
        // 3 - enter last name
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        // 4 - enter phone
        type(By.cssSelector("input:nth-child(3)"), contact.getPhoneNumber());
        // 5 - enter email
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        // 6 - enter address
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        // 7 - enter description
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactCreatedByText(String name) {
        List<WebElement> contacts = ApplicationManager.driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return ApplicationManager.driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}

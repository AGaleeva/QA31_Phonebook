package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void Precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("test74@mail.com").setPassword("Qweyxc$9"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setFirstName("Ewan")
                .setLastName("Thomas")
                .setPhoneNumber("04963524897")
                .setEmail("thomas@mail.com")
                .setAddress("Berlinerstr. 5, 12345 Berlin")
                .setDescription("description"));
        app.getContact().clickOnSaveButton();

        assertTrue(app.getContact().isContactCreatedByText("Ewan"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

    @Test(dataProvider = "addContacts", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String firstName,
                                                       String lastName,
                                                       String phoneNumber,
                                                       String email,
                                                       String address,
                                                       String description ) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();

        assertTrue(app.getContact().isContactCreatedByText(firstName));
    }

    @Test(dataProvider = "addContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithFile(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();

        assertTrue(app.getContact().isContactCreatedByText(contact.getFirstName()));
    }
}

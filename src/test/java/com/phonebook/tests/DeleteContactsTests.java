package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeleteContactsTests extends TestBase {

    @BeforeMethod
    public void Precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("test74@mail.com").setPassword("Qweyxc$9"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setFirstName("Ewan")
                .setLastName("Thomas")
                .setPhoneNumber("04963524897")
                .setEmail("thomas@mail.com")
                .setAddress("Berlinerstr. 5, 12345 Berlin")
                .setDescription("description"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        assertEquals(sizeAfter, sizeBefore - 1);    }

}

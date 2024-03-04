package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateAccountTests extends TestBase {

    // 1 - click on Login link
    // 2 - enter email
    // 3 - enter password
    // 4 - click on Registration
    // 5 - assert SignOut button is present

//    @Test
    // This Test can be executed only once !!!
    /*public void createNewAccountPositiveTest() {
        // 1
        click(By.cssSelector("[href='/login']"));
        // 2
        type(By.name("email"), "test74@mail.com");
        // 3
        type(By.name("password"), "Qweyxc$9");
        // 4
        click(By.name("registration"));
        // 5
        assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }*/

   /* @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            // click on Sign Out button
            click(By.xpath("//button[.='Sign Out']"));
        }
    }*/

/*
    @Test
    public void createExistedAccountNegativeTest() {
        // 1
        click(By.cssSelector("[href='/login']"));
        // 2
        type(By.name("email"), "test74@mail.com");
        // 3
        type(By.name("password"), "Qweyxc$9");
        // 4
        click(By.name("registration"));
        // 5
        assertTrue(isAlertAppears());
    }
*/


    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void createExistedAccountNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("test74@mail.com").setPassword("Qweyxc$9"));
        app.getUser().clickOnRegistrationButton();
        assertTrue(app.getUser().isAlertAppears());
    }


}

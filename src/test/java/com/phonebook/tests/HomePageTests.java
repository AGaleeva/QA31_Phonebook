package com.phonebook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTests extends TestBase {

    @BeforeMethod void ensurePrecondition() {
        if (!app.getHomePage().isHomeComponentPresent()) {
            app.getHomePage().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest() {
        assertTrue(app.getHomePage().isHomeComponentPresent());
    }
}

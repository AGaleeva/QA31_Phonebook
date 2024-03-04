package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addContacts() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"Oliver", "Kan", "1234567890", "kan@gmail.xon", "Berlin", "description"});
        list.add(new Object[] {"Oliver1", "Kan", "1234567890", "kan@gmail.xon", "Berlin", "description"});
        list.add(new Object[] {"Oliver2", "Kan", "1234567890", "kan@gmail.xon", "Berlin", "description"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contact.csv"));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setFirstName(split[0]).setLastName(split[1]).setPhoneNumber(split[2]).setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}

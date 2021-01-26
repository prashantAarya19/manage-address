package com.manageaddress;

import com.manageaddress.model.Address;
import com.manageaddress.model.Person;

import java.util.Locale;
import java.util.Map;

public class ManageAddressUtil {

    public static Person getPerson(Map<String, String> data) {
        Address address = new Address();
        address.setHouse(data.get("house").toLowerCase());
        address.setFloor(Integer.valueOf(data.get("floor")));
        address.setLocality(data.get("locality").toLowerCase());
        address.setSociety(data.get("society").toLowerCase());
        address.setPinCode(Integer.valueOf(data.get("pincode")));
        address.setCity(data.get("city").toLowerCase());
        address.setState(data.get("state").toLowerCase());
        address.setStreet(data.get("street").toLowerCase());
        Person person = new Person();
        person.setEmail(data.get("email").toLowerCase());
        person.setName(data.get("name").toLowerCase());
        person.setAddress(address);
        return person;
    }
}

package com.manageaddress;

import com.manageaddress.model.Address;
import com.manageaddress.model.Person;

import java.util.Map;

public class ManageAddressUtil {

    public static Person getPerson(Map<String, String> data) {
        String lastName = "";
        Address address = new Address();
        address.setHouse(Integer.valueOf(data.get("house")));
        address.setFloor(Integer.valueOf(data.get("floor")));
        address.setLocality(data.get("locality").toLowerCase());
        address.setSociety(data.get("society").toLowerCase());
        address.setPinCode(Integer.valueOf(data.get("pincode")));
        address.setCity(data.get("city").toLowerCase());
        address.setState(data.get("state").toLowerCase());
        address.setStreet(data.get("street").toLowerCase());

        String[] name = data.get("name").split(" ");
        Person person = new Person();
        person.setFirstName(name[0]);
        for(int i = 1; i < name.length; i++){
            lastName += name[i].toLowerCase()+" ";
        }
        person.setLastName(lastName);
        person.setAddress(address);
        return person;
    }
}

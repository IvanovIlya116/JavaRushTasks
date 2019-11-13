package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

        Customer customer1 = new Customer() {
            @Override
            public String getCompanyName() {
                return "Company Name 1";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };

        Customer customer2 = new Customer() {
            @Override
            public String getCompanyName() {
                return "Company Name 2";
            }

            @Override
            public String getCountryName() {
                return "Canada";
            }
        };

        Contact contact1 = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38958456489";
            }
        };

        Contact contact2 = new Contact() {
            @Override
            public String getName() {
                return "FirstName2 LastName2";
            }

            @Override
            public String getPhoneNumber() {
                return "+48655648974984";
            }
        };

        DataAdapter dataAdapter = new DataAdapter(customer1,contact1);

        String countyCode = dataAdapter.getCountryCode();
        String company = dataAdapter.getCompany();
        String firstName = dataAdapter.getContactFirstName();
        String lastName = dataAdapter.getContactLastName();
        String dialString = dataAdapter.getDialString();
        System.out.println(firstName );

    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }


        @Override
        public String getCountryCode() {
            String key = null;
            String value = customer.getCountryName();
            for (Map.Entry<String,String> entry: countries.entrySet()) {
                if( entry.getValue().equals(value)){
                    key = entry.getKey();
                }
            }
            return key;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name = contact.getName().split(",");
            return name[1].trim();
        }

        @Override
        public String getContactLastName() {
            String[] name = contact.getName().split(",");
            return name[0].trim();
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replaceAll("[()-]","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }

}
package org.example;

import db.Database;
import entities.menu.Menu;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = Database.getHibSesh();

        Menu.chooseAccount();


    }
}

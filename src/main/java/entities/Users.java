package entities;

import db.Database;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
@Entity (name = "accounts")
@Data
@NoArgsConstructor

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static int id;
    @Column (name = "age")
    private int age;
    @Column (name = "name")
    private String name;
    @Column (name = "email")
    private String email;
    @Column (name = "admin")
    private boolean isAdmin;

    static Session session = (Session) Database.getHibSesh();

    Scanner scanner = new Scanner(System.in);


    public Users(int age, String name, String email, boolean isAdmin) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;

    }

    public static void updateUsers(int age, String name, String email, boolean isAdmin) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Users user = session.get(Users.class, id); // correction by title
        try {
            session.merge(user);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }

    }

    public static void deleteUsers(int id) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Users user = session.get(Users.class, id); // correction by title
        try {
            session.delete(user);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    public static void listUsers() {

        try {
            session.beginTransaction();
            List<Users> user = session.createQuery("from users").list();

            user.forEach(System.out::println);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createUser(Users user) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        try {
            session.persist(user);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }

    }


}

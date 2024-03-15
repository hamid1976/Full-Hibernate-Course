package com.tut;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args)throws IOException {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //  Creating Object of Studnet Class
        Student st=new Student();
        st.setId(3);
        st.setName("Hamid");
        st.setCity("Larkana");
        System.out.println(st);

        //  Creating Object of Address Class
      /*  Address ad=new Address();
        ad.setStreet("Street 2");
        ad.setCity("LARKANA");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);

        FileInputStream fis=new FileInputStream("src/main/resources/userpic.jpg");
        byte[] data=new byte[fis.available()];
        fis.read();
        ad.setImage(data);*/

        Session session= factory.openSession();

        Transaction tx=session.beginTransaction();
        session.save(st);
       // session.save(ad);
        tx.commit();
        session.close();
    }
}

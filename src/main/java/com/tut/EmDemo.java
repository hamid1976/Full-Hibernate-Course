package com.tut;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String arg[]){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student st=new Student();
        st.setId(6);
        st.setName("UZAIR");
        st.setCity("HYDERABAD");

        Certificate ct=new Certificate();
        ct.setCourse("PHP");
        ct.setDuration("1 Months");
        st.setCerti(ct);

        Student st1=new Student();
        st1.setId(7);
        st1.setName("Govinda");
        st1.setCity("MEHAR");

        Certificate ct1=new Certificate();
        ct1.setCourse("AJAX");
        ct1.setDuration("2 Months");
        st1.setCerti(ct1);

        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();

        //object save

        s.save(st);
        s.save(st1);


        tx.commit();
        s.close();
        factory.close();


    }
}

package com.States;

import com.tut.Certificate;
import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String arg[]) {
        //Practical of Hibernate Objects States:
        //Transient
        //Persistent
        //Detached
        //Removed
        System.out.println("Practical of Hibernate Objects States");

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //Student Create
        Student st=new Student();
        st.setId(1);
        st.setName("Hamid");
        st.setCity("Hyderabad");
        st.setCerti(new Certificate("Java Hibernate Course","2 Month"));
        //Student: Transient

        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(st);
        st.setName("HAMIDULLAH");
        //  Student : Persistent - Session,Database

        //Student :Removed
        s.delete(st);


        tx.commit();

        //Student:Detached
        s.close();
        st.setName("Noor ");
        System.out.println(st);


        factory.close();
    }
}

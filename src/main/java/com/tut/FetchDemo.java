package com.tut;


import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.openmbean.SimpleType;
import java.util.Date;

public class FetchDemo {
    public static void main (String arg[]){

        //get   ,    load
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Session session= factory.openSession();

        //get
        Student student=(Student)session.load(Student.class,2);
        Student student1=(Student)session.load(Student.class,2);
        System.out.println(student.getName());

        Address address=(Address)session.get(Address.class,1);
        System.out.println(address.getCity()+":"+address.getAddedDate());

        Address ad1=(Address)session.get(Address.class,1);
        System.out.println(ad1.getCity()+":"+ad1.getAddedDate());




        factory.close();
        session.close();
    }
}

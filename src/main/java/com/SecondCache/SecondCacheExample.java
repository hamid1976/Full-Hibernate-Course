package com.SecondCache;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondCacheExample {
    public static void main(String arg[]){



        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        Session s1=factory.openSession();
        //first

        Student std1=s1.get(Student.class,1);
        System.out.println(std1);
        s1.close();

        Session s2=factory.openSession();
        //second

        Student std2=s2.get(Student.class,1);
        System.out.println(std2);
        s2.close();
    }
}

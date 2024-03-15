package com.FirstCache;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class FirstDemo {
  public static void main(String arg[]){
      Configuration cfg=new Configuration();
      cfg.configure("hibernate.cfg.xml");
      SessionFactory factory=cfg.buildSessionFactory();
      Session s=factory.openSession();
      //By Default Enabled

      Student std=s.get(Student.class,1);
      System.out.println(std);

      System.out.println("WORKING SOMETHING");

      Student std1=s.get(Student.class,1);
      System.out.println(std1);

      System.out.println(s.contains(std1));

      s.close();
  }
}

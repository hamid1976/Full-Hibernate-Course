package com.SqlQuery;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class SQLExample {
     public static void main(String arg[]){

         Configuration cfg=new Configuration();
         cfg.configure("hibernate.cfg.xml");
         SessionFactory factory=cfg.buildSessionFactory();
         Session s=factory.openSession();

         //SQL Query

         String q="select * from student";

         Query nq=s.createSQLQuery(q);

         List<Object[]> list=nq.list();

         for(Object[] std:list){
             System.out.println(std[4]+  ":"  +std[3]);
         }
         s.close();
         factory.close();


     }
}

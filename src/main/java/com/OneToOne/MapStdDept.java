package com.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapStdDept {
    public static void main(String arg[]){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //set Student
        Student1 st=new Student1();
        st.setStudentId(1);
        st.setName("HAMID");
        st.setAge(21);

        //set Department
        Department dpt=new Department();
        dpt.setDeptId(1);
        dpt.setDeptName("Information & Technology");
        st.setDept(dpt);



        //Set Student
        Student1 st1=new Student1();
        st1.setStudentId(2);
        st1.setName("AHSAN");
        st1.setAge(23);

        //set Department
        Department dpt1=new Department();
        dpt1.setDeptId(2);
        dpt1.setDeptName("COMPUTER SCIENCE");
        st1.setDept(dpt1);

        //Set Student
        Student1 st2=new Student1();
        st2.setStudentId(3);
        st2.setName("UZAIR");
        st2.setAge(35);

        //set Department
        Department dpt2=new Department();
        dpt2.setDeptId(3);
        dpt2.setDeptName("Softwear Engineering");
        st2.setDept(dpt2);


        //Creating Session
        Session s= factory.openSession();
        Transaction tx=s.beginTransaction();

        s.save(dpt);
        s.save(st);
        s.save(dpt1);
        s.save(st1);
        s.save(dpt2);
        s.save(st2);

        tx.commit();
        s.close();
        factory.close();

    }
}

package com.OneToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapFacDept {
    public static void main(String arg[]){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //creating faculty
        Faculty f=new Faculty();
        f.setFacId(1);
        f.setFaculty("FET");

        //creating department
        Department1 d=new Department1();
        d.setDeptId(1);
        d.setDeptName("INFORMATION & TECHNOLOGY");
        d.setFaculty(f);

        //creating department
        Department1 d1=new Department1();
        d1.setDeptId(2);
        d1.setDeptName("SOFTWEAR ENGINERRING");
        d1.setFaculty(f);

        //creating department
        Department1 d2=new Department1();
        d2.setDeptId(3);
        d2.setDeptName("TELECOM");
        d2.setFaculty(f);

        //creating department
        Department1 d3=new Department1();
        d3.setDeptId(4);
        d3.setDeptName("ELECTRONICS");
        d3.setFaculty(f);

        Session s=factory.openSession();
        Transaction tx= s.beginTransaction();

        s.save(f);
        s.save(d);
        s.save(d1);
        s.save(d2);
        s.save(d3);

        tx.commit();
        factory.close();
        s.close();

    }
}

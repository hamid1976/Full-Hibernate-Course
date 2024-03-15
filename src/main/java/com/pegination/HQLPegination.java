package com.pegination;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;


public class HQLPegination {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session s=factory.openSession();

        Query q=s.createQuery("from Student");

        //implementing pegination using hibernate
        q.setFirstResult(1);

        q.setMaxResults(2);

        List<Student> list= (List<Student>) ((org.hibernate.query.Query<?>) q).list();

        for(Student st:list){
            System.out.println(st.getName()+"   :   "+st.getCity()+"  :   " +st.getId() );
        }


        s.close();
        factory.close();
    }
}

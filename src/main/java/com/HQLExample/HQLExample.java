package com.HQLExample;

import com.tut.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        //Fetching List or Multiple Records
        String query = "from Student";

        Query q = session.createQuery(query);


        List<Student> list = q.list();

        for (int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            System.out.println(st.getName());
        }

        //Fetching Single record using where claus
        int targetId = 4;
        String query1 = "from Student where id = :targetId";
        Query q1 = session.createQuery(query1);
        q1.setParameter("targetId", targetId);

        Student st = (Student) q1.uniqueResult();
        System.out.println(st.getCity());

        // deleting querie
        System.out.println("___________________________________________________");

   /*     Transaction tx=session.beginTransaction();
        Query q2=session.createQuery("delete from Student where city=:c");
        q2.setParameter("c","Larkana");
        int r=q2.executeUpdate();
        System.out.println("Successfully Deleted");
        System.out.println("Rows Deleted:"+r);*/

       /*
       Transaction tx=session.beginTransaction();
        Query q2=session.createQuery("delete from Student where id=:i");
        q2.setParameter("i",2);
        int r=q2.executeUpdate();
        System.out.println("Successfully Deleted");
        System.out.println("Rows Deleted:"+r);
        */


        //update query
 /*     System.out.println("_____________________________________");
        Transaction tx=session.beginTransaction();
        Query q2=session.createQuery("update  Student set name='HAMID' where city=:c");
        q2.setParameter("c","HYDERABAD");
        int r=q2.executeUpdate();
        System.out.println("Successfully UPDATED");
        System.out.println("Rows UPDATED:"+r);*/

       /* Transaction tx1=session.beginTransaction();
        Query q3=session.createQuery("update  Student set city=:c where name=:n");
        q3.setParameter("c","MATIARI");
        q3.setParameter("n","AZHAR");
        int r1=q3.executeUpdate();
        System.out.println("Successfully UPDATED");
        System.out.println("Rows UPDATED:"+r1);

        tx1.commit();*/

        //how to execute join query
        Query q4=session.createQuery("select q.question ,q.questionId,a.answer from Question as q  INNER JOIN q.answers as a");
        List<Object []> list3=q4.getResultList();
        for (Object[] arr:list3){
            System.out.println(Arrays.toString(arr));
        }
        session.close();
        factory.close();

    }
}

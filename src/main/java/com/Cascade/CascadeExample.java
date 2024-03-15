package com.Cascade;

import com.map.Answer;
import com.map.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CascadeExample {
    public  static  void main(String arg[]){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session s=factory.openSession();

        Question q=new Question();
        q.setQuestionId(3);
        q.setQuestion("What is Swing Framework?");

        Answer a=new Answer(4,"Use for development");
        Answer a1=new Answer(5,"Desktop ");
        Answer a2=new Answer(6,"Learn By Programmers ");
        List<Answer> list=new ArrayList<>();
        list.add(a);
        list.add(a1);
        list.add(a2);

        q.setAnswers(list);
        Transaction tx= s.beginTransaction();

        s.save(q);
//        s.save(a);
//        s.save(a1);
//        s.save(a2);

        tx.commit();
        s.close();
        factory.close();
    }
}

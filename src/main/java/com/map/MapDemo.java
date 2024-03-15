package com.map;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class MapDemo {
    public  static void main(String arg[]) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //creating Question
        Question q1=new Question();
        q1.setQuestionId(1);
        q1.setQuestion("What is Java?");
//
//        //Creating Answer
        Answer a1=new Answer();
        a1.setAnswerId(1);
        a1.setAnswer("Java is Programming Language");
        a1.setQuestion(q1);
//
        Answer a2=new Answer();
        a2.setAnswerId(2);
        a2.setAnswer("With the help of Java we create softwears");
        a2.setQuestion(q1);

        Answer a3=new Answer();
        a3.setAnswerId(3);
        a3.setAnswer(" Java has different types of FrameWork");
        a3.setQuestion(q1);

        List<Answer> list=new ArrayList<Answer>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswers(list);


        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();

        //save
        s.save(q1);
        s.save(a1);
        s.save(a2);
        s.save(a3);


        tx.commit();

        //fetching

        Question q=(Question) s.get(Question.class,1);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());


        System.out.println(q.getAnswers().size());

//        for(Answer a:q.getAnswers()){
//            System.out.println(a.getAnswer());
//        }

        s.close();
        factory.close();
    }
}

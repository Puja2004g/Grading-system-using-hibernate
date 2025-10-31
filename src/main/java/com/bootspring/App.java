package com.bootspring;

import com.bootspring.entity.Student;
import com.bootspring.hibernateUtil.HibernateUtil;
import com.bootspring.services.studentServices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        MenuHandler handler = new MenuHandler();
        handler.mainMenu();
    }
}

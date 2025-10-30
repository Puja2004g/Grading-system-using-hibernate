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

        System.out.println(sessionFactory);
        studentServices services = new studentServices();
        Session session = sessionFactory.openSession();

        System.out.println("How many students you want to enter: ");
        int n;

        Scanner sc = new Scanner(System.in);
        Student student;

        n = Integer.parseInt(sc.nextLine());

        for(int i=0;i<n;i++){
            System.out.println(i);
            System.out.println("Enter first name: ");
            String Fname = sc.nextLine();
            System.out.println("Enter last name: ");
            String Lname = sc.nextLine();
            System.out.println("Enter department: ");
            String dept = sc.nextLine();

            student = new Student(Fname, Lname, dept);
            services.saveStudent(student);
        }
    }
}

package com.bootspring.services;

import com.bootspring.entity.Student;
import com.bootspring.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class studentServices {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//  save the student
    public  void saveStudent(Student student){
        try(Session session = sessionFactory.openSession()) {
            Transaction beginTransaction = session.beginTransaction();
            session.persist(student);
            beginTransaction.commit();
            System.out.println("Student saved");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
    }

//    get all Student
    public List<Student> getAllStudents(Student student){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    delete a student by id
    public void deleteStudent(int studentId){
        try(Session session = sessionFactory.openSession()){
            Student temp = session.find(Student.class,  studentId);
            session.remove(temp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

//    find student by id
    public Student findStudent(int studentId){
        try(Session session = sessionFactory.openSession()){
            Student temp = session.find(Student.class,  studentId);
            return temp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}

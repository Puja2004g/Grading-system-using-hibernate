package com.bootspring.services;

import com.bootspring.entity.Student;
import com.bootspring.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;
import java.util.Queue;

public class studentServices {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//  save the student
    public  void saveStudent(Student student){
        Transaction beginTransaction = null;
        try(Session session = sessionFactory.openSession()) {
            beginTransaction = session.beginTransaction();
            session.persist(student);
            beginTransaction.commit();
            System.out.println("Student saved");
        }
        catch (Exception e){
            if(beginTransaction != null){
                beginTransaction.rollback();
            }
            System.out.println(e.getMessage());
            return;
        }
    }

//    get all Student
    public List<Student> getAllStudents(){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    delete a student by id
    public void deleteStudent(int studentId){
        Transaction beginTransaction = null;
        try(Session session = sessionFactory.openSession()){
            beginTransaction = session.beginTransaction();
            Student temp = session.find(Student.class,  studentId);
            session.remove(temp);
            beginTransaction.commit();
            System.out.println("Deleted");
        } catch (Exception e) {
            if(beginTransaction != null){
                beginTransaction.rollback();
            }
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

//    find student by name
    public Student findStudentByName(String studentName){
        try(Session session = sessionFactory.openSession()){
            String getName ="From Student where firstName = :studentName";
            Query<Student> query =session.createQuery(getName,Student.class);
            query.setParameter(("studentName"), studentName);
            List<Student> lists = query.list();
            if(!lists.isEmpty()){
                return lists.get(0);
            }
            else{
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    Delete student by name
    public void deleteStudentByName(String studentName){
        Transaction beginTransaction = null;
        try(Session session = sessionFactory.openSession()){
            beginTransaction = session.beginTransaction();

            String getName = "From Student where firstName = :studentName";
            Query<Student> query = session.createQuery(getName, Student.class);

            List<Student> lists = query.list();

            if(!lists.isEmpty()) {
                for (Student st : lists) {
                    session.remove(st);
                }

                beginTransaction.commit();
                System.out.println("Deleted");
            }
            else{
                System.out.println("Not found");
            }
        } catch (Exception e) {
            if(beginTransaction!=null){
                beginTransaction.rollback();
            }
            System.out.println(e.getMessage());
            return;
        }
    }

//    find student by department
    public List<Student> findStudentByDepartment(String depart){
        try(Session session = sessionFactory.openSession()){
            String dept = "From Student where department = :depart";
            Query<Student> query = session.createQuery(dept, Student.class);
            List<Student> lists = query.list();

            if(!lists.isEmpty()){
                return lists;
            }
            else {
                return null;
            }
        }
    }

//    count no. of students
    public int countStudent(){
        List<Student> getStudents = getAllStudents();
        return getStudents.size();
    }

//  update student details
    public void updateStudent(int id, Student student){
        Transaction beginTransaction = null;
        try(Session session = sessionFactory.openSession()) {
            beginTransaction = session.beginTransaction();
            Student oldStudent = session.find(Student.class, id);

            if(oldStudent!=null){
                if (student.getFirstName() != null && !student.getFirstName().isEmpty()) {
                    oldStudent.setFirstName(student.getFirstName());
                }

                if (student.getLastName() != null && !student.getLastName().isEmpty()) {
                    oldStudent.setLastName(student.getLastName());
                }

                if (student.getDepartment() != null && !student.getDepartment().isEmpty()) {
                    oldStudent.setDepartment(student.getDepartment());
                }

            }

//            session.merge(oldStudent);
            beginTransaction.commit();
            System.out.println("Updated");
        } catch (Exception e) {
            if(beginTransaction != null){
                beginTransaction.rollback();
            }
            System.out.println(e.getMessage());
            return;
        }
    }
}

package com.bootspring;

import com.bootspring.entity.Student;
import com.bootspring.hibernateUtil.HibernateUtil;
import com.bootspring.services.studentServices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    studentServices services = new studentServices();
    Session session = sessionFactory.openSession();


    public void mainMenu(){
        while(true){
            System.out.println("1. Add a new student");
            System.out.println("2. Find a student by id");
            System.out.println("3. Delete a student by id");
            System.out.println("4. Get all student");
            System.out.println("5. Find a Student by name");
            System.out.println("6. Delete a Student by name");
            System.out.println("7. Update student details");
            System.out.println("8. Find Students by department");
            System.out.println("9. Count total number of students");
            System.out.println("10. Exit the program");

            Scanner sc = new Scanner(System.in);

            System.out.println("Choose an option: ");
            int n = Integer.parseInt(sc.nextLine());
            Student student;

//            add a new student
            if(n==1){
                System.out.println("How many students you want to enter: ");
                int x = Integer.parseInt(sc.nextLine());

                for(int i=0;i<x;i++) {
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
//            find student by id
            else if(n==2){
                System.out.println("Enter student id: ");
                int id = Integer.parseInt(sc.nextLine());
                Student temp = services.findStudent(id);
                System.out.println(temp.getFirstName()+" " +temp.getLastName() + " "+temp.getDepartment());
            }
//            delete student by id
            else if(n==3){
                System.out.println("Enter student id: ");
                int id = Integer.parseInt(sc.nextLine());
                services.deleteStudent(id);
            }
//            get all student
            else if(n==4){
                List<Student> all = services.getAllStudents();
                if(all!=null && !all.isEmpty()){
                    for(Student st : all){
                        System.out.println(st.getFirstName() + " " + st.getLastName() + " " + st.getDepartment());
                    }
                }
            }
//            find a student by name
            else if(n==5){
                System.out.println("Enter student name: ");
                String name = (sc.nextLine());
                Student temp = services.findStudentByName(name);
                System.out.println(temp.getStudentId() + " " + temp.getFirstName()+" " +temp.getLastName() + " "+temp.getDepartment());
            }
//            delete a student by name
            else if(n==6){
                System.out.println("Enter student name: ");
                String name = (sc.nextLine());
                services.deleteStudentByName(name);
            }
//            update student details
            else if(n==7){

            }
//            find student by department
            else if(n==8){
                System.out.println("Enter student name: ");
                String name = (sc.nextLine());
                List<Student> temp = services.findStudentByDepartment(name);
                if(temp!=null){
                    for(Student st : temp){
                        System.out.println(st.getStudentId() +" "   +st.getFirstName() + " " + st.getLastName() + " " + st.getDepartment());
                    }
                }
            }
//            count total number of students
            else if(n==9){

            }
            else{
                return;
            }
        }
    }
}

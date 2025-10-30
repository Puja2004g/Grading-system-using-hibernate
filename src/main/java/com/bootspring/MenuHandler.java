package com.bootspring;

import java.util.Scanner;

public class MenuHandler {
    public void mainMenu(){
        while(true){
            System.out.println("Choose an option: ");
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

            int n = Integer.parseInt(sc.nextLine());

            if(n==1){

            }
            else if(n==2){

            }
            else if(n==3){

            }
            else if(n==4){

            }
            else if(n==5){

            }
            else if(n==6){

            }
            else if(n==7){

            }
            else if(n==8){

            }
            else if(n==9){

            }
            else{
                return;
            }
        }
    }
}

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    static ArrayList<Course> courses = new ArrayList<Course>();
    public static void main(String[] args){



        //students.add(new Student("Marcus", 98, 15, "Male"));

        //teachers.add(new Teacher("David Buckley", "Game Development", 5, "Computer Science"));
        //UpdateData.updateStudent(6,"geraldo",16,10);

       while(true){
           boolean exit = false;
           try {
               System.out.println("Would you like to \n 1. Add a teacher \n 2. Add a student \n 3. Create a course \n 4. See all students in database \n 5. See all teachers in database \n 6. See all courses in the database \n 7. Change a students data \n 8. Change a teachers data \n or 15. Add students and teachers to the Database?");
               int input = scn.nextInt();
               scn.nextLine();
               switch(input){
                   case 1:
                       askToMakeATeacher();
                       break;
                   case 2:
                       askToMakeAStudent();
                       break;
                   case 3 :
                       askToMakeACourse();
                       break;
                   case 4:
                       var products = SelectStudents.findAll();
                       for (var product: products) {
                           System.out.println(product);
                       }
                       break;
                   case 5:
                       var teachers = SelectStudents.findAllTeachers();
                       for (var product: teachers) {
                           System.out.println(product);
                       }
                       break;
                   case 6:
                       var courses = SelectStudents.findAllCourses();
                       for (var product: courses) {
                           System.out.println(product);
                       }
                       break;
                   case 7:
                       SetStudent();
                       break;
                   case 8:
                       SetTeacher();
                       break;
                   case 15:
                       exit = true;
                       break;
               }
           } catch(Exception e){
               System.out.println("Bad Input Try Again");
               //probably makes this work I hope?
               scn.nextLine();
           }

           if(exit){
               break;
           }

       }




        TeacherValue.add(teachers);
        StudentValue.add(students);
        CourseValue.add(courses);

    }

    private static void askToMakeATeacher(){
        System.out.println("Would you like to add a teacher?");
        try{
            String j = scn.nextLine();
            if(j.toLowerCase().equals("yes") || j.toLowerCase().equals("y") || j.toLowerCase().equals("sure") || j.toLowerCase().equals("yea")){
                teachers.add(makeTeacher());
            }
        } catch (Exception e){
            System.out.println("Bad input. Skipping making a teacher...");
        }
    }
    private static void askToMakeACourse(){
        System.out.println("Would you like to add a course?");
        try{
            String j = scn.nextLine();
            if(j.toLowerCase().equals("yes") || j.toLowerCase().equals("y") || j.toLowerCase().equals("sure") || j.toLowerCase().equals("yea")){
                courses.add(makeCourse());
            }
        } catch (Exception e){
            System.out.println("Bad input. Skipping making a teacher...");
        }
    }
    private static void askToMakeAStudent(){
        System.out.println("Would you like to add a student?");
        try{
            String j = scn.nextLine();
            if(j.toLowerCase().equals("yes") || j.toLowerCase().equals("y") || j.toLowerCase().equals("sure") || j.toLowerCase().equals("yea")){
                students.add(makeStudent());
            }
        } catch (Exception e){
            System.out.println("Bad input. Skipping making a student...");
        }
    }
    private static Teacher makeTeacher(){
        Teacher tempTeacher = new Teacher("","",-1,"");
        System.out.println("what is the name of the teacher?");
        tempTeacher.setName(scn.nextLine());
        System.out.println("What subject does the teacher teach?");
        tempTeacher.setSubject(scn.nextLine());
        System.out.println("How many year of experience does this teacher have?");
        tempTeacher.setYearsOfExperience(scn.nextInt());
        scn.nextLine();
        System.out.println("What department is the teacher in?");
        tempTeacher.setDepartment(scn.nextLine());
        System.out.println(tempTeacher.toString());
        return tempTeacher;
    }
    private static Student makeStudent(){
        Student tempStudent = new Student("",-1,-1,"");
        System.out.println("what is the name of the student?");
        tempStudent.setName(scn.nextLine());
        System.out.println("What is the students grade (number)?");
        tempStudent.setGrade(scn.nextInt());
        scn.nextLine();
        System.out.println("How old is the student?");
        tempStudent.setAge(scn.nextInt());
        scn.nextLine();
        System.out.println("What is the students gender?");
        tempStudent.setGender(scn.nextLine());
        System.out.println(tempStudent.toString());
        return tempStudent;
    }
    private static Course makeCourse(){
        Course tempCourse = new Course("","",-1,"");
        System.out.println("what is the name of the course?");
        tempCourse.setName(scn.nextLine());
        System.out.println("What is the course description?");
        tempCourse.setDescription(scn.nextLine());

        System.out.println("What teacher ID does this course have?");
        tempCourse.setTeacher_id(scn.nextInt());
        scn.nextLine();
        System.out.println("What is the period of this course?");
        tempCourse.setSchedule(scn.nextLine());
        System.out.println(tempCourse.toString());
        return tempCourse;
    }

    private static void SetStudent(){
        int id;
        String name;
        int grade;
        int age;


        Student baseStudent = null;

        System.out.println("What student would you like to change? (Give student id)");
        id = scn.nextInt();
        scn.nextLine();
        var students = SelectStudents.findAll();
        for (var product: students) {
            if(product.id == id) {
                baseStudent = product;
            }
        }
        try {
            if (baseStudent == null) {
                throw new Exception("Student id invalid");
            }
        } catch (Exception e){
            System.out.println(e);
            return;
        }
        System.out.println("What would you like to change the name to? type 0 for no change");
        name = scn.nextLine();
        if(name.toLowerCase().equals("0")){
            name = baseStudent.name;
        }
        System.out.println("What is the new grade of the Student? type 0 for no change");
        grade = scn.nextInt();
        scn.nextLine();
        if(grade == 0){
            grade = baseStudent.grade;
        }

        System.out.println("What is the new age of the student? type 0 for no change");
        age = scn.nextInt();
        scn.nextLine();
        if(age == 0){
            age = baseStudent.age;
        }
        UpdateData.updateStudent(id,name,age,grade);
    }
    private static void SetTeacher(){
        int id;
        String name;
        String subject;
        int years;
        String department;


        Teacher baseTeacher = null;

        System.out.println("What teacher would you like to change? (Give teacher id)");
        id = scn.nextInt();
        scn.nextLine();
        var students = SelectStudents.findAllTeachers();
        for (var product: students) {
            if(product.id == id) {
                baseTeacher = product;
            }
        }
        try {
            if (baseTeacher == null) {
                throw new Exception("Teacher id invalid");
            }
        } catch (Exception e){
            System.out.println(e);
            return;
        }
        System.out.println("What would you like to change the name to? type 0 for no change");
        name = scn.nextLine();
        if(name.toLowerCase().equals("0")){
            name = baseTeacher.name;
        }
        System.out.println("What is the new subject of the Teacher? type 0 for no change");
        subject = scn.nextLine();

        if(subject.equals("0")){
            subject = baseTeacher.subject;
        }

        System.out.println("How long has the teacher taught? type -1 for no change");
        years = scn.nextInt();
        scn.nextLine();
        if(years == 0){
            years = baseTeacher.yearsOfExperience;
        }

        System.out.println("What is the new department of the Teacher? type 0 for no change");
        department = scn.nextLine();

        if(department.equals("0")){
            department = baseTeacher.department;
        }
        UpdateData.updateTeacher(id,name,subject,years,department);
    }

}
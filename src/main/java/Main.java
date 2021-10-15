import org.joda.time.DateTime;
import java.util.ArrayList;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        // First, create a bunch of test objects
        Student student1 = new Student(
                "James",
                (short)22,
                DateTime.parse("1999-01-01"),
                "1111",
                new ArrayList<Course>(),
                new ArrayList<Module>()
        );

        Student student2 = new Student(
                "Sam",
                (short)20,
                DateTime.parse("2001-06-12"),
                "1112",
                new ArrayList<Course>(),
                new ArrayList<Module>()
        );

        Student student3 = new Student(
                "Catherine",
                (short)35,
                DateTime.parse("1987-12-1"),
                "1113",
                new ArrayList<Course>(),
                new ArrayList<Module>()
        );

        Module module1 = new Module(
                "Machine Learning",
                "CT4101",
                new ArrayList<Student>(),
                new ArrayList<Course>()
        );

        Module module2 = new Module(
                "Programming 3",
                "CT326",
                new ArrayList<Student>(),
                new ArrayList<Course>()
        );

        Module module3 = new Module(
                "Calculus",
                "MA392",
                new ArrayList<Student>(),
                new ArrayList<Course>()
        );

        Course course1 = new Course(
            "CS & IT",
                new ArrayList<Module>(),
                new ArrayList<Student>(),
                DateTime.parse("2021-09-15"),
                DateTime.parse("2025-05-20")
        );

        Course course2 = new Course(
                "DS",
                new ArrayList<Module>(),
                new ArrayList<Student>(),
                DateTime.parse("2021-10-20"),
                DateTime.parse("2024-06-01")
        );

        // Step 2: Create connections between test objects
        course1.addModule(module1);
        course1.addModule(module2);
        course1.addStudent(student1);
        course1.addStudent(student2);

        course2.addModule(module2);
        course2.addModule(module3);
        course2.addStudent(student3);

        module1.addStudent(student3);
        module1.addStudent(student1);

        module2.addStudent(student1);
        module2.addStudent(student2);

        module3.addStudent(student3);

        // Step 3: Print the names of objects and the contents
        // of their arrayLists
        System.out.println("Courses:");
        System.out.println(course1.getName() + " Students:");
        printListNames(course1.getStudents());
        System.out.println();
        System.out.println(course1.getName() + " Modules:");
        printListNames(course1.getModules());
        System.out.println();

        System.out.println(course2.getName() + " Students:");
        printListNames(course2.getStudents());
        System.out.println();
        System.out.println(course2.getName() + " Modules:");
        printListNames(course2.getModules());
        System.out.println("===========================================");

        System.out.println("Modules:");
        System.out.println(module1.getName() + " Courses:");
        printListNames(module1.getCourses());
        System.out.println();
        System.out.println(module1.getName() + " Students:");
        printListNames(module1.getStudents());
        System.out.println();

        System.out.println(module2.getName() + " Courses:");
        printListNames(module2.getCourses());
        System.out.println();
        System.out.println(module2.getName() + " Students:");
        printListNames(module2.getStudents());
        System.out.println();

        System.out.println(module3.getName() + " Courses:");
        printListNames(module3.getCourses());
        System.out.println();
        System.out.println(module3.getName() + " Students:");
        printListNames(module3.getStudents());
        System.out.println("===========================================");

        System.out.println("Students:");
        System.out.println(student1.getName() + " Courses:");
        printListNames(student1.getCourses());
        System.out.println();
        System.out.println(student1.getName() + " Modules:");
        printListNames(student1.getModules());
        System.out.println();

        System.out.println(student2.getName() + " Courses:");
        printListNames(student2.getCourses());
        System.out.println();
        System.out.println(student2.getName() + " Modules:");
        printListNames(student2.getModules());
        System.out.println();

        System.out.println(student3.getName() + " Courses:");
        printListNames(student3.getCourses());
        System.out.println();
        System.out.println(student3.getName() + " Modules:");
        printListNames(student3.getModules());
        System.out.println("===========================================");
    }

    public static <T> void printListNames(ArrayList<T> list){
        // Take in an ArrayList of abstract objects and print them
        // This could be replaced by 3 different methods to print each
        // type of list, but it works for now
        for (Object o : list) {
            try{
                System.out.println(((Student)o).getName());
                continue;
            }
            catch (ClassCastException e) {
                // Not a student list. Continue
            }
            try{
                System.out.println(((Module)o).getName());
                continue;
            }
            catch (ClassCastException e) {
                // Not a Module list. Continue
            }
            try{
                System.out.println(((Course)o).getName());
            }
            catch (ClassCastException e) {
                System.out.println("Some unknown class was entered. Exiting...");
                return;
            }
        }
    }
}

import org.joda.time.DateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
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

        System.out.println(course1.getName() + ":\n" + course1.getModules());
        System.out.println(course2.getName() + ":\n" + course2.getModules());
    }
}

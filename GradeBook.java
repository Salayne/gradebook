import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeBook {
    LinkedList<Student> student = new LinkedList<>();
    GradeBook(String filename){
        String line;
        try {
            File openFile = new File(filename);
            Scanner scan = new Scanner(openFile);
            while (scan.hasNextLine()){
                line = scan.nextLine();
                Student newStudent = new Student(line);
                student.add(newStudent);
            }
        }catch (FileNotFoundException fnf){
            System.out.println("Error: File not found");

        }
    }

    public Student getStudent(String name){  //needs fixing
        for (Student cell:student) {
            if (cell.getName().equals(name)){
                return student.peek();
            }
        }
        return null;
    }

    public void getStudentGrade(String name){
        for (Student cell :student) {
            if (cell.getName().equals(name)){
                System.out.println(cell.getGrade());
            }
        }
    }
    public LinkedList<String> getAllStudentNames(){
        LinkedList<String> studentNames = new LinkedList<>();
        for (Student cell: student) {
            studentNames.add(cell.getName());
        }
        return studentNames;
    }

}

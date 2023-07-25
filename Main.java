import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StatisticGradeBook sgb = new StatisticGradeBook("Assignment7-Spreadsheet.csv");
        Thread thread = new Thread(sgb);
        thread.start();

        System.out.println("What student would you like to see grades for ");
        String name = input.next();
        sgb.getStudentGrade(name);

    }
}
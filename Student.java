import java.lang.reflect.Array;
import java.util.Arrays;

public class Student {

    private int [] quizScores = new int[9];
    private int [] homeworkScores = new int[9];
    private int midtermExam;
    private int finalExam;
    private double quizAverage;
    private double homeworkAverage;
    private double overallAverage;
    private String name;
    private int ID;
    Student(String line){
        String [] tokens = line.split(",");
        name = tokens[0];
        ID = Integer.parseInt(tokens[1]);
        for (int i = 0; i < quizScores.length; i++){
            quizScores[i] = Integer.parseInt(tokens[2+i]);
            homeworkScores[i] = Integer.parseInt(tokens[11 + i]);
        }
        midtermExam = Integer.parseInt(tokens[20]);
        finalExam = Integer.parseInt(tokens[21]);
    }
    public String getName(){ return name;}
    public int getID() { return ID;}
    public void calcQuizAverage(){
        int min = quizScores[0];
        double sum = 0;
        for (int i = 0; i < quizScores.length; i++){
            if (quizScores[i] < min){
                min = quizScores[i];
            }
            sum += quizScores[i]; //?
        }
        quizAverage = (sum-min) / (quizScores.length -1);
    }
    public void calcHWAverage(){
        int min = homeworkScores[0];
        double sum = 0;
        for (int i = 0; i < homeworkScores.length; i++){
            if (homeworkScores[i] < min){
                min = homeworkScores[i];
            }
            sum += homeworkScores[i];
        }
        homeworkAverage = (sum - min) / (homeworkScores.length - 1);
    }
    public void calcOverallAverage(){
        calcQuizAverage();
        calcHWAverage();
        double quizPercentage = (quizAverage * .4);
        double homeworkPercentage = (homeworkAverage * .1);
        double midtermPercentage = (midtermExam * .2);
        double finalPercentage = (finalExam * .3);
        overallAverage = quizPercentage + homeworkPercentage + midtermPercentage + finalPercentage;
    }


    /*
    h. Write a method getGrade()
        i. It should return a string with all the values from the attributes. See
           output below for an example of how it should be formatted.*/
    public String getGrade() {
        String grade = "";
        for (int i = 0; i < quizScores.length; i++) {
            grade += "Quiz " + i + ": " + quizScores[i] + "\n";
        }
        grade += "Quiz Avg: " + quizAverage + "\n";

        for (int i = 0; i < homeworkScores.length; i++) {
            grade += "HW " + i + ": " + homeworkScores[i] + "\n";
        }
        grade += "HW Avg: " + homeworkAverage + "\n";
        grade += "Midterm: " + midtermExam + " Final Exam: " + midtermExam + "\n";
        grade += "Overall Average: " + overallAverage + "\n";
        return grade;
    }
}


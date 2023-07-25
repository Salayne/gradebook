import java.util.LinkedList;

public class StatisticGradeBook extends GradeBook implements Runnable{
    StatisticGradeBook(String filename){ super(filename);}
    @Override
    public void run() {
        LinkedList<String> getAllNames = new LinkedList<>();
        int count = 0;

        for (Student cell: student) {
            getAllNames.add(cell.getName());
            cell.calcQuizAverage();
            cell.calcHWAverage();
            cell.calcOverallAverage();
            count ++;
            if (count % 100 == 0 && count <= 900){
                System.out.println("Calculating grades " + count + " out of 1000");
            }
        }
        System.out.println("All grades calculated");
    }





}

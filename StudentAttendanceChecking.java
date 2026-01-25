import java.util.Scanner;
public class StudentAttendanceChecking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentnumber=2;
        String [][] student=new String[studentnumber][2];
        float[][] attend=new float[studentnumber][2];
        for(int i=0;i<student.length;i++){
            System.out.println("Enter student name");
            String name=scan.next();
            student[i][0]=name;
            System.out.println("Enter student surname");
            String surname=scan.next();
            student[i][1]=surname;
            System.out.println("Enter students discontinuity");
            int discontinuity=scan.nextInt();
            attend[i][0]=discontinuity;
            System.out.println("Enter students total lesson");
            int totallesson=scan.nextInt();
            attend[i][1]=totallesson;
        }
        for(int i=0;i<student.length;i++){
            float ratio=(attend[i][0]/attend[i][1]);
            System.out.print(student[i][0]+" "+student[i][1]+" ");
            System.out.print(attend[i][0]+" "+attend[i][1]+" ");
            if(ratio>(float)3/10){
                System.out.print("Failed");
            }
            else System.out.print("Passed");
            System.out.println();
        }
    }
}
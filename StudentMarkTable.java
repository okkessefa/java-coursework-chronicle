import java.util.Scanner;
public class StudentMarkTable{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        System.out.print("How many students exist in class: ");
        int Scount = sn.nextInt();
        String[][] table = new String[Scount + 1][5];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = "-";
            }
        }
        table[0][0] = "Name";
        table[0][1] = "M1";
        table[0][2] = "M2";
        table[0][3] = "F";
        table[0][4] = "A";
        for (int i = 1; i <= Scount; i++) {
            System.out.print("Enter student name: ");
            table[i][0] = sn.next();
        }
        while (true) {
            // Print table
            System.out.println("\n--- Student Table ---");
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    System.out.print(table[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.print("\nEnter student name (or exit): ");
            String name = sn.next();
            if (name.equalsIgnoreCase("exit")) break;
            System.out.print("Enter exam name (M1, M2, F): ");
            String exam = sn.next().toUpperCase();
            int indexN = -1, indexE = -1;
            for (int i = 1; i < table.length; i++) {
                if (table[i][0].equals(name)) {
                    indexN = i;
                    break;
                }
            }
            for (int i = 1; i < table[0].length - 1; i++) {
                if (table[0][i].equals(exam)) {
                    indexE = i;
                    break;
                }
            }
            if (indexN == -1 || indexE == -1) {
                System.out.println("Invalid student or exam!");
                continue;
            }
            System.out.print("Enter student note: ");
            int note = sn.nextInt();
            table[indexN][indexE] = String.valueOf(note);
            int sum = 0, count = 0;
            for (int i = 1; i <= 3; i++) {
                if (!table[indexN][i].equals("-")) {
                    sum += Integer.parseInt(table[indexN][i]);
                    count++;
                }
            }
            if (count > 0) {
                table[indexN][4] = String.valueOf(sum / count);
            }
        }
    }    
}
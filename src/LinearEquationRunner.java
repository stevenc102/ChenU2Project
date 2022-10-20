import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");


        String coords1 = scan.nextLine();
        int indexOfClosing1 = coords1.indexOf(")");
        String withoutPar = coords1.substring(1).substring(0, indexOfClosing1 - 1);
        int indexOfComma = coords1.indexOf(",");

        double x1 = Integer.parseInt(withoutPar.substring(0, indexOfComma - 1));
        double y1 = Integer.parseInt(withoutPar.substring(indexOfComma + 1));

        System.out.print("Enter coordinate 2: ");
        String coords2 = scan.nextLine();
        int indexOfClosing2 = coords2.indexOf(")");
        String withoutPar2 = coords2.substring(1).substring(0, indexOfClosing2 - 1);
        int indexOfComma2 = coords2.indexOf(",");


        double x2 = Integer.parseInt(withoutPar2.substring(0, indexOfComma2 - 1));
        double y2 = Integer.parseInt(withoutPar2.substring(indexOfComma2 + 1));


        System.out.println("");


        if (x2 - x1 != 0) {
            LinearEquation linearEq = new LinearEquation(x1,y1,x2,y2);
            System.out.println(linearEq.lineInfo());
            System.out.print("Enter a value for x: ");
            double newX = scan.nextDouble();
            scan.nextLine();
            System.out.println(linearEq.coordinateForX(newX));

        } else {
            System.out.println("These points are on a vertical line: " + "x = " + (int) x1);
        }

    }
}

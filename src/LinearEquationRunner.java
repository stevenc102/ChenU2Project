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

        LinearEquation linearEq = new LinearEquation(x1,y1,x2,y2);

        double intercept = 0;
        if (x2 - x1 != 0) {
            System.out.println("The two points are: (" + (int) x1 + ", " + (int) y1 + ")" + " and " + "(" + (int) x2 + ", " + (int) y2 + ")");
            System.out.println("The equation of the line between these points is " + linearEq.returnEquation());
            System.out.println("The slope of this line is: " + linearEq.calculateSlope(x1, y1, x2, y2));
            double slope = linearEq.calculateSlope(x1, y1, x2, y2);
            if (linearEq.calculateIntercept().indexOf("-") != -1) {
                System.out.println("The y-intercept of the line is: " + "-" + linearEq.calculateIntercept().substring(3));
                intercept = -1 * Integer.parseInt(linearEq.calculateIntercept().substring(3, linearEq.calculateIntercept().length() - 2));
            } else {
                System.out.println("The y-intercept of the line is: " + linearEq.calculateIntercept().substring(3));
                intercept = Integer.parseInt(linearEq.calculateIntercept().substring(3, linearEq.calculateIntercept().length() - 2));
            }
            System.out.println("The distance between the two points is: " + linearEq.calculateDistance());

            System.out.println("");

            System.out.print("Enter a value for x: ");
            double newX = scan.nextDouble();
            scan.nextLine();
            System.out.println("\nThe point on the line is (" + newX + ", " + (slope * newX + intercept) + ")");
        } else {
            System.out.println("These points are on a verical line: " + "x = " + x1);
        }
    }
}

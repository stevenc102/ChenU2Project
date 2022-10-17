import java.util.Scanner;
public class LinearEquationRunner {
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome!");
    System.out.println("Enter coordinate 1: ");
    String coords1 = scan.nextLine();
    String withoutPar = coords1.substring(1).substring(0, coords1.length() - 1);
    int indexOfComma = coords1.indexOf(",");
    double x1 = Integer.parseInt(withoutPar.substring(0, indexOfComma));
    double y1 = Integer.parseInt(withoutPar.substring(indexOfComma + 2));
    System.out.println("Enter coordinate 1: ");
    String coords2 = scan.nextLine();
    double x2 = Integer.parseInt( coords1.substring(1,2));
}

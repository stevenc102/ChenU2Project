public class LinearEquation {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double calculateSlope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public double calculateIntercept() {
        return y2 - (x1 * calculateSlope(x1, y1, x2, y2));
    }

    public double roundedToHundredth(double num) {
        return Math.round(num);
    }

    public String returnEquation() {
        int temp = (int) calculateSlope(x1, y1, x2, y2);
        if (calculateSlope(x1, y1, x2, y2) > temp) {
            if (calculateSlope(x1, y1, x2, y2) < 0) {
                return "y = " + "-" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x  + " + calculateIntercept();
            }
            return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x  + " + calculateIntercept();
        }
        if (calculateSlope(x1, y1, x2, y2) == 0) {
            return "y = " + calculateIntercept();
        }
        if (calculateSlope(x1, y1, x2, y2) < 0) {
            return "y = " + "-" + Math.abs(calculateSlope(x1,y1,x2,y2) + "x + " + calculateIntercept();
        }
        return "y = " + calculateSlope(x1, y1, x2, y2) + "x + " + calculateIntercept();
    }





}

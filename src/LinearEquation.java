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

    public String calculateIntercept() {
        if (y2 - (x2 * calculateSlope(x1, y1, x2, y2)) < 0) {
            return " - " + Math.abs((y2 - (x2 * calculateSlope(x1, y1, x2, y2))));
        }
        return " + " + (y2 - (x2 * calculateSlope(x1, y1, x2, y2)));
    }

    public double roundedToHundredth(double num) {
        return Math.round(num * 100) / 100.0;
    }

    public double calculateDistance() {
        return roundedToHundredth(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }

    public String returnEquation() {
        int temp = (int) calculateSlope(x1, y1, x2, y2);
        if (calculateSlope(x1, y1, x2, y2) == 1){
            return "y = " + "x" + calculateIntercept();
        }

        if (calculateSlope(x1, y1, x2, y2) == -1){
            return "y = " + "-x" + calculateIntercept();
        }

        if (calculateSlope(x1, y1, x2, y2) > temp) {
            if (calculateSlope(x1, y1, x2, y2) < 0) {
                return "y = " + "-" + (int) Math.abs(y2 - y1) + "/" + (int) Math.abs(x2 - x1) + "x" + calculateIntercept();
            }
            return "y = " + (int) (y2 - y1) + "/" + (int) (x2 - x1) + "x" + calculateIntercept();
        }
        if (calculateSlope(x1, y1, x2, y2) == 0) {
            return "y = " + calculateIntercept();
        }
        if (calculateSlope(x1, y1, x2, y2) < 0) {
            return "y = " + "-" + (int) Math.abs(calculateSlope(x1,y1,x2,y2)) + "x" + calculateIntercept();
        }
        return "y = " + calculateSlope(x1, y1, x2, y2) + "x" + calculateIntercept();
    }





}

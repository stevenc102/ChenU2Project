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
        return roundedToHundredth((y2 - (x2 * calculateSlope(x1, y1, x2, y2))));
    }

    public double roundedToHundredth(double num) {
        return Math.round(num * 100) / 100.0;
    }

    public double calculateDistance() {
        return roundedToHundredth(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }

    public String returnEquation() {
        String interceptAsString = "" + calculateIntercept();
        boolean isNegative = (calculateIntercept() < 0);
        boolean isNegativeSlope = (calculateSlope(x1,y1,x2,y2) < 0);
        int temp = (int) calculateSlope(x1,y1,x2,y2);
        boolean isDecimal = (calculateSlope(x1,y1,x2,y2) > temp || calculateSlope(x1,y1,x2,y2) < temp);
        String y = "" + (int) (y2 - y1);
        String x = "" + (int) (x2 - x1);
        if (calculateSlope(x1,y1,x2,y2) == 0) {
            return "y = " + (int)calculateIntercept();
        }
        if (calculateSlope(x1,y1,x2,y2) == 1) {
            if (calculateIntercept() > 0) {
                return "y = x + " + calculateIntercept();
            }
            if (calculateIntercept() < 0) {
                return "y = x" + " - " + interceptAsString.substring(1);
            }
            if (calculateIntercept() == 0) {
                return "y = x";
            }

        }
        if (calculateSlope(x1,y1,x2,y2) == -1) {
            if (calculateIntercept() > 0) {
                return "y = -x + " + calculateIntercept();
            }
            if (calculateIntercept() < 0) {
                return "y = -x" + " - " + interceptAsString.substring(1);
            }
            if (calculateIntercept() == 0) {
                return "y = -x";
            }
        }
        if (calculateIntercept() == 0) {
            if (isDecimal) {
                if (y2 - y1 > 0 || x2 - x1 > 0) {
                    if (isNegative) {
                        if (isNegativeSlope) {
                            return "y = -" + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x";
                        }
                        return "y = " + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x";
                    }
                    if (isNegativeSlope) {
                        return "y = -" + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x";
                    }
                    return "y = " + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x";
                }

            }
            return "y = " + (int) calculateSlope(x1,y1,x2,y2) + "x";
        }
        if (isDecimal) {
            if (y2 - y1 > 0 || x2 - x1 > 0) {
                if (isNegative) {
                    if (isNegativeSlope) {
                        return "y = -" + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x" + " - " + interceptAsString.substring(1);
                    }
                    return "y = " + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x" + " - " + interceptAsString.substring(1);
                }
                if (isNegativeSlope) {
                    return "y = -" + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x" + " + " + interceptAsString;
                }
                return "y = " + Math.abs((int) (y2 - y1)) + "/" + Math.abs((int) (x2 - x1)) + "x" + " + " + interceptAsString;
            }
            if (isNegative) {
                return "y = " + y.substring(1) + "/" + x.substring(1) + "x" + " - " + interceptAsString.substring(1);
            }
            return "y = " + y.substring(1) + "/" + x.substring(1) + "x" + " + " + interceptAsString;
        }
        if (isNegative) {
            return "y = " + (int) calculateSlope(x1,y1,x2,y2) + "x" + " - " + interceptAsString.substring(1);
        }
        return "y = " + (int) calculateSlope(x1,y1,x2,y2) + "x" + " + " + interceptAsString;
    }
}
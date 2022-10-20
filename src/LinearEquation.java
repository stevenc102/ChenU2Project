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

    public double slope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public double yIntercept() {
        return roundedToHundredth((y2 - (x2 * slope(x1, y1, x2, y2))));
    }

    public double roundedToHundredth(double num) {
        return Math.round(num * 100) / 100.0;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }

    public String equation() {
        //set up for convenience
        String interceptAsString = "" + yIntercept();
        boolean isNegative = (yIntercept() < 0);
        boolean isNegativeSlope = (slope(x1,y1,x2,y2) < 0);
        int temp = (int) slope(x1,y1,x2,y2);
        boolean isDecimal = (slope(x1,y1,x2,y2) > temp || slope(x1,y1,x2,y2) < temp);
        String y = "" + (int) (y2 - y1);
        String x = "" + (int) (x2 - x1);
        //tests for slope = 0
        if (slope(x1,y1,x2,y2) == 0) {
            return "y = " + (int)yIntercept();
        }
        //tests for if slope is 1 and -1

        if (slope(x1,y1,x2,y2) == 1) {
            if (yIntercept() > 0) {
                return "y = x + " + yIntercept();
            }
            if (yIntercept() < 0) {
                return "y = x" + " - " + interceptAsString.substring(1);
            }
            if (yIntercept() == 0) {
                return "y = x";
            }

        }
        if (slope(x1,y1,x2,y2) == -1) {
            if (yIntercept() > 0) {
                return "y = -x + " + yIntercept();
            }
            if (yIntercept() < 0) {
                return "y = -x" + " - " + interceptAsString.substring(1);
            }
            if (yIntercept() == 0) {
                return "y = -x";
            }
        }

        if (yIntercept() == 0) {
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
            return "y = " + (int) slope(x1,y1,x2,y2) + "x";
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
            return "y = " + (int) slope(x1,y1,x2,y2) + "x" + " - " + interceptAsString.substring(1);
        }
        return "y = " + (int) slope(x1,y1,x2,y2) + "x" + " + " + interceptAsString;

    }
    public String lineInfo() {
        String info = "The two points are: (" + (int) x1 + ", " + (int) y1 + ")" + " and " + "(" + (int) x2 + ", " + (int) y2 + ")\n";
        info += "The equation of the line between these points is " + equation();
        info += "The slope of this line is: " + roundedToHundredth(slope(x1, y1, x2, y2));
        info += "The y-intercept of the line is: " + yIntercept();
        info += "The distance between the two points is: " + distance();
        return info;
    }
    public String coordinateForX(double X) {
        return "The point on the line is (" + X + ", " + (slope(x1,y1,x2,y2) * X + (y2 - (x2 * slope(x1, y1, x2, y2))) + ")");
    }
}
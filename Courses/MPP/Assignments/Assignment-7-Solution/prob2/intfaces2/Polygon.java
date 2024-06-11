package lesson5.lecture.intfaces2;

import java.awt.*;

public interface Polygon extends ClosedCurve {
    public double[] getSides();

    public default double computePerimeter() {
        double perimeter = 0;
        for (Double d : getSides()) {
            perimeter += d;
        }
        return perimeter;
    }
}

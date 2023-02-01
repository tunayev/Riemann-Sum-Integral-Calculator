import java.util.ArrayList;

/**
 * The class that computes the integral value of a polynomial function using left-hand Riemann sum.
 */
public class Polynomial {
    private ArrayList<Double> coefficients = new ArrayList<Double>();
    private double a;
    private double b;
    private double c;
    private double d;

    private double deltaX = 0.0001;

    /**
     * Constructor function
     * @param a coefficient of x^3
     * @param b coefficient of x^2
     * @param c coefficient of x
     * @param d constant
     */
    Polynomial(double a, double b, double c, double d) {
        // Set coefficients
        setCoefficents(a, b, c, d);
        // Store the coefficients in the array list
        storeCoefficients(a, b, c, d);
    }

    /**
     * The function that does the computation.
     * It returns the approximate value of the integral of the polynomial function
     * in the given range and with the previously provided deltaX.
     * @param minX the minimum x value
     * @param maxX the maximum x value
     * @return the approximate integral
     */
    public double computeIntegral(double minX, double maxX) {
        double sum = 0;
        // Calculate subintervals with deltaX
        double intervals = (maxX - minX) / deltaX;

        //Calculate the sum of the function values
        for (int i = 0; i < intervals; i++) {
            sum += valueAt(minX + i * deltaX);
        }
        // Multiply the sum by deltaX. This is the approximate integral,
        // however, to increase the precision when working with double values,
        // we multiply deltaX only once by sum, rather than multiplying it by each subinterval (in the loop).
        return sum * deltaX;
    }

    /**
     * Gets the value at a given x point for the polynomial function.
     * Rather than hardcoding the coefficients, it uses the coefficients array list and
     * iterates over it for a future-proof solution.
     * This way, we can change the class' maximum degree in the future, let's say as "Polynomial(a,b,c,d,e)",
     * without having to change the code.
     * @param x the x value
     * @return the value of the function at the given x point
     */
    private double valueAt(double x) {
        double value = 0;
        int power = 0;
        for (double coefficient : coefficients) {
            power = coefficients.size() - 1 - coefficients.indexOf(coefficient);
            value += coefficient * Math.pow(x, power);
        }
        return value;
    }

    /**
     * @param deltaX the deltaX to set
     */
    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    /**
     * Setter function for the coefficients
     * @param a coefficient of x^3
     * @param b coefficient of x^2
     * @param c coefficient of x
     * @param d constant
     */
    public void setCoefficents(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * Stores the coefficients in the array list
     * @param a
     * @param b
     * @param c
     * @param d
     */
    private void storeCoefficients(double a, double b, double c, double d) {
        coefficients.add(a);
        coefficients.add(b);
        coefficients.add(c);
        coefficients.add(d);
    }

    /**
     * @return the String representation of the polynomial function
     */
    public String toString() {
        int size = coefficients.size();
        String str = "f(x) = ";
        for(double coefficient : coefficients) {
            if(coefficient != 0 && coefficients.indexOf(coefficient) != size - 1) {
                if(coefficient > 0 && coefficients.indexOf(coefficient) != 0) {
                    str += "+";
                }
                str += coefficient + "x^" + (size - 1 - coefficients.indexOf(coefficient));
            } else if(coefficient != 0 && coefficients.indexOf(coefficient) == size - 1) {
                str += coefficient;
            }
        }

        return str;
    }
}

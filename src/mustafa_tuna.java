/**
 *  This program calculates the integral of a maximum 3rd degree polynomial function
    using left-hand Riemann sum. However, it can easily transformed into a class that can handle more than
    3rd degree polynomial functions, if we add new coefficients as
    data fields, set them via setCoefficients method and add them to the array list in the storeCoefficients method.
    It takes the coefficients of the polynomial function as input and calculates the integral of the function within
    the given range.
 */

import java.util.Scanner;

public class mustafa_tuna {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coefficients of the polynomial function in the following order: a, b, c, d " +
                "as double values \n");
        System.out.println("a: ");
        double a = input.nextDouble();
        System.out.println("b: ");
        double b = input.nextDouble();
        System.out.println("c: ");
        double c = input.nextDouble();
        System.out.println("d: ");
        double d = input.nextDouble();

        System.out.println("Enter the minimum x value: ");
        double minX = input.nextDouble();
        System.out.println("Enter the maximum x value: ");
        double maxX = input.nextDouble();
        System.out.println("Enter the deltaX value (default 0.0001): ");
        double deltaX = input.nextDouble();

        Polynomial p = new Polynomial(a, b, c, d);
        p.setDeltaX(deltaX);

        System.out.println(p + " in the range (" + minX + "," + maxX + ")\n" + p.computeIntegral(minX, maxX));

    }
}

package generic.calculator;


class Calculator {

    /**
     * Summarize all elements of array.
     *
     * @param values the array of Number elements, which sum should be calculated
     * @param <T>    generic type: subclasses of Number class
     * @return total sum as double primitive
     * @throws NullPointerException if {@code values.length <= 0} or {@code values == null}
     */
    static <T extends Number> double summarize(T... values) throws NullPointerException {
        if (values == null || values.length <= 0)
            throw new NullPointerException("description");
        double sum = 0;
        for (T v : values) {
            sum += v.doubleValue();
        }
        return sum;
    }


    /**
     * Divides {@code numerator} by {@code divisor}.
     *
     * @param numerator numerator
     * @param divisor   divisor
     * @param <T>       generic type: subclasses of Number class
     * @return result of division as double primitive
     * @throws ArithmeticException if {@code (double / double)} throws ArithmeticException
     */
    static <T extends Number> double divide(T numerator, T divisor) throws ArithmeticException {
        return numerator.doubleValue() / divisor.doubleValue();
    }
}

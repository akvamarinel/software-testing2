package trigonometry;

import useful.FunctionInterface;
import useful.UsefulMethods;

public class MySin implements FunctionInterface {
    private double epsilon;

    public MySin(double epsilon){
        if (epsilon <= 0) {
            throw new IllegalArgumentException("epsilon must be more than zero: " + epsilon);
        }
        this.epsilon = epsilon;
    }

    @Override
    public void setEpsilon(double epsilon) {
        if (epsilon <= 0 || epsilon == Double.NEGATIVE_INFINITY || epsilon == Double.POSITIVE_INFINITY || Double.isNaN(epsilon)) {
            throw new IllegalArgumentException("epsilon must be more than zero: " + epsilon);
        }
        this.epsilon = epsilon;
    }

    @Override
    public double calc(double value) {
        if(value == Double.POSITIVE_INFINITY || value == Double.NEGATIVE_INFINITY || Double.isNaN(value)) {
            return Double.NaN;
        } else {
            double result = Double.MAX_VALUE;
            int n = 1;
            double nextResult = 0;
            while (Math.abs(result - nextResult) > epsilon) {
                result = nextResult;
                nextResult += (Math.pow(-1, n - 1) * Math.pow(value, 2 * n - 1)) / UsefulMethods.fact(2 * n - 1);
                n++;
            }
            return nextResult;
        }
    }
}

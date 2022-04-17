package logarithm;

import useful.FunctionInterface;

public class MyLn implements FunctionInterface {
    private double epsilon;

    public MyLn(double epsilon){
        this.epsilon = epsilon;
    }
    public double getEpsilon(){
        return this.epsilon;
    }

    @Override
    public double calc(double value){
        if (value <= 0){
            return Double.NaN;
        }
        if (value == Double.POSITIVE_INFINITY){
            return Double.POSITIVE_INFINITY;
        }
        if(value > 2){
            return calc(value/2.0) + calc(2.0);
        }
        double nextResult = value-1;
        double result = Double.MAX_VALUE;
        int n = 1;
        while (Math.abs(result-nextResult)>epsilon){
            result = nextResult;
            nextResult += Math.pow(-1, n) * (Math.pow((value-1), n+1)/(n+1));
            n++;
        }
        return result;
    }

    @Override
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }
}

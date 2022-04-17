package trigonometry;

import useful.FunctionInterface;

public class MyCos implements FunctionInterface {
    private double epsilon;
    private MySin mySin;

    public MyCos(double epsilon, MySin mySin){
        this.epsilon = epsilon;
        this.mySin = mySin;
    }

    @Override
    public double calc(double value) {
        return Math.sqrt(1 - Math.pow(mySin.calc(value),2));
    }

    @Override
    public void setEpsilon(double epsilon) {
        if (epsilon <= 0 || epsilon == Double.NEGATIVE_INFINITY || epsilon == Double.POSITIVE_INFINITY || Double.isNaN(epsilon)) {
            throw new IllegalArgumentException("epsilon must be more than zero: " + epsilon);
        }
        this.epsilon = epsilon;
    }

    public double getEpsilon(){
        return epsilon;
    }
}

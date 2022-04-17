package trigonometry;

import useful.FunctionInterface;

public class MyCot implements FunctionInterface {
    private double epsilon;
    private MySin mySin;
    private MyCos myCos;

    public MyCot(double epsilon, MySin mySin){
        this.epsilon = epsilon;
        this.mySin = mySin;
        myCos = new MyCos(epsilon,mySin);
    }

    @Override
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    @Override
    public double calc(double value) {
        if(value % Math.PI == 0) {
            return Double.NaN;
        }
        return myCos.calc(value)/mySin.calc(value);
    }

    public double getEpsilon(){
        return epsilon;
    }
}

import main.java.useful.FunctionInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void write(List<FunctionInterface> functions, double step) throws IOException {
        FileWriter fileWriter = new FileWriter("result.csv");
        for (int i = 0; i < functions.size(); i++) {
            double tmpStep = step;
            for (int j = 0; j < 10; j++){
                fileWriter.write(Double.toString(functions.get(i).calc(tmpStep)) + ' ' + " Результат модуля: " + functions.get(i).getClass() + "\n");
                tmpStep+=step;
            }
        }
    }
}

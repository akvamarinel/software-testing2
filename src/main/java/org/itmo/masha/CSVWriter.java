package org.itmo.masha;

import org.itmo.masha.useful.FunctionInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void write(List<FunctionInterface> functions, double step) {
        try {
            FileWriter fileWriter = new FileWriter("result.csv");
            try {
                for (int i = 0; i < functions.size(); i++) {
                    double tmpStep = step;
                    for (int j = 0; j < 10; j++) {
                        fileWriter.write(Double.toString(functions.get(i).calc(tmpStep)) + ' ' + " Результат модуля: " + functions.get(i).getClass() + "\n");
                        fileWriter.flush();
                        tmpStep += step;
                    }
                }
            }
            finally {
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("there is an exception");
            e.printStackTrace();
        }
    }
}

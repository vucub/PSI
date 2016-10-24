import java.util.Arrays;
import org.neuroph.nnet.Hopfield;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.learning.TrainingElement;
import java.util.Vector;
import org.neuroph.core.data.DataSetRow;

public class HopfieldSample {

public static void main(String args[]) {

DataSet trainingSet = new DataSet(9);

trainingSet.addRow(new DataSetRow(new double[]{1, 0, 1, 1, 1, 1, 1, 0, 1})); // H  
trainingSet.addRow(new DataSetRow(new double[]{1, 1, 1, 0, 1, 0, 0, 1, 0})); // T 


Hopfield myHopfield = new Hopfield(9);

myHopfield.learn(trainingSet);


System.out.println("Testing network");

trainingSet.addRow(new DataSetRow(new double[]{1, 0, 0, 1, 0, 1, 1, 0, 1}));

for(DataSetRow dataRow : trainingSet.getRows()) {

myHopfield.setInput(dataRow.getInput());
myHopfield.calculate();
myHopfield.calculate(); 
double[ ] networkOutput = myHopfield.getOutput();

System.out.print("Input: " + Arrays.toString(dataRow.getInput()) );
System.out.println(" Output: " + Arrays.toString(networkOutput) );

}

}

}
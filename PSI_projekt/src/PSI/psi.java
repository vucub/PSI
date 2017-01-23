package PSI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TrainingSetImport;
import org.neuroph.util.TransferFunctionType;

public class psi {


    public static void main(String[] args) {

        String nazwa = "znormalizowane.txt";
        int inputsCount = 6;
        int outputsCount = 1;

        System.out.println("Uzywam zestawu treningowego o nazwie: " + nazwa);

        // tworzenie training setu
        DataSet trainingSet = null;
        try {
            trainingSet = TrainingSetImport.importFromFile(nazwa, inputsCount, outputsCount, ",");
        } catch (FileNotFoundException ex) {
            System.out.println("Nie odnaleziono pliku!");
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Blad podczas wczytywania pliku!");
        }


        // tworzenie wielowarstwowej sieci
        System.out.println("Tworzenie sieci...");
        MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 6, 8, 1);

        // Ustawianie paraetrow nauki
        MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNet.getLearningRule();
        learningRule.setLearningRate(0.2);
        learningRule.setMomentum(0.9);

        //Trenowanie
        System.out.println("Trenowanie sieci...");
        neuralNet.learn(trainingSet);
        System.out.println("Gotowe!");

        // test perceptron
        System.out.println("Test sieci...");
        test(neuralNet, trainingSet);

    }

    public static void test(NeuralNetwork nnet, DataSet dset) {

        for (DataSetRow trainingElement : dset.getRows()) {

            nnet.setInput(trainingElement.getInput());
            nnet.calculate();
            double[] networkOutput = nnet.getOutput();
            System.out.print("Wejscie: " + Arrays.toString(trainingElement.getInput()));
            System.out.println("Wyjscie: " + Arrays.toString(networkOutput));
        }

    }
}

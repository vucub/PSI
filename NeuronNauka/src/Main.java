import java.util.*;

public class Main {

    public static void main(String[] args) 
    {
        
        double[][] tab = {{0,0},{0,1},{1,0},{1,1}};
        double[] tab2 = {1,0};
        double[] wynikiNOT = {0,1};
        double [] wynikiAND = {0,0,0,1};
        double[] wynikiOR = {0,1,1,1};
        Perceptron p1 = new Perceptron();
        p1.ustawBias(0.0);
        p1.ustawN(0.5);
        p1.ustawWagi();
        p1.ucz(tab, wynikiAND);
        
        System.out.println();
        
        Perceptron p2 = new Perceptron();
        p2.ustawBias(0.0);
        p2.ustawN(0.5);
        p2.ustawWagi();
        p2.ucz(tab, wynikiAND);
        
        System.out.println();
        
        Perceptron p3 = new Perceptron();
        p3.ustawBias(0.0);
        p3.ustawN(0.5);
        p3.ustawWagi();
        p3.uczNOT(tab2, wynikiNOT);
        
        
        System.out.println();
        System.out.print("Ogolna ilosc powtorzen dla AND: ");
        p1.wypiszPowtorzenia();
        System.out.print("Ogolna ilosc powtorzen dla OR: ");
        p2.wypiszPowtorzenia();
        System.out.print("Ogolna ilosc powtorzen dla NOT: ");
        p3.wypiszPowtorzenia();
        
        
    }
    
}

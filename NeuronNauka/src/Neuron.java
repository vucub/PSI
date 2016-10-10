import java.util.*;

public class Neuron 
{
    private double w1, w2; //wagi
    private double n; //wspolczynnik uczenia
    private double b; //bias
    private double y; //odpowiedz neuronu; d -> odpowiedz prawidlowa
    
    public Neuron()
    {
        Random r = new Random();
        w1 = r.nextDouble();
        w2 = r.nextDouble();
        b=0.0;
        n=0.5;
    }
    
    private double modyfikujWagi(double waga, double n, double blad, double x)
    {
        waga = waga + (n*blad*x);
        return waga;
    }
    
    private double modyfikujBias(double b, double n, double blad)
    {
        b = b + (n*blad);
        return b;
    }
    
    public void ucz(double[][] dane)
    {
        int powtorzenia=0; //liczba powtorzen petli
        double blad; //blad, wyliczany jako odpowiedz poprawna - odpowiedz perceptronu
        boolean koniec;
        int iloscBledow;
        
        do 
        {
            blad = 0.0;
            iloscBledow = 0;
            koniec = true;
            
            powtorzenia++;
            System.out.println("Liczba powtorzen (poczatek): "+powtorzenia+" w1: "+w1+" w2: "+w2+" b: "+b);
            
            
            for(int i=0; i<dane.length; i++)
            {
                y = odpowiedzNeuronu(dane[i][0], dane[i][1], w1, w2, b);
                
                System.out.println("Oczekiwana odpowiedz: "+dane[i][2]+", a otrzymana: "+y);
                blad = dane[i][2]-y;
                
                if (blad != 0)
                {
                   koniec = false;
                   iloscBledow++;
                }
            
                w1 = modyfikujWagi(w1, n, blad, dane[i][0]);
                w2 = modyfikujWagi(w2, n, blad, dane[i][1]);
                b=modyfikujBias(b, n, blad);
            }
            
            System.out.println("Liczba powtorzen (koniec): "+powtorzenia+", ilosc bledow: "+iloscBledow);            
        }
        while(!koniec);
    }
        
        private double odpowiedzNeuronu(double x1, double x2, double w1, double w2, double b)
        {
            double odp = (x1*w1) + (x2*w2) + b;
            return (odp>=0)?1:0;
        }
    }

/*
 * VERIFICA SUI THREAD JAVA
 * Samuele Roselli 4°AIA
 * 17/05/2023
 */
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        int nBevitori = 10;
        Botte b = new Botte(100, 3);
        List<Bevitore> bevitori = new ArrayList<>();

        System.out.println("[*] INIZIA LA BEVUTA!");

        //Creo n thread 'Bevitore' per il valore di 'nBevitori' e 
        //li avvio
        for(int i=0; i<nBevitori; i++){
            bevitori.add(new Bevitore("bevitore"+i, b));
            bevitori.get(i).start();
        }

        
    }
}

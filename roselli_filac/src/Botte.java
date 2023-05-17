
//La classe 'Botte' funziona da MONITOR

public class Botte {
    private int qtaResidua;
    private int nRubinetti;
    private int occupati;

    public Botte(int capienza, int nRubinetti){
        qtaResidua = capienza;
        this.nRubinetti = nRubinetti;
        occupati = 0;
    }

    public synchronized void bevi() throws InterruptedException{
        String name = Thread.currentThread().getName();


        while((occupati == nRubinetti) || (qtaResidua <= 0)){
            System.out.println("- "+name+" sta aspettando...");
            wait();
        }

        occupati++;

        System.out.println("> "+name+" ha iniziato la bevuta."); 
    }

    public synchronized void fineBevuta(){
        qtaResidua = qtaResidua - 1;
        String name = Thread.currentThread().getName();
        System.out.println("> "+name+" ha terminato la bevuta. quantità residua: "+qtaResidua);
        occupati--;
        notifyAll();
    }

    public int getQtaResidua() {
        return qtaResidua;
    }
    
}

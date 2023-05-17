public class Bevitore extends Thread{
    
    Botte b;

    public Bevitore(String nome, Botte b){
        super(nome);
        this.b = b;
    }

    @Override
    public void run() {
        while(b.getQtaResidua() > 0){
            try{
                int tempoAttesa = (int)(Math.random() * 4000 + 1000);
                /* Il tempo di attesa in cui il bevitore decide di bere è
                * compreso tra 1 e 5 secondi.
                */
                Thread.sleep(tempoAttesa);  
                b.bevi();
                tempoAttesa = (int)(Math.random() * 1000 + 1000);
                /* Il tempo impiegato dalla bevuta è compreso tra 1 e 2
                * secondi.
                */
                Thread.sleep(tempoAttesa); 
                b.fineBevuta();

                
        
            }catch (InterruptedException e) {}
        }

        if(b.getQtaResidua() == 0){
            System.out.println("[!] LA BOTTE HA FINITO IL VINO. BEVUTA TERMINATA.");
            System.exit(0);
        }
        
    }
}

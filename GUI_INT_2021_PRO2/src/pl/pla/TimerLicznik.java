package pl.pla;

public class TimerLicznik extends Thread  {
    DrawPanel drawPanel;
    boolean timerRunning = true;
    long ileMinut = 0;
    long ileCzasuMinelo;
    long ileSekund;
    long czasStart = System.currentTimeMillis();

    public TimerLicznik(DrawPanel drawPanel){
        this.drawPanel = drawPanel;
    }

    public void quit()
    {

        this.timerRunning = false;
    }
    public void run() {
        System.out.println("Timer:");
        while (timerRunning) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ileCzasuMinelo = System.currentTimeMillis() - czasStart;
            ileSekund = ileCzasuMinelo / 1000;
            if (ileSekund == 60) {
                ileSekund = 0;
                czasStart = System.currentTimeMillis();
            }
            if ((ileSekund % 60) == 0)
                ileMinut++;
            System.out.println(ileMinut + " : " + ileSekund);
        }
    }

}

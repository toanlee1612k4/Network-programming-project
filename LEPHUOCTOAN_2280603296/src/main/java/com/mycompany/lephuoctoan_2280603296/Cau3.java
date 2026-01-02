class TicketCounter {
    private int tickets = 1000;

    
    public synchronized void sellTicket(String threadName) {
        if (tickets > 0) {
            try {
                Thread.sleep(5); 
            } catch (InterruptedException e) {}
            tickets--;
            System.out.println(threadName + " ban 1 ve. Con lai " + tickets);
        }
    }
}

class TicketSeller extends Thread {
    TicketCounter counter;

    public TicketSeller(TicketCounter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        
        for (int i = 0; i < 100; i++) { 
            counter.sellTicket(this.getName());
        }
    }
}

public class Cau3 {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();
        
        TicketSeller s1 = new TicketSeller(counter, "Seller 1");
        TicketSeller s2 = new TicketSeller(counter, "Seller 2");
        
        s1.start();
        s2.start();
    }
}
public class Cashier {
    private String name;
    private TicketBox ticketBox;
    private Integer targetTickets;

    public Cashier(String name, TicketBox ticketBox, Integer targetTickets) {
        this.name = name;
        this.ticketBox = ticketBox;
        this.targetTickets = targetTickets;
    }

    public void startSelling() {
        Integer soldByCashier = 0;
        for (int i = 0; i < targetTickets; i++) {
            if (ticketBox.sellTicket(name)) {
                soldByCashier++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            else {
                System.out.println("Tickets are sold. Plan was not done");
            }
        }
        System.out.println(name + " finished job. Sold total " + soldByCashier + " of " + targetTickets);
    }
}

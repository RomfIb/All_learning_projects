public class TicketBox {
    private int totalTickets;

    public TicketBox(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public synchronized Boolean sellTicket(String cashierName) {
        if (totalTickets > 0) {
            totalTickets--;
            System.out.println(cashierName + " sold ticket. Tickets left at box office: " +totalTickets);
            return true;
        }
        return false;
    }
}

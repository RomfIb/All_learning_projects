public enum ClientStatus {
    STANDART(0),
    SILVER(5),
    GOLD(10),
    VIP(20);

    private final int percent;

    ClientStatus(int percent) {
        this.percent = percent;
    }

    public double calculateDiscount(double price) {
        return (price * (100 - percent)) / 100;
    }
}

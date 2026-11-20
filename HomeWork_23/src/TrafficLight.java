public class TrafficLight {
    private volatile String color = "green";
    private volatile Boolean isRunning = true;

    public void switchColor() {
        if (color.equalsIgnoreCase("green")) {
            color = "red";
        }
        else {
            color = "green";
        }
        System.out.println("Traffic light switched to: " + color);
    }

    public void stop() {
        isRunning = false;
    }
    public String getColor() {
        return color;
    }

    public Boolean getRunning() {
        return isRunning;
    }
}
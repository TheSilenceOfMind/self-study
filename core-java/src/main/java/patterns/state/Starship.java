package patterns.state;

public class Starship {

    private AlertStatus[] alerts = {new Alert1(), new Alert2(), new Alert3()};
    private int index = 0;

    public AlertStatus nextAlert() {
        AlertStatus ret = alerts[index];
        index = (index + 1) % alerts.length;
        return ret;
    }

    public static void main(String[] args) {
        Starship ship = new Starship();
        System.out.println(ship.nextAlert());
        System.out.println(ship.nextAlert());
        System.out.println(ship.nextAlert());
        System.out.println(ship.nextAlert());
    }
}

class AlertStatus {
    @Override
    public String toString() {
        return "alert";
    }
}

class Alert1 extends AlertStatus {
    @Override
    public String toString() {
        return super.toString() + " type 1";
    }
}

class Alert2 extends AlertStatus {
    @Override
    public String toString() {
        return super.toString() + " type 2";
    }
}

class Alert3 extends AlertStatus {
    @Override
    public String toString() {
        return super.toString() + " type 3";
    }
}
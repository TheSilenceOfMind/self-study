package enums;

public class Example {
    public static void main(String[] args) {

        System.out.println("Apples 'values'");
        Apple[] apples = Apple.values();
        for (Apple a : apples) {
            System.out.println(a + " " + a.getPrice());
        }
        System.out.println();

        System.out.println("Apples 'valueOf'");
        Apple a = Apple.valueOf("Jonathan");
        System.out.println(a);
        System.out.println();

        comparing();
    }

    static void comparing() {
        System.out.println("comparing: ");
        System.out.println(Apple.valueOf("Jonathan").compareTo(Apple.Cortland));
        System.out.println();
    }

    enum Apple {
        Jonathan(100), GoldenDel, RedDel, Winesap, Cortland;

        private int price;

        Apple() {
            price = Integer.MIN_VALUE;
        }

        Apple(int price) {
            this.price = price;
        }

        int getPrice() {
            return this.price;
        }
    }

}

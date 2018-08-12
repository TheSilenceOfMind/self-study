package string;

public class ToStringExample {
    static class Box {
        int w, l, h;

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void main(String[] args) {
        Box box = new Box();
        System.out.println(box);
    }
}

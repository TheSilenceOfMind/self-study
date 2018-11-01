package patterns.adapter;

public class Main {
    public static void main(String[] args) {
        SoundableAnimal dog = (say, volume) -> {
            System.out.println("dog: " + say);
            System.out.println(volume);
            System.out.println();
        };

        SoundableComputer laptop = sound -> {
            System.out.println("laptop: " + sound);
            System.out.println();
        };

        makeNoise(dog);
        SoundableAnimal pretendingComputer = AdapterComputer2Animal.getAdaptedComputer(laptop);
        makeNoise(pretendingComputer);
    }

    static void makeNoise(SoundableAnimal animal) {
        animal.say("gow", 100);
    }
}

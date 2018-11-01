package patterns.adapter;

public class AdapterComputer2Animal implements SoundableAnimal {
    SoundableComputer comp;

    private AdapterComputer2Animal(SoundableComputer comp) {
        this.comp = comp;
    }

    public static SoundableAnimal getAdaptedComputer(SoundableComputer comp) {
        return new AdapterComputer2Animal(comp);
    }

    @Override
    public void say(String say, int volume) {
        comp.makeSound(say);
    }
}

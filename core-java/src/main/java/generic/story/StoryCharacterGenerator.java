package generic.story;

import generic.Generator;

import java.util.Iterator;
import java.util.Random;

public class StoryCharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {

    private Class[] types = {BadGuy.class, GoodGuy.class,};
    private static Random rand = new Random(1488);
    private int size; // used for iteration

    public StoryCharacterGenerator() {

    }

    public StoryCharacterGenerator(int sz) {
        this.size = sz;
    }

    @Override
    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class StoryCharacterIterator implements Iterator<StoryCharacter> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StoryCharacter next() {
            count--;
            return StoryCharacterGenerator.this.next();
        }
    }

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new StoryCharacterIterator();
    }

    public static void main(String[] args) {
        StoryCharacterGenerator generator = new StoryCharacterGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
        for (StoryCharacter sc : new StoryCharacterGenerator(10000)) {
            System.out.println(sc);
        }

    }
}

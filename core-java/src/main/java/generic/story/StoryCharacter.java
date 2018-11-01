package generic.story;

public class StoryCharacter {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return String.format("%s %d", getClass().getSimpleName(), id);
    }
}

class GoodGuy extends StoryCharacter {}

class BadGuy extends StoryCharacter {}

package ch2.mixconfig;

import org.springframework.stereotype.Component;

@Component
class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Playing " + title + " by " + artist;
    }
}

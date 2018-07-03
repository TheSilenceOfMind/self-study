package ch2.xmlconfig;

import java.util.List;

class BlankDisc implements CompactDisc {

    private String artist;
    private String title;
    private List<CompactDisc> tracks;

    BlankDisc(String artist, String title, List<CompactDisc> tracks) {
        this.artist = artist;
        this.title = title;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (CompactDisc track : tracks) {
            System.out.println("-Track: " + track);
        }
    }
}

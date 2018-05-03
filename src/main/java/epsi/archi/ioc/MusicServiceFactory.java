package epsi.archi.ioc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MusicServiceFactory {

    MusicStorage storage;

    public MusicServiceFactory() {

    }

    public void inJsonStorage() {
        Music music = new Music();
        music.setTitle("Billie Jean");
        music.setCategory("Pop");
        music.setDuration(3);
        music.setExploitationNumber("1234567890");
        music.setSinger("Michael Jackson");
        music.setReleaseDate(LocalDate.of(1983, 01, 02));

        List<Music> musics = Arrays.asList(music);

        storage = new MusicStorageInMemory(musics);
    }

    public void jsonStorage() {
        new MusicJsonStorage("musiques.json");
        System.out.println("Les données proviennent d'un fichier Json.");
    }

    public MusicService create() {
        return new MusicService(storage);
    }

    public void inXmlStorage() {
        Music music = new Music();
        music.setTitle("Hello");
        music.setCategory("Pop");
        music.setDuration(3);
        music.setExploitationNumber("1111111111");
        music.setSinger("Adele");
        music.setReleaseDate(LocalDate.of(2017, 12, 03));

        List<Music> musics = Arrays.asList(music);

        storage = new MusicStorageInMemory(musics);
    }

    public void xmlStorage() {
        new MusicJsonStorage("musiques.xml");
        System.out.println("Les données proviennent d'un fichier XML.");
    }
}

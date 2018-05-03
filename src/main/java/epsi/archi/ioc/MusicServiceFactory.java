package epsi.archi.ioc;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MusicServiceFactory {

    MusicStorage storage;

    public MusicServiceFactory() {
        inMemoryStorage();
    }

    public void inMemoryStorage() {
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
    }

    public MusicService create() {
        return new MusicService(storage);
    }

}

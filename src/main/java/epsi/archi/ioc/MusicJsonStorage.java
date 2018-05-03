package epsi.archi.ioc;

import utils.JsonReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MusicJsonStorage implements MusicStorage {

    private List<Music> musics;

    public MusicJsonStorage(String filePath) {
        JsonReader.readJsonFile(filePath, obj -> {
            Music music = new Music();
            music.setTitle(obj.getString("title"));
            music.setSinger(obj.getString("singer"));
            music.setExploitationNumber(obj.getString("exploitation"));
            music.setDuration(obj.getInt("duration"));
            music.setCategory(obj.getString("category"));
            music.setReleaseDate(LocalDate.parse(obj.getString("release"), DateTimeFormatter.ISO_LOCAL_DATE));
            return music;
        }).ifPresent(musics -> this.musics = musics);
    }

    public List<Music> all() {
        return Collections.unmodifiableList(musics);
    }

    public Optional<Music> get(String exploitationNumber) {
        return musics.stream()
                .filter(m -> m.getExploitationNumber().equals(exploitationNumber))
                .findFirst();
    }

    public List<Music> searchByTitle(String title) {
        return musics.stream()
                .filter(m -> m.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public void add(Music music) {
        if (!get(music.getExploitationNumber()).isPresent()) {
            musics.add(music);
        }
    }

    public void delete(String exploitatioNumber) {
        get(exploitatioNumber).ifPresent(m -> musics.remove(m));
    }

}

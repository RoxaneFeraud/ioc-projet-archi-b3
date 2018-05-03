package epsi.archi.ioc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MusicStorageInMemory implements MusicStorage {

    private List<Music> musics;

    public MusicStorageInMemory(List<Music> musics){
        this.musics = musics;
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





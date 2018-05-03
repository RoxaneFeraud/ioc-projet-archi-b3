package epsi.archi.ioc;

import java.util.List;
import java.util.Optional;

public interface MusicStorage {

    List<Music> all();

    Optional<Music> get(String exploitationNumber);

    List<Music> searchByTitle(String title);

    void add(Music music);

    void delete(String exploitatioNumber);
}

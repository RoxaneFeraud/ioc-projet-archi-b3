package epsi.archi.ioc;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MusicService {

    private MusicStorage storage;

    public MusicService(MusicStorage storage) {
        this.storage = storage;
    }

    public void add(Music music) {
        storage.add(music);
    }

    public void delete(String exploitationNumber) {
        storage.delete(exploitationNumber);
    }

    public List<Music> searchBySingerAndAfter(String singer, LocalDate after) {
        return storage.all().stream()
                .filter(m -> m.getSinger().equals(singer))
                .filter(m -> m.getReleaseDate().isAfter(after))
                .collect(Collectors.toList());
    }

    public void garbage(int minDuration) {
        storage.all().stream()
                .filter(m -> m.getDuration() < minDuration)
                .forEach(m -> storage.delete(m.getExploitationNumber()));
    }
}

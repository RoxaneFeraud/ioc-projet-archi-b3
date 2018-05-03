package epsi.archi.ioc;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class MusicStorageInMemoryTest {

    @Test
    public void testGet() {
        MusicStorageInMemory storage = new MusicStorageInMemory(Arrays.asList());
        Optional<Music> music = storage.get("1452E51426512");
        music.ifPresent(m -> System.out.println(m.getCategory()));

    }
}

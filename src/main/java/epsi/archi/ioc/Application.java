package epsi.archi.ioc;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        MusicServiceFactory factory = new MusicServiceFactory();
        factory.jsonStorage();

        MusicService service = factory.create();

        service.searchBySingerAndAfter("Michael Jackson", LocalDate.of(1995, 01, 01))
                .forEach(m -> System.out.println(m));

    }

}
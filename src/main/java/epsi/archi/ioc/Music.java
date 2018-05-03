package epsi.archi.ioc;

import java.time.LocalDate;

public class Music {
    private String exploitationNumber;
    private String title;
    private String singer;
    private int duration;
    private LocalDate releaseDate;
    private String category;

    public String getExploitationNumber() {
        return exploitationNumber;
    }

    public void setExploitationNumber(String exploitationNumber) {
        this.exploitationNumber = exploitationNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Music{" +
                "exploitationNumber='" + exploitationNumber + '\'' +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", category='" + category + '\'' +
                '}';
    }
}

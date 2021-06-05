package eu.atomicradio.objects;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Kacper Mura
 * 2020 Copyright (c) by atomicradio.eu to present.
 * All rights reserved. https://github.com/VocalZero
 *
 */
public class Channel {

    private String name;
    private int listeners;
    private Song song;
    private List<Song> schedule;
    private List<Song> history;
    private StreamUrls stream_urls;

    public static class Song {

        private String artist;
        private String title;
        private String playlist;
        private Date start_at;
        private Date end_at;
        private int duration;
        private Artworks artworks;

        public static class Artworks {

            private List<String> art100;
            private List<String> art250;
            private List<String> art500;
            private List<String> art1000;

            public String getArt100() {
                return art100.stream().findFirst().orElse(null);
            }

            public String getArt250() {
                return art250.stream().findFirst().orElse(null);
            }

            public String getArt500() {
                return art500.stream().findFirst().orElse(null);
            }

            public String getArt1000() {
                return art1000.stream().findFirst().orElse(null);
            }

            public void setArt100(List<String> art100) {
                this.art100 = art100;
            }

            public void setArt250(List<String> art250) {
                this.art250 = art250;
            }

            public void setArt500(List<String> art500) {
                this.art500 = art500;
            }

            public void setArt1000(List<String> art1000) {
                this.art1000 = art1000;
            }

        }

        public String getArtist() {
            return artist;
        }

        public String getTitle() {
            return title;
        }

        public String getPlaylist() {
            return playlist;
        }

        public Date getStart_at() {
            return start_at;
        }

        public void setStart_at(Date start_at) {
            this.start_at = start_at;
        }

        public Date getEnd_at() {
            return end_at;
        }

        public void setEnd_at(Date end_at) {
            this.end_at = end_at;
        }

        public int getDuration() {
            return duration;
        }

        public Artworks getArtworks() {
            return artworks;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPlaylist(String playlist) {
            this.playlist = playlist;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setArtworks(Artworks artworks) {
            this.artworks = artworks;
        }

    }

    public static class StreamUrls {

        private String highquality;
        private String middlequality;
        private String lowquality;

        public String getHighquality() {
            return highquality;
        }

        public String getMiddlequality() {
            return middlequality;
        }

        public String getLowquality() {
            return lowquality;
        }

        public void setHighquality(String highquality) {
            this.highquality = highquality;
        }

        public void setMiddlequality(String middlequality) {
            this.middlequality = middlequality;
        }

        public void setLowquality(String lowquality) {
            this.lowquality = lowquality;
        }

    }

    public String getName() {
        return name;
    }

    public int getListeners() {
        return listeners;
    }

    public Song getSong() {
        return song;
    }

    public List<Song> getSchedule() {
        return schedule;
    }

    public List<Song> getHistory() {
        return history;
    }

    public StreamUrls getStreamUrls() {
        return stream_urls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public void setSchedule(List<Song> schedule) {
        this.schedule = schedule;
    }

    public void setHistory(List<Song> history) {
        this.history = history;
    }

    public void setStreamUrls(StreamUrls stream_urls) {
        this.stream_urls = stream_urls;
    }

}

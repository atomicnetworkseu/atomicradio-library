package eu.atomicradio;

import com.google.gson.Gson;
import eu.atomicradio.managers.SocketManager;
import eu.atomicradio.objects.Channel;
import eu.atomicradio.objects.Channels;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Kacper Mura
 * 2020 Copyright (c) by atomicradio.eu to present.
 * All rights reserved. https://github.com/VocalZero
 *
 */
public class AtomicClient {

    private Gson gson;
    private Logger logger;
    private SocketManager socketManager;

    public AtomicClient() {
        this.gson = new Gson();
        this.socketManager = new SocketManager(this);
        this.logger = Logger.getLogger("eu.atomicradio");
    }
    
    /**
     * Returns the live status of the channel atr.one.
     * @return Returns the live status.
     */
    public boolean isLive() {
        if (this.socketManager.getJsonObjectOne() == null) {
            return false;
        }
        return this.socketManager.getJsonObjectOne().getJSONObject("live").getBoolean("is_live");
    }
    
    /**
     * Returns the streamer name when someone is live at atr.one.
     * @return Returns the name of the streamer.
     */
    public String getStreamer() {
        if (this.socketManager.getJsonObjectOne() == null) {
            return "";
        }
        return this.socketManager.getJsonObjectOne().getJSONObject("live").getString("streamer");
    }

    /**
     * Returns all informations about a channel.
     * @param channel
     * @return Returns the channel object.
     */
    public Channel getChannel(Channels channel) {
        if (this.socketManager.getChannel(channel) == null) {
            return this.getLoadingChannel("one");
        }
        return this.socketManager.getChannel(channel);
    }

    /**
     * Returns the listener count of all channels.
     * @return Returns the listener count as a Integer.
     */
    public int getAllListeners() {
        return this.socketManager.getAllListeners();
    }

    private Channel getLoadingChannel(String channelName) {
        Channel channel = new Channel();
        channel.setName("atr." + channelName);
        channel.setListeners(0);

        Channel.Song song = new Channel.Song();
        song.setArtist("LOADING...");
        song.setTitle("LOADING...");
        song.setPlaylist("LOADING...");
        song.setDuration(0);
        song.setStart_at(new Date());
        song.setEnd_at(new Date());

        Channel.Song.Artworks artworks = new Channel.Song.Artworks();
        artworks.setArt100(Arrays.asList("https://cdn.atomicradio.eu/artworks/fallback/0100.jpg"));
        artworks.setArt250(Arrays.asList("https://cdn.atomicradio.eu/artworks/fallback/0250.jpg"));
        artworks.setArt500(Arrays.asList("https://cdn.atomicradio.eu/artworks/fallback/0500.jpg"));
        artworks.setArt1000(Arrays.asList("https://cdn.atomicradio.eu/artworks/fallback/1000.jpg"));
        song.setArtworks(artworks);

        Channel.StreamUrls streamUrls = new Channel.StreamUrls();
        streamUrls.setHighquality("https://listen.atomicradio.eu/" + channelName + "/highquality");
        streamUrls.setMiddlequality("https://listen.atomicradio.eu/" + channelName + "/middlequality");
        streamUrls.setLowquality("https://listen.atomicradio.eu/" + channelName + "/lowquality");

        channel.setSong(song);
        channel.setHistory(Arrays.asList(song));
        channel.setSchedule(Arrays.asList(song));
        channel.setStreamUrls(streamUrls);

        return channel;
    }

    public SocketManager getSocketManager() {
        return this.socketManager;
    }

    public Gson getGson() {
        return gson;
    }

    public Logger getLogger() {
        return logger;
    }

}

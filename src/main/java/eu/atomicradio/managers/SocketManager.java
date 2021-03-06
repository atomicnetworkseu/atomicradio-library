package eu.atomicradio.managers;

import eu.atomicradio.AtomicClient;
import eu.atomicradio.objects.Channel;
import eu.atomicradio.objects.Channels;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kacper Mura
 * 2020 Copyright (c) by atomicradio.eu to present.
 * All rights reserved. https://github.com/VocalZero
 *
 */
public class SocketManager {

    private final AtomicClient client;
    private final Socket socket;
    private HashMap<Channels, Channel> channels;
    private JSONObject jsonObjectOne;
    private int allListeners;

    public SocketManager(AtomicClient client) {
        this.client = client;
        this.channels = new HashMap<>();
        this.socket = IO.socket(URI.create("https://api.atomicradio.eu"));
        initListeners();
        this.socket.connect();
    }

    private void initListeners() {
        socket.on(Socket.EVENT_CONNECT, (Object... os) -> {
            this.client.getLogger().info("The connection to the Socket.IO server has been established.");
        });
        socket.on(Socket.EVENT_CONNECT_ERROR, (Object... os) -> {
            this.client.getLogger().warning("Connection error to the socket.io server.");
        });
        socket.on(Socket.EVENT_DISCONNECT, (Object... os) -> {
            this.client.getLogger().warning("The connection to the socket.io server has been closed.");
        });
        socket.on("channels", (Object... os) -> {
            JSONObject jsonObject = new JSONObject(os[0].toString());
            String name = jsonObject.getString("name").substring(4);
            jsonObject.getJSONObject("song").getJSONObject("artworks").append("art100", jsonObject.getJSONObject("song").getJSONObject("artworks").getString("100"));
            jsonObject.getJSONObject("song").getJSONObject("artworks").append("art250", jsonObject.getJSONObject("song").getJSONObject("artworks").getString("250"));
            jsonObject.getJSONObject("song").getJSONObject("artworks").append("art500", jsonObject.getJSONObject("song").getJSONObject("artworks").getString("500"));
            jsonObject.getJSONObject("song").getJSONObject("artworks").append("art1000", jsonObject.getJSONObject("song").getJSONObject("artworks").getString("1000"));

            ArrayList<JSONObject> history = this.getJsonArrayList(jsonObject.getJSONArray("history"));
            history.stream().forEach(t -> {
                t.getJSONObject("artworks").append("art100", (String) t.getJSONObject("artworks").getString("100"));
                t.getJSONObject("artworks").append("art250", (String) t.getJSONObject("artworks").getString("250"));
                t.getJSONObject("artworks").append("art500", (String) t.getJSONObject("artworks").getString("500"));
                t.getJSONObject("artworks").append("art1000", (String) t.getJSONObject("artworks").getString("1000"));
            });

            ArrayList<JSONObject> schedule = this.getJsonArrayList(jsonObject.getJSONArray("schedule"));
            schedule.stream().forEach(t -> {
                t.getJSONObject("artworks").append("art100", (String) t.getJSONObject("artworks").getString("100"));
                t.getJSONObject("artworks").append("art250", (String) t.getJSONObject("artworks").getString("250"));
                t.getJSONObject("artworks").append("art500", (String) t.getJSONObject("artworks").getString("500"));
                t.getJSONObject("artworks").append("art1000", (String) t.getJSONObject("artworks").getString("1000"));
            });
            
            try {
                this.channels.put(Channels.valueOf(name.toUpperCase()), this.client.getGson().fromJson(jsonObject.toString(), Channel.class));
                if(name.toUpperCase().equals("ONE")) {
                    this.jsonObjectOne = jsonObject;
                }
            } catch(IllegalArgumentException ex) {
            }
        });
        socket.on("listeners", (Object... os) -> {
            if(os[0].toString() == null) this.allListeners = 0;
            this.allListeners = Integer.valueOf(os[0].toString());
        });
    }

    public Socket getSocket() {
        return socket;
    }

    public JSONObject getJsonObjectOne() {
        return jsonObjectOne;
    }

    public Channel getChannel(Channels channel) {
        Map.Entry<Channels, Channel> result = channels.entrySet().stream().filter(t -> t.getKey().equals(channel)).findFirst().orElse(null);
        if(result == null) return null;
        return result.getValue();
    }

    public int getAllListeners() {
        return allListeners;
    }

    private ArrayList<JSONObject> getJsonArrayList(JSONArray jsonArray) {
        ArrayList<JSONObject> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.optJSONObject(i));
            }
        }
        return list;
    }

}

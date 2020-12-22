package eu.atomicradio.managers;

import eu.atomicradio.AtomicClient;
import eu.atomicradio.objects.Channel;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URI;
import java.util.ArrayList;
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
    private JSONObject jsonObjectOne;
    private JSONObject jsonObjectDance;
    private JSONObject jsonObjectTrap;
    private Channel channelOne;
    private Channel channelDance;
    private Channel channelTrap;
    private int allListeners;

    public SocketManager(AtomicClient client) {
        this.client = client;
        this.socket = IO.socket(URI.create("https://api.atomicradio.eu"));
        initListeners();
        this.socket.connect();
    }

    private void initListeners() {
        socket.on(Socket.EVENT_CONNECT, (Object... os) -> {
            System.out.println("The connection to the Socket.IO server has been established.");
        });
        socket.on(Socket.EVENT_CONNECT_ERROR, (Object... os) -> {
            System.out.println("SOCKET.IO CONNECTION ERROR");
        });
        socket.on(Socket.EVENT_DISCONNECT, (Object... os) -> {
            System.out.println("SOCKET.IO DISCONNECTED");
        });
        socket.on("one", (Object... os) -> {
            JSONObject jsonObject = new JSONObject(os[0].toString());
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

            this.channelOne = this.client.getGson().fromJson(jsonObject.toString(), Channel.class);
            this.jsonObjectOne = jsonObject;
        });
        socket.on("dance", (Object... os) -> {
            JSONObject jsonObject = new JSONObject(os[0].toString());
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

            this.channelDance = this.client.getGson().fromJson(jsonObject.toString(), Channel.class);
            this.jsonObjectDance = jsonObject;
        });
        socket.on("trap", (Object... os) -> {
            JSONObject jsonObject = new JSONObject(os[0].toString());
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

            this.channelTrap = this.client.getGson().fromJson(jsonObject.toString(), Channel.class);
            this.jsonObjectTrap = jsonObject;
        });
        socket.on("listeners", (Object... os) -> {
            this.allListeners = Integer.valueOf(os[0].toString());
        });
    }

    public Socket getSocket() {
        return socket;
    }

    public JSONObject getJsonObjectOne() {
        return jsonObjectOne;
    }

    public JSONObject getJsonObjectDance() {
        return jsonObjectDance;
    }

    public JSONObject getJsonObjectTrap() {
        return jsonObjectTrap;
    }

    public Channel getChannelOne() {
        return channelOne;
    }

    public Channel getChannelDance() {
        return channelDance;
    }

    public Channel getChannelTrap() {
        return channelTrap;
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

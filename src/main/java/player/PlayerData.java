package me.arkallic.chaotix.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {

    private final UUID uuid;
    private String name;
    private String displayName;
    private String title;
    private int HomeLimit;

    private final Map<String, Home> homes;

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
        homes = new HashMap<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Home> getHomes() {
        return homes;
    }

    public int getHomeLimit() {
        return HomeLimit;
    }

    public void setHomeLimit(int homeLimit) {
        HomeLimit = homeLimit;
    }
}

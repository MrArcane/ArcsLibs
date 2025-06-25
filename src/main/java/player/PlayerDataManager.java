package me.arkallic.chaotix.managers;

import me.arkallic.chaotix.Chaotix;
import me.arkallic.chaotix.models.PlayerData;
import me.arkallic.chaotix.modules.PlayerDataModule;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

import static me.arkallic.chaotix.utils.ChatUtils.log;

public class PlayerDataManager {

    private final Chaotix chaotix;

    private final Map<UUID, PlayerData> data = new HashMap<>();
    private final Map<String, PlayerDataModule> modules = new HashMap<>();

    public PlayerDataManager(Chaotix chaotix) {
        this.chaotix = chaotix;
    }

    public Map<UUID, PlayerData> getData() {
        return data;
    }

    public void registerModule(String name, PlayerDataModule playerDataModule, boolean override) {
        name = name.toLowerCase();

        if (!override && modules.containsKey(name)) {
            throw new IllegalArgumentException("Module already exists: " + name);
        }

        this.modules.put(name, playerDataModule);
    }

    public Map<String, PlayerDataModule> getModules() {
        return this.modules;
    }

    public void saveCorePlayerData(UUID uuid, PlayerData pd) {
        YMLFileManager fileManager = new YMLFileManager("Players", uuid.toString(), chaotix);
        FileConfiguration config = fileManager.getConfig();

        config.set("Name", pd.getName());
        config.set("DisplayName", pd.getDisplayName());
        config.set("HomeLimit", pd.getHomeLimit());
        fileManager.save();
    }

    public PlayerDataModule getModule(String name) {
        return this.modules.get(name);
    }


    public PlayerData get(UUID uuid) {
        return this.data.get(uuid);
    }
}

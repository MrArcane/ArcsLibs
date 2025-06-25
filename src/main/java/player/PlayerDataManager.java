package player;

import managers.YMLFileManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    private final JavaPlugin javaPlugin;

    private final Map<UUID, PlayerData> data = new HashMap<>();
    private final Map<String, PlayerDataModule> modules = new HashMap<>();

    public PlayerDataManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
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

    public PlayerDataModule getModule(String name) {
        return this.modules.get(name);
    }


    public PlayerData get(UUID uuid) {
        return this.data.get(uuid);
    }
}

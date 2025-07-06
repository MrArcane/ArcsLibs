package player;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {

    private final UUID uuid;
    private String name;
    private Map<String, Object> moduleData;

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
        moduleData = new HashMap<>();
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

    public Map<String, Object> getModuleData() {
        return moduleData;
    }

    public void setModuleData(String key, Object value) {
        moduleData.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getModuleData(String name) {
        return (T) moduleData.get(name);
    }
}

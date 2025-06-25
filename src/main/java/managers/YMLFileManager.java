package managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;


public class YMLFileManager {

    private final File file;
    private final String fileName;
    private FileConfiguration config;
    private final JavaPlugin javaPlugin;

    public YMLFileManager(String folder, String fileName, JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
        this.fileName = fileName.endsWith(".yml") ? fileName : fileName + ".yml";

        this.file = new File(javaPlugin.getDataFolder(), folder + File.separator + this.fileName);
        createFileIfNotExists();
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    private void createFileIfNotExists() {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();

                InputStream resource = javaPlugin.getResource(fileName);
                if (resource != null) {
                    try (Reader reader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                         Writer writer = new FileWriter(file)) {

                        char[] buffer = new char[1024];
                        int bytesRead;
                        while ((bytesRead = reader.read(buffer)) != -1) {
                            writer.write(buffer, 0, bytesRead);
                        }
                    }
                } else {
                    javaPlugin.getLogger().warning("No default resource found for " + fileName + ", created blank file.");
                }
            } catch (IOException e) {
                javaPlugin.getLogger().log(Level.SEVERE, "Could not create or copy " + fileName, e);
            }
        }
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
            javaPlugin.getLogger().info("Saved YAML file: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save YAML file: " + fileName, e);
        }
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}
package me.kozmio.takisLib.utils;

import me.kozmio.takisLib.Colors.Colorize;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.io.IOException;

public class YmlManager {
    private static final YmlManager instance = new YmlManager();
    public static YmlManager getInstance() {
        return instance;
    }

    private File file;
    private FileConfiguration config;

    public void load(Plugin plugin, String fileName) {
        this.file = new File(plugin.getDataFolder(), fileName);
        if (!this.file.exists())
            plugin.saveResource(fileName, false);
        this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
        plugin.getLogger().log(Level.INFO, fileName + " loaded successfully.");
    }

    public void save() {
        if (this.config == null || this.file == null) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save " + this.file.getName() + " because the configuration is null.");
            return;
        }
        try {
            this.config.save(this.file);
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Error saving " + this.file.getName(), ex);
        }
    }

    public void set(String path, Object value) {
        if (this.config == null) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot set a value in " + this.file.getName() + " because the configuration is null.");
            return;
        }
        this.config.set(path, value);
        save();
    }

    public String getString(String key, String fallback) {
        if (this.config == null) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot retrieve a value from " + this.file.getName() + " because the configuration is null.");
            return fallback;
        }
        String value = this.config.getString(key, fallback);
        return Colorize.applyColors(value);
    }

    public int getInt(String key, int fallback) {
        if (this.config == null) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot retrieve a value from " + this.file.getName() + " because the configuration is null.");
            return fallback;
        }
        return this.config.getInt(key, fallback);
    }

    public boolean getBoolean(String key, boolean fallback) {
        if (this.config == null) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot retrieve a value from " + this.file.getName() + " because the configuration is null.");
            return fallback;
        }
        return this.config.getBoolean(key, fallback);
    }

    public List<String> getStringList(String key, List<String> fallback) {
        if (this.config == null) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot retrieve a value from " + this.file.getName() + " because the configuration is null.");
            return fallback;
        }
        List<String> value = this.config.getStringList(key);
        for (int i = 0; i < value.size(); i++)
            value.set(i, Colorize.applyColors(value.get(i)));
        return value;
    }
}

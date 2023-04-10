package me.steep.datahandler;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public class Key {

    private static Plugin instance;

    public static void register(Plugin instance) {
        Key.instance = instance;
    }

    public static NamespacedKey key(String s) {
        return new NamespacedKey(instance, s);
    }

}

package me.steep.datahandler;

import org.bukkit.NamespacedKey;

public class Key {

    public static NamespacedKey key(String s) {
        return new NamespacedKey(DataHandler.getPluginInstance(), s);
    }

}

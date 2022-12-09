package me.steep.datahandler;

import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

@SuppressWarnings("all")
public class EntityDataBuilder {

    private Entity entity;
    private PersistentDataContainer container;
    
    public EntityDataBuilder(Entity entity) {
        this.entity = entity;
        this.container = entity.getPersistentDataContainer();
    }

    /**
     * @param key The key to remove from the specified Entity's PersistentDataContainer
     */
    public EntityDataBuilder removeData(String key) {
        container.remove(new NamespacedKey(DataHandler.getPluginInstance(), key));
        return this;
    }

    /**
     * @param key The key for the Object stored in the specified Entity's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     */
    public EntityDataBuilder setData(String key, PersistentDataType type, Object object) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), type, object);
        return this;
    }

    /**
     * @param key The key to the String stored in the Entity's PersistentDataContainer
     * @param s The String to store in the specified Entity's PersistentDataContainer
     */
    public EntityDataBuilder setDataString(String key, String s) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.STRING, s);
        return this;
    }

    /**
     * @param key The key to the Boolean stored in the Entity's PersistentDataContainer.
     * @param b The Boolean to store in the specified Entity's PersistentDataContainer.
     */
    public EntityDataBuilder setDataBoolean(String key, Boolean b) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BOOLEAN, b);
        return this;
    }

    /**
     * @param key The key to the Integer stored in the Entity's PersistentDataContainer.
     * @param i The Integer to store in the specified Entity's PersistentDataContainer.
     */
    public EntityDataBuilder setDataInt(String key, Integer i) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.INTEGER, i);
        return this;
    }

    /**
     * @param key The key to the Double stored in the Entity's PersistentDataContainer.
     * @param d The Double to store in the specified Entity's PersistentDataContainer.
     */
    public EntityDataBuilder setDataDouble(String key, Double d) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.DOUBLE, d);
        return this;
    }

    /**
     * @param key The key to the Float stored in the Entity's PersistentDataContainer.
     * @param f The Float to store in the specified Entity's PersistentDataContainer.
     */
    public EntityDataBuilder setDataFloat(String key, Float f) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.FLOAT, f);
        return this;
    }

    /**
     * @param key The key to the Long stored in the Entity's PersistentDataContainer.
     * @param l The Long to store in the specified Entity's PersistentDataContainer.
     */
    public EntityDataBuilder setDataLong(String key, Long l) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.LONG, l);
        return this;
    }

    /**
     * @param key The key to the Short stored in the Entity's PersistentDataContainer.
     * @param s The Short to store in the specified Entity's PersistentDataContainer.
     */
    public EntityDataBuilder setDataShort(String key, Short s) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.SHORT, s);
        return this;
    }

    /**
     * @param key The key to the Byte stored in the Entity's PersistentDataContainer.
     * @param b The Byte to store in the specified Entity's PersistentDataContainer.
     */
    public EntityDataBuilder setDataByte(String key, Byte b) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BYTE, b);
        return this;
    }

    /**
     * @param key The key to the ItemStack stored in the specified Entity's PersistentDataContainer
     * @param toStore The ItemStack to store in the specified Entity's PersistentDataContainer
     */
    public EntityDataBuilder setDataItemStack(String key, ItemStack toStore) {
        container.set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.ITEM_STACK, toStore);
        return this;
    }
    
    public Entity entity() {
        return this.entity;
    }

}

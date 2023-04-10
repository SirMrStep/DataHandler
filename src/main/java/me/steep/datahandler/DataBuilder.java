package me.steep.datahandler;

import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;

import static me.steep.datahandler.Key.key;

@SuppressWarnings("all")
public class DataBuilder<T extends PersistentDataHolder> {

    private T holder;
    private PersistentDataContainer container;

    public DataBuilder(T holder) {
        this.holder = holder;
        this.container = holder.getPersistentDataContainer();
    }

    /**
     * @param key The key to remove from the specified Entity's PersistentDataContainer
     */
    public DataBuilder<T> removeData(String key) {
        container.remove(key(key));
        return this;
    }

    /**
     * @param key The key for the Object stored in the specified Entity's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     */
    public DataBuilder<T> setData(String key, PersistentDataType type, Object object) {
        container.set(key(key), type, object);
        return this;
    }

    /**
     * @param key The key to the String stored in the Entity's PersistentDataContainer
     * @param s The String to store in the specified Entity's PersistentDataContainer
     */
    public DataBuilder<T> setDataString(String key, String s) {
        container.set(key(key), DataType.STRING, s);
        return this;
    }

    /**
     * @param key The key to the Boolean stored in the Entity's PersistentDataContainer.
     * @param b The Boolean to store in the specified Entity's PersistentDataContainer.
     */
    public DataBuilder<T> setDataBoolean(String key, Boolean b) {
        container.set(key(key), DataType.BOOLEAN, b);
        return this;
    }

    /**
     * @param key The key to the Integer stored in the Entity's PersistentDataContainer.
     * @param i The Integer to store in the specified Entity's PersistentDataContainer.
     */
    public DataBuilder<T> setDataInt(String key, Integer i) {
        container.set(key(key), DataType.INTEGER, i);
        return this;
    }

    /**
     * @param key The key to the Double stored in the Entity's PersistentDataContainer.
     * @param d The Double to store in the specified Entity's PersistentDataContainer.
     */
    public DataBuilder<T> setDataDouble(String key, Double d) {
        container.set(key(key), DataType.DOUBLE, d);
        return this;
    }

    /**
     * @param key The key to the Float stored in the Entity's PersistentDataContainer.
     * @param f The Float to store in the specified Entity's PersistentDataContainer.
     */
    public DataBuilder<T> setDataFloat(String key, Float f) {
        container.set(key(key), DataType.FLOAT, f);
        return this;
    }

    /**
     * @param key The key to the Long stored in the Entity's PersistentDataContainer.
     * @param l The Long to store in the specified Entity's PersistentDataContainer.
     */
    public DataBuilder<T> setDataLong(String key, Long l) {
        container.set(key(key), DataType.LONG, l);
        return this;
    }

    /**
     * @param key The key to the Short stored in the Entity's PersistentDataContainer.
     * @param s The Short to store in the specified Entity's PersistentDataContainer.
     */
    public DataBuilder<T> setDataShort(String key, Short s) {
        container.set(key(key), DataType.SHORT, s);
        return this;
    }

    /**
     * @param key The key to the Byte stored in the Entity's PersistentDataContainer.
     * @param b The Byte to store in the specified Entity's PersistentDataContainer.
     */
    public DataBuilder<T> setDataByte(String key, Byte b) {
        container.set(key(key), DataType.BYTE, b);
        return this;
    }

    /**
     * @param key The key to the ItemStack stored in the specified Entity's PersistentDataContainer
     * @param toStore The ItemStack to store in the specified Entity's PersistentDataContainer
     */
    public DataBuilder<T> setDataItemStack(String key, ItemStack toStore) {
        container.set(key(key), DataType.ITEM_STACK, toStore);
        return this;
    }

    public T get() {
        return this.holder;
    }

}

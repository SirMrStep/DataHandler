package me.steep.datahandler;

import com.jeff_media.customblockdata.CustomBlockData;
import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import static me.steep.datahandler.Key.key;

@SuppressWarnings("all")
public class BlockDataBuilder {
    
    private final Block block;
    private CustomBlockData data;
    
    public BlockDataBuilder(Block block) {
        this.block = block;
        this.data = new CustomBlockData(block, DataHandler.getPluginInstance());
    }

    /**
     * @param key The key to remove from the specified Block's PersistentDataContainer
     */
    public BlockDataBuilder removeData(String key) {
        data.remove(key(key));
        return this;
    }

    /**
     * @param key The key for the Object stored in the specified Block's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     */
    public BlockDataBuilder setData(String key, PersistentDataType type, Object object) {
        data.set(key(key), type, object);
        return this;
    }

    /**
     * @param key The key to the String stored in the Block's PersistentDataContainer
     * @param s The String to store in the specified Block's PersistentDataContainer
     */
    public BlockDataBuilder setDataString(String key, String s) {
        data.set(key(key), DataType.STRING, s);
        return this;
    }

    /**
     * @param key The key to the Boolean stored in the Block's PersistentDataContainer.
     * @param b The Boolean to store in the specified Block's PersistentDataContainer.
     */
    public BlockDataBuilder setDataBoolean(String key, Boolean b) {
        data.set(key(key), DataType.BOOLEAN, b);
        return this;
    }

    /**
     * @param key The key to the Integer stored in the Block's PersistentDataContainer.
     * @param i The Integer to store in the specified Block's PersistentDataContainer.
     */
    public BlockDataBuilder setDataInt(String key, Integer i) {
        data.set(key(key), DataType.INTEGER, i);
        return this;
    }

    /**
     * @param key The key to the Double stored in the Block's PersistentDataContainer.
     * @param d The Double to store in the specified Block's PersistentDataContainer.
     */
    public BlockDataBuilder setDataDouble(String key, Double d) {
        data.set(key(key), DataType.DOUBLE, d);
        return this;
    }

    /**
     * @param key The key to the Float stored in the Block's PersistentDataContainer.
     * @param f The Float to store in the specified Block's PersistentDataContainer.
     */
    public BlockDataBuilder setDataFloat(String key, Float f) {
        data.set(key(key), DataType.FLOAT, f);
        return this;
    }

    /**
     * @param key The key to the Long stored in the Block's PersistentDataContainer.
     * @param l The Long to store in the specified Block's PersistentDataContainer.
     */
    public BlockDataBuilder setDataLong(String key, Long l) {
        data.set(key(key), DataType.LONG, l);
        return this;
    }

    /**
     * @param key The key to the Short stored in the Block's PersistentDataContainer.
     * @param s The Short to store in the specified Block's PersistentDataContainer.
     */
    public BlockDataBuilder setDataShort(String key, Short s) {
        data.set(key(key), DataType.SHORT, s);
        return this;
    }

    /**
     * @param key The key to the Byte stored in the Block's PersistentDataContainer.
     * @param b The Byte to store in the specified Block's PersistentDataContainer.
     */
    public BlockDataBuilder setDataByte(String key, Byte b) {
        data.set(key(key), DataType.BYTE, b);
        return this;
    }

    /**
     * @param key The key to the ItemStack stored in the specified Block's PersistentDataContainer
     * @param toStore The ItemStack to store in the specified Block's PersistentDataContainer
     */
    public BlockDataBuilder setDataItemStack(String key, ItemStack toStore) {
        data.set(key(key), DataType.ITEM_STACK, toStore);
        return this;
    }

    public Block block() {
        return this.block;
    }

}

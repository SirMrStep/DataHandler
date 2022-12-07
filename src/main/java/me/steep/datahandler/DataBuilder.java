package me.steep.datahandler;

import com.jeff_media.customblockdata.CustomBlockData;
import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class DataBuilder {

    private ItemStack item = null;
    private Block block = null;
    private Entity entity = null;
    private final BuilderType type;

    private enum BuilderType {
        ITEM,
        BLOCK,
        ENTITY
    }

    public DataBuilder(ItemStack item) {
        this.item = item;
        this.type = BuilderType.ITEM;
    }

    public DataBuilder(Block block) {
        this.block = block;
        this.type = BuilderType.BLOCK;
    }

    public DataBuilder(Entity entity) {
        this.entity = entity;
        this.type = BuilderType.ENTITY;
    }

    public ItemStack item() {
        return this.item;
    }

    public Entity entity() {
        return this.entity;
    }

    public Block block() {
        return this.block;
    }

    /**
     * @param name The name to put on the ItemStack.
     * @param lore The lore to put on the ItemStack.
     * @return This DataBuilder
     */
    public DataBuilder setNameAndLore(String name, String... lore) {
        if (this.type != BuilderType.ITEM) return this;
        ItemMeta meta = this.item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * @param name The name to put on the ItemStack.
     * @param lore The lore to put on the ItemStack.
     * @return This DataBuilder
     */
    public DataBuilder setNameAndLore(String name, List<String> lore) {
        if (this.type != BuilderType.ITEM) return this;
        ItemMeta meta = this.item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * @param lore The lore to put on the ItemStack
     * @return This DataBuilder
     */
    public DataBuilder setLore(String... lore) {
        if (this.type != BuilderType.ITEM) return this;
        ItemMeta meta = this.item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * @param name The name to put on the ItemStack.
     * @return This DataBuilder
     */
    public DataBuilder setName(String name) {
        if (this.type != BuilderType.ITEM) return this;
        ItemMeta meta = this.item.getItemMeta();
        meta.setDisplayName(name);
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * @param key The key to remove from the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder removeData(String key) {

        switch (this.type) {

            case ITEM -> {

                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().remove(new NamespacedKey(DataHandler.getPluginInstance(), key));
                this.item.setItemMeta(meta);

            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().remove(new NamespacedKey(DataHandler.getPluginInstance(), key));

            case BLOCK ->
                    new CustomBlockData(this.block, DataHandler.getPluginInstance()).remove(new NamespacedKey(DataHandler.getPluginInstance(), key));

        }

        return this;
    }

    /**
     * @param key  The key for the Object stored in the Object's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     * @return This DataBuilder
     */
    public DataBuilder setData(String key, PersistentDataType type, Object object) {

        switch (this.type) {

            case ITEM -> this.item.getItemMeta().getPersistentDataContainer()
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), type, object);

            case ENTITY -> this.entity.getPersistentDataContainer()
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), type, object);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), type, object);

        }

        return this;
    }

    /**
     * @param key The key to the String stored in the Object's PersistentDataContainer
     * @param s   The String to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataString(String key, String s) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.STRING, s);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.STRING, s);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.STRING, s);

        }

        return this;
    }

    /**
     * @param key The key to the Boolean stored in the Object's PersistentDataContainer
     * @param b   The Boolean to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataBoolean(String key, Boolean b) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BOOLEAN, b);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BOOLEAN, b);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BOOLEAN, b);

        }

        return this;
    }

    /**
     * @param key The key to the Integer stored in the Object's PersistentDataContainer
     * @param i   The Integer to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataInt(String key, Integer i) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.INTEGER, i);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.INTEGER, i);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.INTEGER, i);

        }

        return this;
    }

    /**
     * @param key The key to the Double stored in the Object's PersistentDataContainer
     * @param d   The Double to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataDouble(String key, Double d) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.DOUBLE, d);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.DOUBLE, d);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.DOUBLE, d);

        }

        return this;
    }

    /**
     * @param key The key to the Float stored in the Object's PersistentDataContainer
     * @param f   The Float to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataFloat(String key, Float f) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.FLOAT, f);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.FLOAT, f);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.FLOAT, f);

        }

        return this;
    }

    /**
     * @param key The key to the Long stored in the Object's PersistentDataContainer
     * @param l   The Long to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataLong(String key, Long l) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.LONG, l);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.LONG, l);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.LONG, l);

        }

        return this;
    }

    /**
     * @param key The key to the Short stored in the Object's PersistentDataContainer
     * @param b   The Short to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataShort(String key, Short s) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.SHORT, s);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.SHORT, s);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.SHORT, s);

        }

        return this;
    }

    /**
     * @param key The key to the Byte stored in the Object's PersistentDataContainer
     * @param b   The Byte to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataByte(String key, Byte b) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BYTE, b);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BYTE, b);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.BYTE, b);

        }

        return this;
    }

    /**
     * @param key     The key to the ItemStack stored in the Object's PersistentDataContainer
     * @param toStore The ItemStack to store in the Object's PersistentDataContainer
     * @return This DataBuilder
     */
    public DataBuilder setDataItemStack(String key, ItemStack toStore) {

        switch (this.type) {

            case ITEM -> {
                ItemMeta meta = this.item.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.ITEM_STACK, toStore);
                this.item.setItemMeta(meta);
            }

            case ENTITY ->
                    this.entity.getPersistentDataContainer().set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.ITEM_STACK, toStore);

            case BLOCK -> new CustomBlockData(this.block, DataHandler.getPluginInstance())
                    .set(new NamespacedKey(DataHandler.getPluginInstance(), key), DataType.ITEM_STACK, toStore);

        }

        return this;
    }

}

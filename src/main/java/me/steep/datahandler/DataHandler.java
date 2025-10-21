package me.steep.datahandler;

import com.jeff_media.customblockdata.CustomBlockData;
import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static me.steep.datahandler.Key.key;

/**
 * This DataHandler will work for all versions that have PersistantDataContainer
 * Uses Maven Dependancies inside this pom.xml: MorePersistentDataTypes, CustomBlockData
 * Also uses maven-shade-plugin with specified settings in this pom.xml
 */
@SuppressWarnings("all")
public class DataHandler {

    private static Plugin instance;

    static {
        instance = JavaPlugin.getProvidingPlugin(DataHandler.class);
    }

    public static Plugin getPluginInstance() {
        return instance;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param name The name to put on the ItemStack
     * @param lore The lore to put on the ItemStack
     */
    public static ItemStack setNameAndLore(ItemStack itemStack, String name, String... lore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param name The name to put on the ItemStack
     * @param lore The lore to put on the ItemStack
     */
    public static ItemStack setNameAndLore(ItemStack itemStack, String name, List<String> lore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param lore The lore to put on the ItemStack
     */
    public static ItemStack setLore(ItemStack itemStack, String... lore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param lore The lore to put on the ItemStack
     */
    public static ItemStack setLore(ItemStack itemStack, List<String> lore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param itemStack The ItemStack to edit.
     * @param name The name to put on the ItemStack.
     */
    public static ItemStack setName(ItemStack itemStack, String name) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param itemStack The ItemStack to check.
     * @param key The key to check for.
     * @param dataType The PersistentDataType to check for.
     * @return Whether the specified ItemStack has the specified key in it's PersistentDataContainer.
     */
    public static boolean hasData(ItemStack itemStack, String key, PersistentDataType dataType) {
        return itemStack.getItemMeta().getPersistentDataContainer().has(key(key), dataType);
    }

    /**
     * @param ent The Object extending PersistantDataHolder to modify.
     * @param key The key to check for.
     * @return Whether the specified Object extending PersistantDataHolder has the specified key in it's PersistentDataContainer.
     */
    public static boolean hasData(PersistentDataHolder holder, String key, PersistentDataType dataType) {
        return holder.getPersistentDataContainer().has(key(key), dataType);
    }

    /**
     * DISCLAIMER: THIS IS NOT FOR TileEntity BLOCKS, THIS IS FOR NORMAL BLOCK ONLY. FOR TileEntity BLOCK USE:
     * ((<BLOCK_CLASS>) <BLOCK>).getPersistentDataContainer().has(new NamespacedKey(<INSTANCE>, <KEY>), <PERSISTENTDATATYPE>)
     * @param b The Block to check.
     * @param key The key to check for.
     * @return Whether the specified Block has the specified key in it's PersistentDataContainer.
     */
    public static boolean hasData(Block b, String key, PersistentDataType dataType) {
        return new CustomBlockData(b, instance).has(key(key), dataType);
    }

    /**
     * @param itemStack The ItemStack to get the PersistentDataContainer from.
     * @return Returns the PersistentDataContainer of the specified ItemStack.
     */
    public static PersistentDataContainer getData(ItemStack itemStack) {
        return itemStack.getItemMeta().getPersistentDataContainer();
    }

    /**
     * @param holder The Object extending PersistantDataHolder to modify
     */
    public static PersistentDataContainer getData(PersistentDataHolder holder) {
        return holder.getPersistentDataContainer();
    }

    /**
     * @param b The Block to get the PersistentDataContainer from.
     * @return Returns the PersistentDataContainer of the specified Block.
     */
    public static PersistentDataContainer getData(Block b) {
        return new CustomBlockData(b, instance);
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to remove from the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack removeData(ItemStack itemStack, String key) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().remove(key(key));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key for the Object stored in the specified Entity's PersistentDataContainer
     */
    public static <T extends PersistentDataHolder> T removeData(T holder, String key) {
        holder.getPersistentDataContainer().remove(key(key));
        return holder;
    }

    /**
     * @param b The Block to edit
     * @param key The key to remove from the specified Block's PersistentDataContainer
     */
    public static Block removeData(Block b, String key) {
        new CustomBlockData(b, instance).remove(key(key));
        return b;
    }

    /**
     * @param itemStack The ItemStack to modify
     * @param key The key for the Object stored in the specified ItemStack's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     */
    public static ItemStack setData(ItemStack itemStack, String key, PersistentDataType type, Object object) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), type, object);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key for the Object stored in the specified Entity's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     * @param object The object you are storing.
     */
    public static <T extends PersistentDataHolder> T setData(T holder, String key, PersistentDataType type, Object object) {
        holder.getPersistentDataContainer().set(key(key), type, object);
        return holder;
    }

    /**
     * @param b The Block to modify
     * @param key The key for the Object stored in the specified Block's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     */
    public static Block setData(Block b, String key, PersistentDataType type, Object object) {
        new CustomBlockData(b, instance).set(key(key), type, object);
        return b;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the String stored in the ItemStack's PersistentDataContainer
     * @param s The String to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataString(ItemStack itemStack, String key, String s) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.STRING, s);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the String stored in the Object's PersistentDataContainer
     * @param s The String to store in the specified Object's PersistentDataContainer
     */
    public static <T extends PersistentDataHolder> T setDataString(T holder, String key, String s) {
        holder.getPersistentDataContainer().set(key(key), DataType.STRING, s);
        return holder;
    }

    /**
     * @param b The Block to edit
     * @param key The key to the String stored in the Block's PersistentDataContainer
     * @param s The String to store in the specified Block's PersistentDataContainer
     */
    public static Block setDataString(Block b, String key, String s) {
        new CustomBlockData(b, instance).set(key(key), DataType.STRING, s);
        return b;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the Boolean stored in the ItemStack's PersistentDataContainer
     * @param b The Boolean to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataBoolean(ItemStack itemStack, String key, Boolean b) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.BOOLEAN, b);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the Boolean stored in the Object's PersistentDataContainer.
     * @param b The Boolean to store in the specified Object's PersistentDataContainer.
     */
    public static <T extends PersistentDataHolder> T setDataBoolean(T holder, String key, Boolean b) {
        holder.getPersistentDataContainer().set(key(key), DataType.BOOLEAN, b);
        return holder;
    }

    /**
     * @param block The Block to edit.
     * @param key The key to the Boolean stored in the Block's PersistentDataContainer.
     * @param b The Boolean to store in the specified Block's PersistentDataContainer.
     */
    public static Block setDataBoolean(Block block, String key, Boolean b) {
        new CustomBlockData(block, instance).set(key(key), DataType.BOOLEAN, b);
        return block;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the Integer stored in the ItemStack's PersistentDataContainer
     * @param i The Integer to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataInt(ItemStack itemStack, String key, Integer i) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.INTEGER, i);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the Integer stored in the Object's PersistentDataContainer.
     * @param i The Integer to store in the specified Object's PersistentDataContainer.
     */
    public static <T extends PersistentDataHolder> T setDataInt(T holder, String key, Integer i) {
        holder.getPersistentDataContainer().set(key(key), DataType.INTEGER, i);
        return holder;
    }

    /**
     * @param b The Block to edit.
     * @param key The key to the Integer stored in the Block's PersistentDataContainer.
     * @param i The Integer to store in the specified Block's PersistentDataContainer.
     */
    public static Block setDataInt(Block b, String key, Integer i) {
        new CustomBlockData(b, instance).set(key(key), DataType.INTEGER, i);
        return b;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the Double stored in the ItemStack's PersistentDataContainer
     * @param d The Double to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataDouble(ItemStack itemStack, String key, Double d) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.DOUBLE, d);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the Double stored in the Object's PersistentDataContainer.
     * @param d The Double to store in the specified Object's PersistentDataContainer.
     */
    public static <T extends PersistentDataHolder> T setDataDouble(T holder, String key, Double d) {
        holder.getPersistentDataContainer().set(key(key), DataType.DOUBLE, d);
        return holder;
    }

    /**
     * @param b The Block to edit.
     * @param key The key to the Double stored in the Block's PersistentDataContainer.
     * @param d The Double to store in the specified Block's PersistentDataContainer.
     */
    public static Block setDataDouble(Block b, String key, Double d) {
        new CustomBlockData(b, instance).set(key(key), DataType.DOUBLE, d);
        return b;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the Float stored in the ItemStack's PersistentDataContainer
     * @param f The Float to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataFloat(ItemStack itemStack, String key, Float f) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.FLOAT, f);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the Float stored in the Object's PersistentDataContainer.
     * @param f The Float to store in the specified Object's PersistentDataContainer.
     */
    public static <T extends PersistentDataHolder> T setDataFloat(T holder, String key, Float f) {
        holder.getPersistentDataContainer().set(key(key), DataType.FLOAT, f);
        return holder;
    }

    /**
     * @param b The Block to edit.
     * @param key The key to the Float stored in the Block's PersistentDataContainer.
     * @param f The Float to store in the specified Block's PersistentDataContainer.
     */
    public static Block setDataFloat(Block b, String key, Float f) {
        new CustomBlockData(b, instance).set(key(key), DataType.FLOAT, f);
        return b;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the Long stored in the ItemStack's PersistentDataContainer
     * @param l The Long to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataLong(ItemStack itemStack, String key, Long l) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.LONG, l);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the Long stored in the Object's PersistentDataContainer.
     * @param l The Long to store in the specified Object's PersistentDataContainer.
     */
    public static <T extends PersistentDataHolder> T setDataLong(T holder, String key, Long l) {
        holder.getPersistentDataContainer().set(key(key), DataType.LONG, l);
        return holder;
    }

    /**
     * @param b The Block to edit.
     * @param key The key to the Long stored in the Block's PersistentDataContainer.
     * @param l The Long to store in the specified Block's PersistentDataContainer.
     */
    public static Block setDataLong(Block b, String key, Long l) {
        new CustomBlockData(b, instance).set(key(key), DataType.LONG, l);
        return b;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the Short stored in the ItemStack's PersistentDataContainer
     * @param b The Short to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataShort(ItemStack itemStack, String key, Short s) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.SHORT, s);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the Short stored in the Object's PersistentDataContainer.
     * @param s The Short to store in the specified Object's PersistentDataContainer.
     */
    public static <T extends PersistentDataHolder> T setDataShort(T holder, String key, Short s) {
        holder.getPersistentDataContainer().set(key(key), DataType.SHORT, s);
        return holder;
    }

    /**
     * @param b The Block to edit.
     * @param key The key to the Short stored in the Block's PersistentDataContainer.
     * @param s The Short to store in the specified Block's PersistentDataContainer.
     */
    public static Block setDataShort(Block b, String key, Short s) {
        new CustomBlockData(b, instance).set(key(key), DataType.SHORT, s);
        return b;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the Byte stored in the ItemStack's PersistentDataContainer
     * @param b The Byte to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataByte(ItemStack itemStack, String key, Byte b) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.BYTE, b);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the Byte stored in the Object's PersistentDataContainer
     * @param b The Byte to store in the specified Object's PersistentDataContainer
     */
    public static <T extends PersistentDataHolder> T setDataByte(T holder, String key, Byte b) {
        holder.getPersistentDataContainer().set(key(key), DataType.BYTE, b);
        return holder;
    }

    /**
     * @param block The Block to edit.
     * @param key The key to the Byte stored in the Block's PersistentDataContainer.
     * @param b The Byte to store in the specified Block's PersistentDataContainer.
     */
    public static Block setDataByte(Block block, String key, Byte b) {
        new CustomBlockData(block, instance).set(key(key), DataType.BYTE, b);
        return block;
    }

    /**
     * @param itemStack The ItemStack to edit
     * @param key The key to the ItemStack stored in the ItemStack's PersistentDataContainer
     * @param toStore The ItemStack to store in the specified ItemStack's PersistentDataContainer
     */
    public static ItemStack setDataItemStack(ItemStack itemStack, String key, ItemStack toStore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(key(key), DataType.ITEM_STACK, toStore);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * @param T The Object extending PersistantDataHolder to modify
     * @param key The key to the ItemStack stored in the specified Object's PersistentDataContainer
     * @param toStore The ItemStack to store in the specified Object's PersistentDataContainer
     */
    public static <T extends PersistentDataHolder> T setDataItemStack(T holder, String key, ItemStack toStore) {
        holder.getPersistentDataContainer().set(key(key), DataType.ITEM_STACK, toStore);
        return holder;
    }

    /**
     * @param b The Block to edit
     * @param key The key to the ItemStack stored in the specified Block's PersistentDataContainer
     * @param toStore The ItemStack to store in the specified Block's PersistentDataContainer
     */
    public static Block setDataItemStack(Block b, String key, ItemStack toStore) {
        new CustomBlockData(b, instance).set(key(key), DataType.ITEM_STACK, toStore);
        return b;
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Object stored in the specified ItemStack's PersistentDataContainer
     * @param type The type of Object you are getting (you can use DataType for this)
     * @return The requested Object or null of not present
     */
    @Nullable
    public static Object getData(ItemStack itemStack, String key, PersistentDataType type) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), type);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Object stored in the specified Object's PersistentDataContainer
     * @param type The type of Object you are getting (you can use DataType for this)
     * @return The requested Object or null of not present
     */
    @Nullable
    public static Object getData(PersistentDataHolder holder, String key, PersistentDataType type) {
        return holder.getPersistentDataContainer().get(key(key), type);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Object stored in the specified Block's PersistentDataContainer
     * @param type The type of Object you are getting (you can use DataType for this)
     * @return The requested Object or null of not present
     */
    @Nullable
    public static Object getData(Block b, String key, PersistentDataType type) {
        return new CustomBlockData(b, instance).get(key(key), type);
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the String stored in the specified ItemStack's PersistentDataContainer
     * @return The requested String or null if not present
     */
    @Nullable
    public static String getDataString(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.STRING);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the String stored in the specified Object's PersistentDataContainer
     * @return The requested String or null if not present
     */
    @Nullable
    public static String getDataString(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.STRING);
    }

    /**
     * @param b The Block to check
     * @param key The key to the String stored in the specified Block's PersistentDataContainer
     * @return The requested String or null if not present
     */
    @Nullable
    public static String getDataString(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.STRING);
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Boolean stored in the specified ItemStack's PersistentDataContainer
     * @return The requested Boolean or null if not present
     */
    public static Boolean getDataBoolean(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.BOOLEAN);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Boolean stored in the specified Object's PersistentDataContainer
     * @return The requested Boolean or null if not present
     */
    public static Boolean getDataBoolean(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.BOOLEAN);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Boolean stored in the specified Block's PersistentDataContainer
     * @return The requested Boolean or null if not present
     */
    public static Boolean getDataBoolean(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.BOOLEAN);
    }


    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Integer stored in the ItemStack's PersistentDataContainer
     * @return The requested Integer or null if not present
     */
    public static Integer getDataInt(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.INTEGER);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Integer stored in the specified Object's PersistentDataContainer
     * @return The requested Integer or null if not present
     */
    public static Integer getDataInt(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.INTEGER);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Integer stored in the specified Block's PersistentDataContainer
     * @return The requested Integer or null if not present
     */
    public static Integer getDataInt(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.INTEGER);
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Double stored in the specified ItemStack's PersistentDataContainer
     * @return The requested Double or null if not present
     */
    public static Double getDataDouble(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.DOUBLE);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Double stored in the specified Object's PersistentDataContainer
     * @return The requested Double or null if not present
     */
    public static Double getDataDouble(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.DOUBLE);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Double stored in the specified Block's PersistentDataContainer
     * @return The requested Double or null if not present
     */
    public static Double getDataDouble(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.DOUBLE);
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Float stored in the specified ItemStack's PersistentDataContainer
     * @return The requested Float or null if not present
     */
    public static Float getDataFloat(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.FLOAT);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Float stored in the specified Object's PersistentDataContainer
     * @return The requested Float or null if not present
     */
    public static Float getDataFloat(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.FLOAT);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Float stored in the specified Block's PersistentDataContainer
     * @return The requested Float or null if not present
     */
    public static Float getDataFloat(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.FLOAT);
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Long stored in the specified ItemStack's PersistentDataContainer
     * @return The requested Long or null if not present
     */
    public static Long getDataLong(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.LONG);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Long stored in the specified Object's PersistentDataContainer
     * @return The requested Long or null if not present
     */
    public static Long getDataLong(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.LONG);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Long stored in the specified Block's PersistentDataContainer
     * @return The requested Long or null if not present
     */
    public static Long getDataLong(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.LONG);
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Short stored in the specified ItemStack's PersistentDataContainer
     * @return The requested Short or null if not present
     */
    public static Short getDataShort(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.SHORT);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Short stored in the specified Object's PersistentDataContainer
     * @return The requested Short or null if not present
     */
    public static Short getDataShort(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.SHORT);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Short stored in the specified Block's PersistentDataContainer
     * @return The requested Short or null if not present
     */
    public static Short getDataShort(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.SHORT);
    }

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the Byte stored in the specified ItemStack's PersistentDataContainer
     * @return The requested Byte or null if not present
     */
    public static Byte getDataByte(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.BYTE);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the Byte stored in the specified Object's PersistentDataContainer
     * @return The requested Byte or null if not present
     */
    public static Byte getDataByte(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.BYTE);
    }

    /**
     * @param b The Block to check
     * @param key The key to the Byte stored in the specified Block's PersistentDataContainer
     * @return The requested Byte or null if not present
     */
    public static Byte getDataByte(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.BYTE);
    }

    // this is where the fun starts

    /**
     * @param itemStack The ItemStack to check
     * @param key The key to the ItemStack stored in the specified ItemStack's PersistentDataContainer
     * @return The requested ItemStack or null if not present
     */
    @Nullable
    public static ItemStack getDataItemStack(ItemStack itemStack, String key) {
        return itemStack.getItemMeta().getPersistentDataContainer().get(key(key), DataType.ITEM_STACK);
    }

    /**
     * @param holder The Object extending PersistantDataHolder to check
     * @param key The key to the ItemStack stored in the specified Object's PersistentDataContainer
     * @return The requested ItemStack or null if not present
     */
    @Nullable
    public static ItemStack getDataItemStack(PersistentDataHolder holder, String key) {
        return holder.getPersistentDataContainer().get(key(key), DataType.ITEM_STACK);
    }

    /**
     * @param b The Block to check
     * @param key The key to the ItemStack stored in the specified Block's PersistentDataContainer
     * @return The requested ItemStack or null if not present
     */
    @Nullable
    public static ItemStack getDataItemStack(Block b, String key) {
        return new CustomBlockData(b, instance).get(key(key), DataType.ITEM_STACK);
    }

    // yeeeeeeeeeeeeey we're done.

}
package me.steep.datahandler;

import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;

import static me.steep.datahandler.Key.key;

@SuppressWarnings("all")
public class ItemDataBuilder {

    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemDataBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.meta = itemStack.getItemMeta();
    }

    /**
     * @param name The name to put on the ItemStack
     * @param lore The lore to put on the ItemStack
     */
    public ItemDataBuilder setNameAndLore(String name, String... lore) {
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    /**
     * @param name The name to put on the ItemStack
     * @param lore The lore to put on the ItemStack
     */
    public ItemDataBuilder setNameAndLore(String name, List<String> lore) {
        meta.setDisplayName(name);
        meta.setLore(lore);
        return this;
    }

    /**
     * @param lore The lore to put on the ItemStack
     */
    public ItemDataBuilder setLore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    /**
     * @param lore The lore to put on the ItemStack
     */
    public ItemDataBuilder setLore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }

    /**
     * @param name The name to put on the ItemStack.
     */
    public ItemDataBuilder setName(String name) {
        meta.setDisplayName(name);

        return this;
    }

    public ItemDataBuilder addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        meta.addAttributeModifier(attribute, modifier);
        return this;
    }

    /**
     * @param key The key to remove from the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder removeData(String key) {
        meta.getPersistentDataContainer().remove(key(key));
        return this;
    }

    /**
     * @param key  The key for the Object stored in the specified ItemStack's PersistentDataContainer
     * @param type The type of Object you are storing (you can use DataType for this)
     */
    public ItemDataBuilder setData(String key, PersistentDataType type, Object object) {
        meta.getPersistentDataContainer().set(key(key), type, object);
        return this;
    }

    /**
     * @param key The key to the String stored in the ItemStack's PersistentDataContainer
     * @param s   The String to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataString(String key, String s) {
        meta.getPersistentDataContainer().set(key(key), DataType.STRING, s);
        return this;
    }

    /**
     * @param key The key to the Boolean stored in the ItemStack's PersistentDataContainer
     * @param b   The Boolean to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataBoolean(String key, Boolean b) {
        meta.getPersistentDataContainer().set(key(key), DataType.BOOLEAN, b);
        return this;
    }

    /**
     * @param key The key to the Integer stored in the ItemStack's PersistentDataContainer
     * @param i   The Integer to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataInt(String key, Integer i) {
        meta.getPersistentDataContainer().set(key(key), DataType.INTEGER, i);
        return this;
    }

    /**
     * @param key The key to the Double stored in the ItemStack's PersistentDataContainer
     * @param d   The Double to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataDouble(String key, Double d) {
        meta.getPersistentDataContainer().set(key(key), DataType.DOUBLE, d);
        return this;
    }

    /**
     * @param key The key to the Float stored in the ItemStack's PersistentDataContainer
     * @param f   The Float to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataFloat(String key, Float f) {
        meta.getPersistentDataContainer().set(key(key), DataType.FLOAT, f);
        return this;
    }

    /**
     * @param key The key to the Long stored in the ItemStack's PersistentDataContainer
     * @param l   The Long to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataLong(String key, Long l) {
        meta.getPersistentDataContainer().set(key(key), DataType.LONG, l);
        return this;
    }

    /**
     * @param key The key to the Short stored in the ItemStack's PersistentDataContainer
     * @param b   The Short to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataShort(String key, Short s) {
        meta.getPersistentDataContainer().set(key(key), DataType.SHORT, s);
        return this;
    }

    /**
     * @param key The key to the Byte stored in the ItemStack's PersistentDataContainer
     * @param b   The Byte to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataByte(String key, Byte b) {
        meta.getPersistentDataContainer().set(key(key), DataType.BYTE, b);
        return this;
    }

    /**
     * @param key     The key to the ItemStack stored in the ItemStack's PersistentDataContainer
     * @param toStore The ItemStack to store in the specified ItemStack's PersistentDataContainer
     */
    public ItemDataBuilder setDataItemStack(String key, ItemStack toStore) {
        meta.getPersistentDataContainer().set(key(key), DataType.ITEM_STACK, toStore);
        return this;
    }

    public ItemStack item() {
        this.itemStack.setItemMeta(meta);
        return this.itemStack;
    }

}

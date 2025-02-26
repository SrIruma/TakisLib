package me.kozmio.takisLib.interfaces;

import java.util.function.Consumer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface BaseMenu extends InventoryHolder {
    void click(Player paramPlayer, int paramInt);

    void setItem(int paramInt, ItemStack paramItemStack);

    void setItem(int paramInt, ItemStack paramItemStack, Consumer<Player> paramConsumer);

    void onSetItems();

    default void open(Player player) {
        onSetItems();
        player.openInventory(getInventory());
    }
}
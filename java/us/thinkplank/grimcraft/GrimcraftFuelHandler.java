package us.thinkplank.grimcraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GrimcraftFuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel) {
        Item fuelType = fuel.getItem();
        if (fuelType == GameRegistry.findItem("grimcraft", "sulfur")) {
            return 2400;
        } else if (fuelType == GameRegistry.findItem("grimcraft", "chiliPepper")) {
            return 100;
        } else {
            return 0;
        }
    }
}

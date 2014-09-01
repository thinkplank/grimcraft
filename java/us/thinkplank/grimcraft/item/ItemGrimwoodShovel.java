package us.thinkplank.grimcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemGrimwoodShovel extends ItemSpade {
    public ItemGrimwoodShovel(ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabTools);
        setUnlocalizedName("grimwood_shovel");
        setTextureName("grimcraft:grimwood_shovel");
    }
}

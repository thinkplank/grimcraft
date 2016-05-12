package us.thinkplank.grimcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFossilstoneOre extends Block {
    public BlockFossilstoneOre () {
        super(Material.rock);
        setHardness(3F);
        setStepSound(Block.soundTypeStone);
        setBlockName("fossilstone_ore");
        setCreativeTab(CreativeTabs.tabBlock);
        setHarvestLevel("pickaxe", 1);
    }
    
    //TODO fix this GameRegistry.findItem() call
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return GameRegistry.findItem("minecraft", "bone");
    }

    public int quantityDropped(Random random) {
        return random.nextInt(2) + 4;
    }
}

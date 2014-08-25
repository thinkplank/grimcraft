package us.thinkplank.grimcraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockGrimwoodFenceGate extends BlockFenceGate {
	public BlockGrimwoodFenceGate() {
		super();
		setBlockName("grimwood_fence_gate");
		setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return GrimcraftBlocks.grimwood_planks.getBlockTextureFromSide(side);
    }
}

package us.thinkplank.grimcraft.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;

public class BlockGrimwoodFenceGate extends BlockFenceGate {
	public BlockGrimwoodFenceGate() {
		super(BlockPlanks.EnumType.OAK);
		setHardness(2F);
		setRegistryName("grimwood_fence_gate");
	}
}

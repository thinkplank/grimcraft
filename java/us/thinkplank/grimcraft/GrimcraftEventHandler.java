package us.thinkplank.grimcraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import us.thinkplank.grimcraft.block.GrimcraftBlocks;
import us.thinkplank.grimcraft.item.GrimcraftItems;

public class GrimcraftEventHandler {
	
	@SubscribeEvent
	public void onUseHoe(UseHoeEvent event) {
		Block targetBlock = event.world.getBlock(event.blockPos);
		
		if (targetBlock.equals(Blocks.soul_sand)) {
			event.world.playSoundEffect(new BlockPos((double)((float)event.blockPos.getX() + 0.5F), (double)((float)event.blockPos.getY() + 0.5F), (double)((float)event.blockPos.getZ() + 0.5F)), targetBlock.stepSound.getStepResourcePath(), (targetBlock.stepSound.getVolume() + 1.0F) / 2.0F, targetBlock.stepSound.getPitch() * 0.8F);
			
			if (event.world.isRemote) {
				return;
			}
			
			event.world.setBlock(event.blockPos, GrimcraftBlocks.peat);
            event.current.damageItem(1, event.entityPlayer);
		}
	}
	
	@SubscribeEvent
	public void onUseBonemeal(BonemealEvent event) {
		Block targetBlock = event.block;
		
		if (targetBlock.equals(GrimcraftBlocks.barley_crop) || targetBlock.equals(GrimcraftBlocks.netherroot_crop)) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event) {
		Block targetBlock = event.world.getBlock(event.blockPos);
		ItemStack heldItemStack = event.entityPlayer.inventory.getCurrentItem();
		
		// handles strawberry harvesting
		if (targetBlock.equals(GrimcraftBlocks.vulpiberry_bush) && event.action == event.action.LEFT_CLICK_BLOCK) {
			if (event.world.getBlockMetadata(event.blockPos) == 1) {
				event.setCanceled(true);
				event.world.spawnEntityInWorld(new EntityItem(event.world, event.blockPos, new ItemStack(GrimcraftItems.vulpiberry, 3)));
				event.world.setBlockMetadataWithNotify(event.blockPos, 0, 2);
			}
		}
		
		if (targetBlock.equals(GrimcraftBlocks.ghast_pepper_bush) && event.action == event.action.LEFT_CLICK_BLOCK) {
			if (event.world.getBlockMetadata(event.blockPos) == 1) {
				event.setCanceled(true);
				event.world.spawnEntityInWorld(new EntityItem(event.world, event.blockPos, new ItemStack(GrimcraftItems.ghast_pepper, 3)));
				event.world.setBlockMetadataWithNotify(event.blockPos, 0, 2);
			}
		}
	}
	
	/* this makes lava push around mobs */
	@SubscribeEvent
	public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
		event.entity.worldObj.handleMaterialAcceleration(event.entity.boundingBox.expand(0.0D, -0.4000000059604645D, 0.0D).contract(0.001D, 0.001D, 0.001D), Material.lava, event.entity);
	}
}

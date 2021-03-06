/*
* modified from code generated by MrPonyCaptain's
* .schematic to .java converting tool v2.0
*/

package us.thinkplank.grimcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
// import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenNetherLair extends WorldGenerator implements IWorldGenerator {
	//TODO in 1.11 update, make this work with /locate!
	
	// old loot table contents
	//WeightedRandomChestContent(Item, meta, min stack size, max stack size, freq)
//    public static final WeightedRandomChestContent[] loot = new WeightedRandomChestContent[] {
//    	new WeightedRandomChestContent(GrimcraftItems.wither_bone, 0, 1, 4, 10), 
//    	new WeightedRandomChestContent(GrimcraftItems.wither_bonemeal, 0, 1, 4, 10), 
//    	new WeightedRandomChestContent(Items.BREAD, 0, 1, 1, 10), 
//    	new WeightedRandomChestContent(GrimcraftItems.barley, 0, 1, 4, 10), 
//    	new WeightedRandomChestContent(GrimcraftItems.brimstone, 0, 1, 4, 10), 
//    	new WeightedRandomChestContent(Items.STRING, 0, 1, 4, 10), 
//    	new WeightedRandomChestContent(Items.BUCKET, 0, 1, 1, 10), 
//    	new WeightedRandomChestContent(Items.GOLDEN_APPLE, 0, 1, 1, 1), 
//    	new WeightedRandomChestContent(GrimcraftItems.ghast_pepper, 0, 1, 4, 10),
//    	new WeightedRandomChestContent(GrimcraftItems.vulpiberry, 0, 1, 4, 10), 
//    	new WeightedRandomChestContent(Items.RECORD_11, 0, 1, 1, 10), 
//    	new WeightedRandomChestContent(Items.RECORD_WAIT, 0, 1, 1, 10), 
//    	new WeightedRandomChestContent(Items.NAME_TAG, 0, 1, 1, 10), 
//    };
	
	ResourceLocation netherLairLootTable = LootTableList.CHESTS_SIMPLE_DUNGEON;
	//TODO figure out how to register Loot Table correctly
	// LootTableList.register(new ResourceLocation("grimcraft", "nether_lair"));
	
	Block air = Blocks.AIR;
	Block brick = Blocks.NETHER_BRICK;
	Block tnt = Blocks.TNT;
	Block sand = Blocks.SOUL_SAND;
	Block lava = Blocks.LAVA;
	Block torch = Blocks.REDSTONE_TORCH;
	Block chest = Blocks.TRAPPED_CHEST;
	Block wart = Blocks.NETHER_WART;
	
	Block[][] layer7 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, brick, air, air, air, air, air, brick, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	Block[][] layer6 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{brick, brick, brick, air, brick, air, brick, brick, brick},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	Block[][] layer5 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, brick, brick, brick, brick, brick, brick, brick, air},
		{air, brick, brick, brick, brick, brick, brick, brick, air},
		{air, brick, brick, brick, brick, brick, brick, brick, air},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, lava, brick, brick, brick, brick, brick, lava, brick},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	Block[][] layer4 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{air, air, air, brick, air, brick, air, air, air},
		{air, air, air, air, air, air, air, air, air}
	};
	
	Block[][] layer3 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, torch, brick, brick, brick, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, brick, brick, brick, air, brick, brick, brick, brick},
		{air, air, air, brick, air, brick, air, air, air},
		{air, air, air, air, air, air, air, air, air}
	};
	
	Block[][] layer2 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, torch, chest, torch, brick, brick, brick},
		{brick, wart, wart, air, air, air, wart, wart, brick},
		{brick, wart, air, air, air, air, air, wart, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, air, air, air, air, air, air, air, brick},
		{brick, brick, brick, brick, air, brick, brick, brick, brick},
		{air, air, air, brick, air, brick, air, air, air},
		{air, air, air, air, air, air, air, air, air}
	};
	
	Block[][] layer1 = {
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, tnt, brick, brick, brick, brick},
		{brick, sand, sand, brick, brick, brick, sand, sand, brick},
		{brick, sand, brick, brick, brick, brick, brick, sand, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick},
		{brick, air, brick, brick, brick, brick, brick, air, brick},
		{brick, brick, brick, brick, brick, brick, brick, brick, brick}
	};
	
	Block[][] layer0 = {
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, air, air, air, air, air, air, air, air},
		{air, brick, air, air, air, air, air, brick, air},
		{air, air, air, air, air, air, air, air, air},
	};
	
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {
			Blocks.NETHERRACK,
			Blocks.SOUL_SAND
		};
	}

	public boolean locationIsValidSpawn(World worldIn, BlockPos pos) {
		int distanceToAir = 0;
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		Block check = worldIn.getBlockState(new BlockPos(i, j, k)).getBlock();

		while (check != Blocks.AIR){
			if (distanceToAir > 3) {
				return false;
			}

			distanceToAir++;
			check = worldIn.getBlockState(new BlockPos(i, j + distanceToAir, k)).getBlock();
		}

		j += distanceToAir - 1;

		Block block = worldIn.getBlockState(new BlockPos(i, j, k)).getBlock();
		Block blockAbove = worldIn.getBlockState(new BlockPos(i, j + 1, k)).getBlock();
		Block blockBelow = worldIn.getBlockState(new BlockPos(i, j - 1, k)).getBlock();
		
		for (Block x : getValidSpawnBlocks()){
			if (blockAbove != Blocks.AIR){
				return false;
			}
			if (block == x) {
				return true;
			} else if (block == Blocks.SNOW && blockBelow == x) {
				return true;
			}
		}
		
		return false;
	}

	public WorldGenNetherLair() {
		
	}
	
	private void fillChest(World worldIn, Random rand, BlockPos pos) {
		TileEntityChest chest = (TileEntityChest) worldIn.getTileEntity(pos);
		
		if (chest != null) {
			chest.setLootTable(netherLairLootTable, rand.nextLong());
		}
	}
	
	private void setBlocksInArray(Block[][] array, int height, BlockPos pos, World worldIn, Random rand, int rotateNum) {
		for (int x = 0; x < rotateNum; x++) {
			array = rotateMatrix(array);
		}
		
		for (int x = 0; x < array.length; x++) {
			for (int z = 0; z < array[0].length; z++) {
				BlockPos thisPos = pos.add(x, height, z);
				worldIn.setBlockState(thisPos, array[x][z].getDefaultState());
				
				if (array[x][z] == chest) {
					fillChest(worldIn, rand, thisPos);
				}
			}
		}
	}
	
	private Block[][] rotateMatrix(Block[][] matrix) {
	    /* W and H are already swapped */
	    int w = matrix.length;
	    int h = matrix[0].length;   
	    Block[][] ret = new Block[h][w];
	    for (int i = 0; i < h; ++i) {
	        for (int j = 0; j < w; ++j) {
	            ret[i][j] = matrix[j][h - i - 1];
	        }
	    }
	    return ret;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World worldIn, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		//check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(worldIn, pos) || 
			!locationIsValidSpawn(worldIn, pos.add(8, 0, 0)) || 
			!locationIsValidSpawn(worldIn, pos.add(8, 0, 8)) || 
			!locationIsValidSpawn(worldIn, pos.add(0, 0, 8))) {
			return false;
		}
		
		System.out.println("Generating nether lair at coords " + pos.getX() + " " + pos.getY() + " " + pos.getZ());
		
		int rotateNum = (int) Math.floor(rand.nextDouble() * 4);
		
		setBlocksInArray(layer0, 0, pos, worldIn, rand, rotateNum);
		setBlocksInArray(layer1, 1, pos, worldIn, rand, rotateNum);
		setBlocksInArray(layer2, 2, pos, worldIn, rand, rotateNum);
		setBlocksInArray(layer3, 3, pos, worldIn, rand, rotateNum);
		setBlocksInArray(layer4, 4, pos, worldIn, rand, rotateNum);
		setBlocksInArray(layer5, 5, pos, worldIn, rand, rotateNum);
		setBlocksInArray(layer6, 6, pos, worldIn, rand, rotateNum);
		setBlocksInArray(layer7, 7, pos, worldIn, rand, rotateNum);
		
		return true;
	}
}

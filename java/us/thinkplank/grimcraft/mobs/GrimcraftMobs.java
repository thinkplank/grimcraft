package us.thinkplank.grimcraft.mobs;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import us.thinkplank.grimcraft.Grimcraft;

public class GrimcraftMobs {
	public static void register() {
		int id = 1;
		
		EntityRegistry.registerModEntity(EntityBoar.class, "boar", id++, Grimcraft.instance, 64, 3, true, 0xA26C60, 0x8C3519);
		EntityRegistry.addSpawn(EntityBoar.class, 100, 3, 5, EnumCreatureType.CREATURE, Biomes.HELL);
		
		EntityRegistry.registerModEntity(EntityPhoenix.class, "phoenix", id++, Grimcraft.instance, 64, 3, true, 0x383838, 0x9e2d08);
		EntityRegistry.addSpawn(EntityPhoenix.class, 100, 3, 5, EnumCreatureType.CREATURE, Biomes.HELL);
	}
	
	public static void registerModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, RenderBoar.factory);
		RenderingRegistry.registerEntityRenderingHandler(EntityPhoenix.class, RenderPhoenix.factory);
	}
}

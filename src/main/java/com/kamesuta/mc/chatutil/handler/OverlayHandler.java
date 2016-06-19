package com.kamesuta.mc.chatutil.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class OverlayHandler {
	private static final FMLControlledNamespacedRegistry<Block> BLOCK_REGISTRY = GameData.getBlockRegistry();
	private final Minecraft minecraft = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onText(final RenderGameOverlayEvent event) {
	}
}

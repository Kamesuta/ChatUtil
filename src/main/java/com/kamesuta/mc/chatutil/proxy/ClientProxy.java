package com.kamesuta.mc.chatutil.proxy;

import java.io.File;
import java.io.IOException;

import com.kamesuta.mc.chatutil.Reference;
import com.kamesuta.mc.chatutil.handler.ClientTickHandler;
import com.kamesuta.mc.chatutil.handler.ConfigurationHandler;
import com.kamesuta.mc.chatutil.handler.InputHandler;
import com.kamesuta.mc.chatutil.handler.OverlayHandler;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
	public static final Minecraft MC = FMLClientHandler.instance().getClient();

	@Override
	public void preInit(final FMLPreInitializationEvent event) {
		super.preInit(event);

		for (final KeyBinding keyBinding : InputHandler.KEY_BINDINGS) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}

	@Override
	public void init(final FMLInitializationEvent event) {
		super.init(event);

		FMLCommonHandler.instance().bus().register(InputHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(ClientTickHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(ConfigurationHandler.INSTANCE);

		MinecraftForge.EVENT_BUS.register(new OverlayHandler());
	}

	@Override
	public File getDataDirectory() {
		final File file = MC.mcDataDir;
		try {
			return file.getCanonicalFile();
		} catch (final IOException e) {
			Reference.logger.debug("Could not canonize path!", e);
		}
		return file;
	}
}
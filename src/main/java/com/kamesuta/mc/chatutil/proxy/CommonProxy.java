package com.kamesuta.mc.chatutil.proxy;

import java.io.File;
import java.io.IOException;

import com.kamesuta.mc.chatutil.Reference;
import com.kamesuta.mc.chatutil.handler.ConfigurationHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.server.MinecraftServer;

public abstract class CommonProxy {
	public static MinecraftServer MCSERVER = FMLCommonHandler.instance().getMinecraftServerInstance();

	public void preInit(final FMLPreInitializationEvent event) {
		Reference.logger = event.getModLog();
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
	}

	public void init(final FMLInitializationEvent event) {
	}

	public void postInit(final FMLPostInitializationEvent event) {
	}

	public void serverStarting(final FMLServerStartingEvent event) {
	}

	public abstract File getDataDirectory();

	public File getDirectory(final String directory) {
		final File dataDirectory = getDataDirectory();
		final File subDirectory = new File(dataDirectory, directory);

		if (!subDirectory.exists()) {
			if (!subDirectory.mkdirs()) {
				Reference.logger.error("Could not create directory [{}]!", subDirectory.getAbsolutePath());
			}
		}

		try {
			return subDirectory.getCanonicalFile();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return subDirectory;
	}
}

package com.kamesuta.mc.chatutil.handler;

import java.io.File;

import com.kamesuta.mc.chatutil.Reference;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigurationHandler {
	public static final ConfigurationHandler INSTANCE = new ConfigurationHandler();

	public static final String VERSION = "1";

	public static Configuration configuration;

	public static final boolean MCUTILNOTICE_DEFAULT = true;
	public static boolean mcutilnotice = MCUTILNOTICE_DEFAULT;
	public static Property propMcUtilNotice = null;

	public static void init(final File configFile) {
		if (configuration == null) {
			configuration = new Configuration(configFile, VERSION);
			loadConfiguration();
		}
	}

	public static void loadConfiguration() {
		propMcUtilNotice = configuration.get("mcutilmod.enablenotice", "mcutilmod.notice", MCUTILNOTICE_DEFAULT, "Enable notice balloon.");
		mcutilnotice = propMcUtilNotice.getBoolean();

		if (configuration.hasChanged()) {
			configuration.save();
		}
	}

	private ConfigurationHandler() {
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(final ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MODID)) {
			loadConfiguration();
		}
	}
}
package com.kamesuta.mc.chatutil.proxy;

import java.io.File;
import java.io.IOException;

import com.kamesuta.mc.chatutil.Reference;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class ServerProxy extends CommonProxy {
	@Override
	public void serverStarting(final FMLServerStartingEvent event) {
	}

	@Override
	public File getDataDirectory() {
		final File file = MCSERVER.getFile(".");
		try {
			return file.getCanonicalFile();
		} catch (final IOException e) {
			Reference.logger.info("Could not canonize path!", e);
		}
		return file;
	}
}

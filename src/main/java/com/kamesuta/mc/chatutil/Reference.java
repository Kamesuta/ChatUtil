package com.kamesuta.mc.chatutil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reference {
	public static final String MODID = "ChatUtil";
	public static final String NAME = "ChatUtil";
	public static final String VERSION = "${version}";
	public static final String FORGE = "${forgeversion}";
	public static final String MINECRAFT = "${mcversion}";
	public static final String PROXY_SERVER = "com.kamesuta.mc.chatutil.proxy.ServerProxy";
	public static final String PROXY_CLIENT = "com.kamesuta.mc.chatutil.proxy.ClientProxy";

	public static Logger logger = LogManager.getLogger(Reference.MODID);
}

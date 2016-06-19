package com.kamesuta.mc.chatutil.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.settings.KeyBinding;

public class InputHandler {
	public static final InputHandler INSTANCE = new InputHandler();

	//	private final Action screenshotaction = new Action();

	//	private static final KeyBinding KEY_BINDING_SCREENSHOT = new KeyBinding("mcutilmod.key.screenshot", Keyboard.KEY_O,
	//			"mcutil.key.category");

	public static final KeyBinding[] KEY_BINDINGS = new KeyBinding[] { /*KEY_BINDING_SCREENSHOT*/ };

	private InputHandler() {
	}

	@SubscribeEvent
	public void onKeyInput(final InputEvent event) {
		//		if (KEY_BINDING_SCREENSHOT.isPressed()) {
		//			this.screenshotaction.screenShot();
		//		}
	}
}

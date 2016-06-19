package com.kamesuta.mc.chatutil.handler;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

public class ClientTickHandler {
	public static final ClientTickHandler INSTANCE = new ClientTickHandler();

	public long afktime = 10 * 60 * 1000;

	private final Minecraft minecraft = Minecraft.getMinecraft();
	private long lastctrled;
	private boolean isAfk;

	private ClientTickHandler() {
	}

	@SubscribeEvent
	public void onClientTick(final TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.START) {
			this.minecraft.mcProfiler.startSection("mcutil");
			if (this.minecraft.thePlayer != null) {
				final long now = System.currentTimeMillis();

				final boolean key = Keyboard.getNumKeyboardEvents() > 0;
				final boolean mouse = Mouse.getEventButtonState();

				if (this.lastctrled < 0) this.lastctrled = now;
				if (key || mouse) {
					if (this.isAfk == true) {
						setAfk(false);
					}
					this.lastctrled = now;
				} else {
					if (this.isAfk == false && (now - this.lastctrled > this.afktime)) {
						setAfk(true);
					}
				}

				if (this.minecraft.thePlayer.posY < -15) {
					spawn();
				}
			} else {
				this.lastctrled = -1;
				this.isAfk = false;
			}
			this.minecraft.mcProfiler.endSection();
		}
	}

	public void setAfk(final boolean isAfk) {
		this.isAfk = isAfk;
		this.minecraft.thePlayer.sendChatMessage(isAfk ? "/me is now AFK." : "/me is no longer AFK.");
	}

	private long spawnspan;
	public void spawn() {
		final long now = System.currentTimeMillis();
		if (now - this.spawnspan > 2000) {
			this.minecraft.thePlayer.sendChatMessage("/spawn");
			this.spawnspan = now;
		}
	}
}
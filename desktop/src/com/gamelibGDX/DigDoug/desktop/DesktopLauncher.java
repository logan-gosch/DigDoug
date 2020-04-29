package com.gamelibGDX.DigDoug.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gamelibGDX.DigDoug.DigDoug;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 600;
		config.height = 750;
		new LwjglApplication(new DigDoug(), config);
	}
}

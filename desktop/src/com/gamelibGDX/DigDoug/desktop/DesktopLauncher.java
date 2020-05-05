package com.gamelibGDX.DigDoug.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.ApplicationListener;
import com.gamelibGDX.DigDoug.DigDoug;
import com.badlogic.gdx.Game;

import javax.swing.*;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DigDoug(), config);
	}
}

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
		int selection;
		boolean isYes;
		boolean isNo;

		selection = JOptionPane.showConfirmDialog(null, "Would you like to play DigDug?");
		isYes = (selection == JOptionPane.YES_OPTION);
		isNo = (selection == JOptionPane.NO_OPTION);
		if(isYes == true){
			new LwjglApplication((ApplicationListener) new DigDoug(), config);
		}
		else if(isNo){
			JOptionPane.showConfirmDialog(null, "Coward");
		}
	}
}

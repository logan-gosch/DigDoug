package com.gamelibGDX.DigDoug.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.ApplicationListener;
import com.gamelibGDX.DigDoug.DigDoug;

import javax.swing.*;

public class DesktopLauncher {
	public static void main (String[] args) {
		ImageIcon logo = new ImageIcon("logo.png");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		int selection;
		Object[] options = {"Play", "Leaderboard","Quit"};


		selection = JOptionPane.showOptionDialog(null, "Would you like to play DigDoug?", "Dig Doug", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, logo, options, options[2]);
		if(selection == JOptionPane.YES_OPTION){
			new LwjglApplication((ApplicationListener) new DigDoug(), config);
		}
		else if(selection != JOptionPane.YES_OPTION && selection != JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Coward");
		}
		else if(selection == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "In Progress, leave me alone.");
		}
	}
}

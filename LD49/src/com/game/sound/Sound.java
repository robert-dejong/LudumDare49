package com.game.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import com.game.Constants;

public class Sound {
	
	public static Sound hurt = new Sound("hurt.wav");
	public static Sound item = new Sound("item.wav");
	public static Sound death = new Sound("death.wav");
	
	private AudioClip clip;
	
	public Sound(String file) {
		try {
			this.clip = Applet.newAudioClip(new File(Constants.DATA_PATH + "/sounds/" + file).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		clip.play();
	}

}

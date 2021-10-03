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
		String path = Constants.DATA_PATH + "/sounds/" + file;
		try {
			this.clip = Applet.newAudioClip(new File(path).toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.clip = Applet.newAudioClip(ImageLoader.class.getClass().getResource(path));
	}
	
	public void play() {
		clip.play();
	}

}

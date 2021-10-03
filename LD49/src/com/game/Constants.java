package com.game;

public class Constants {
	
	public final static String TITLE = "Drunkenness Simulator";
	public final static String DATA_PATH = "./data";
	
	public final static int RENDER_SCALE = 4;
	
	public final static int TILE_SIZE = 16;
	
	public final static int SCREEN_WIDTH = 800;
	public final static int SCREEN_HEIGHT = 640;
	
	public final static float DOUBLE_VISION_TRANSPARENCY = 0.5f;
	
	public final static int MIN_Y_POSITION = 91;
	public final static int MAX_Y_POSITION = SCREEN_HEIGHT / RENDER_SCALE;
	
	public final static int PLAYER_MAX_HEALTH = 15;
	
	public final static int SCORE_INCREASE_RATE = 3;
	
	public final static int PICKUP_BEER_SCORE_INCREASE = 100;
	public final static int PICKUP_NEEDLE_SCORE_INCREASE = 250;
}

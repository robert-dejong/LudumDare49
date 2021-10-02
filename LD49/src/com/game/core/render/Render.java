package com.game.core.render;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.entity.player.Player;
import com.game.entity.player.PlayerStats;
import com.game.world.WorldManager;

public class Render extends Canvas {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Player player;
	
	@Inject
	private PlayerStats playerStats;
	
	@Inject
	private WorldManager worldManager;
	
	private BufferedImage bufferedImage;
	private int scrollX;
	private int scrollY;
	
	private int doubleVisionOffset = 1;
	
	public void init() {
		this.bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
	}
	
	public void render(BufferedImage image, int x, int y) {
		int renderX = getAbsoluteX(x);
		int renderY = getAbsoluteY(y);
		renderAbsolute(image, renderX, renderY);
	}
	
	public void renderPlayer(BufferedImage image) {
		int x = this.scrollX - (image.getWidth() / 2);
		int y = this.scrollY - (image.getHeight() / 2);
		renderAbsolute(image, x, y);
	}
	
	public void renderAbsolute(BufferedImage image, int x, int y) {
		Graphics2D g = (Graphics2D) this.bufferedImage.getGraphics();
		
		if(shouldRender(x, y, image.getWidth(), image.getHeight())) {
			g.drawImage(image, x, y, null);
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		if(screenSizeChanged()) {
			bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		}
		
		this.scrollX = getScrollX();
		this.scrollY = getScrollY();
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D) bufferedImage.getGraphics();
		g.scale(Constants.RENDER_SCALE, Constants.RENDER_SCALE);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
		
		worldManager.render(this);
		player.render(this);
		
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Constants.DOUBLE_VISION_TRANSPARENCY);
		g.setComposite(ac);
		g.drawImage(bufferedImage, doubleVisionOffset, doubleVisionOffset, null);
		
		g.drawImage(bufferedImage, 0, 0, null);
		
		ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
		g.setComposite(ac);
		
		// Debug
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 5));
		g.drawString(player.getX() + ", " + player.getY(), 5, getHeight() - 5);
		
		// Player stats
		g.setFont(new Font("Arial", Font.BOLD, 4));
		g.drawString("Score:   " + playerStats.getScore(), 5, 7);
		g.drawString("Health:", 5, 14);
		
		// Draw health bar
		int innerSize = 28;
		int healthWidthToFill = (int) ((double)innerSize / Constants.PLAYER_MAX_HEALTH * playerStats.getHealth());
		g.drawRect(22, 10, innerSize + 2, 5);
		g.setColor(Color.RED);
		g.fillRect(23, 11, innerSize, 3);
		
		g.setColor(Color.GREEN);
		g.fillRect(23, 11, healthWidthToFill, 3);
		
		if(playerStats.getHealth() <= 0) {
			String deathReason = playerStats.getReasonLastDamage().getReason();
			int renderX = playerStats.getReasonLastDamage().getRenderX();
			g.setFont(new Font("Arial", Font.BOLD, 5));
			g.setColor(Color.WHITE);
			g.drawString(deathReason, renderX, 73);
		}
		
		g.dispose();
		bs.show();
	}
	
	private boolean shouldRender(int absoluteX, int absoluteY, int renderWidth, int renderHeight) {
		int screenWidth = getWidth();
		int screenHeight = getHeight();
		
		if(absoluteX > screenWidth)
			return false;
		
		if(absoluteY > screenHeight)
			return false;
		
		if(absoluteX + renderWidth < 0)
			return false;
		
		if(absoluteY + renderHeight < 0)
			return false;
		
		return true;
	}
	
	private int getScrollX() {
		// TODO: Max width?
		//int maxWidth = worldManager.getTiles().length * Constants.TILE_SIZE;
		int scrollX = getWidth() / 2;
		
		if(player.getX() < scrollX) {
			return scrollX - (scrollX - (int)player.getX());
		}
		
		//if(player.getX() > maxWidth - scrollX) {
		//	return scrollX - ((maxWidth - scrollX) - (int)player.getX());
		//}
		
		return scrollX;
	}
	
	private int getScrollY() {
		// TODO: Max height?
		int maxHeight = Constants.SCREEN_HEIGHT / Constants.RENDER_SCALE;
		int scrollY = getHeight() / 2;
		
		if(player.getY() < scrollY) {
			return scrollY - (scrollY - (int)player.getY());
		}
		
		if(player.getY() > maxHeight - scrollY) {
			return scrollY - ((maxHeight - scrollY) - (int)player.getY());
		}
		
		return scrollY;
	}
	
	private boolean screenSizeChanged() {
		return (getWidth() != bufferedImage.getWidth() || getHeight() != bufferedImage.getHeight());
	}
	
	private int getAbsoluteX(int x) {
		return x + (int)-player.getX() + scrollX;
	}
	
	private int getAbsoluteY(int y) {
		return y + (int)-player.getY() + scrollY;
	}
	
	@Override
	public int getWidth() {
		return super.getWidth() / Constants.RENDER_SCALE;
	}
	
	@Override
	public int getHeight() {
		return super.getHeight() / Constants.RENDER_SCALE;
	}

	public int getDoubleVisionOffset() {
		return doubleVisionOffset;
	}

	public void setDoubleVisionOffset(int doubleVisionOffset) {
		this.doubleVisionOffset = doubleVisionOffset;
	}

}

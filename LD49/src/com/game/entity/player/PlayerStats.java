package com.game.entity.player;

import com.dependencyinjection.Inject;
import com.game.Constants;
import com.game.sound.Sound;

public class PlayerStats {
	
	@Inject
	private Player player;
	
	private int score;
	private int health;
	private DamageReason reasonLastDamage;
	private int distance;
	
	public PlayerStats() { 
		init();
	}
	
	public void init() {
		this.score = 0;
		this.distance = 0;
		this.health = Constants.PLAYER_MAX_HEALTH;
		this.setReasonLastDamage(DamageReason.UNKNOWN);
	}
	
	public void addScore(int amount) {
		this.score += amount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void removeHealth(int amount, DamageReason damageReason) {
		this.reasonLastDamage = damageReason;
		this.health -= amount;
		
		player.setHurt();
		
		if(this.health > 0)
			Sound.hurt.play();
		else
			Sound.death.play();
	}
	
	public void addHealth(int amount) {
		this.health += amount;
		
		if(this.health > Constants.PLAYER_MAX_HEALTH) {
			this.health = Constants.PLAYER_MAX_HEALTH;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public DamageReason getReasonLastDamage() {
		return reasonLastDamage;
	}

	public void setReasonLastDamage(DamageReason reasonLastDamage) {
		this.reasonLastDamage = reasonLastDamage;
	}
	
	public void addDistance(int amount) {
		this.distance += amount;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}

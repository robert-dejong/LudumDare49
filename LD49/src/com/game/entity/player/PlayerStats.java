package com.game.entity.player;

import com.game.Constants;

public class PlayerStats {
	
	private int score;
	private int health;
	private DamageReason reasonLastDamage;
	
	public PlayerStats() { 
		init();
	}
	
	public void init() {
		this.score = 0;
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
	}
	
	public void addHealth(int amount) {
		this.health += amount;
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
	
}

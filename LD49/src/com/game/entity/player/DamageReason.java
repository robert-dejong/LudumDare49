package com.game.entity.player;

public enum DamageReason {
	UNKNOWN("You died for a reason the game can't comprehend", 40),
	HIT_BY_CAR("You got crushed by a car", 65);

    private String reason;
    private int renderX;
    
    DamageReason(String reason, int renderX) {
        this.reason = reason;
        this.renderX = renderX;
    }
 
    public String getReason() {
        return reason;
    }
    
    public int getRenderX() {
    	return renderX;
    }
}

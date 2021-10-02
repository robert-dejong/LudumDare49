package com.game.task;

public abstract class Task {
	
	private String name;
	private int initialTicks;
	private int ticks;
	private boolean loop;
	
	public abstract void execute();
	
	public Task(int ticks) {
		this.initialTicks = ticks;
		this.ticks = ticks;
	}
	
	public Task(int ticks, boolean loop) {
		this.initialTicks = ticks;
		this.ticks = ticks;
		this.loop = loop;
	}
	
	public Task(String name, int ticks, boolean loop) {
		this.name = name;
		this.initialTicks = ticks;
		this.ticks = ticks;
		this.loop = loop;
	}
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getTicks() {
		return ticks;
	}

	protected void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
	protected void tick() {
		this.ticks--;
	}
	
	protected boolean isLoop() {
		return loop;
	}

	protected void setLoop(boolean loop) {
		this.loop = loop;
	}

	protected int getInitialTicks() {
		return initialTicks;
	}

}

package com.nightmare.Run.Templates;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Entity_Temp extends Entity {

	public Entity_Temp(float x, float y) {
		super(x, y);
	}
	
//	@Override
//	public void init(GameContainer container, StateBasedGame sbg)
//			throws SlickException {
//		super.init(container, sbg);
//	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);

	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}

//	 new java.util.Timer().schedule(new java.util.TimerTask() {
//	 @Override
//	 public void run() {
//	FatZombie fz = new FatZombie((float) java.lang.Math.random() * 1000, (float) java.lang.Math.random() * 800);
//	add(fz);
//	 }
//	 }, 360);
	
//	public void collisionResponse(Entity other) {
//		if (other.isType(Class.type)) {
//			this.destroy();
//		}
//	}

}

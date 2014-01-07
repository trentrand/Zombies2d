package com.nightmare.Run.Bullets;
//Done
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Zombies.FatZombie;

public class SniperBullet extends Entity {

	public static final String SNBULLET = "snbullet";

	int speed = 15;
	int hitCount = 0;
	private double moveX;

	private double moveY;

	public SniperBullet(float x, float y, int angle) {
		super(x, y);
		this.angle = angle;
		centered = true;
		setGraphic(Resources.ss.getSprite(5, 1));
		setHitBox(14, 14, 3, 3);
		this.name = "bullet";
		this.depth = 50;
		addType(SNBULLET, COLLIDABLE);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		moveX = Math.sin(Math.toRadians(angle));
		moveY = Math.cos(Math.toRadians(angle));
		this.x += moveX * speed;
		this.y -= moveY * speed;
	}

	public void collisionResponse(Entity other) {
		if (other.isType(FatZombie.ENEMY)) {
			hitCount++;
			if (hitCount >= 5) {
			this.destroy();
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);

	}

	public void leftWorldBoundaries() {
		// the player unfortunately left the screen - so we retry
		world.remove(this);
	}

}

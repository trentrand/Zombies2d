package com.nightmare.Run.Bullets;
//done
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Zombies.FatZombie;

public class GeneralBullet extends Entity {

	public static final String BULLET = "bullet";

	int speed = 5;

	private double moveX;

	private double moveY;

	public GeneralBullet(float x, float y, int angle) {
		super(x, y);
		this.angle = angle;
		centered = true;
		setGraphic(Resources.ss.getSprite(0, 1));
		setHitBox(14, 14, 3, 3);
		this.name = "bullet";
		this.depth = 50;
		addType(BULLET, COLLIDABLE);
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
			this.destroy();
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

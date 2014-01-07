package com.nightmare.Run.Bullets;
//Done
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Zombies.FatZombie;

public class FlameBullet extends Entity {

	public static final String FLBULLET = "flbullet";

	int speed = 5;

	private double moveX;

	private double moveY;

	public FlameBullet(float x, float y, int angle) {
		super(x, y);
		this.angle = angle;
		centered = true;
		setGraphic(Resources.ss.getSprite(6, 1));
		setHitBox(14, 14, 3, 3);
		this.name = "bullet";
		this.depth = 50;
		addType(FLBULLET, COLLIDABLE);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		moveX = Math.sin(Math.toRadians(angle));
		moveY = Math.cos(Math.toRadians(angle));
		this.x += moveX * speed;
		this.y -= moveY * speed;
		Entity player = this.world.find("character");
		float distance = getDistance(player);
		if (distance > 100) {
			this.destroy();
		}
	}

	
	public void burn(float x, float y, int initAngle) {
		ExplosionParticles a = new ExplosionParticles(x, y, angle + 30);
		this.world.add(a);
		ExplosionParticles b = new ExplosionParticles(x, y, angle + 15);
		this.world.add(b);
		ExplosionParticles c = new ExplosionParticles(x, y, angle - 15);
		this.world.add(c);
		ExplosionParticles d = new ExplosionParticles(x, y, angle  - 30);
		this.world.add(d);
//		ExplosionParticles e = new ExplosionParticles(x, y, initAngle + 100);
//		this.world.add(e);
//		ExplosionParticles f = new ExplosionParticles(x, y, initAngle + 120);
//		this.world.add(f);
//		ExplosionParticles g = new ExplosionParticles(x, y, initAngle + 140);
//		this.world.add(g);
//		ExplosionParticles h = new ExplosionParticles(x, y, initAngle + 160);
//		this.world.add(h);
//		ExplosionParticles i = new ExplosionParticles(x, y, initAngle + 180);
//		this.world.add(i);
//		ExplosionParticles j = new ExplosionParticles(x, y, initAngle + 200);
//		this.world.add(j);
//		ExplosionParticles k = new ExplosionParticles(x, y, initAngle + 220);
//		this.world.add(k);
//		ExplosionParticles l = new ExplosionParticles(x, y, initAngle + 240);
//		this.world.add(l);
//		ExplosionParticles m = new ExplosionParticles(x, y, initAngle + 260);
//		this.world.add(m);
//		ExplosionParticles n = new ExplosionParticles(x, y, initAngle + 280);
//		this.world.add(n);
//		ExplosionParticles o = new ExplosionParticles(x, y, initAngle + 300);
//		this.world.add(o);
//		ExplosionParticles p = new ExplosionParticles(x, y, initAngle + 320);
//		this.world.add(p);
//		ExplosionParticles q = new ExplosionParticles(x, y, initAngle + 340);
//		this.world.add(q);
//		ExplosionParticles r = new ExplosionParticles(x, y, initAngle + 360);
//		this.world.add(r);
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

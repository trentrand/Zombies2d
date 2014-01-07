package com.nightmare.Run.Bullets;
// Done **Stop multistick from keeping entity alive**
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Zombies.FatZombie;

public class Grenade_Sticky extends Entity {

	public static final String SBULLET = "sbullet";

	int speed = 5;
	boolean move = true;
	private double moveX;
	private double moveY;

	private int spawnFrame = 0;
	private int spawnTimer = 0;
	 private int spawnInterval = 125;
	 private boolean exploded = false;
	public Grenade_Sticky(float x, float y, int angle) {
		super(x, y);
		this.angle = angle;
		centered = true;
		setGraphic(Resources.ss.getSprite(8, 1));
		setHitBox(14, 14, 3, 3);
		this.name = "bullet";
		this.depth = 50;
		addType(SBULLET, COLLIDABLE);

	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		if (move) {
			moveX = Math.sin(Math.toRadians(angle));
			moveY = Math.cos(Math.toRadians(angle));
			this.x += moveX * speed;
			this.y -= moveY * speed;
		}

		Entity fatzombie = collide(FatZombie.ENEMY, x, y);
		if (fatzombie != null) {
			x = fatzombie.x;
			y = fatzombie.y;
		}

	}

	public void collisionResponse(Entity other) {
		if (other.isType(FatZombie.ENEMY)) {
			spawnTimer -= 1;
			while (spawnTimer <= 0) {
				spawnFrame++;
				spawnTimer += spawnInterval;
				if (spawnFrame > 1) {
					move = false;
					if (!exploded) {
					explode(x, y, angle);
					this.destroy();
					exploded = true;
					}
				}
			}
			
		}
	}

	public void explode(float x, float y, int initAngle) {
		ExplosionParticles a = new ExplosionParticles(x, y, initAngle + 20);
		this.world.add(a);
		ExplosionParticles b = new ExplosionParticles(x, y, initAngle + 40);
		this.world.add(b);
		ExplosionParticles c = new ExplosionParticles(x, y, initAngle + 60);
		this.world.add(c);
		ExplosionParticles d = new ExplosionParticles(x, y, initAngle + 80);
		this.world.add(d);
		ExplosionParticles e = new ExplosionParticles(x, y, initAngle + 100);
		this.world.add(e);
		ExplosionParticles f = new ExplosionParticles(x, y, initAngle + 120);
		this.world.add(f);
		ExplosionParticles g = new ExplosionParticles(x, y, initAngle + 140);
		this.world.add(g);
		ExplosionParticles h = new ExplosionParticles(x, y, initAngle + 160);
		this.world.add(h);
		ExplosionParticles i = new ExplosionParticles(x, y, initAngle + 180);
		this.world.add(i);
		ExplosionParticles j = new ExplosionParticles(x, y, initAngle + 200);
		this.world.add(j);
		ExplosionParticles k = new ExplosionParticles(x, y, initAngle + 220);
		this.world.add(k);
		ExplosionParticles l = new ExplosionParticles(x, y, initAngle + 240);
		this.world.add(l);
		ExplosionParticles m = new ExplosionParticles(x, y, initAngle + 260);
		this.world.add(m);
		ExplosionParticles n = new ExplosionParticles(x, y, initAngle + 280);
		this.world.add(n);
		ExplosionParticles o = new ExplosionParticles(x, y, initAngle + 300);
		this.world.add(o);
		ExplosionParticles p = new ExplosionParticles(x, y, initAngle + 320);
		this.world.add(p);
		ExplosionParticles q = new ExplosionParticles(x, y, initAngle + 340);
		this.world.add(q);
		ExplosionParticles r = new ExplosionParticles(x, y, initAngle + 360);
		this.world.add(r);
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

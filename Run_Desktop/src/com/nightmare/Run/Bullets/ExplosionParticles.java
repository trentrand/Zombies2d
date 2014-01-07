package com.nightmare.Run.Bullets;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.nightmare.Run.Resources;

public class ExplosionParticles extends Entity {

    public static final String EXBULLET = "exbullet";

    public float size;
    int speed = 5;
    private double moveX;
    private double moveY;
    float startX, startY;

    // public boolean killed = false;

    public ExplosionParticles(float x, float y, int angle) {
        super(x, y);
        startX = x;
        startY = y;
        this.angle = angle;
        addType(EXBULLET, COLLIDABLE);
        setGraphic(Resources.ss.getSprite(6, 1));

        // if (!killed ) {
        // new java.util.Timer().schedule(new java.util.TimerTask() {
        // @Override
        // public void run() {
        // killed = true;
        // ExplosionParticles.this.world.remove(ExplosionParticles.this);
        // }
        // }, 200);
        // }
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        super.update(container, delta);
        moveX = Math.sin(Math.toRadians(angle));
        moveY = Math.cos(Math.toRadians(angle));
        this.x += moveX * speed;
        this.y -= moveY * speed;
        size += 0.5f;
        Vector2f start = new Vector2f(startX, startY);
        if (getDistance(start) > 75) {
            world.remove(ExplosionParticles.this);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics gr) throws SlickException {
        super.render(gc, gr);
        // gr.fillRect(x, y, size, size);
    }
}

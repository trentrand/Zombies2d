package com.nightmare.Run.Templates;

import it.marteEngine.entity.Entity;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.Run.Amt;
import com.nightmare.Run.Character;
import com.nightmare.Run.Resources;
import com.nightmare.Run.Settings;
import com.nightmare.Run.cs;
import com.nightmare.Run.Bullets.ExplosionParticles;
import com.nightmare.Run.Bullets.FlameBullet;
import com.nightmare.Run.Bullets.GeneralBullet;
import com.nightmare.Run.Bullets.Grenade_Sticky;
import com.nightmare.Run.Bullets.LaserBullet;
import com.nightmare.Run.Bullets.MagnumBullet;
import com.nightmare.Run.Bullets.RpgBullet;
import com.nightmare.Run.Bullets.SniperBullet;
import com.nightmare.Run.Drops.DropFlameThrower;
import com.nightmare.Run.Drops.DropGrenadeLauncher;
import com.nightmare.Run.Drops.DropLaserBeam;
import com.nightmare.Run.Drops.DropMachineGun;
import com.nightmare.Run.Drops.DropMagnum;
import com.nightmare.Run.Drops.DropRpg;
import com.nightmare.Run.Drops.DropSniper;
import com.nightmare.Run.Drops.DropStickyLauncher;

public class ZombieTemplate extends Entity {

    public Integer health = 500;
    public Integer maxHealth = 500;
    // public int health = 500;
    // public int maxHealth = 500;
    public static String ENEMY = "enemy";
    public float speed = 0.3f;
    private double moveX;
    private double moveY;
    public int scoreValue;
    public float level = 1;

    public ZombieTemplate(float x, float y) {
        super(x, y);
        setGraphic(Resources.ss.getSprite(0, 0));
        setHitBox(0, 0, 32, 32);
        this.name = "Zombie";
        centered = true;
        addType(ENEMY);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        super.update(container, delta);
        if (collide(COLLIDABLE, x, y) != null) {
            if (collide(GeneralBullet.BULLET, x, y) != null) {
                this.health -= 100;
            } else if (collide(LaserBullet.LBULLET, x, y) != null) {
                this.health -= 50;
            } else if (collide(RpgBullet.RPGBULLET, x, y) != null) {
                this.health -= 300;
            } else if (collide(MagnumBullet.MGBULLET, x, y) != null) {
                this.health -= 150;
            } else if (collide(SniperBullet.SNBULLET, x, y) != null) {
                this.health -= 150;
            } else if (collide(FlameBullet.FLBULLET, x, y) != null) {
                this.health -= 25;

                // Is Damage delt by a grenade contact? NO!
                // } else if (collide(GrenadeLauncherBullet.BULLET, x, y) !=
                // null) {
                // this.health -= 200;
                // Sticky Bullet doesnt damage, the particles do!
            } else if (collide(Grenade_Sticky.SBULLET, x, y) != null) {
                this.health -= 0;
            } else if (collide(ExplosionParticles.EXBULLET, x, y) != null) {
                this.health -= 75;
            }
            if (collide(PLAYER, x, y) != null) {
                Character.health -= 100;
            }
        }
        // p1 = new Point2D.Float(x, y);
        // p2 = new Point2D.Float(Character.myX, Character.myY);
        angle = (int) calculateAngle(this.x, this.y, Character.myX,
                Character.myY);

        moveX = Math.sin(Math.toRadians(angle));
        moveY = Math.cos(Math.toRadians(angle));
        this.x += moveX * speed;
        this.y -= moveY * speed;

        if (health <= 0) {
            if (Amt.game.getCurrentStateID() == 3) {
                cs.zombiesLeft--;
                Amt.cash += (level * 10) / 5;
                this.world.remove(this);
            } else {
                Amt.score += scoreValue;
                this.world.remove(this);
                Random r = new Random();
                int itemSpawn = r.nextInt(1001);
                if (itemSpawn < 25 * level) {
                    DropMachineGun dmg = new DropMachineGun(x, y);
                    this.world.add(dmg);
                } else if (itemSpawn > 25 * level && itemSpawn < 40 * level) {
                    DropLaserBeam dlb = new DropLaserBeam(x, y);
                    this.world.add(dlb);
                } else if (itemSpawn > 40 * level && itemSpawn < 55 * level) {
                    DropRpg drl = new DropRpg(x, y);
                    this.world.add(drl);
                } else if (itemSpawn > 55 * level && itemSpawn < 75 * level) {
                    DropMagnum dm = new DropMagnum(x, y);
                    this.world.add(dm);
                } else if (itemSpawn > 75 * level && itemSpawn < 90 * level) {
                    DropSniper dsp = new DropSniper(x, y);
                    this.world.add(dsp);
                } else if (itemSpawn > 90 * level && itemSpawn < 110 * level) {
                    DropFlameThrower dft = new DropFlameThrower(x, y);
                    this.world.add(dft);
                } else if (itemSpawn > 110 * level && itemSpawn < 125 * level) {
                    DropGrenadeLauncher dgl = new DropGrenadeLauncher(x, y);
                    this.world.add(dgl);
                } else if (itemSpawn > 125 * level && itemSpawn < 140 * level) {
                    DropStickyLauncher dsl = new DropStickyLauncher(x, y);
                    this.world.add(dsl);
                }
            }
        }

        // sc.print(health);
    }

    @Override
    public void render(GameContainer gc, Graphics gr) throws SlickException {
        super.render(gc, gr);
        // TODO descide if Float makes impact, if not change back and renable
        // below
        if (Settings.showEnemyHealth == true) {
            float healthScale = (health.floatValue() / maxHealth.floatValue());
            gr.setColor(Color.red);
            gr.fillRect(x - 16, y - 25, 32f, 3);
            gr.setColor(Color.green);
            gr.fillRect(x - 16, y - 25, healthScale * 32f, 3);
        }
    }
}

package com.nightmare.Run.Templates;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.nightmare.Run.Amt;
import com.nightmare.Run.Character;
import com.nightmare.Run.Weapon;

public class BulletDropTemplate extends Entity {

	public int id;
	public int amtAmmo;
	public static final String DROP = "drop";
	
	private int spawnFrame = 0;
    private int spawnTimer = 0;
    private int spawnInterval = 10000;

	public BulletDropTemplate(float x, float y) {
		super(x, y);
		setHitBox(0, 0, 32, 32);
		this.depth = 10000;
		addType(DROP);
		this.setCentered(true);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		if (collide(Character.PLAYER, x, y) != null) {
			if (id != Weapon.primaryWeapon) {
				Weapon.lastWeapon = Weapon.primaryWeapon;
				Weapon.primaryWeapon = id;
				Amt.ammo1 = amtAmmo;
				this.world.remove(this);
			} else {
				Amt.ammo1 += amtAmmo;
				this.world.remove(this);
			}
		}
		
		 spawnTimer -= delta;
	        while (spawnTimer <= 0) {
	            spawnFrame++;
	            spawnTimer += spawnInterval;
	            if (spawnFrame > 1) {
	                destroy();
	            }
	        }
		
		this.angle += delta / 5;
	}
}

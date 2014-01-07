package com.nightmare.Run.Zombies;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.ZombieTemplate;

public class TankZombie extends ZombieTemplate {

	public TankZombie(float x, float y) {
		super(x, y);
		setGraphic(Resources.ss.getSprite(4, 0));
		this.speed = 0.2f;
		this.health = 1200;
		maxHealth = 1200;
		scoreValue = 1500;
		level = 2.5f;
	}

}

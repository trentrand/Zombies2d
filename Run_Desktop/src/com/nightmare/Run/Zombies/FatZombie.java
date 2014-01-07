package com.nightmare.Run.Zombies;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.ZombieTemplate;

public class FatZombie extends ZombieTemplate{

	public FatZombie(float x, float y) {
		super(x, y);
		setGraphic(Resources.ss.getSprite(0, 0));
		this.speed = 0.5f;
		this.health = 500;
		maxHealth = 500;
		scoreValue = 500;
		level = 1.5f;
	}

}

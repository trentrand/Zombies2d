package com.nightmare.Run.Zombies;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.ZombieTemplate;

public class FastZombie extends ZombieTemplate {

	public FastZombie(float x, float y) {
		super(x, y);
		setGraphic(Resources.ss.getSprite(3, 0));
		this.speed = 1.5f;
		this.health = 500;
		maxHealth = 500;
		scoreValue = 250;
		level = 1.5f;
	}

}

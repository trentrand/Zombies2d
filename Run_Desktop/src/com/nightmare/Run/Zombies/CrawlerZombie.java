package com.nightmare.Run.Zombies;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.ZombieTemplate;

public class CrawlerZombie extends ZombieTemplate{

	public CrawlerZombie(float x, float y) {
		super(x, y);
		setGraphic(Resources.ss.getSprite(2, 0));
		this.speed = 2;
		this.health = 50;
		maxHealth = 50;
		scoreValue = 50;
		level = 0.5f;
	}

}

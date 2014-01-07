package com.nightmare.Run.Drops;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.BulletDropTemplate;


public class DropFlameThrower extends BulletDropTemplate {

	public DropFlameThrower(float x, float y) {
		super(x, y);
		this.amtAmmo = 250;
		this.id = 6;
		setGraphic(Resources.ss.getSprite(id, 1));

	}

}

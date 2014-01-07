package com.nightmare.Run.Drops;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.BulletDropTemplate;


public class DropGrenadeLauncher extends BulletDropTemplate {

	public DropGrenadeLauncher(float x, float y) {
		super(x, y);
		this.amtAmmo = 25;
		this.id = 8;
		setGraphic(Resources.ss.getSprite(id, 1));

	}

}

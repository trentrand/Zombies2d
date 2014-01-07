package com.nightmare.Run.Drops;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.BulletDropTemplate;


public class DropStickyLauncher extends BulletDropTemplate {

	public DropStickyLauncher(float x, float y) {
		super(x, y);
		this.amtAmmo = 25;
		this.id = 7;
		setGraphic(Resources.ss.getSprite(id, 1));

	}

}

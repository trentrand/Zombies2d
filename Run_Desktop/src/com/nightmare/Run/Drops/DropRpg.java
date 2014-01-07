package com.nightmare.Run.Drops;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.BulletDropTemplate;


public class DropRpg extends BulletDropTemplate {

	public DropRpg(float x, float y) {
		super(x, y);
		this.amtAmmo = 15;
		this.id = 3;
		setGraphic(Resources.ss.getSprite(id, 1));

	}

}

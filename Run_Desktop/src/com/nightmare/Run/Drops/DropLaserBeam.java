package com.nightmare.Run.Drops;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.BulletDropTemplate;


public class DropLaserBeam extends BulletDropTemplate {

	public DropLaserBeam(float x, float y) {
		super(x, y);
		this.amtAmmo = 50;
		this.id = 2;
		setGraphic(Resources.ss.getSprite(id, 1));

	}

}

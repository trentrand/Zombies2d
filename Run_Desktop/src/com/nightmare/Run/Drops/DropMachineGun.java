package com.nightmare.Run.Drops;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.BulletDropTemplate;


public class DropMachineGun extends BulletDropTemplate {

	public DropMachineGun(float x, float y) {
		super(x, y);
		this.amtAmmo = 250;
		this.id = 1;
		setGraphic(Resources.ss.getSprite(id, 1));
	}

}

package com.nightmare.Run;
import it.marteEngine.entity.Entity;


public class Walls extends Entity {

	public Walls(float x, float y, int length, int width) {
		super(x, y);
		setHitBox(0, 0, length, width);
		addType(SOLID);
	}

}

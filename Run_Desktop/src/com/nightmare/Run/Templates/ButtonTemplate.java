package com.nightmare.Run.Templates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;


public class ButtonTemplate extends Entity {

	public ButtonTemplate(float x, float y, float scale) {
		super(x, y);
		this.scale = scale;
		this.depth = 10000;
	}
	
	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);

	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}

}
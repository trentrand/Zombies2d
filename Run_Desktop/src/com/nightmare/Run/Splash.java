package com.nightmare.Run;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Splash extends Entity {

	public static Image ss;
	
	public Splash(float x, float y) throws SlickException {
		super(x, y);
		
		ss = new Image("resources/logo.png");
			setGraphic(ss);
		this.depth = -1;
		this.scale = 1;
	}
	
	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}
}

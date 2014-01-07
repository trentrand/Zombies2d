package com.nightmare.Run;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Background extends Entity {

	public static Image bg;
	
	public Background(float x, float y) throws SlickException {
		super(x, y);
		
		bg = new Image("resources/bg.png");
		if (Amt.game.getCurrentStateID() == Main.RunWorld) {
			setGraphic(bg);
		}
		if (Amt.game.getCurrentStateID() == Main.MenuState) {
			setGraphic(bg);
		}
		if (Amt.game.getCurrentStateID() == Main.SettingsState) {
			setGraphic(bg);
		}
		this.depth = -1;
		this.scale = 1;
	}
	
	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}
}

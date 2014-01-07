package com.nightmare.Run.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.ButtonTemplate;
import com.nightmare.Run.Character;

public class RunPlayButton extends ButtonTemplate {

	public RunPlayButton(float x, float y, float scale) {
		super(x, y, scale);
		setGraphic(Resources.gui.getSubImage(0, 127, 320, 129));
		name = "pb";
		Character.rpbX = x;
		Character.rpbY = y;
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

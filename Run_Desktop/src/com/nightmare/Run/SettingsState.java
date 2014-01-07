package com.nightmare.Run;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.marteEngine.World;

public class SettingsState extends World {

	public SettingsState(int id, GameContainer container) throws SlickException {
		super(id, container);
		Settings.defaults();
	}

	
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr)
			throws SlickException {
		gr.drawImage(Background.bg, 0, 0);
		
		if (Settings.showPlayerHealth == true) { 
			gr.drawImage(Resources.gui.getSubImage(426, 0, 320, 128), 100, 100); 
		} else {
			gr.drawImage(Resources.gui.getSubImage(426, 0, 320, 128), 100, 100, Color.gray); 
		}
		
		if (Settings.showEnemyHealth == true) {
			gr.drawImage(Resources.gui.getSubImage(426, 129, 320, 128 ), 100, 256);
		} else {
			gr.drawImage(Resources.gui.getSubImage(426, 129, 320, 128 ), 100, 256, Color.gray);
		}

		
		if (Settings.enableMusic == true) {
			gr.drawImage(Resources.gui.getSubImage(426, 258, 320, 128 ), getWidth() - 420, 100 );
		} else {
			gr.drawImage(Resources.gui.getSubImage(426, 258, 320, 128 ), getWidth() - 420, 100, Color.gray);
		}
		
		if (Settings.enableSFX == true) {
			gr.drawImage(Resources.gui.getSubImage(426, 386, 320, 128 ), getWidth() - 420, 256 );
		} else {
			gr.drawImage(Resources.gui.getSubImage(426, 386, 320, 128 ), getWidth() - 420, 256, Color.gray);
		}
		
		gr.drawImage(Resources.gui.getSubImage(335, 267, 64, 32),  10, 10);
		
	}
}	

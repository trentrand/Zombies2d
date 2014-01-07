package com.nightmare.Run;

import it.marteEngine.World;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.nightmare.Run.gui.ExitButton;
import com.nightmare.Run.gui.RunPlayButton;
import com.nightmare.Run.gui.SettingsButton;

public class MenuState extends World {

	public boolean black;

	public MenuState(int id, GameContainer gc) throws SlickException {
		super(id, gc);
	}

	@Override
	public int getID() {
		return Main.MenuState;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		super.init(gc, sbg);
		Resources.loadRes();
		// bg = new Image("resources/bg.png");
		 Background bg = new Background(0, 0);
		 add(bg);
		RunPlayButton play = new RunPlayButton((width / 2) - 160,
				(height / 2) - 64, 1);
		add(play);
		SettingsButton sb = new SettingsButton((width / 2) - 330,
				(height / 2) + 90, 1);
		add(sb);
		ExitButton x = new ExitButton((width / 2) + 10, (height / 2) + 90, 1);
		add(x);
		width = getWidth();
		height = getHeight();
	}
	
	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr)
			throws SlickException {
		super.render(gc, sbg, gr);
		// gr.drawImage(Resources.bg, 0, 0);
		gr.drawImage(Resources.gui.getSubImage(0, 0, 258, 124),
				(width / 2) - 129, 32);
		// gr.drawImage(bg, 0, 0);
		// tile the background image to get a full background
		// for (int x = 0; x < gc.getWidth(); x += brickBackground.getWidth()) {
		// for (int y = 0; y < gc.getHeight(); y += brickBackground
		// .getHeight()) {
		// brickBackground.draw(x, y);
		// }
		// }
		// show the high score
//		new java.util.Timer().schedule(new java.util.TimerTask() {
//			@Override
//			public void run() {
//				black = (black == false) ? true : false;
//			}
//		}, 5000);
//		
//		if (black == false) {
//			gr.setBackground(Color.white);
//		} else {
//			gr.setBackground(Color.black);
//		}
		
		gr.setFont(RunWorld.font);
		gr.setColor(Color.black);
		gr.drawString("High Score - " + Stats.highScore, 25,
				RunWorld.screenY - 50);
		gr.resetTransform();
		gr.setAntiAlias(true);
		gr.setColor(Color.white);
		// gr.drawString("Press A for zombies!", (RunWorld.screenX / 2)
		// - gr.getFont().getWidth("Press A for zombies!") / 2,
		// RunWorld.screenY / 2 - 100);
		// gr.drawString("Press S for options", (RunWorld.screenX / 2)
		// - gr.getFont().getWidth("Press S for options") / 2,
		// RunWorld.screenY / 2);
		// gr.getFont().drawString(
		// (RunWorld.screenX / 2)
		// - gr.getFont().getWidth("Press D to exit") / 2,
		// RunWorld.screenY / 2 + 100, "Press D to exit");
		// // show buttons
		// gr.getFont().drawString(
		// (RunWorld.screenX / 2) - gr.getFont().getWidth("RUN!") / 2, 25,
		// "RUN!");
gr.drawString("Use the mouse to aim and WASD to move! \nZombies randomly drop weapons as they die.", 200, 165);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		super.update(gc, sbg, delta);
	}

	@Override
	public void mousePressed(int button, int x, int y) {

		// see if one of the buttons are pressed
		// if (x > playLocation.x && x < playLocation.x + play.getWidth()
		// && y > playLocation.y && y < playLocation.y + play.getHeight()) {
		// // start the game
		// nextState = Main.PlayState;
		// }
		// if (x > exitLocation.x && x < exitLocation.x + exit.getWidth()
		// && y > exitLocation.y && y < exitLocation.y + exit.getHeight()) {
		// // exit
		// System.exit(0);
		// }
	}
}

package com.nightmare.Run;

import it.marteEngine.World;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class SplashState extends World {

    public SplashState(int id, GameContainer container) {
        super(id, container);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getID() {
        return Main.SplashState;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg)
            throws SlickException {
        super.init(container, sbg);
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                if (Amt.game.getCurrentStateID() == Main.SplashState) {
                    Amt.game.enterState(Main.MenuState, new FadeOutTransition(
                            Color.white), new FadeInTransition(Color.black));
                }
            }
        }, 2000);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr)
            throws SlickException {
        super.render(gc, sbg, gr);
        gr.setBackground(Color.white);
        // bg = new Image("resources/bg.png");
        Splash s = new Splash(Main.gcWidth / 2 - 325, Main.gcHeight / 2 - 111);
        add(s);
    }
}

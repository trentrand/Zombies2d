package com.nightmare.Run;

import it.marteEngine.ME;
import it.marteEngine.World;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Input.Keys;

/**
 * a demo game that works on both slick and android
 * 
 * bounce the balls as long as you can without letting them hit the ground. the
 * longer you go, the more will be added. High scores will be recorded.
 */
public class Main extends StateBasedGame implements ApplicationListener {

    public static final int MenuState = 0;
    public static final int SettingsState = 1;
    public static final int RunWorld = 2;
    public static final int CampaignMode = 3;
    public static final int SurvivalMode = 4;
    public static final int SplashState = 5;
    
    
    public static int gcWidth, gcHeight;
    private static SavedState highScoreSave;

    public static final String highScoreName = "highscore";

    private static int highScore;
    
    public static World world;

    /** volume for SFX and music */
    public static float musicVolume = 1.0f;
    public static float sfxVolume = 1.0f;

    public Main() {
        super("Run - Desktop Edition v0.6");
        Amt.game = this;
    }

    public static void saveHighscore(int newHigh) {
        highScoreSave.setNumber(highScoreName, newHigh);
        try {
            highScoreSave.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        highScore = newHigh;
    }

    public static int getHighScore() {
        return highScore;
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {

        gc.setMaximumLogicUpdateInterval(50);
        gc.setIcon("resources/icon.png");
        highScoreSave = new SavedState(highScoreName);
        try {
            highScoreSave.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        highScore = (int) highScoreSave.getNumber(highScoreName, 0);

        // add the menu
        addState(new MenuState(0, gc));

        // add the settings
        addState(new SettingsState(1, gc));

        // add ME level
        addState(new RunWorld(2, gc));
        
        // add Campaign
        addState(new CampaignMode(3, gc));
        
        // add Survival
        addState(new SurvivalMode(4, gc));

        //add SplashState
        addState(new SplashState(5, gc));

        
        ME.keyFullScreen = Keys.DEL;

        gcWidth = getContainer().getWidth();
        gcHeight = getContainer().getHeight();

        // start with the menu
         enterState(SurvivalMode);
//        enterState(SplashState);
    }

    @Override
    public void create() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void render() {
    }

    @Override
    public void resize(int arg0, int arg1) {
    }

    @Override
    public void resume() {
    }

}

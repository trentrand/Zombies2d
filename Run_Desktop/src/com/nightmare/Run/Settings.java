package com.nightmare.Run;

import org.newdawn.slick.state.GameState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;

public class Settings {

	public static boolean showEnemyHealth;
	public static boolean showPlayerHealth;
	public static boolean enableMusic;
	public static boolean enableSFX;
	public static GameState lastState;

	public static void defaults() {
		if (Gdx.app.getType() == ApplicationType.Android) {
			showEnemyHealth = false;
			showPlayerHealth = false;
			enableMusic = false;
			enableSFX = true;
		}
		if (Gdx.app.getType() == ApplicationType.Desktop) {
			showEnemyHealth = true;
			Settings.showPlayerHealth = false;
			Settings.enableMusic = true;
			Settings.enableSFX = true;
		}
	}
	
    public static GameState getLastState() {
        return lastState;
    }
    public static void setLastState(GameState lastState) {
        Settings.lastState = lastState;
    }
}

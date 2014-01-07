package com.nightmare.Run;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Resources {
    public static SpriteSheet ws;
    public static SpriteSheet ss;
    public static SpriteSheet gui;
    public static Image bg;
    public static Image base;
    public static Image knob;

    public static void loadRes() throws SlickException {
        ws = new SpriteSheet("resources/weaponsSheet.png", 32, 64);
        ss = new SpriteSheet("resources/nightmareSheet.png", 32, 32);
        gui = new SpriteSheet("resources/guiSheet.png", 32, 32);
        bg = new Image("resources/bg.png");
        base = new Image("resources/base.png");
        knob = new Image("resources/knob.png");

    }

}

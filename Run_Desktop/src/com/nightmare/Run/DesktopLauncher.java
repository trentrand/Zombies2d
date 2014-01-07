package com.nightmare.Run;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.ApplicationGDXContainer;
import org.newdawn.slick.SlickException;

public class DesktopLauncher {
    /**
     * @param args
     */
    public static ApplicationGDXContainer agc;

    public static void main(String[] args) throws SlickException,
            LWJGLException {
        try {
            agc = new ApplicationGDXContainer(new Main(), 1200, 600, 1200, 600);
            // size of window x, y, scale x, scale y
            agc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

        
        // if (agc instanceof ApplicationGDXContainer) {
        agc.setIcons(new String[] { "resources/32x32.tga",
                "resources/24x24.tga", "resources/16x16.tga" });
//        agc.setMouseCursor("resources/icon.png", 16, 16);
        agc.setClearEachFrame(true);
        agc.setTargetFrameRate(50);
        agc.setForceExit(true);
        // }
    }
}

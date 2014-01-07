package com.nightmare.Run;

//~--- non-JDK imports --------------------------------------------------------

import android.os.Bundle;

import org.newdawn.slick.SlickActivity;

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.nightmare.Run.Main;

public class AndroidLauncher extends SlickActivity {

	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        start( new Main(), 800, 480);
    }
}
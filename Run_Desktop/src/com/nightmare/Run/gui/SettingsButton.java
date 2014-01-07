package com.nightmare.Run.gui;

import com.nightmare.Run.Character;
import com.nightmare.Run.Resources;
import com.nightmare.Run.Templates.ButtonTemplate;

public class SettingsButton extends ButtonTemplate {

	public SettingsButton(float x, float y, float scale) {
		super(x, y, scale);
		setGraphic(Resources.gui.getSubImage(0, 256, 320, 129));
		Character.sX = x;
		Character.sY = y;
	}

}

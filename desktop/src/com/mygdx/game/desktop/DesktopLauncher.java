package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

import java.io.IOException;

public class DesktopLauncher {
	public static void main(String[] arg) throws IOException, InterruptedException {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;
		config.height = 800;
		new LwjglApplication(new MyGdxGame(), config);
	}

}

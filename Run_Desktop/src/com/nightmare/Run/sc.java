package com.nightmare.Run;


import it.marteEngine.entity.Entity;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.GameState;

public class sc {

	public static void print(int i) {
		System.out.println(i);
	}

	public static void print(long l) {
		System.out.println(l);
	}

	public static void print(String s) {
		System.out.println(s);
	}

	public static void print(Vector2f v) {
		System.out.println(v);

	}

	public static void print(float f) {
		System.out.println(f);
	}

	public static void print(double d) {
		System.out.println(d);

	}

	public static void print(Entity e) {
		System.out.println(e);
	}


	public static void print(float x, float y) {
		System.out.println(x + y);
	}

	public static void print(boolean b) {
		System.out.println(b);
	}

    public static void print(GameState gs) {
        System.out.println(gs);
    }

}

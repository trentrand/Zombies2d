package com.nightmare.Run;

//if (osType.startsWith("Win")) {
//}

import it.marteEngine.Camera;
import it.marteEngine.ME;
import it.marteEngine.World;

import java.util.Random;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Circle;
import com.nightmare.Run.Zombies.CrawlerZombie;
import com.nightmare.Run.Zombies.FastZombie;
import com.nightmare.Run.Zombies.FatZombie;
import com.nightmare.Run.Zombies.TankZombie;

public class CampaignMode extends World implements ApplicationListener,
        InputProcessor {

    public static int levelNum = 0;
    public static Image bg;
    public static Font font;
    public int myX, myY;
    public static int screenX, screenY;
    public static Rectangle up, down, left, right, whole;
    public static int w, h;
    public float guiX, guiY;
    private int spawnFrame = 0;
    private int spawnTimer = 0;
    private int spawnInterval = 250;
    // default 250
    // private int frameInterval = 55555;
    public static Character p;
    public Random r;
    public Animation count;
    public static Rectangle knob, base, center;
    public static int knobX, knobY, startX, startY, baseX, baseY;

    public CampaignMode(int id, GameContainer gc) throws SlickException {
        super(id, gc);

    }

    @Override
    public int getID() {
        return Main.CampaignMode;
    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        super.init(gc, sbg);
        Resources.loadRes();
        gc.setShowFPS(true);
        r = new Random();
        // Called in MenuState
        // Resources.loadRes();
        gc.setMouseGrabbed(true);
        screenX = this.getWidth();
        screenY = this.getHeight();
        font = new AngelCodeFont("resources/zombiefnt.fnt",
                "resources/zombiepng.png");
        Background bg = new Background(0, 0);
        add(bg);
        this.setWidth(1920);
        this.setHeight(1080);
        p = new Character(width / 2, height / 2);
        add(p);
        Weapon myWeapon = new Weapon(p);
        add(myWeapon);
        // FatZombie fz = new FatZombie(300, 300);
        // add(fz);
        w = this.getWidth();
        h = this.getHeight();

        setCamera(new Camera(this, p, container.getWidth(),
                container.getHeight(), 100, 100, new Vector2f(2, 2)));
        Walls north = new Walls(0, 5, getWidth(), 1);
        add(north);
        Walls east = new Walls(getWidth(), 0, -1, getHeight());
        add(east);
        Walls south = new Walls(0, getHeight(), getWidth(), -1);
        add(south);
        Walls west = new Walls(0, 0, 1, getHeight());
        add(west);
        if (Gdx.app.getType() == ApplicationType.Android) {
            ME.setTargetFrameRate(gc, 50);
            // AnalogOut ao = new AnalogOut(128, getHeight() - 128);
            // add(ao);
        }

        count = new Animation();
        count.addFrame(Resources.gui.getSubImage(402, 0, 15, 22), 1000);
        count.addFrame(Resources.gui.getSubImage(372, 0, 19, 22), 1000);
        count.addFrame(Resources.gui.getSubImage(347, 0, 13, 22), 1000);
        count.addFrame(Resources.gui.getSubImage(315, 0, 23, 23), 1000);
        count.addFrame(Resources.gui.getSubImage(294, 0, 12, 23), 1000);
        count.addFrame(Resources.gui.getSubImage(0, 0, 0, 0), 1000);
        count.setLooping(false);

       
        baseX = 0;
        baseY = Main.gcHeight - 128;
        knobX = 32;
        knobY = Main.gcHeight - 96;
        startX = knobX;
        startY = knobY;
//        knob = new Circle(knobX + 32, knobY + 32, 32);
//        base = new Circle(baseX + 64, baseY + 64, 64);
//        center = new Circle(knobX + 32, knobY + 32, 10);

        // DropMachineGun mg = new DropMachineGun(600, 600);
        // add(mg);
        // DropMachineGun mg2 = new DropMachineGun(700, 600);
        // add(mg2);
    }

    public void enter(GameContainer gc, StateBasedGame sbg, Graphics gr)
            throws SlickException {
        super.enter(gc, sbg);
    }

    @Override
    public void update(final GameContainer gc, final StateBasedGame sbg,
            int delta) throws SlickException {
        super.update(gc, sbg, delta);

        if (cs.zombiesSpawned < cs.roundNumber * 5) {
            spawnTimer -= delta;
            while (spawnTimer <= 0) {
                spawnFrame++;
                spawnTimer += spawnInterval;
                if (spawnFrame > 1) {
                    int nextSpawn = r.nextInt(1001);
                    int nextSpawnX, nextSpawnY;
                    nextSpawnX = r.nextInt(w);
                    nextSpawnY = r.nextInt(h);
                    if (nextSpawnX < p.x - 100 || nextSpawn > p.x + 100) {
                        if (nextSpawnY < p.y - 100 || nextSpawnY > p.y + 100) {
                            if (nextSpawn > 850 && nextSpawn < 950) {
                                FatZombie fz = new FatZombie(nextSpawnX,
                                        nextSpawnY);
                                add(fz);
                            } else if (nextSpawn > 950) {
                                TankZombie tz = new TankZombie(nextSpawnX,
                                        nextSpawnY);
                                add(tz);
                            } else if (nextSpawn < 850 && nextSpawn > 600) {
                                CrawlerZombie cz = new CrawlerZombie(
                                        nextSpawnX, nextSpawnY);
                                add(cz);
                            } else if (nextSpawn < 600) {
                                FastZombie fz = new FastZombie(nextSpawnX,
                                        nextSpawnY);
                                add(fz);
                            }
                            cs.zombiesSpawned++;
                            spawnFrame = 0;
                        } else {
                            nextSpawnY = r.nextInt(w);
                        }
                    } else {
                        nextSpawnX = r.nextInt(h);
                    }
                }
            }
            // cs.roundNumber++;
            // cs.zombiesLeft = cs.roundNumber * 25;
        }
        if (Amt.lives < 0) {
            this.clear();
            this.init(gc, sbg);
            cs.defaults();
            Amt.defaults();
            Weapon.primaryWeapon = 0;
            Background bg = new Background(0, 0);
            add(bg);
        }

        if (cs.zombiesLeft == 0) {
            cs.counting = true;
            new java.util.Timer().schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    if (cs.zombiesLeft == 0) {
                        cs.roundNumber++;
                        cs.zombiesSpawned = 0;
                        cs.zombiesLeft = cs.roundNumber * 5;
                    }
                }
            }, 5000);
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, final Graphics gr)
            throws SlickException {
        super.render(gc, sbg, gr);
//        if (base.contains(Character.mouseX, Character.mouseY)) {
//            sc.print("containts");
//        }
        sc.print(Character.mouseX + "  " + Character.mouseY);
        if (Gdx.app.getType() == ApplicationType.Android) {
            // ME.scale(0.5f, 0.5f);
            up = new Rectangle(25, Main.gcHeight - 345, 320, 107);
            left = new Rectangle(25, Main.gcHeight - 345, 107, 320);
            down = new Rectangle(25, Main.gcHeight - 132, 320, 107);
            right = new Rectangle(238, Main.gcHeight - 345, 107, 320);
            whole = new Rectangle(25, Main.gcHeight - 345, 320, 320);
            gr.drawImage(Resources.gui.getSubImage(746, 0, 320, 320), 25,
                    Main.gcHeight - 345);
        }

        // DEBUG!
        gr.drawImage(Resources.base, baseX, baseY);
        gr.drawImage(Resources.knob, knobX, knobY);
        
//        gr.fill(base);
//        gr.setColor(Color.pink);
//        gr.fill(knob);
//        gr.setColor(Color.red);
//        gr.fill(center);
        
        
        gr.setColor(Color.white);
        gr.setFont(font);

        if (cs.counting) {
            gr.drawAnimation(count, Main.gcWidth / 2, Main.gcHeight / 2);
            if (count.getFrame() == 5) {
                count.restart();
                cs.counting = false;
            }
        }

        gr.drawString("Round: " + cs.roundNumber, Main.gcWidth / 2
                - gr.getFont().getWidth("Round: " + cs.roundNumber), 0);

        gr.drawString("" + cs.zombiesLeft, 10, Main.gcHeight
                - gr.getFont().getHeight("" + cs.zombiesLeft) - 10);

        // if (Amt.lives > 0) {
        // gr.drawString(Amt.lives.toString() + " lives", 5, 5);
        // } else {
        // gr.drawString("No lives", 10, 5);
        // }

        if (Amt.ammo1 != 99999) {
            gr.drawString(
                    "Ammo: " + Amt.ammo1.toString(),
                    gc.getWidth()
                            - gr.getFont().getWidth(
                                    "Ammo: " + Amt.ammo1.toString()) - 10,
                    gc.getHeight()
                            - gr.getFont().getHeight(
                                    "Ammo: " + Amt.ammo1.toString()) - 10);
        }
        // gr.draw(camera.getMoveRect());

        for (int i = 0; i < Amt.lives * 32; i += 32) {
            gr.drawImage(Resources.gui.getSubImage(816, 320, 32, 32), i + 5, 5);
        }
        for (int i = 0; i < Amt.ammo2 * 16; i += 24) {
            if (Weapon.equipmentWeapon == 0) {
                gr.drawImage(Resources.gui.getSubImage(757, 324, 22, 24),
                        i + 5, 37);
            } else if (Weapon.equipmentWeapon == 1) {
                gr.drawImage(Resources.gui.getSubImage(789, 324, 22, 24),
                        i + 5, 37);

            }
        }
        gr.setColor(new Color(0.149f, 0.498f, 0));
        gr.drawImage(Resources.gui.getSubImage(768, 352, 128, 128),
                Main.gcWidth - 128, 0);
        gr.drawString("$" + Amt.cash.intValue(), gc.getWidth()
                - gr.getFont().getWidth("$" + Amt.cash.intValue()) - 20,
                60 - gr.getFont().getHeight("$" + Amt.cash.intValue()));
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyUp(int arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchMoved(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {

        return false;
    }

    public static void touch(int x, int y) {
    }

}

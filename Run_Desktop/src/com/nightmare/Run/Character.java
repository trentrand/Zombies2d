package com.nightmare.Run;

import it.marteEngine.ME;
import it.marteEngine.entity.Entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.nightmare.Run.Bullets.FlameBullet;
import com.nightmare.Run.Bullets.GeneralBullet;
import com.nightmare.Run.Bullets.Grenade_Regular;
import com.nightmare.Run.Bullets.Grenade_Sticky;
import com.nightmare.Run.Bullets.LaserBullet;
import com.nightmare.Run.Bullets.MagnumBullet;
import com.nightmare.Run.Bullets.RpgBullet;
import com.nightmare.Run.Bullets.SniperBullet;

public class Character extends Entity implements InputProcessor {
    public static int mouseX, mouseY;
    public Point2D.Float p1;
    public Point2D.Float p2;
    public static int mouseAngle;
    public int speed = 2;
    public static float myX;
    public static float myY;
    public static float onScreenX;
    public static float onScreenY;
    public static Integer health = 100;
    // public static Integer health = 9999999;

    /** Timer for gun **/
    private int gunFrame = 0;
    private int gunTimer = 0;
    private int gunInterval = 250;
    public boolean invincible;

    /** MainMenu Button x/y **/
    public static float rpbX, rpbY, ebX, ebY, sX, sY;

    // 0 = unlimited pistol
    // 1 = machine gun
    // 2 = laser beam
    // 3 = rpg
    // 4 = .357 magnum
    // 5 = sniper
    // 6 = flame thrower
    // 7 = grenade launcher
    // 8 = (sticky/spike) grenade launcher
    // 9 = katana

    public Character(float x, float y) throws SlickException {
        super(x, y);
        setGraphic(Resources.ss.getSprite(1, 0));
        this.setCentered(true);
        setHitBox(-14, -14, 28, 28);
        addType(PLAYER, COLLIDABLE);
        this.depth = 99;
        this.name = "character";
        Gdx.input.setInputProcessor(this);
        p1 = new Point2D.Float(x, y);
        p2 = new Point2D.Float(onScreenX, onScreenY);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        super.update(container, delta);
        if (Gdx.input.isKeyPressed(Keys.B)) {
            Gdx.input.setOnscreenKeyboardVisible(true);
        }
        if (health <= 0) {
            health = 999999;
            Amt.lives -= 1;
            invincible = true;
            x = RunWorld.w / 2;
            y = RunWorld.h / 2;
            new java.util.Timer().schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    health = 100;
                    invincible = false;
                }
            }, 4000);
        }

        // if (health <= 0) {
        // health = 999999;
        // x = RunWorld.w / 2;
        // y = RunWorld.h / 2;
        //
        // }

        if (Amt.lives < 0) {
            // Move Off Screen for Now :(
            x = RunWorld.w + 500;
            y = RunWorld.h + 500;
            if (Amt.score > Stats.highScore) {
                Stats.highScore = Amt.score;
            }
            Amt.game.enterState(Main.MenuState, new FadeOutTransition(
                    Color.black), new FadeInTransition(Color.white));
        }
        myX = x;
        myY = y;
        onScreenX = x - this.world.camera.cameraX;
        onScreenY = y - this.world.camera.cameraY;
        if (Gdx.app.getType() == ApplicationType.Desktop) {
            if ((Gdx.input.isKeyPressed(Keys.A) || (Gdx.input
                    .isKeyPressed(Keys.LEFT)))
                    && collide(SOLID, x - 2, y) == null) {
                x -= speed;
            }
            if ((Gdx.input.isKeyPressed(Keys.D) || (Gdx.input
                    .isKeyPressed(Keys.RIGHT)))
                    && collide(SOLID, x + 2, y) == null) {
                x += speed;
            }
            if ((Gdx.input.isKeyPressed(Keys.W) || (Gdx.input
                    .isKeyPressed(Keys.UP)))
                    && collide(SOLID, x, y - 2) == null) {
                y -= speed;
            }
            if ((Gdx.input.isKeyPressed(Keys.S) || (Gdx.input
                    .isKeyPressed(Keys.DOWN)))
                    && collide(SOLID, x, y + 2) == null) {
                y += speed;
            }
            //FIXME Desktop Secondary
            if (Gdx.input.isButtonPressed(1)) {
                mouseX = Gdx.input.getX();
                mouseY = Gdx.input.getY();
                if (Amt.ammo2 > 0) {
                if (Weapon.equipmentWeapon == 0) {
                    gunInterval = 450;
                    gunTimer -= delta;
                    while (gunTimer <= 0) {
                        gunFrame++;
                        gunTimer += gunInterval;
                        if (gunFrame > 1) {
                            Grenade_Regular glb = new Grenade_Regular(x, y,
                                    angle);
                            this.world.add(glb);
                            Amt.ammo2 -= 1;
                            gunFrame = 0;
                        }
                    }
                }
                } else if (Weapon.equipmentWeapon == 1) {
                    gunInterval = 450;
                    gunTimer -= delta;
                    while (gunTimer <= 0) {
                        gunFrame++;
                        gunTimer += gunInterval;
                        if (gunFrame > 1) {
                            Grenade_Sticky sb = new Grenade_Sticky(x, y, angle);
                            this.world.add(sb);
                            Amt.ammo2 -= 1;
                            gunFrame = 0;
                        }
                    }
                }
            }

            //FIXME Primary Weapon
            if (Gdx.input.isButtonPressed(0)) {
                mouseX = Gdx.input.getX();
                mouseY = Gdx.input.getY();
                if (Weapon.primaryWeapon == 0) {
                    Amt.ammo1 = 99999;
                    gunInterval = 150;
                    gunTimer -= delta;
                    while (gunTimer <= 0) {
                        gunFrame++;
                        gunTimer += gunInterval;
                        if (gunFrame > 1) {
                            GeneralBullet gb = new GeneralBullet(x, y, angle);
                            this.world.add(gb);
                            gunFrame = 0;
                        }
                    }
                } else if (Amt.ammo1 > 0) {
                    if (Weapon.primaryWeapon == 1) {
                        gunInterval = 50;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                GeneralBullet gb = new GeneralBullet(x, y,
                                        angle);
                                this.world.add(gb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 2) {
                        gunInterval = 250;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                LaserBullet lb = new LaserBullet(x, y, angle);
                                this.world.add(lb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 3) {
                        gunInterval = 250;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                RpgBullet rb = new RpgBullet(x, y, angle);
                                this.world.add(rb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 4) {
                        gunInterval = 250;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                MagnumBullet mb = new MagnumBullet(x, y, angle);
                                this.world.add(mb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 5) {
                        gunInterval = 450;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                SniperBullet sb = new SniperBullet(x, y, angle);
                                this.world.add(sb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 6) {
                        gunInterval = 50;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                FlameBullet fb = new FlameBullet(x, y, angle);
                                this.world.add(fb);
                                FlameBullet fb1 = new FlameBullet(x, y,
                                        angle - 15);
                                this.world.add(fb1);
                                FlameBullet fb2 = new FlameBullet(x, y,
                                        angle - 11);
                                this.world.add(fb2);
                                FlameBullet fb3 = new FlameBullet(x, y,
                                        angle - 7);
                                this.world.add(fb3);
                                FlameBullet fb4 = new FlameBullet(x, y,
                                        angle - 3);
                                this.world.add(fb4);
                                FlameBullet fb5 = new FlameBullet(x, y,
                                        angle + 3);
                                this.world.add(fb5);
                                FlameBullet fb6 = new FlameBullet(x, y,
                                        angle + 7);
                                this.world.add(fb6);
                                FlameBullet fb7 = new FlameBullet(x, y,
                                        angle + 11);
                                this.world.add(fb7);
                                FlameBullet fb8 = new FlameBullet(x, y,
                                        angle + 15);
                                this.world.add(fb8);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 7) {
                        gunInterval = 450;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                Grenade_Regular glb = new Grenade_Regular(x, y,
                                        angle);
                                this.world.add(glb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 8) {
                        gunInterval = 450;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                Grenade_Sticky sb = new Grenade_Sticky(x, y,
                                        angle);
                                this.world.add(sb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 9) {

                    }
                    // end of else if's

                }
                // end of ammo > 0 check
            }

        } else if (Gdx.app.getType() == ApplicationType.Android) {
            if (RunWorld.up.contains(mouseX, mouseY) && Gdx.input.isTouched()
                    && collide(SOLID, x, y - 2) == null) {
                y -= speed;
            }
            if (RunWorld.down.contains(mouseX, mouseY) && Gdx.input.isTouched()
                    && collide(SOLID, x, y + 2) == null) {
                y += speed;

            }
            if (RunWorld.left.contains(mouseX, mouseY) && Gdx.input.isTouched()
                    && collide(SOLID, x - 2, y) == null) {
                x -= speed;
            }
            if (RunWorld.right.contains(mouseX, mouseY)
                    && Gdx.input.isTouched()
                    && collide(SOLID, x + 2, y) == null) {
                x += speed;
            }
            if (Gdx.input.isTouched()
                    && !RunWorld.whole.contains(Gdx.input.getX(),
                            Gdx.input.getY())) {
                mouseX = Gdx.input.getX();
                mouseY = Gdx.input.getY();
                if (Weapon.primaryWeapon == 0) {
                    Amt.ammo1 = 99999;
                    gunInterval = 150;
                    gunTimer -= delta;
                    while (gunTimer <= 0) {
                        gunFrame++;
                        gunTimer += gunInterval;
                        if (gunFrame > 1) {
                            GeneralBullet gb = new GeneralBullet(x, y, angle);
                            this.world.add(gb);
                            gunFrame = 0;
                        }
                    }
                } else if (Amt.ammo1 > 0) {
                    if (Weapon.primaryWeapon == 1) {
                        gunInterval = 50;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                GeneralBullet gb = new GeneralBullet(x, y,
                                        angle);
                                this.world.add(gb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 2) {
                        gunInterval = 250;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                LaserBullet lb = new LaserBullet(x, y, angle);
                                this.world.add(lb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 3) {
                        gunInterval = 250;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                RpgBullet rb = new RpgBullet(x, y, angle);
                                this.world.add(rb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 4) {
                        gunInterval = 250;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                MagnumBullet mb = new MagnumBullet(x, y, angle);
                                this.world.add(mb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 5) {
                        gunInterval = 450;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                SniperBullet sb = new SniperBullet(x, y, angle);
                                this.world.add(sb);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 6) {
                        gunInterval = 50;
                        gunTimer -= delta;
                        while (gunTimer <= 0) {
                            gunFrame++;
                            gunTimer += gunInterval;
                            if (gunFrame > 1) {
                                FlameBullet fb = new FlameBullet(x, y, angle);
                                this.world.add(fb);
                                FlameBullet fb1 = new FlameBullet(x, y,
                                        angle - 15);
                                this.world.add(fb1);
                                FlameBullet fb2 = new FlameBullet(x, y,
                                        angle - 11);
                                this.world.add(fb2);
                                FlameBullet fb3 = new FlameBullet(x, y,
                                        angle - 7);
                                this.world.add(fb3);
                                FlameBullet fb4 = new FlameBullet(x, y,
                                        angle - 3);
                                this.world.add(fb4);
                                FlameBullet fb5 = new FlameBullet(x, y,
                                        angle + 3);
                                this.world.add(fb5);
                                FlameBullet fb6 = new FlameBullet(x, y,
                                        angle + 7);
                                this.world.add(fb6);
                                FlameBullet fb7 = new FlameBullet(x, y,
                                        angle + 11);
                                this.world.add(fb7);
                                FlameBullet fb8 = new FlameBullet(x, y,
                                        angle + 15);
                                this.world.add(fb8);
                                Amt.ammo1 -= 1;
                                gunFrame = 0;
                            }
                        }
                    } else if (Weapon.primaryWeapon == 9) {

                    }
                    // end of else if's

                }
                // end of ammo > 0 check
            }
        }
        mouseAngle = (int) calculateAngle(onScreenX, onScreenY,
                Character.mouseX, Character.mouseY);
        p1.setLocation(x, y);
        p2.setLocation(onScreenX, onScreenY);
        this.angle = mouseAngle;
        
//        double moveX;
//        double moveY;
//        float anglefrom = Entity.calculateAngle(CampaignMode.baseX + 64, CampaignMode.baseY + 64, CampaignMode.knobX, CampaignMode.knobY);
//        sc.print(anglefrom);
//        moveX = Math.sin(Math.toRadians(anglefrom));
//        moveY = Math.cos(Math.toRadians(anglefrom));
//        this.x += moveX * speed;
//        this.y -= moveY * speed;
        // end of input mouse processor
        
    }

    @Override
    public void render(GameContainer gc, Graphics gr) throws SlickException {
        super.render(gc, gr);
        if (invincible) {
            gr.setColor(Color.red);
            gr.drawRoundRect(x - 32, y - 32, 64, 64, 2);
        }
        if (Settings.showPlayerHealth == true) {
            if (health <= 100) {
                gr.setColor(Color.red);
                gr.drawString(health.toString(), x - 16, y + 16);
            }
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.HOME || keycode == Keys.MENU) {
            if (ME.debugEnabled == false) {
                ME.debugEnabled = true;
            } else {
                ME.debugEnabled = false;
            }
        }
        if (keycode == Keys.ESCAPE) {
            if (Amt.game.getCurrentStateID() != Main.SettingsState) {
                Settings.setLastState(Amt.game.getCurrentState());
                Amt.game.enterState(Main.SettingsState);
            } else {
                Amt.game.enterState(Settings.getLastState().getID());
            }
        }
        if (keycode == Keys.BACKSLASH) {
            sc.print(this.world.camera.cameraX + "   " + world.camera.cameraY);
        }
        if (keycode == Keys.SPACE) {
            health = 999999;
        }
        if (keycode == Keys.NUM_0) {
            Weapon.primaryWeapon = 0;
        }
        if (keycode == Keys.NUM_1) {
            Weapon.primaryWeapon = 1;
        }
        if (keycode == Keys.NUM_2) {
            Weapon.primaryWeapon = 2;
        }
        if (keycode == Keys.NUM_3) {
            Weapon.primaryWeapon = 3;
        }
        if (keycode == Keys.NUM_4) {
            Weapon.primaryWeapon = 4;
        }
        if (keycode == Keys.NUM_5) {
            Weapon.primaryWeapon = 5;
        }
        if (keycode == Keys.NUM_6) {
            Weapon.primaryWeapon = 6;
        }
        if (keycode == Keys.NUM_7) {
            Weapon.primaryWeapon = 7;
        }
        if (keycode == Keys.NUM_8) {
            Weapon.primaryWeapon = 8;
        }
        if (keycode == Keys.NUM_9) {
            Weapon.primaryWeapon = 9;
        }
        // if (keycode == Keys.P) {
        // }
        // if (amt.game.getCurrentStateID() == Main.MenuState) {
        // if (keycode == Keys.A) {
        // amt.game.enterState(Main.RunWorld, new FadeOutTransition(
        // Color.black), new FadeInTransition(Color.white));
        // // amt.game.enterState(Main.RunWorld);
        // }
        // if (keycode == Keys.S) {
        // amt.game.enterState(Main.SettingsState);
        // }
        // if (keycode == Keys.D) {
        // System.exit(0);
        // }
        // }

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // System.out.println(character + "");
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
        if (Amt.game.getCurrentStateID() == Main.MenuState) {
            if (x > rpbX && x < rpbX + 320 && y > rpbY && y < rpbY + 129) {
                Amt.game.enterState(Main.CampaignMode, new FadeOutTransition(
                        Color.black), new FadeInTransition(Color.white));
            }
            if (x > sX && x < sX + 320 && y > sY && y < sY + 129) {
                Settings.setLastState(Amt.game.getCurrentState());
                Amt.game.enterState(Main.SettingsState);
            }
            if (x > ebX && x < ebX + 320 && y > ebY && y < ebY + 128) {
                System.exit(0);
            }
        } else if (Amt.game.getCurrentStateID() == Main.SettingsState) {
            if (x > 10 && x < 74 && y > 10 && y < 42) {
                Amt.game.enterState(Settings.lastState.getID());
            } else if (x > 100 && x < 420 && y > 100 && y < 228) {
                Settings.showPlayerHealth = (Settings.showPlayerHealth == false ? true
                        : false);
            } else if (x > 100 && x < 420 && y > 256 && y < 384) {
                Settings.showEnemyHealth = (Settings.showEnemyHealth == false ? true
                        : false);
            } else if (x > Main.gcWidth - 420 && x < Main.gcWidth - 100
                    && y > 100 && y < 228) {
                Settings.enableMusic = (Settings.enableMusic == false ? true
                        : false);
                // sc.print(Settings.enableMusic);
            } else if (x > Main.gcWidth - 420 && x < Main.gcWidth - 100
                    && y > 256 && y < 384) {
                Settings.enableSFX = (Settings.enableSFX == false ? true
                        : false);
                // sc.print(Settings.enableSFX);
            }
        }
        return false;

    }

    @Override
    public boolean touchDragged(int x, int y, int finger) {
        return false;
    }

    @Override
    public boolean touchMoved(int x, int y) {
        mouseX = x;
        mouseY = y;
        return false;
    }

    @Override
    public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    // new java.util.Timer().schedule(new java.util.TimerTask() {
    // @Override
    // public void run() {
    // }
    // }, 360);

}

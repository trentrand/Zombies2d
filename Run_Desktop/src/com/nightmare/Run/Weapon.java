package com.nightmare.Run;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Weapon extends Entity {

    private Character parent;
    public Image unlimitedPistol;
    public Image machineGun;
    public Image laserBeam;
    public Image rpg;
    public Image magnum;
    public Image sniper;
    public Image flameThrower;
    public Image grenadeLauncher;
    public Image spikeLauncher;
    public Image nullGraphic;
    public static int lastWeapon;
    public static int primaryWeapon = 0;
//    public static int secondaryWeapon = 0;
    public static int equipmentWeapon = 0;

    // 0 = unlimited pistol
    // 1 = machine gun
    // 2 = laser beam
    // 3 = rpg
    // 4 = magnum
    // 5 = sniper
    // 6 = flame thrower
    // 7 = grenade launcher
    // 8 = (sticky/spike) grenade
    // 9 = null/reserved

    public Weapon(Character parent) throws SlickException {
        super(parent.x, parent.y);
        this.parent = parent;
        unlimitedPistol = Resources.ws.getSprite(0, 0);
        machineGun = Resources.ws.getSprite(1, 0);
        laserBeam = Resources.ws.getSprite(2, 0);
        rpg = Resources.ws.getSprite(3, 0);
        magnum = Resources.ws.getSprite(4, 0);
        sniper = Resources.ws.getSprite(5, 0);
        flameThrower = Resources.ws.getSprite(6, 0);
        grenadeLauncher = Resources.ws.getSprite(7, 0);
        spikeLauncher = Resources.ws.getSprite(8, 0);
        nullGraphic = Resources.ws.getSprite(9, 0);
        this.setCentered(true);
        setGraphic(unlimitedPistol);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        super.update(container, delta);
        x = parent.x;
        y = parent.y;
        if (Amt.ammo1 <= 0) {
            lastWeapon = primaryWeapon;
            primaryWeapon = 0;
        }
        if (primaryWeapon != lastWeapon) {
            if (primaryWeapon == 0) {
                setGraphic(unlimitedPistol);
            } else if (primaryWeapon == 1) {
                setGraphic(machineGun);
            } else if (primaryWeapon == 2) {
                setGraphic(laserBeam);
            } else if (primaryWeapon == 3) {
                setGraphic(rpg);
            } else if (primaryWeapon == 4) {
                setGraphic(magnum);
            } else if (primaryWeapon == 5) {
                setGraphic(sniper);
            } else if (primaryWeapon == 6) {
                setGraphic(flameThrower);
            } else if (primaryWeapon == 7) {
                setGraphic(nullGraphic);
            } else if (primaryWeapon == 8) {
                setGraphic(nullGraphic);
            } else if (primaryWeapon == 9) {
                setGraphic(nullGraphic);
            }
        }
        this.angle = Character.mouseAngle;
    }

    @Override
    public void render(GameContainer gc, Graphics gr) throws SlickException {
        super.render(gc, gr);
    }

}

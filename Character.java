
import greenfoot.Greenfoot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tom
 */
public class Character extends Mover {
//public static int timer = 1;

    public Character() {
        super();
        setImage("hud_p1.png");
    }

    /**
     *
     */
    @Override
    public void act() {

        if (Greenfoot.isKeyDown("1")) {
            setImage("hud_p1.png");
        } else if (Greenfoot.isKeyDown("2")) {
            setImage("hud_p2.png");
        } else if (Greenfoot.isKeyDown("3")) {
            setImage("hud_p3.png");
        }
    }
}

/* public void act(){
        if (timer == 1)
        {
            setImage("hud_gem_blue.png");
        }
        if (timer == 2)
        {
            setImage("hud_gem_green.png");
        }
        if (timer == 3)
        {
            setImage("hud_gem_red.png");
        }
        if (timer == 4)
        {
            setImage("hud_gem_yellow.png");
        }
        if (timer == 5)
        {
            timer = 1;
        }
        timer ++;
        
    }}
 */

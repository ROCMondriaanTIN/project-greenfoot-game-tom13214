/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class HeartFull extends Mover {

    /**
     *
     */
    @Override
    public void act() {
        if (Hero.levens == 2) {
            setImage("hud_heartFull.png");
        }
        else if (Hero.levens == 1) {
            setImage("hud_heartHalf.png");
        }
        else if (Hero.levens == 0) {
            setImage("hud_heartEmpty.png");
        }
    }

}

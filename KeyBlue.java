

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tom
 */
public class KeyBlue extends Mover {

    public KeyBlue() {
        super();
        setImage("hud_keyBlue_disabled.png");
    }

    public void act() {

        if (Hero.blueOpen == true) {
            setImage("hud_keyBlue.png");
        } else {
            setImage("hud_keyBlue_disabled.png");
        }
    }

}

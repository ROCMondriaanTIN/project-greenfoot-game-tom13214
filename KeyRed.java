/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class KeyRed extends Mover 
{


         public void act(){
    if (Hero.redOpen == true){
    setImage("hud_keyRed.png");}
    else{
    setImage("hud_keyRed_disabled.png");}}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class KeyGreen extends Mover 
{


         public void act(){
    if (Hero.keyCollectGreen == true){
    setImage("hud_keyGreen.png");}
    else{
    setImage("hud_keyGreem_disabled.png");}}

}
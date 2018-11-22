/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class HeartFull extends Mover 
{


         public void act(){
    if (Hero.heartFull == true){
    setImage("hud_heartEmpty.png");}
    else{
    setImage("hud_heartFull.png");}}

}
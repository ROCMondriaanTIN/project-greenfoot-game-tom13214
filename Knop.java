import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knop extends Actor
{
    /**
     * Act - do whatever the Knop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        setImage("knop.png");
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MyWorld());
        }
        // Add your action code here.
    }    
}

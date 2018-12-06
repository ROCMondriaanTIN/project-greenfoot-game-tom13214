
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (Tom) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    public static boolean start;

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        //Greenfoot.start();
        setBackground("achtergrond.png");
        addObject(new Knop(), 500, 400);
        
    }
}
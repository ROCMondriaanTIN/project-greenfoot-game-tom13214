
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class MyWorld extends World {
    
    

    private CollisionEngine ce;
    public static int coinX = 200;
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");
        
        
        
        int[][] testmap = {
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,},
        {-1,-1,24,23,27,-1,-1,13,-1,22,},
        {-1,-1,55,56,57,-1,-1,-1,-1,25,},
        {-1,-1,5,5,5,-1,-1,-1,49,18,},
        {14,14,14,14,14,14,14,14,14,14,},
        };
                
        
        
        int[][] map = {
           {16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
{14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14},
{14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,49,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,23,14},
{14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14},
{14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14},
{14,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,17,-1,-1,17,-1,3,-1,3,-1,3,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,-1,-1,16,14},
{14,14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,4,4,4,4,4,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14,14},
{14,14,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,17,-1,-1,-1,-1,-1,-1,4,-1,4,4,4,-1,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,14,14},
{14,14,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,10,4,11,4,10,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,14,14,14},
{14,14,14,16,-1,-1,-1,-1,-1,-1,-1,-1,7,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,4,4,11,4,4,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,-1,-1,10,-1,-1,-1,-1,16,14,14,14,14},
{14,14,14,14,16,16,16,16,16,16,16,16,16,12,-1,-1,-1,-1,-1,-1,-1,-1,-1,15,15,15,15,15,15,15,15,15,-1,-1,-1,-1,-1,-1,-1,16,15,16,16,16,16,16,16,1073741833,-1,-1,-1,-1,-1,-1,1073741833,16,16,16,22,22,16,16,16,16,16,14,14,14,14,14},
{14,14,14,14,14,14,14,14,14,14,14,14,14,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,6,6,6,6,6,6,6,-1,-1,-1,-1,-1,-1,15,16,14,14,14,6,14,14,14,-1,-1,-1,1073741833,-1,-1,-1,-1,-1,14,14,14,25,25,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,14,14,14,14,14,14,-1,-1,22,-1,-1,-1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,15,15,14,6,6,14,14,14,14,14,14,-1,-1,-1,-1,-1,-1,1073741833,-1,-1,14,14,14,18,18,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,14,14,14,-1,10,-1,-1,-1,22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,15,15,6,14,6,6,14,10,5,10,-1,25,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14,14,14,-1,-1,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,10,5,10,-1,-1,-1,-1,-1,22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,15,15,6,14,6,14,6,14,14,-1,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,1073741833,-1,-1,-1,-1,14,14,-1,-1,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,-1,-1,-1,-1,-1,-1,-1,16,16,12,-1,-1,-1,-1,-1,2,-1,-1,15,15,15,-1,-1,15,-1,-1,15,6,6,14,6,6,6,14,6,14,27,-1,-1,-1,25,-1,-1,-1,1073741833,-1,-1,-1,-1,-1,-1,-1,14,14,-1,-1,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,24,-1,-1,-1,-1,16,16,14,14,-1,-1,-1,2,-1,-1,-1,-1,-1,6,6,6,50,50,50,50,50,6,6,6,6,6,14,6,14,14,14,14,14,14,14,14,14,-1,-1,-1,-1,-1,-1,-1,1073741833,-1,-1,14,14,-1,-1,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,14,14,14,14,14,14,14,14,14,8,8,8,8,8,8,8,8,8,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,14,6,14,14,14,14,14,-1,-1,-1,-1,1073741833,-1,-1,-1,-1,-1,14,14,-1,-1,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,14,14,14,14,14,14,14,14,14,13,13,13,13,13,13,13,13,13,6,6,6,6,6,6,6,6,6,6,6,14,6,6,14,6,14,6,14,14,6,14,14,8,8,8,8,8,8,8,8,8,8,8,14,14,-1,-1,14,14,14,14,14,14,14,14,14,14},
{14,14,14,14,14,14,14,14,14,14,14,14,14,13,13,13,13,13,13,13,13,13,6,6,6,6,6,6,6,6,6,6,6,6,14,6,6,14,6,14,6,14,14,14,14,13,13,13,13,13,13,13,13,13,13,13,14,14,14,14,14,14,14,14,14,14,14,14,14,14},
        };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        
        CoinCounter cc = new CoinCounter();
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero(cc);

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero, 350, 500);
        //addObject(hero, 10, 10);
        //addObject(hero, 3000, 200);
        addObject(new Enemy(), 3800, 575);
        //addObject(new Enemy2(), 3800, 575);
        addObject(new KeyBlue(), 30, 25);
        addObject(new KeyRed(), 80, 25);
        addObject(new KeyGreen(), 130, 25);
        addObject(new Character(), 967, 28);
        addObject(new Coin(), 450, 28);
        addObject(cc, 500, 30);
        addObject(new diamant(), 550, 30);
        //addObject(new intro(), 500, 500);
        
        
        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }
       
    
    
    
    
    
    @Override
    public void act() {
        ce.update();
        /*if (Hero.coins == 1);
        {
            addObject(new Coins(), coinX, 200);
            coinX += 35;
            //Hero.coinAdded = false;
        }
        else if (Hero.coins == 2);
        {
            addObject(new Coins(), coinX, 200);
            coinX += 35;
        }*/
    }
    

}

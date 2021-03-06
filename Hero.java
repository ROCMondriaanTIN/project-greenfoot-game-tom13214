
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    static boolean heartFull;
    static int world = 1;

    private double gravity;
    private double acc = 1;
    private double drag;
    private GreenfootImage walkIm1;
    private GreenfootImage walkIm2;
    private GreenfootImage walkIm3;
    private GreenfootImage walkIm4;
    private GreenfootImage walkIm5;
    private GreenfootImage walkIm6;
    private GreenfootImage walkIm7;
    private GreenfootImage walkIm8;
    private GreenfootImage walkIm9;
    private GreenfootImage walkIm10;
    private GreenfootImage walkIm11;

    private GreenfootImage P1;
    private GreenfootImage P2;
    private GreenfootImage P3;

    private boolean start;

    public static boolean collectGem;

    public static int player = 1;

    private int width;

    private boolean isOnGround;

    private boolean isTouching;

    private int walkStatus;

    private int status = 0;

    private String direction = "right";

    private int walking = 1;

    private String richting = "right";

    public static int coins;

    private boolean geraakt = false;
    private int pause = 50;
    static int levens = 1;
    public static boolean canJump;
    public int animationCounter = 0;
    private int frame = 1;
    private static int teller = 1;
    public static boolean keyCollect = false;
    public static boolean keyCollectRed = false;
    public static boolean keyCollectBlue = false;
    public static boolean keyCollectGreen = false;
    public static boolean coinAdded = false;
    public static boolean keyNotFound = false;
    public static boolean blueOpen = false;
    public static boolean greenOpen = false;
    public static boolean redOpen = false;

    private CoinCounter counter;

    public Hero(CoinCounter coinCounter) {
        super();
        this.counter = coinCounter;

        gravity = 9.8;
        acc = 1;
        drag = 0.8;

        walkIm1 = new GreenfootImage("p1_walk1.png");
        walkIm2 = new GreenfootImage("p1_walk2.png");
        walkIm3 = new GreenfootImage("p1_walk3.png");
        walkIm4 = new GreenfootImage("p1_walk4.png");
        walkIm5 = new GreenfootImage("p1_walk5.png");
        walkIm6 = new GreenfootImage("p1_walk6.png");
        walkIm7 = new GreenfootImage("p1_walk7.png");
        walkIm8 = new GreenfootImage("p1_walk8.png");
        walkIm9 = new GreenfootImage("p1_walk9.png");
        walkIm10 = new GreenfootImage("p1_walk10.png");
        walkIm11 = new GreenfootImage("p1_walk11.png");

        //Greenfoot.setWorld(new testmap);
        //P1 = new GreenfootImage("p1_walk01");
        //P2 = new GreenfootImage("p2_walk01");
        //P3 = new GreenfootImage("p3_walk01");
        setImage("p1_stand.png");
        
    }

    private void removeTile(Tile tile) {
        tile.getImage().setTransparency(0);
        tile.isSolid = false;
    }

    @Override
    public void act() {
        for (Tile tile : getIntersectingObjects(Tile.class)) {

            
//            int xMin = getImage().getWidth() / 2;
//        int xMax = TileEngine.MAP_WIDTH * TileEngine.TILE_WIDTH - xMin;
//        if (getX() <= xMin) {
//            setLocation(xMin, getY());
//            velocityX = 0;
//        } else if (getX() >= xMax) {
//            setLocation(xMax, getY());
//            velocityX = 0;
//        }
            
            if (start == false) {
                getImage().scale(50, 70);
                start = true;
            }
            
            
            if (tile.getImage().toString().contains("door_open")) {
                Greenfoot.setWorld(new MyWorld2());
                setLocation(300, 200);
            }
            
            
            

            if (tile.getImage().toString().contains("hud_p1Alt.png")) {
                getImage().scale(50, 70);
                acc = 1;
                player = 1;
            }
            if (tile.getImage().toString().contains("hud_p2Alt.png")) {
                getImage().scale(60, 90);
                acc = 0.7;
                player = 2;
            }
            if (tile.getImage().toString().contains("hud_p3Alt.png")) {
                getImage().scale(35, 50);
                acc = 1.5;
                player = 3;
            }

            if (tile.getImage().toString().contains("gemBlue")) {
                removeTile(tile);
                collectGem = true;
            }

            if (tile.getImage().toString().contains("keyBlue")) {
                removeTile(tile);
                blueOpen = true;
            }

            if (tile.getImage().toString().contains("keyRed")) {
                removeTile(tile);
                redOpen = true;
            }

            if (tile.getImage().toString().contains("keyGreen")) {
                removeTile(tile);
                greenOpen = true;
            }
            if (tile.getImage().toString().contains("lock_blue") && (blueOpen == true)) {
                removeTile(tile);

            }
            if (tile.getImage().toString().contains("lock_green") && (greenOpen == true)) {
                removeTile(tile);

            }
            if (tile.getImage().toString().contains("lock_red") && (redOpen == true)) {
                removeTile(tile);

            }

        }

        if (Greenfoot.isKeyDown("q")) {
            levens = 0;
        }

//        if (Greenfoot.isKeyDown("p")) {
//            velocityY = -20;
//        }
//
//        if (Greenfoot.isKeyDown("1")) {
//            player = 1;
//            acc = 1;
//            getImage().scale(50, 70);
//            //setImage("p1_walk1.png");
//        }
//
//        if (Greenfoot.isKeyDown("2")) {
//            player = 2;
//            acc = 0.7;
//            getImage().scale(60, 90);
//            //setImage("p1_stand.png");
//        }
//
//        if (Greenfoot.isKeyDown("3")) {
//            player = 3;
//            acc = 1.5;
//            getImage().scale(35, 50);
//            //setImage("p1_walk6.png");
//        }
//
//        if (Greenfoot.isKeyDown("9")) {
//            setLocation(300, 200);
//        }
//
//        if (Greenfoot.isKeyDown("0")) {
//            setLocation(4000, 400);
//        }

        /*
        if (Greenfoot.isKeyDown("4")) {
            keyCollectRed = true;
            keyCollectBlue = true;
            keyCollectGreen = true;
        }
         */
        if (Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new StartScreen());
        }

      //  if (Greenfoot.isKeyDown("e")) {
     //       Greenfoot.setWorld(new MyWorld());
     //   }

//        if (Greenfoot.isKeyDown("u")) {
//            Greenfoot.setWorld(new MyWorld2());
//        }
        /*
            if (world == 1) {
                world = 2;
                Greenfoot.setWorld(new MyWorld2());
            } else if (world == 2) {
                world = 1;
                Greenfoot.setWorld(new MyWorld());
            }
         */

 /*
        if (Greenfoot.isKeyDown("1")) {
            setImage("p1_walk1.png");
        }
        
        if (Greenfoot.isKeyDown("2")) {
            setImage("p2_walk1.png");
        }
        
        if (Greenfoot.isKeyDown("3")) {
            setImage("p3_walk1.png");
        }
         */
        for (Tile tile : getIntersectingObjects(Tile.class)) {
            if (tile != null) {
                if (tile.getImage().toString().contains("star") && tile.getImage().getTransparency() != 0) {
                    removeTile(tile);
                    this.counter.addCoin();

                } else if (tile.getImage().toString().contains("keyBlue") && tile.getImage().getTransparency() != 0) {
                    removeTile(tile);
                    keyCollectBlue = true;
                    // Loop door alle tiles die de world vast houd
                    for (Tile doorTile : getWorld().getObjects(Tile.class)) {
                        // als de tile die ik heb gevonden (doorTile) het plaatje lock_blue bevat dan
                        if (doorTile.getImage().toString().contains("lock_blue")) {
                            // Verwijder uit de wereld
                            removeTile(doorTile);

                        }
                    }
                } else if (tile.getImage().toString().contains("keyRed") && tile.getImage().getTransparency() != 0) {
                    removeTile(tile);
                    keyCollectRed = true;
                    // Loop door alle tiles die de world vast houd
                    for (Tile doorTile : getWorld().getObjects(Tile.class)) {
                        // als de tile die ik heb gevonden (doorTile) het plaatje lock_blue bevat dan
                        if (doorTile.getImage().toString().contains("lock_red")) {
                            // Verwijder uit de wereld
                            removeTile(doorTile);

                        }
                    }
                } else if (tile.getImage().toString().contains("keyGreen") && tile.getImage().getTransparency() != 0) {
                    removeTile(tile);
                    keyCollectGreen = true;
                    for (Tile doorTile : getWorld().getObjects(Tile.class)) {
                        // als de tile die ik heb gevonden (doorTile) het plaatje lock_blue bevat dan
                        if (doorTile.getImage().toString().contains("lock_green")) {
                            // Verwijder uit de wereld
                            removeTile(doorTile);

                        }
                    }
                }
            }
        }

        for (Tile tile
                : getIntersectingObjects(Tile.class
                )) {
            //Tile tile = (Tile) actor;
            if (tile.getImage().toString().contains("Water")) {

                while (pause != 0) {
                    geraakt = true;

                    setImage("p" + player + "_hurt.png");

                    heartFull = true;

                    pause--;
                    return;
                }
                pause = 50;

                setLocation(300, 200);
                setImage("p1.png");
                geraakt = false;

                levens--;
                System.out.println(levens);
            }

            if (tile.getImage().toString().contains("spikes")) {

                while (pause != 0) {
                    geraakt = true;

                    setImage("p" + player + "_hurt.png");

                    heartFull = true;

                    pause--;
                    return;
                }
                pause = 50;

                setLocation(300, 200);
                setImage("p1.png");
                geraakt = false;

                levens--;
                System.out.println(levens);
            }

            if (levens == 0) {
                setLocation(300, 200);
                levens = 1;
                //getWorld().removeObject(this);
                return;

            }
            continue;
        }

        updateOnGroundStats();

        handleInput();

        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }

        applyVelocity();

        for (Actor enemy
                : getIntersectingObjects(Enemy.class
                )) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }

        for (Actor enemy2
                : getIntersectingObjects(Enemy2.class
                )) {
            if (enemy2 != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }

    private double invert(double x) {
        return x * -1;
    }

    private void updateOnGroundStats() {
        int dx = getImage().getWidth() / 2;
        int dy = getImage().getHeight() / 2 + 1;

        //checks if here is not going up or down
        if (velocityY != 0) {
            isOnGround = false;
            return;

        }
        //checks tile exacly under hero
        for (Tile tile : getObjectsAtOffset(0, dy, Tile.class
        )) {
            if (tile.isSolid) {
                isOnGround = true;
            }
            break;

        }
        //checks if hero is on the edge of a block
        if (!isOnGround) {
            for (Tile tile : getObjectsAtOffset(dx - 3, dy, Tile.class
            )) {
                if (tile.isSolid) {
                    isOnGround = true;
                }
                break;

            }
            if (!isOnGround) {
                for (Tile tile : getObjectsAtOffset(dx * -1 + 3, dy, Tile.class
                )) {
                    if (tile.isSolid) {
                        isOnGround = true;
                    }
                    break;
                }
            }
        }
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            if (isOnGround) {
                velocityY = -17;
                animationJump(getWidth(), getHeight(), 2);
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            direction = "left";
            animationWalk(getWidth(), getHeight(), player);
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            direction = "right";
            animationWalk(getWidth(), getHeight(), player);
        } else {
            animationStand(getWidth(), getHeight(), player);
        }
    }

    public void animationWalk(int width, int heigth, int player) {
        if (status == 2) {
            if (walkStatus >= 11) {
                walkStatus = 1;
            }
            if (isOnGround) {
                setImage("p" + player + "_walk"
                        + walkStatus + ".png");
            } else {
                setImage("p" + player + "_jump.png");
            }
            mirror();
            walkStatus++;
            status = 0;
        } else {
            status++;
        }
        getImage().scale(width, heigth);
    }

    public void animationJump(int width, int heigth, int player) {
        setImage("p" + player + "_jump.png");
        mirror();
        getImage().scale(width, heigth);
    }

    public void animationStand(int width, int heigth, int player) {
        if (isOnGround) {
            setImage("p" + player + "_walk1.png");
            getImage().scale(width, heigth);
            walkStatus = 1;
        } else {
            setImage("p" + player + "_jump.png");
        }
        mirror();
        getImage().scale(width, heigth);
    }

    public void mirror() {
        if (direction.equals("left")) {
            getImage().mirrorHorizontally();

        }

    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

}

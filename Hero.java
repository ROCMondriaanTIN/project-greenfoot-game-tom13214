
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    static boolean heartFull;

    private final double gravity;
    private final double acc;
    private final double drag;
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

    private int width;

    private boolean isOnGround;

    private boolean isTouching;

    private int walkStatus;

    private int status = 0;

    private String direction = "right";

    private int walking = 1;

    private String richting = "right";

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
    public static boolean keyNotFound = false;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;

        walkIm1 = new GreenfootImage("p2_walk1.png");
        walkIm2 = new GreenfootImage("p2_walk2.png");
        walkIm3 = new GreenfootImage("p2_walk3.png");
        walkIm4 = new GreenfootImage("p2_walk4.png");
        walkIm5 = new GreenfootImage("p2_walk5.png");
        walkIm6 = new GreenfootImage("p2_walk6.png");
        walkIm7 = new GreenfootImage("p2_walk7.png");
        walkIm8 = new GreenfootImage("p2_walk8.png");
        walkIm9 = new GreenfootImage("p2_walk9.png");
        walkIm10 = new GreenfootImage("p2_walk10.png");
        walkIm11 = new GreenfootImage("p2_walk11.png");

        //P1 = new GreenfootImage("p1_walk01");
        //P2 = new GreenfootImage("p2_walk01");
        //P3 = new GreenfootImage("p3_walk01");
        setImage("p2_stand.png");
    }

    private void removeTile(Tile tile) {
        tile.getImage().setTransparency(0);
        tile.isSolid = false;
    }

    @Override
    public void act() {
        for (Tile tile : getIntersectingObjects(Tile.class)) {

            if (tile.getImage().toString().contains("keyBlue")) {
                removeTile(tile);
            }

            if (tile.getImage().toString().contains("keyRed")) {
                removeTile(tile);
            }

            if (tile.getImage().toString().contains("keyGreen")) {
                removeTile(tile);
            }

        }

        if (Greenfoot.isKeyDown("p")) {
            velocityY = -20;
        }

        if (Greenfoot.isKeyDown("i")) {
            levens = 1;
        }

        if (Greenfoot.isKeyDown("o")) {
            levens = 2;
        }

        if (Greenfoot.isKeyDown("u")) {
            levens = 0;
        }

        if (Greenfoot.isKeyDown("z")) {
            setImage("p2_walk1.png");
        }

        if (Greenfoot.isKeyDown("x")) {
            setImage("p2_stand.png");
        }

        if (Greenfoot.isKeyDown("c")) {
            setImage("p2_walk6.png");
        }

        for (Tile tile : getIntersectingObjects(Tile.class)) {
            if (tile != null) {
                if (tile.getImage().toString().contains("coinGold")) {
                    removeTile(tile);

                } else if (tile.getImage().toString().contains("keyBlue")) {
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
                } else if (tile.getImage().toString().contains("keyRed")) {
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
                } else if (tile.getImage().toString().contains("keyGreen")) {
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

        for (Tile tile : getIntersectingObjects(Tile.class)) {
            //Tile tile = (Tile) actor;
            if (tile.getImage().toString().contains("Water")) {

                while (pause != 0) {
                    geraakt = true;

                    setImage("p1_hurt.png");
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
                getWorld().removeObject(this);

            }
            continue;
        }
        onGroundHandler();
        handleInput();

        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }

    private double invert(double x) {
        return x * -1;
    }

    private void onGroundHandler() {
        width = getImage().getWidth() / 2;

        Boolean successRate = false;

        for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class)) {
            if (tile.isSolid) {
                successRate = true;
            }
        }
        if (!successRate) {
            for (Tile tile : getObjectsAtOffset(this.width - 3, getImage().getHeight() / 2 + 1, Tile.class)) {
                if (tile.isSolid) {
                    successRate = true;
                }
            }
            if (!successRate) {
                for (Tile tile : getObjectsAtOffset((int) invert(this.width) + 3, getImage().getHeight() / 2 + 1, Tile.class)) {
                    if (tile.isSolid) {
                        successRate = true;
                    }
                }
            }
        }

        for (Tile tile : getObjectsAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class)) {
            if (tile.isSolid) {
                successRate = true;
            }
        }
        isOnGround = successRate;
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
            animationWalk(getWidth(), getHeight(), 2);
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            direction = "right";
            animationWalk(getWidth(), getHeight(), 2);
        } else {
            animationStand(getWidth(), getHeight(), 2);
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

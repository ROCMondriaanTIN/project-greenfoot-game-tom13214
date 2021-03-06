import greenfoot.*;

/**
 *
 * @author Tom Vollebregt
 */
public class CoinCounter extends Actor {
    
    private int count = 0;
    
    public CoinCounter() {
        super();
        setImage("hud_0.png");
    }
    
    public void addCoin() {
        count++;
        if(count > 9) {
            count = 0;
        }
        setImage("hud_" + count + ".png");
    }
}

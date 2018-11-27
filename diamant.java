
public class diamant extends Mover {

    public diamant() {
        getImage().setTransparency(0);
    }

    @Override
    public void act() {
        if (Hero.collectGem == true) {
            setImage("hud_gem_blue.png");
        }
    }
    
}

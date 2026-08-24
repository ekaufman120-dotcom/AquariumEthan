public class AnimatedProp extends Prop {

    private String symbol1;
    private String symbol2;
    private int animationFrame;

    public AnimatedProp(String name, int position, String symbol1, String symbol2) {
        super(name, position, "If you're seeing this, an error has occured in AnimatedProp.java.");
        this.symbol1 = symbol1;
        this.symbol2 = symbol2;
        this.animationFrame = 1;
    }

    @Override
    public String getSymbol() {
        if(animationFrame <= 4) {
            animationFrame += 1;
            return symbol1;
        } 
        else if(animationFrame < 8)
        {
            animationFrame += 1;
            return symbol2;
        }
        else
        {
            animationFrame = 1;
            return symbol2;
        }
    }
}

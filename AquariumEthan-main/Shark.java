public class Shark extends Fish {
    public Shark(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException  {
        super(name, position, 2*speed, direction, symbol);
    }
}
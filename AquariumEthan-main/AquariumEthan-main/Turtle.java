public class Turtle extends Fish {

    private boolean movedLast;

    public Turtle(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException  {
        super(name, position, speed, direction, symbol);
        movedLast = false;
    }

    @Override
    public void move(int tankWidth) {
        if(movedLast)
        {
            movedLast = false;
        }
        else
        {
            position += speed * direction;
            keepInsideTank(tankWidth);
            movedLast = true;
        }
    }
}

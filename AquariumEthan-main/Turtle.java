public class Turtle extends SeaCreature {

    private String symbol;
    private boolean movedLast;

    public Turtle(String name, int position, int speed, int direction, String symbol) {
        super(name, position, speed, direction);
        this.symbol = symbol;
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

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    private String reverseSymbol(String text) {
        String temp = new StringBuilder(text).reverse().toString();
        String result = "";
        for(int i = 0; i < temp.length(); i++)
        {
            if(temp.charAt(i) == '(')
                result += ")";
            else if(temp.charAt(i) == ')')
                result += "(";
            else if(temp.charAt(i) == '<')
                result += ">";
            else if(temp.charAt(i) == '>')
                result += "<";
            else
                result += temp.charAt(i);
        }
        return result;
    }
}

public class Fish extends SeaCreature {

    private String symbol;

    public Fish(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        if (symbol == null || symbol.equals("")) {
            throw new InvalidCreatureException("Error: Fish is invisible.");
        }
        this.symbol = symbol;
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);
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

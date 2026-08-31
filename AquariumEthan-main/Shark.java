public class Shark extends SeaCreature {

    private String symbol;

    public Shark(String name, int position, int speed, int direction, String symbol) {
        super(name, position, speed, direction);
        this.symbol = symbol;
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction * 2;
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

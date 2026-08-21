public class Prop extends SeaCreature {

    private String symbol;

    public Prop(String name, int position, String symbol) {
        super(name, position, 0, 1);
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

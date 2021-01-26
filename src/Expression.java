public class Expression {
    private int a;
    private int b;
    private double result;
    private char operation;
    private boolean ofRim = false;

    private final static String REGEX = "(((10)|[1-9])[+*-/]((10)|[1-9]))|(((V?I{1,3})|(I?(V|X)))[+*-/]((V?I{1,3})|(I?(V|X))))";
    private final static String RIM_REGEX = "(V?I{1,3})|(I?(V|X))";

    Expression(String expression) throws Exception{
        if (expression.matches(REGEX)) {
            String[] temp = expression.split("[+*-/]");
            operation = expression.charAt(temp[0].length());
            a = getNumber(temp[0]);
            b = getNumber(temp[1]);
        } else {
            throw new Exception("Выражение введено неверно!!!");
        }
    }

    private int getNumber(String number) {
        if (number.matches(RIM_REGEX)) {
            ofRim = true;
            return RimNumber.valueOf(number).toNumber();
        }
        return Integer.parseInt(number);
    }

    public String getResult() throws Exception{
        double temp = 0;
        switch (operation) {
            case('-'):
                temp = a - b;
                break;
            case('+'):
                temp = a + b;
            break;
            case('*'):
                temp = a * b;
            break;
            case('/'):
                temp = (double) a / b;
            break;
        }

        if (ofRim) {
            if (temp % 1 != 0) throw new Exception("Ответ дробное число, невозможно перевести в римские цифры!!!");
            return RimNumber.getRim((int) temp);
        }
        return String.valueOf(temp);

    }
}

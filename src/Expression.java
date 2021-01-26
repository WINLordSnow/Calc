public class Expression {
    private final int a;
    private final int b;
    private double result;
    private final char operation;
    private boolean ofRim = false;

    private final static String REGEX = "(((10)|[1-9])[+*-/]((10)|[1-9]))|(((V?I{1,3})|(I?[VX]))[+*-/]((V?I{1,3})|(I?[VX])))";
    private final static String RIM_REGEX = "(V?I{1,3})|(I?[VX])";

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
        switch (operation) {
            case ('-') -> result = a - b;
            case ('+') -> result = a + b;
            case ('*') -> result = a * b;
            case ('/') -> result = (double) a / b;
        }

        if (ofRim) {
            if (result % 1 != 0) throw new Exception("Ответ дробное число, невозможно перевести в римские цифры!!!");
            return RimNumber.getRim((int) result);
        }
        return String.valueOf(result);

    }
}

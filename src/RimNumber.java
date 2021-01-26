enum RimNumber {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);
    private int number;

    RimNumber(int number) {
        this.number = number;
    }

    public int toNumber() {
        return number;
    }

    static String getRim(int number) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < number / 100; i++) {
            temp.append("C");
        }
        number -= (number / 100) * 100;
        if (number >= 90) {
            temp.append("XC");
            number -= 90;
        }
        for (int i = 0; i < (number % 100) / 50; i++) {
            temp.append("L");
        }
        number -= (number / 50) * 50;
        if (number >= 40) {
            temp.append("XL");
            number -= 40;
        }
        for (int i = 0; i < (number % 50) / 10; i++) {
            temp.append("X");
        }
        for (RimNumber rim : RimNumber.values()) {
            if ((number % 10) == rim.ordinal() + 1) {
                temp.append(rim.toString());
            }
        }
        return temp.toString();
    }
}
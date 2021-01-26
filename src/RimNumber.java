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
    private final int number;

    RimNumber(int number) {
        this.number = number;
    }

    public int toNumber() {
        return number;
    }

    static String getRim(int number) {
        StringBuilder temp = new StringBuilder();
        temp.append("C".repeat(Math.max(0, number / 100)));
        number -= (number / 100) * 100;
        if (number >= 90) {
            temp.append("XC");
            number -= 90;
        }
        temp.append("L".repeat(Math.max(0, (number % 100) / 50)));
        number -= (number / 50) * 50;
        if (number >= 40) {
            temp.append("XL");
            number -= 40;
        }
        temp.append("X".repeat(Math.max(0, (number % 50) / 10)));
        for (RimNumber rim : RimNumber.values()) {
            if ((number % 10) == rim.ordinal() + 1) {
                temp.append(rim.toString());
            }
        }
        return temp.toString();
    }
}
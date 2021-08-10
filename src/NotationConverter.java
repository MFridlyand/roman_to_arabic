public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        validateInput(romanNotation);
        int prev = 0;
        int arabic = 0;
        for (char c : romanNotation.toCharArray()) {
            int cur = charToInt(c);
            if (cur > prev) {
                // subtract previous * 2 because previous was added to arabic
                // once already
                arabic += cur - (prev * 2);
            } else {
                // if current is less than or equal to previous then add it to
                // arabic
                arabic += cur;
            }
            prev = cur;
        }
        return arabic;
    }

    private static int charToInt(char c) {
        switch (c) {
            case ('I'):
                return 1;
            case ('V'):
                return 5;
            case ('X'):
                return 10;
            case ('L'):
                return 50;
            case ('C'):
                return 100;
            case ('D'):
                return 500;
            case ('M'):
                return 1000;
        }
        return -1;
    }

    private static char getValidLowerPredecessor(char c) {
        switch (c) {
            case ('V'):
            case ('X'):
                return 'I';
            case ('L'):
            case ('C'):
                return 'X';
            case ('D'):
            case ('M'):
                return 'C';
        }
        return '#';
    }

    private static void validateInput(String roman) {
        String errorMsg = "String must contain only valid roman numerals + [I, V, X, L, C, D, M].";
        char[] symbols = roman.toCharArray();
        for (char c : symbols) {
            if (charToInt(c) == -1)
                throw new InvalidValueException(errorMsg);
        }

        for (int i = 1; i < symbols.length; i++) {
            if (charToInt(symbols[i - 1]) < charToInt(symbols[i])
                    && getValidLowerPredecessor(symbols[i]) != symbols[i - 1])
                throw new InvalidValueException(errorMsg);
        }
    }
}

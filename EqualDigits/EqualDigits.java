class EqualDigits {
    public static void main(String[] args) {
//        String str = "66644319333";
//        String str = "999433";
        String str = "8166";
        System.out.println(solve(str));
    }

    public static String solve(String strs) {
        StringBuilder str = new StringBuilder();
        str.append(strs);
        StringBuilder result = new StringBuilder();
        int count = 0;
        char z = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (z == c) {
                count++;
                if (i == str.length() - 1)
                    result.append(Integer.toString(count * (Character.getNumericValue(str.charAt(i)))));
            } else {
                if (i == str.length() - 1) {
                    result.append(Integer.toString(count * (Character.getNumericValue(str.charAt(i - 1)))));
                    result.append(Integer.toString((Character.getNumericValue(str.charAt(i)))));
                } else {
                    result.append(Integer.toString(count * (Character.getNumericValue(str.charAt(i - 1)))));
                    count = 0;
                    z = str.charAt(i);
                    i--;
                }

            }
        }
        String temp = result.toString();
        if (equalNumbers(result.toString())) {
            result.setLength(0);
            result.append(solve(temp));
        }
        return result.toString();
    }

    public static Boolean equalNumbers(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return true;
        }
        return false;
    }
}

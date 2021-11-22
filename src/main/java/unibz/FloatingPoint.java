package unibz;

public class FloatingPoint {

    public static String floatToBinary(String number) {
        float num = Float.parseFloat(number);
        byte sign;
        if (num > 0.0F) {
            sign = 0;
        } else {
            sign = 1;
        }

        int integerPart = Math.abs((int) num);
        float floatingPart = Math.abs(num % 1.0F);

        String integerPartBinary = Functions.decimalToBinary(Integer.toString(integerPart));
        String floatingPartBinary = computeFloatingPartBinary(floatingPart);
        String mantissa = computeMantissa(integerPart, integerPartBinary, floatingPartBinary);

        int exponent = computeExponent(integerPart, integerPartBinary, floatingPartBinary);

        String exponentToBinary = computeExponentToBinary(exponent);

        return sign + " " + exponentToBinary + " " + mantissa;
    }

    private static String computeFloatingPartBinary(float floatingPart) {
        StringBuilder floatingPartBinary = new StringBuilder();

        for (int i = 1; i <= 252; ++i) {
            floatingPart *= 2.0F;
            if (floatingPart >= 1.0F) {
                floatingPartBinary.append(1);
            } else {
                floatingPartBinary.append(0);
            }

            if (floatingPart >= 1.0F) {
                --floatingPart;
            }
        }

        return floatingPartBinary.toString();
    }

    private static int computeExponent(int integerPart, String integerPartBinary, String floatingPartBinary) {
        int exponent = 127;
        if (integerPart > 0) {
            exponent += integerPartBinary.length() - 1;
        } else {
            int i;
            for (i = 0; floatingPartBinary.charAt(i) != '1'; ++i) {
                --exponent;
            }

            if (floatingPartBinary.charAt(i) == '1') {
                --exponent;
            }
        }

        return exponent;
    }

    private static String computeMantissa(int integerPart, String integerPartBinary, String floatingPartBinary) {
        String mantissa;

        if (integerPart > 0) {
            mantissa = integerPartBinary.substring(1) + floatingPartBinary;
        } else {
            int index = 0;

            while (floatingPartBinary.charAt(index) != '1')
                index++;

            mantissa = floatingPartBinary.substring(index + 1);
        }

        if (mantissa.length() > 23) {
            mantissa = mantissa.substring(0, 23);
        }

        return mantissa;
    }

    public static String floatToHexadecimal(String number) {
        StringBuilder input = new StringBuilder();
        String numberToBinary = floatToBinary(number);

        for (int i = 0; i < numberToBinary.length(); ++i) {
            if (numberToBinary.charAt(i) != ' ') {
                input.append(numberToBinary.charAt(i));
            }
        }

        return Functions.binaryToHexadecimal(input.toString());
    }

    private static String computeExponentToBinary(int exponent) {
        if (exponent < 1)
            throw new NumberFormatException("ERROR, VALUE OUT OF RANGE");

        StringBuilder exponentToBinary = new StringBuilder(Functions.decimalToBinary(Integer.toString(exponent)));

        if (exponentToBinary.length() < 8) {
            while (exponentToBinary.length() != 8) {
                exponentToBinary.insert(0, "0");
            }
        }

        return exponentToBinary.toString();
    }

    public static String binaryToFloat(String number) {
        StringBuilder input = new StringBuilder();

        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) != ' ') {
                input.append(number.charAt(i));
            }
        }

        if (input.length() != 32)
            throw new NumberFormatException("ERROR, WRONG INPUT...");

        boolean sign = input.charAt(0) != '0';

        int exponent = Integer.parseInt(Functions.binaryToDecimal(input.substring(1, 9))) - 127;
        int integerPart = computeIntegerPart(input, exponent);

        String floatingPartBinary = computeFloatingPartBinary(input, exponent);

        float floatingPart = computeFloatingPart(floatingPartBinary);
        float finalNumber = computeFloatingNumberWithSign(sign, integerPart, floatingPart);

        return Float.toString(finalNumber);
    }

    private static int computeIntegerPart(StringBuilder input, int exponent) {
        if (exponent >= 0) {
            String integerPartBinary = "1" + input.substring(9, 9 + exponent);
            return Integer.parseInt(Functions.binaryToDecimal(integerPartBinary));
        } else {
            return 0;
        }
    }

    private static String computeFloatingPartBinary(StringBuilder input, int exponent) {
        StringBuilder floatingPartBinary;
        if (exponent >= 0) {
            floatingPartBinary = new StringBuilder(input.substring(9 + exponent));
        } else {
            floatingPartBinary = new StringBuilder("1" + input.substring(9));

            for (int i = 1; i < Math.abs(exponent); ++i) {
                floatingPartBinary.insert(0, "0");
            }
        }

        return floatingPartBinary.toString();
    }

    private static float computeFloatingPart(String floatingPartBinary) {
        float floatingPart = 1.0F;
        boolean startDecrease = false;

        for (int i = floatingPartBinary.length() - 1; i >= 0; --i) {
            if (startDecrease && floatingPartBinary.charAt(i) == '1') {
                ++floatingPart;
            }

            if (floatingPartBinary.charAt(i) == '1') {
                startDecrease = true;
            }

            if (startDecrease) {
                floatingPart /= 2.0F;
            }
        }

        return floatingPart;
    }

    private static float computeFloatingNumberWithSign(boolean sign, int integerPart, float floatingPart) {
        if (!sign) {
            return (float) integerPart + floatingPart;
        } else {
            return -1.0F * ((float) integerPart + floatingPart);
        }
    }

    public static String hexadecimalToFloat(String number) {
        if (number.length() != 8) {
            throw new NumberFormatException("ERROR, WRONG INPUT...");
        } else {
            StringBuilder inputToBinary = new StringBuilder(Functions.hexadecimalToBinary(number));
            if (inputToBinary.length() < 32) {
                while (inputToBinary.length() < 32) {
                    inputToBinary.insert(0, "0");
                }
            }

            return binaryToFloat(inputToBinary.toString());
        }
    }
}


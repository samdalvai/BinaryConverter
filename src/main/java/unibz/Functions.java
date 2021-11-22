package unibz;

import java.util.Objects;

public class Functions {

    public static String decimalToBinary(String number) {
        long num = Long.parseLong(number);
        if (num == 0L) {
            return "0";
        } else {
            String output;
            for (output = ""; num != 0L; num /= 2L) {
                output = num % 2L + output;
            }

            return output;
        }
    }

    public static String decimalToHexadecimal(String number) {
        long num = Long.parseLong(number);
        if (num == 0L) {
            return "0";
        } else {
            String output;
            for (output = ""; num != 0L; num /= 16L) {
                if (num % 16L == 10L) {
                    output = "A" + output;
                } else if (num % 16L == 11L) {
                    output = "B" + output;
                } else if (num % 16L == 12L) {
                    output = "C" + output;
                } else if (num % 16L == 13L) {
                    output = "D" + output;
                } else if (num % 16L == 14L) {
                    output = "E" + output;
                } else if (num % 16L == 15L) {
                    output = "F" + output;
                } else {
                    output = num % 16L + output;
                }
            }

            return output;
        }
    }

    public static String decimalToOctal(String number) {
        long num = Long.parseLong(number);
        if (num == 0L) {
            return "0";
        } else {
            String output;
            for (output = ""; num != 0L; num /= 8L) {
                output = num % 8L + output;
            }

            return output;
        }
    }

    public static String binaryToDecimal(String number) {
        if (Objects.equals(number, "0")) {
            return "0";
        } else {
            String input = number;
            long output = 0L;
            int loopStop = number.length();

            for (int i = 0; i < loopStop; ++i) {
                if (input.charAt(0) != '0') {
                    if (input.charAt(0) != '1') {
                        return "ERROR, INVALID INPUT...";
                    }

                    output = (long) ((double) output + Math.pow(2.0D, loopStop - i - 1));
                }
                input = input.substring(1);
            }

            return Long.toString(output);
        }
    }

    public static String binaryToHexadecimal(String number) {
        return decimalToHexadecimal(binaryToDecimal(number));
    }

    public static String binaryToOctal(String number) {
        return decimalToOctal(binaryToDecimal(number));
    }

    public static String hexadecimalToDecimal(String number) {
        if (Objects.equals(number, "0")) {
            return "0";
        } else {
            String input = number.toUpperCase();
            long output = 0L;
            int loop_stop = input.length();

            for (int i = 0; i < loop_stop; ++i) {
                if (input.charAt(0) == 'A') {
                    output = (long) ((double) output + 10.0D * Math.pow(16.0D, loop_stop - i - 1));
                    input = input.substring(1);
                } else if (input.charAt(0) == 'B') {
                    output = (long) ((double) output + 11.0D * Math.pow(16.0D, loop_stop - i - 1));
                    input = input.substring(1);
                } else if (input.charAt(0) == 'C') {
                    output = (long) ((double) output + 12.0D * Math.pow(16.0D, loop_stop - i - 1));
                    input = input.substring(1);
                } else if (input.charAt(0) == 'D') {
                    output = (long) ((double) output + 13.0D * Math.pow(16.0D, loop_stop - i - 1));
                    input = input.substring(1);
                } else if (input.charAt(0) == 'E') {
                    output = (long) ((double) output + 14.0D * Math.pow(16.0D, loop_stop - i - 1));
                    input = input.substring(1);
                } else if (input.charAt(0) == 'F') {
                    output = (long) ((double) output + 15.0D * Math.pow(16.0D, loop_stop - i - 1));
                    input = input.substring(1);
                } else {
                    if (!Character.isDigit(input.charAt(0))) {
                        return "ERROR, INVALID INPUT...";
                    }

                    output = (long) ((double) output + (double) Character.getNumericValue(input.charAt(0)) * Math.pow(16.0D, loop_stop - i - 1));
                    input = input.substring(1);
                }
            }

            return Long.toString(output);
        }
    }

    public static String hexadecimalToBinary(String number) {
        return decimalToBinary(hexadecimalToDecimal(number));
    }

    public static String hexadecimalToOctal(String number) {
        return decimalToOctal(hexadecimalToDecimal(number));
    }

    public static String octalToDecimal(String number) {
        if (Objects.equals(number, "0")) {
            return "0";
        } else {
            String input = number;
            long output = 0L;
            int loopStop = number.length();

            for (int i = 0; i < loopStop; ++i) {
                if (!Character.isDigit(input.charAt(0)) || Character.getNumericValue(input.charAt(0)) < 0 || Character.getNumericValue(input.charAt(0)) > 7) {
                    return "ERROR, INVALID INPUT...";
                }

                output = (long) ((double) output + (double) Character.getNumericValue(input.charAt(0)) * Math.pow(8.0D, loopStop - i - 1));
                input = input.substring(1);
            }

            return Long.toString(output);
        }
    }

    public static String octalToBinary(String number) {
        return decimalToBinary(octalToDecimal(number));
    }

    public static String octalToHexadecimal(String number) {
        return decimalToHexadecimal(octalToDecimal(number));
    }
}

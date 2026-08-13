// WAP to declare all primitive data types and their minimum and maximum values
public class Variables {
    public static void main(String[] args) {
        // byte
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("byte: " + minByte + " to " + maxByte);

        // short
        short minShort = Short.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;
        System.out.println("short: " + minShort + " to " + maxShort);

        // int
        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        System.out.println("int: " + minInt + " to " + maxInt);

        // long
        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;
        System.out.println("long: " + minLong + " to " + maxLong);

        // float
        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;
        System.out.println("float: " + minFloat + " to " + maxFloat);

        // double
        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println("double: " + minDouble + " to " + maxDouble);

        // char
        char minChar = Character.MIN_VALUE;
        char maxChar = Character.MAX_VALUE;
        System.out.println("char: " + (int) minChar + " to " + (int) maxChar);

        // boolean
        boolean trueValue = true;
        boolean falseValue = false;
        System.out.println("boolean: " + trueValue + " to " + falseValue);
    }
}
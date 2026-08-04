// WAP to declare variables of all primitive data types in Java and print their default values

public class primitive_defaults {
    static byte defByte;
    static short defShort;
    static int defInt;
    static long defLong;
    static float defFloat;
    static double defDouble;
    static char defChar;
    static boolean defBoolean;

    public static void main(String[] args) {
        System.out.println("byte default: " + defByte);
        System.out.println("short default: " + defShort);
        System.out.println("int default: " + defInt);
        System.out.println("long default: " + defLong);
        System.out.println("float default: " + defFloat);
        System.out.println("double default: " + defDouble);
        System.out.println("char default: " + (int) defChar);
        System.out.println("boolean default: " + defBoolean);
    }
}

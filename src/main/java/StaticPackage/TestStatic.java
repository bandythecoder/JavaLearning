package StaticPackage;

public class TestStatic {
    static int a;
    static int b;

    static
    {
        a = 10;
        b = 20;
    }

    public static int getA()
    {
        return a;
    }

    public static void increment()
    {
        a++;
    }
}

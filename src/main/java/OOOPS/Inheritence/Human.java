package OOOPS.Inheritence;

public class Human extends Species
{
    String name;

    public String Name()
    {
        return name;
    }

    public Human(String name, int age)
    {
        super(age);
        this.name = name;
    }

    public Human(Human old)
    {
        super(old);
        this.name = old.name;
    }
}

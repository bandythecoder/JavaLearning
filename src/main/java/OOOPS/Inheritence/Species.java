package OOOPS.Inheritence;

public class Species {
    int age;

    public int getAge()
    {
        return age;
    }

    public Species(int age) {
        this.age = age;
    }

    Species(Species old)
    {
        this.age = old.age;
    }
}

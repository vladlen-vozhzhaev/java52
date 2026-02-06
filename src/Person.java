// hp персонажа не может превышать 100 единиц
public class Person {
    public String name;
    private int hp;
    public static int mark = 100;

    public Person(String name) {
        this.name = name;
        this.hp = 100;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (this.hp + hp >= 100) this.hp = 100;
        else this.hp += hp;
    }
}

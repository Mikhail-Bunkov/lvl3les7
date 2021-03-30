package lesson;

public class Cat {

    public String name;
    int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public final void info(){
        System.out.printf(" %s %d %s \n",name, age, color);
    }
    private void meow(){
        System.out.println(name + " meow");
    }
}

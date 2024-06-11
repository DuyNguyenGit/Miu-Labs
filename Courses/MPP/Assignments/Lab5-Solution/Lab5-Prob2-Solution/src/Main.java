public class Main {
    public static void main(String[] args) {
        Duck[] ducks = {new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()};
        for (Duck d : ducks) {
            System.out.println(d.getClass().getSimpleName() + ":");
            System.out.print("\t");
            d.display();
            System.out.print("\t");
            d.fly();
            System.out.print("\t");
            d.quack();
            System.out.print("\t");
            d.swim();
        }
    }
}
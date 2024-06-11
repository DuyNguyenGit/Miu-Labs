public class Duck {
    private QuackBehavior quackBehavior;
    private FlyBehavior flyBehavior;

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void display() {
        System.out.println("displaying");
    }
    public void swim() {
        System.out.println("swimming");
    }

    public void quack() {
        quackBehavior.quack();
    }
    public void fly() {
        flyBehavior.fly();
    }
}

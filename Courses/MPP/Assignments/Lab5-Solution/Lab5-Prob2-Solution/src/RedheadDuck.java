public class RedheadDuck extends Duck{

    public RedheadDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }
}

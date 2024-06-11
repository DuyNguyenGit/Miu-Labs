public class CannotFly implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("cannot fly");
    }
}

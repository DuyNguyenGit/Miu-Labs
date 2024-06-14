public class Main {
    public static void main(String[] args) {
        MySingletonLazy mySingletonLazy1 = MySingletonLazy.getInstance();
        MySingletonLazy mySingletonLazy2 = MySingletonLazy.getInstance();
        System.out.println(mySingletonLazy1.equals(mySingletonLazy2));
    }
}
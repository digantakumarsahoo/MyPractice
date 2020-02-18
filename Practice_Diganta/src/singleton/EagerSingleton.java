package singleton;

public class EagerSingleton {
    private static EagerSingleton singleton = new EagerSingleton();
    private EagerSingleton(){

    }
    public static EagerSingleton getInstance(){
        return singleton;
    }

}
class LazySingleton {
    private static LazySingleton singleton ;
    private LazySingleton() {
    }
    public static LazySingleton getInstance(){
        if(singleton == null){
            singleton=new LazySingleton();
        }
        return singleton;
    }
}
class DoubleCheckSingleton {
    private static DoubleCheckSingleton singleton;
    private DoubleCheckSingleton(){

    }
    public static DoubleCheckSingleton getInstance(){
        if(singleton == null){
            synchronized (DoubleCheckSingleton.class){
                if(singleton == null){
                    singleton=new DoubleCheckSingleton();
                }
            }

        }
        return singleton;
    }
}
class BillPughSingleton {
    private BillPughSingleton(){}
    private static class SingletonHelper {
        private static final BillPughSingleton singleton = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return SingletonHelper.singleton;
    }

    public static void main(String[] args) {
        System.out.println(BillPughSingleton.getInstance());
        System.out.println(BillPughSingleton.getInstance());
    }
}
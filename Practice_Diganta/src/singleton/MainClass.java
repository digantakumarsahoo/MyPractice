package singleton;

import java.lang.reflect.Constructor;

public class MainClass {
    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.SINGLETON;
        EnumSingleton singleton2 =null;
        EnumSingleton.SINGLETON.doSomething();
        System.out.println(singleton);
        System.out.println(singleton.nameVar);
        Constructor<?>[] declaredConstructors = EnumSingleton.class.getDeclaredConstructors();
        for (Constructor constructor:declaredConstructors
             ) {
            constructor.setAccessible(true);
            singleton2=EnumSingleton.SINGLETON;
            singleton2.nameVar="123";
            break;
        }
        System.out.println(singleton2.nameVar);
        System.out.println(singleton.nameVar);
    }

}

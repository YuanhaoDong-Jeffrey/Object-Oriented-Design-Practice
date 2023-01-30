package SingletonPattern;

/**
 * A basic way to implement Singleton pattern in Java
 *
 * @author Jeffrey Dong
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}


/**
 * A thread-safe version of Singleton Pattern in Java
 * The synchronization is only done when the instance is null,
 * which reduces the number of unnecessary lock acquisitions,
 * thus improving performance.
 *
 * @author Jeffrey Dong
 */
class ThreadSafeSingleton {
    // The volatile keyword is used to ensure that the value of the instance variable is consistently visible to all threads.
    private volatile static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        // The first check is used to avoid the synchronized block in the case that the instance has been created
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                // The reason for the second check is to ensure that the instance is still null after the thread has acquired the lock.
                // Without the second check, it's possible that another thread could have entered the synchronized block and created an instance after the first check,
                // but before the current thread acquired the lock.
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }

        return instance;
    }
}

class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);

        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstance();

        System.out.println(threadSafeSingleton1 == threadSafeSingleton2);
    }
}

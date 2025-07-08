package Ch7AdvancedJavaTopic;
class Singleton {
    // Step 1: private static instance
    private static Singleton instance;

    // Step 2: private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // Step 3: public static method to return the single instance (Thread-safe)
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonDemo{
    public static void main(String[] args){
        Singleton obj = Singleton.getInstance();
        Singleton obj1 = Singleton.getInstance();
        System.out.println("Are they same?"+obj.equals(obj1));
    }
}
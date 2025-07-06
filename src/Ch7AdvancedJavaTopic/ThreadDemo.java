package Ch7AdvancedJavaTopic;

class ThreadDemo implements Runnable{
    Thread t;
    ThreadDemo(){
        t= new Thread(this);
        t.start();
    }
    public void run(){
        for( int i= 0; i<10;i++){
            System.out.println("Hello:"+i);
            try{
                Thread.sleep(5000);

            }catch (Exception e){}
        }
    }
    public static void main(String[] args){
        ThreadDemo obj = new ThreadDemo();
        ThreadDemo obj1 = new ThreadDemo();

    }
}
public class Deadlock {

   public static Object cacheLock = new Object();
   public static Object tableLock = new Object();

   public static void main(String[] args){
      new Thread(new Runnable(){
         public void run(){
            new Deadlock().oneMethod();
         }
      }).start();
      new Thread(new Runnable(){
         public void run(){
            new Deadlock().anotherMethod();
         }
      }).start();
   }

   public void oneMethod() {
      synchronized (cacheLock) {
         doSomething();
         synchronized (tableLock) { 
            doSomething();
         }
      }
   }
   public void anotherMethod() {
      synchronized (tableLock) {
         doSomething();
         synchronized (cacheLock) { 
            doSomethingElse();
         }
      }
   }

   private void doSomething(){
      try {
         Thread.sleep(2000);
      }
      catch(InterruptedException e) {}
   }


   private void doSomethingElse(){
      try {
         Thread.sleep(3000);
      }
      catch(InterruptedException e) {}
   }
}

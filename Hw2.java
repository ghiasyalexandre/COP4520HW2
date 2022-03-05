import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hw2
{
   public static class GuestThread implements Runnable {
         public boolean enteredMaze;
         private int threadNumber;
         private Lock lock;

         public GuestThread (int threadNumber, Lock lock)
         {
            this.lock = lock;
            this.threadNumber = threadNumber;
         }

         private boolean flipCoin()
         {
            Random r = new Random();
            int chance = r.nextInt(2);
            if (chance == 1) {
               return true;
            } else {
               return false;
            }
         }

         public boolean eatCupcake()
         {
            try {
               lock.lock();
               flipCoin();
            } finally {
               lock.unlock();
            }
         }

         public boolean askForCupcake()
         {
            try {
               lock.lock();
               flipCoin();
            } finally {
               lock.unlock();
            }
         }

         @Override
         public void run()
         {
            enteredMaze = true;
            System.out.println("Thread: " + threadNumber);

            try{
               Thread.sleep(500);
               if (true)
                  eatCupcake();
               else
                  askForCupcake();
            } catch (InterruptedException e){

            }

         }
      }

       public static void main (String args[])
       {
         int numThreads = 4;
         Lock lock = new ReentrantLock();
         Thread[] myThreads = new Thread[numThreads];

         for (int i = 0; i < numThreads; i++) {
            GuestThread guest = new GuestThread(i);
            myThreads[i] = new Thread(guest);
         }

         maze.threads = myThreads;

         while (allVisited < numThreads)
         {
            try{
               int selectedGuest = selectGuest(numThreads);
               maze.threads[selectedGuest].start();
               maze.threads[selectedGuest].join();

               if (!eatCupcake)
               {
                  bringCupcake();
               }             
            } catch (Exception e)
            {
               System.out.println("Exception: " + e);
            }
         }
       }

       public static int selectGuest(int numGuests)
       {
         Random minotaur = new Random();
         int selectedGuest = minotaur.nextInt(numGuests) + 1;
         System.out.println("Guest: " + selectedGuest + " Enters the maze");
         return selectedGuest - 1;
       }

       public static void bringCupcake()
       {
         try {
            lock.lock();
            
         } finally {
            lock.unlock();
         }
      }
}

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// This implementation is best as the threads will not need to wait for the lock to be unlocked they can just enter once the previous guest has left
public class Hw2Part2
{
    public void lock() {
        Qnode qnode = myNode.get();
        qnode.locked = true; // I’m not done
        
        while (pred.locked) {}
    }

    public void unlock() {
        myNode.get().locked = false; }

    static class Qnode
    { // Queue node inner class public boolean locked = false;
    }

    public static void main(String args[])
    {

    }
}
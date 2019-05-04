package com.company;

public class Philosopher extends Thread {
    private Fork fork_left;
    private Fork fork_right;

    public Philosopher(Fork fork_left, Fork fork_right) {
        this.fork_left = fork_left;

        this.fork_right = fork_right;

    }

    private void function(String method) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + method);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public void run() {
        try {
            while (true) {
                function(System.nanoTime() + ":Thinking");
                synchronized (fork_left) {
                    function(System.nanoTime() + ":take left fork");
                }
                synchronized (fork_right) {
                    function(System.nanoTime()+ ":take right fork");

                    function(System.nanoTime() + ":Put down right fork");
                }
                function(System.nanoTime() + ":put down left fork.And begin to think again");
            }

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return;

        }
    }
}



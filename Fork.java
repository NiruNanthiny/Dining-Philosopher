package com.company;

import java.util.concurrent.Semaphore;

   class Fork {
    public Semaphore fork = new Semaphore(1);
    public int id;

    public Fork(int id) {
        this.id = id;
    }


    public int getId (){
        return id;
    }

    public void putDown() {
        fork.release();
    }

    public boolean take() {

        return fork.tryAcquire();
    }
}


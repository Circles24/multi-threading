package com.circles24.synchroized;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ThreadedCounter counter1 = new ThreadedCounter(5, 1000, new CounterState());
        counter1.count();
        log.info("threaded counter state :: {}", counter1.getCounter());

        ThreadedCounter counter2 = new ThreadedCounter(5, 1000, new CounterState());
        counter2.synchroizedCount();
        log.info("sync threaded counter state :: {}", counter2.getCounter());
    }
}

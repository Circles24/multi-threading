package com.circles24.threadstates;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Thread menuHandler = new Thread(new MenuHandler());

        Consumer<Map<String, Thread.State>> threadStateConsumer = threadStateMap -> threadStateMap.forEach((key, value) -> log.info("thread :: {} state :: {}", key, value));
        Thread poller = new Thread(new ThreadStatePoller(Collections.singletonList(menuHandler), threadStateConsumer, 1000));
        poller.setDaemon(true);
        poller.start();

        menuHandler.start();
    }
}
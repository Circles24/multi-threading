package com.circles24.threadstates;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class ThreadStatePoller implements Runnable {
    private final List<Thread> threads;

    private final Consumer<Map<String, Thread.State>> stateConsumer;

    private final long sleepTimeMS;

    public void run() {
        while(true) {
            try {
                Map<String, Thread.State> stateMap = new HashMap<>();
                threads.forEach(thread -> stateMap.put(thread.getName(), thread.getState()));
                stateConsumer.accept(stateMap);
            } catch (Exception ex) {
                log.error("exception while polling thread states", ex);
            }

            try {
                Thread.sleep(sleepTimeMS);
            } catch (Exception ex) {
                log.error("error while thread sleep", ex);
            }
        }
    }
}

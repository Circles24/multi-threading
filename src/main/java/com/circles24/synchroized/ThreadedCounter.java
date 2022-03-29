package com.circles24.synchroized;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
public class ThreadedCounter {
    private final int threadCount;

    private final int limit;

    private final CounterState state;

    public void count() {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<?>> futures = new ArrayList<>();
        IntStream.range(0, limit).forEach(num -> {
            Future<?> future = executorService.submit(state::tick);
            futures.add(future);
        });

        try {
            futures.forEach(future -> {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            log.error("error while awaiting future result", ex);
        }
    }

    public void synchroizedCount() {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<?>> futures = new ArrayList<>();
        IntStream.range(0, limit).forEach(num -> {
            Future<?> future = executorService.submit(state::synchronizedTick);
            futures.add(future);
        });

        try {
            futures.forEach(future -> {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            log.error("error while awaiting future result", ex);
        }
    }

    public long getCounter() {
        return state.getState();
    }
}

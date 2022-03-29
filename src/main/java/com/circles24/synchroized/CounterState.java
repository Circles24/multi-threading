package com.circles24.synchroized;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;

@Getter
@Setter
public class CounterState {
    private long state;

    public void tick() {
        setState(getState()+1);
    }

    @Synchronized
    public void synchronizedTick() {
        setState(getState()+1);
    }
}

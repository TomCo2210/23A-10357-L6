package dev.tomco.a23a_10357_l6.Models;

import java.util.Timer;
import java.util.TimerTask;

import dev.tomco.a23a_10357_l6.interfaces.CallBack_Timer;

public class Ticker {
    public final int DELAY = 1000;
    private Timer timer;
    private CallBack_Timer callBack_timer;

    public Ticker(CallBack_Timer callBack_timer) {
        timer = new Timer();
        this.callBack_timer = callBack_timer;
    }

    public void start() {

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                callBack_timer.tick();
            }
        },DELAY,DELAY);

    }

    public void stop() {
        timer.cancel();
    }
}

package com.hardware.rloken.hearingaid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by rloke on 4/13/2016.
 */
public class HardwareDetectionService extends Service {

    /**
     * the phone, tablet, or computer.
     */
    private Device device = null;

    private Thread runningThread = null;

    @Override
    public void onCreate(){

        if(device == null){
            device = new Device();
        }

        if(runningThread == null){
            runningThread = new Thread();
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

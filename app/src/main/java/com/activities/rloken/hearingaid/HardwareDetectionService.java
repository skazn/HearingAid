package com.activities.rloken.hearingaid;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;

/**
 * Created by rloke on 4/13/2016.
 */
public class HardwareDetectionService extends Service {

    /**
     * the phone, tablet, or computer.
     */
    private Device device = null;

    private HardwareDetection hd = null;

    private Thread runningThread = null;

    private OnBoardHardware OBH;

    @Override
    public void onCreate(){

        if(OBH == null){
            //OBH = new OnBoardHardware(getApplicationContext().getPackageManager(), (AudioManager)getApplicationContext().getSystemService(Context.AUDIO_SERVICE), getApplicationContext());

        }
        if(device == null){
            device = new Device();
        }

        if(hd == null){
            hd = new HardwareDetection(getApplicationContext());
        }


            runningThread = new Thread(hd);
            runningThread.setPriority(Process.THREAD_PRIORITY_BACKGROUND);
            runningThread.start();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        //Only start the thread if it is not already running.
        if(this.runningThread.getState() == Thread.State.NEW){
            this.runningThread.start();
        }

        ///Returning START_STICKY keeps this service alive if it
        ///somehow shuts down.
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

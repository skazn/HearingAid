package com.activities.rloken.hearingaid;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by rloke on 4/13/2016.
 */
public class HardwareDetection implements Runnable {

    private OnBoardHardware OBH;
    private Context context;

    public HardwareDetection(Context c){
        context = c;
    }

    public HardwareDetection(OnBoardHardware obh){
        OBH = obh;
    }
    @Override
    public void run() {
        CharSequence text;
        for(;;){
            text = "Service running";
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            OBH.ReportStatus();
            if(OBH.MicrophoneDetected()){
                text = "Microphone detected.";
                Toast.makeText(OBH.context, text, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

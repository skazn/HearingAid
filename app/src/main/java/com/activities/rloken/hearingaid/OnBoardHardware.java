package com.activities.rloken.hearingaid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaRecorder;

/**
 * Created by rloke on 4/13/2016.
 */
public class OnBoardHardware extends Hardware {

    /**
     * Constructors
     */
    public OnBoardHardware(PackageManager pm, AudioManager am, Context c)
    {
        super(pm, am, c);
    }

    public OnBoardHardware()
    {
        super();
    }
    @Override
    public void StartReceiving(){

    }

    @Override
    public void StopReceiving(){

    }

    @Override
    public void StartBroadcasting() {

    }

    @Override
    public void StopBroadcasting(){

    }

    @Override
    public void ReportStatus()
    {
        if(PMAvailable())
        {
            MicrophoneDetected();
            MicrophoneIsAvailable();
        }

        if(AMAvailable())
        {
            SpeakerDetected();
            SpeakerIsAvailable();
        }
    }

    @Override
    public boolean SpeakerDetected()
    {
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT))
        {
            canBroadcast = true;
        }
        //this only tells you if there is a speaker, a bluetooth adapter or audio jack.
        return canBroadcast;
    }

    @Override
    public boolean SpeakerIsAvailable()
    {
        //right now only checking for active music.
        return audioManager.isMusicActive();
    }

    @Override
    public boolean MicrophoneDetected()
    {
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
        {
            canReceive = true;
        }
        return canReceive;
    }

    @Override
    public boolean MicrophoneIsAvailable() {
        boolean avail = true;
        try
        {
            MediaRecorder mediaRecorder = new MediaRecorder();
            mediaRecorder.prepare();
        }
        catch(Exception e)
        {
            avail = false;
        }
        return avail;
    }
}

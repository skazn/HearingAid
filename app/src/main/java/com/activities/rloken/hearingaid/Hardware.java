package com.activities.rloken.hearingaid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaRecorder;

/**
 * Created by rloke on 4/13/2016.
 *
 * Represents the different hardware devices available for producing and recieving sound.
 * e.g. bluetooth headset, or microphone.
 */
abstract class Hardware
{
    /**
     * Listening device attributes
     */
    public boolean statusReported = false;
    public boolean canReceive = false;
    public boolean canBroadcast = false;

    public PackageManager packageManager;
    public AudioManager audioManager;
    public Context context;
    /**
     * Constructors
     */
    public Hardware(PackageManager pm, AudioManager am, Context c)
    {
        packageManager = pm;
        audioManager = am;
        context = c;
    }

    public Hardware(){}
    /**
     * Listening device abstract methods.
     */

    public abstract void ReportStatus();

    public abstract void StartReceiving();

    public abstract void StopReceiving();

    public abstract void StartBroadcasting();

    public abstract void StopBroadcasting();

    public abstract boolean SpeakerDetected();

    public abstract boolean SpeakerIsAvailable();
    /**
     * detect if the microphone on the device is available. Currently targeted
     * at mobile devices.
     * @return
     */
    public abstract boolean MicrophoneDetected();

    /**
     * Check to see if the microphone on the device is available.
     * @return
     */
    public abstract boolean MicrophoneIsAvailable();

    /**
     * Check if the package manager is available.
     * @return whether or not the package manager is avail.
     */
    public boolean PMAvailable()
    {
        return (packageManager != null);
    }

    public boolean AMAvailable()
    {
        return (audioManager != null);
    }
}
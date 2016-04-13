package com.hardware.rloken.hearingaid;

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
    public boolean canReceive = false;
    public boolean canBroadcast = false;

    /**
     * Listening device abstract methods.
     */
    public abstract void StartReceiving();

    public abstract void StopReceiving();

    public abstract void StartBroadcasting();

    public abstract void StopBroadcasting();
}
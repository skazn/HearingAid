package com.activities.rloken.hearingaid;

import java.util.ArrayList;

/**
 * Created by rloke on 4/13/2016.
 *
 * Mediator created in the HardwareDetectionService.java class
 */
public class Device
{
    /**
     * Attributes
     */
    public ArrayList<Hardware> peers;

    /**
     * Constructors
     */

    public Device()
    {
        peers = new ArrayList<>();
    }


    public void RequestStatus(){
        if(!peers.isEmpty()){
            for (Hardware hw : peers)
            {
                hw.ReportStatus();
            }
        }
    }
    //Return a list of enum of types
    public boolean DetectHardware()
    {
        return true;
    }

}

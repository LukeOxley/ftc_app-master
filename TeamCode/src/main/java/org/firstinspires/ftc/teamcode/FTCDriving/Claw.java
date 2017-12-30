package org.firstinspires.ftc.teamcode.FTCDriving;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lukeo on 12/29/2017.
 */

public class Claw {
    Servo left;
    Servo right;
    double[] openPos;
    double[] closePos;
    double[] startPos;

    public Claw(Servo leftC,Servo rightC, double[] openPosC, double[] closePosC, double[] startPosC){
        left=leftC;
        right=rightC;
        openPos=openPosC;
        closePos=closePosC;
        startPos=startPosC;
    }


    public void setOpen(Boolean open){
            setLeftOpen(open);
            setRightOpen(open);
    }

    public void setRightOpen(Boolean open){
        if(open){

            right.setPosition(openPos[1]);
        }else{
            right.setPosition(closePos[1]);
        }
    }
    public void setLeftOpen(Boolean open){
        if(open){
            left.setPosition(openPos[0]);
        }else{
            left.setPosition(closePos[0]);
        }
    }

    public void start(){
        left.setPosition(startPos[0]);
        right.setPosition(startPos[1]);
    }

}

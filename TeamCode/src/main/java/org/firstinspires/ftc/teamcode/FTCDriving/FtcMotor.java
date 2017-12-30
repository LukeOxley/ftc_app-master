package org.firstinspires.ftc.teamcode.FTCDriving;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by lukeo on 12/27/2017.
*/
public class FtcMotor extends com.qualcomm.robotcore.hardware.DcMotorImpl {



    /*
     @param controller The controller associated with the motorName.
  * @param portNumber The portNumber on the controller that the motor is connected to.
     */
    public FtcMotor(DcMotorController controller, int portNumber) {
        super(controller, portNumber);
       // initMotorDefaults();
    }
/*
@param hardwareMap The hardwareMap from the opmode you are running.
 @param motorName The name of the motor from the config file.
 @return A TeamDcMotor object
 */
    public static FtcMotor getTeamDcMotor(HardwareMap hardwareMap, String motorName) {
        DcMotor dcMotor;
        DcMotorController controller;
        int portNumber;
        FtcMotor ftcMotor;


        dcMotor = hardwareMap.dcMotor.get(motorName);
        controller = dcMotor.getController();
        portNumber = dcMotor.getPortNumber();

        // Now that I have the controller object and the port number, use it to construct my object.
        // Call my constructor, which will call the DcMotor constructor using super()
        ftcMotor = new FtcMotor(controller, portNumber);
        // return the TeamDCMotor to the user
        return ftcMotor;
    }


    public void resetEncoder(){
        setMode(RunMode.STOP_AND_RESET_ENCODER);
        setMode(RunMode.RUN_USING_ENCODER);
        setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    }
    public void runUsingEncoder(){

        setMode(RunMode.RUN_USING_ENCODER);
        setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    }
    public void runWithoutEncoder(){
        setMode(RunMode.RUN_WITHOUT_ENCODER);
        setZeroPowerBehavior(ZeroPowerBehavior.FLOAT);
    }
    //@param dir True for Forward and False for Backward
    public void setDirection(Boolean dir){
        if(dir){
            setDirection(Direction.FORWARD);
        }else{
            setDirection(Direction.REVERSE);
        }
    }
    public void brake(){
        setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    }
    public void drift(){
        setZeroPowerBehavior(ZeroPowerBehavior.FLOAT);
    }


    boolean invertEncoder = false;
    //@return Get the current position of encoder in ticks
    public int getPosition(){

        double position = getCurrentPosition();
        if(invertEncoder){
            return (int) -position;
        }else{
            return (int) position;
        }

    }




    //@return Returns false when motor has finished moving, else true
    String driveStatus = "start";
    int targetDrivePosition=0;
    int give=5;
    public boolean driveDistance(int distance,double speed){
        boolean running = true;
        switch (driveStatus){
            case "start":
                runUsingEncoder();
                int position=getPosition();
                targetDrivePosition=position+distance;
                if(targetDrivePosition>position){
                    setPower(speed);
                }else if(targetDrivePosition<=position){
                    setPower(-speed);
                }
                driveStatus="move";
                break;
            case "move":
                if(Math.abs(getPosition()-targetDrivePosition)>=Math.abs(distance)-give){
                    driveStatus="finish";
                }
                break;
            case "finish":
                setPower(0);
                driveStatus="start";
                targetDrivePosition=0;
                running=false;
                break;
        }
        if(running) {
            return true;
        }else{
            return false;
        }
    }

}

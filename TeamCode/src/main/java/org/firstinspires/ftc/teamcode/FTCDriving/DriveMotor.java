package org.firstinspires.ftc.teamcode.FTCDriving;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by lukeo on 12/28/2017.
 */

public class DriveMotor extends FtcMotor {
    /*
     @param controller The controller associated with the motorName.
  * @param portNumber The portNumber on the controller that the motor is connected to.
     */
    public DriveMotor(DcMotorController controller, int portNumber) {
        super(controller, portNumber);
        // initMotorDefaults();
    }
    /*
    @param hardwareMap The hardwareMap from the opmode you are running.
     @param motorName The name of the motor from the config file.
     @return A TeamDcMotor object
     */
    public static DriveMotor getDriveMotor(HardwareMap hardwareMap, String motorName) {
        DcMotor dcMotor;
        DcMotorController controller;
        int portNumber;
        DriveMotor driveMotor;


        dcMotor = hardwareMap.dcMotor.get(motorName);
        controller = dcMotor.getController();
        portNumber = dcMotor.getPortNumber();

        // Now that I have the controller object and the port number, use it to construct my object.
        // Call my constructor, which will call the DcMotor constructor using super()
        driveMotor = new DriveMotor(controller, portNumber);
        // return the TeamDCMotor to the user
        return driveMotor;
    }
    static int ticksPerRevolution = 280;
    static int wheelDiameter=4;
    static double ticksPerInchD= ticksPerRevolution/(3.14159*wheelDiameter);
    static int ticksPerInch = (int) ticksPerInchD;

    public static int ticksToInches(double ticks){
       int inches = (int) ticks*ticksPerInch;
    return inches;
    }

    public int getPosition(){
        int ticks=getCurrentPosition();
        return (int) ticks*ticksPerInch;
    }

}

package org.firstinspires.ftc.teamcode.FTCDriving;

import com.qualcomm.hardware.bosch.BNO055IMU;

/**
 * Created by lukeo on 12/28/2017.
 */

public class DriveBase {
    DriveMotor left;
    DriveMotor right;
    BNO055IMU gyro;

    public DriveBase (DriveMotor leftC, DriveMotor rightC, BNO055IMU imu){
        left=leftC;
        right=rightC;
        gyro=imu;
    }

    public void teleDrive(double leftSpeed, double rightSpeed){
        left.setPower(leftSpeed);
        right.setPower(rightSpeed);
    }


    boolean lRunning=true;
    boolean rRunning=true;
    public boolean driveDistance(int distance){
        if(lRunning&&!left.driveDistance(distance,.75)){
            lRunning=false;
        }
        if(rRunning&&!right.driveDistance(distance,.75)){
            rRunning=false;
        }
        if(lRunning&&lRunning){
            return false;
        }else{
            return true;
        }
    }


}

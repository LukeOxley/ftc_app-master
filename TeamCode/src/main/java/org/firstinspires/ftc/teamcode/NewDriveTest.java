package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.FTCDriving.DriveBase;
import org.firstinspires.ftc.teamcode.FTCDriving.DriveMotor;

@TeleOp(name="DriveTesting", group="Linear Opmode")
public class NewDriveTest extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    public DriveBase base = null;
    void inititalize(){
        DriveMotor right = DriveMotor.getDriveMotor(hardwareMap, "right");
        DriveMotor left = DriveMotor.getDriveMotor(hardwareMap, "left");
        //DcMotor lift = hardwareMap.get(DcMotor.class, "lift");

        //rightb = hardwareMap.get(DcMotor.class, "rightb");
        //Servo clawl = hardwareMap.get(Servo.class, "leftClaw");
        // Servo clawr = hardwareMap.get(Servo.class, "rightClaw");
        //Servo light = hardwareMap.get(Servo.class, "light");

        BNO055IMU imu = hardwareMap.get(BNO055IMU.class, "imu");
        base=new DriveBase(left,right,imu);
        //ColorSensor color_sensor = hardwareMap.get(ColorSensor.class,"color");

        // int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        // Declare OpMode members.
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        

    }
    
    @Override
    public void runOpMode() {
        
        inititalize();
        
        boolean clawPosition=false;
        int driveMode=1; //1=steer, 2=tank
        
        waitForStart();
        runtime.reset();
        String state = "start";
        while (opModeIsActive()) {



            base.teleDrive(gamepad1.left_stick_y,gamepad1.right_stick_y);


            /*
            switch(state){
                case "start":
                    if(base.driveDistance(40)){

                    }else{
                        state="done";
                    }
            }
            */

            /*double leftPower;
            double rightPower;
            if(driveMode==1){
            double drive = 0;
             double turn  =  gamepad1.left_stick_x;
            if(gamepad1.right_trigger>0){
                robot.direction(true, true);
                drive=Math.abs(gamepad1.right_trigger);
                //turn=-turn;
            }
            else if(gamepad1.left_trigger>0){
                robot.direction(false, false);
                drive=Math.abs(gamepad1.left_trigger);
            }
            
           
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
            
            robot.speed(leftPower,rightPower);
            
            } 
            
            //steer
            
            else if(driveMode==2){
                leftPower  = -gamepad1.left_stick_y ;
                rightPower = -gamepad1.right_stick_y ;
                robot.speed(leftPower, rightPower);
                
            } //tank
            
            
            
            //player 2
            
            
            robot.lift(gamepad2.left_stick_y);
            
            if(gamepad2.a){
                robot.claw(true);
                
            }else if(gamepad2.b){
                robot.claw(false);
                
            }
            
            */
    
        }
    }
}

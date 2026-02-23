package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class TesteAuto extends AutoFunction{

    @Override
    public void runOpMode(){
        HardwareMap(hardwareMap);

        waitForStart();
        if(opModeIsActive()){
            stopResetMotors();
            autonomous(1500 , 1500 , 1500 , 1500 , 0.1 , 0.6 , 0 , CatapultaModes.HOLD , 2);
            telemetry.update();
        }
    }

}

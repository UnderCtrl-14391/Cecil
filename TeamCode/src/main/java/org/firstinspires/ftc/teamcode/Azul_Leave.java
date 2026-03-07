package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Azul_Leave extends AutoFunction{
    private final ElapsedTime runtime = new ElapsedTime();

    public void waitSeconds(double seconds){
        runtime.reset();
        while(runtime.seconds() <= seconds){

        }
    }


    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
            stopResetMotors();

            autonomous(-1400, -1400, -1400, -1400, 0.8, 0.8, 0, CatapultaModes.DOWN, 0.6);
        }
    }


}
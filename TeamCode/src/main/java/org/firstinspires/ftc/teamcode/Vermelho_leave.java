package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Vermelho_leave extends AutoFunction{
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
            waitSeconds(23);

            /*autonomous(1400 , 1400 ,1400 , 1400, 0.8 , 0.8 , 0 , AutoFunction.CatapultaModes.DOWN);
            waitSeconds(0.005);

            stopResetMotors();
            autonomous(1070 , -1070 , 1070 , -1070, 0.7 , 0.7 , 0 , AutoFunction.CatapultaModes.HOLD);*/
        }
    }
}

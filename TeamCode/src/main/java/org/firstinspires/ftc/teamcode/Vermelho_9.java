package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Vermelho_9 extends AutoFunction{
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
            Catapulta_score();

            stopResetMotors();
            autonomous(-1750, -1750, -1750, -1750, 0.8, 0.8, 0, CatapultaModes.DOWN,1.26);
            //waitSeconds(0.02);

            stopResetMotors();
            autonomous(450 , -450 , 450 , -450, 0.7 , 0.7 , 0 , CatapultaModes.HOLD,0.8);
            //waitSeconds(0.02);

            stopResetMotors();
            autonomous(-800 , 800 , 800 , -800, 0.8 , 0.8 , 0 , CatapultaModes.HOLD,0.7);
            //waitSeconds(0.02);

            stopResetMotors();
            autonomous(2000 , 2000 , 2000 , 2000, 0.5 , 0.5 , 0.7 , CatapultaModes.HOLD,2.1);
            //waitSeconds(0.02);

            stopResetMotors();
            autonomous(-177032 , -177032 , 177320 , 177000, 0 , 0 , 0.7 , CatapultaModes.HOLD,0.5);
            //waitSeconds(0.02);

            stopResetMotors();
            autonomous(-600 , -600 , -600 , -600, 0.8 , 0.8 , 0.7 , CatapultaModes.HOLD,0.6);
            //waitSeconds(0.02);

            stopResetMotors();
            autonomous(1830 , -1830 , -1830 , 1830, 0.8 , 0.8 , 0.7 , CatapultaModes.DOWN,1.17);
            //waitSeconds(0.06);

            stopResetMotors();
            autonomous(-450 , 450 , -450 , 450 , 0.8 , 0.8 , 0 , CatapultaModes.DOWN,0.76);
            //waitSeconds(0.02);

            stopResetMotors();
            autonomous(580 , 580 , 580 , 580, 0.7 , 0.7 , 0 , CatapultaModes.HOLD,0.47);
            //waitSeconds(0.02);

            Catapulta_score();

            stopResetMotors();
            autonomous(-1750 , -1750 , -1750 , -1750, 0.8 , 0.8 , 0 , CatapultaModes.HOLD,1.26);
            //waitSeconds(0.02);

            telemetry.update();

        }
    }

}

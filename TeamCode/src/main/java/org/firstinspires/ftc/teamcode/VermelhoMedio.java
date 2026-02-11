package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class VermelhoMedio extends AutoFunction{
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
            waitSeconds(0.02);

            stopResetMotors();
            /*autonomous(-2250, -2250, -2250, -2250, 0.8, 0.8, 0, CatapultaModes.DOWN);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(600 , -600 , 600 , -600, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(2000 , 2000 , 2000 , 2000, 0.6 , 0.6 , 0.9 , CatapultaModes.HOLD);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(-570 , -570 , -570 , -570, 0.8 , 0.8 , 0.9 , CatapultaModes.HOLD);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(-1770 , -1770 , 1770 , 1770, 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(-600 , 600 , -600 , 600, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(500 , 500 , 500 , 500, 0.8 , 0.8 , 0 , CatapultaModes.DOWN);
            waitSeconds(0.02);

            Catapulta_score();
            waitSeconds(0.06);

            stopResetMotors();
            autonomous(-1800 , -1800 , -1800 , -1800 , 0.8 , 0.8 , 0 , CatapultaModes.DOWN);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(550 , -550 , 550 , -550, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
            waitSeconds(0.02);

            stopResetMotors();
            autonomous(1900 , 1900 , -1900 , -1900, 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
            waitSeconds(0.02);*/

            telemetry.update();

        }
    }

}

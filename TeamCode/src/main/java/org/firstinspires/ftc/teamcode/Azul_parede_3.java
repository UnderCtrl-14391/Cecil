package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Azul_parede_3 extends AutoFunction {

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
            stopResetMotors();
            autonomous( -1400, -1400, -1400, -1400, 0.8, 0.8, 0, CatapultaModes.HOLD, 1);
            //waitSeconds(3);

            stopResetMotors();
            autonomous(-1300, -1300, 1300, 1300, 0.8, 0.8, 0, CatapultaModes.HOLD, 1);
            //waitSeconds(0);

            stopResetMotors();
            autonomous(410, -410, 410, -410, 0.7, 0.7, 0, CatapultaModes.HOLD,1);
            //waitSeconds(0);

            stopResetMotors();
            autonomous(2000, 2000, 2000, 2000, 0.8, 0.8, 0, CatapultaModes.HOLD, 1);
            //waitSeconds(0);

            Catapulta_score();
            //waitSeconds(0);

            stopResetMotors();
            autonomous(-600,600,-600,600,0.7,0.7,0,CatapultaModes.DOWN, 1);
            //waitSeconds(0);

            stopResetMotors();
            autonomous(-1400,-1400,-1400,-1400,0.8,0.8,0,CatapultaModes.HOLD, 1);
            //waitSeconds(0);

            stopResetMotors();
            autonomous(-5000, -5000, 5000, 5000, 0.8, 0.8, 0, CatapultaModes.HOLD, 2);

            telemetry.update();
        }

    }
}
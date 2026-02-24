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
            autonomous(121212,1212121210,12121210,12212121,0,0,0,CatapultaModes.HOLD,3);

            stopResetMotors();
            autonomous( 400, -450, -400, 450, 0.8, 0.8, 0, CatapultaModes.DOWN, 0.3);

            stopResetMotors();
            autonomous(700, 700, 700, 700, 0.8, 0.8, 0, CatapultaModes.HOLD, 1);

            Catapulta_score();

            stopResetMotors();
            autonomous(-900,0,0,-950,0.8,0.8,0,CatapultaModes.HOLD,1);

            stopResetMotors();
            autonomous(-300, 300, -300, 300, 0.8, 0.8, 0, CatapultaModes.HOLD,1);
            //waitSeconds(0);

            /*stopResetMotors();
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
            autonomous(-5000, -5000, 5000, 5000, 0.8, 0.8, 0, CatapultaModes.HOLD, 2);*/

            telemetry.update();
        }

    }
}
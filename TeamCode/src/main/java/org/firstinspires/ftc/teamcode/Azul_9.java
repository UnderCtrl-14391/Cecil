package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Azul_9 extends AutoFunction {

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {

            //score 3 balls
            Catapulta_score();


            //Ré - Load 1
            stopResetMotors();
            autonomous(-2000, -2000, -2000, -2000, 0.7, 1, 0, CatapultaModes.HOLD, 0.5);
            timerReset();

            //Giro load 1
            stopResetMotors();
            autonomous(-530, 530, -530, 530, 0.7, 0.7, 0, CatapultaModes.HOLD, 0.3);
            timerReset();

            // STRAFE
            stopResetMotors();
            autonomous(-500 , 500 , 500 , -500 , 0.7 , 0.7 , 0 , CatapultaModes.HOLD , 1);
            timerReset();

            //load 1
            stopResetMotors();
            autonomous(2000, 2000, 2000, 2000, 0.5, 0.9, 0.9, CatapultaModes.HOLD, 1);
            timerReset();

            /* ré - score 6 balls
            stopResetMotors();
            autonomous(-570, -570, -570, -570, 0.8, 0.8, 0.9, CatapultaModes.HOLD, 0.5);

            //strafe score 6 balls
            stopResetMotors();
            autonomous(1770, 1770, -1770, -1770, 0.8, 0.8, 0.9, CatapultaModes.DOWN, 1.15);

            //giro score 6 balls
            stopResetMotors();
            autonomous(600, -600, 600, -600, 0.7, 0.7, 0, CatapultaModes.HOLD, 0.5);

            //parede score 6 balls
            stopResetMotors();
            autonomous(500, 500, 500, 500, 0.8, 0.8, 0, CatapultaModes.HOLD, 0.4);

            //score 6 balls
            Catapulta_score();


            //re load 2
            stopResetMotors();
            autonomous(-1200, -1200, -1200, -1200, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.2);

            //giro load 2
            stopResetMotors();
            autonomous(-600, 600, -600, 600, 0.8, 0.8, 0, CatapultaModes.HOLD, 0.5);

            //strafe load 2
            stopResetMotors();
            autonomous(-2100, -2100, 2100, 2100, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.8);

            //load 2
            stopResetMotors();
            autonomous(2200, 2200, 2200, 2200, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            //ré score 9 balls
            stopResetMotors();
            autonomous(-600, -600, -600, -600, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            //strafe score 9 balls
            stopResetMotors();
            autonomous(1900, 1900, -1900, -1900, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            //giro score 9 balls
            stopResetMotors();
            autonomous(600, -600, 600, -600, 0.8, 0.8, 0, CatapultaModes.DOWN, 1.4);

            //parede score 9 balls
            stopResetMotors();
            autonomous(500, 500, 500, 500, 0.8, 0.8, 0, CatapultaModes.DOWN, 1.4);

            //score 9 balls
            Catapulta_score();

            /*autonomous(-540, 540, -540, 540, 0.8, 0.8, 0, CatapultaModes.HOLD, 0.4);

            stopResetMotors();
            autonomous(-600, 600, -600, 600, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            autonomous(-2500, -2500, 2500, 2500, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            autonomous(2200, 2200, 2200, 2200, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            autonomous(-600, -600, -600, -600, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            autonomous(2500, 2500, -2500, -2500, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            autonomous(600, -600, 600, -600, 0.8, 0.8, 0, CatapultaModes.DOWN, 0.4);

            stopResetMotors();
            autonomous(500, 500, 500, 500, 0.8, 0.8, 0, CatapultaModes.DOWN, 0.4);


            Catapulta_score();*/

            telemetry.update();
        }
    }
}

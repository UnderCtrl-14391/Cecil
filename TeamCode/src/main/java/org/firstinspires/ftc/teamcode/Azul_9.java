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
            autonomous(-5000, -5000, -5000, -5000, 0.7, 1, 0, CatapultaModes.HOLD, 0.7);
            timerReset();

            //Giro load 1
            stopResetMotors();
            autonomous(-800, 800, -800, 800, 0.7, 0.7, 0, CatapultaModes.HOLD, 0.22);
            timerReset();

            // STRAFE
            stopResetMotors();
            autonomous(-500 , 500 , 500 , -500 , 0.7 , 0.7 , 0 , CatapultaModes.HOLD , 0.93);
            timerReset();

            //load 1
            stopResetMotors();
            autonomous(7000, 7000, 7000, 7000, 0.1, 0.6, 1, CatapultaModes.HOLD, 3);
            timerReset();

            //termina load 1
            stopResetMotors();
            autonomous(0, 0, 0, 0, 0, 0, 1, CatapultaModes.HOLD, 1.3);
            timerReset();

            // ré - score 6 balls
            stopResetMotors();
            autonomous(-800, -800, -800, -800, 0.7, 1, 1, CatapultaModes.HOLD, 0.45);


            /*strafe score 6 balls
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

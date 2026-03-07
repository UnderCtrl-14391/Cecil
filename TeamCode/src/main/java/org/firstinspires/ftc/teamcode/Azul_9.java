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
            autonomous(-1750, -1750, -1750, -1750, 0.8, 0.8, 0, CatapultaModes.HOLD , 1.26);

            //Giro load 1
            stopResetMotors();
            autonomous(-450, 450, -450, 450, 0.8, 0.8, 0, CatapultaModes.HOLD , 0.8);

            //strafe load 1
            stopResetMotors();
            autonomous(-800, 800, 800, -800, 0.8, 0.8, 0, CatapultaModes.HOLD, 0.7);

            //load 1
            stopResetMotors();
            autonomous(2000, 2000, 2000, 2000, 0.5, 0.5, 0.7, CatapultaModes.HOLD, 2.1);

            //loading
            stopResetMotors();
            autonomous(789 , 8789 , 87678 , 789 , 0 , 0 , 0.7 , CatapultaModes.HOLD , 0.5);

            // ré - score 6 balls
            stopResetMotors();
            autonomous(-600, -600, -600, -600, 0.8, 0.8, 0.7, CatapultaModes.HOLD, 0.6);

            //strafe score 6 balls
            stopResetMotors();
            autonomous(1830, -1830, -1830, 1830, 0.8, 0.8, 0.7, CatapultaModes.HOLD, 1.17);

            //giro score 6 balls
            stopResetMotors();
            autonomous(450, -450, 450, -450, 0.8, 0.8, 0, CatapultaModes.DOWN , 0.76);

            //parede score 6 balls
            stopResetMotors();
            autonomous(580, 580, 580, 580, 0.8, 0.8, 0, CatapultaModes.HOLD, 0.47);

            //score 6 balls
            Catapulta_score();


            //re load 2
            stopResetMotors();
            autonomous(-1750, -1750, -1750, -1750, 0.8, 0.8, 0, CatapultaModes.HOLD , 1.26);

            //Giro load 2
            stopResetMotors();
            autonomous(-470, 470, -470, 470, 0.8, 0.8, 0, CatapultaModes.HOLD , 0.87);

            //strafe load 2
            stopResetMotors();
            autonomous(-2200, 2200, 2200, -2200, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.7);

            //load 2
            stopResetMotors();
            autonomous(2200, 2200, 2200, 2200, 0.85, 0.85, 0.5, CatapultaModes.HOLD, 1.5);

            stopResetMotors();
            autonomous(789 , 8789 , 87678 , 789 , 0 , 0 , 0.7 , CatapultaModes.HOLD , 0.5);


            //ré score 9 balls
            stopResetMotors();
            autonomous(-700, -700, -700, -700, 0.8, 0.8, 0.7, CatapultaModes.HOLD, 0.75);

            //strafe score 9 balls
            stopResetMotors();
            autonomous(2800, -2800, -2800, 2800, 0.8, 0.8, 0.7, CatapultaModes.HOLD, 2.57);

            //giro score 9 balls
            stopResetMotors();
            autonomous(450, -450, 450, -450, 0.8, 0.8, 0, CatapultaModes.DOWN , 0.76);

            //parede score 9 balls
            stopResetMotors();
            autonomous(1000, 1000, 1000, 1000, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.8);

            //score 9 balls
            Catapulta_score();
            autonomous(-1750, -1750, -1750, -1750, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.26);

            stopResetMotors();
            autonomous(-450, 450, -450, 450, 0.8, 0.8, 0, CatapultaModes.HOLD, 0.87);

            stopResetMotors();
            autonomous(-3000, 3000, 3000, -3000, 0.8, 0.8, 0, CatapultaModes.HOLD, 2.5);

            stopResetMotors();
            autonomous(2200, 2200, 2200, 2200, 0.8, 0.8, 0.7, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            autonomous(-600, -600, -600, -600, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            /*autonomous(2500, 2500, -2500, -2500, 0.8, 0.8, 0, CatapultaModes.HOLD, 1.4);

            stopResetMotors();
            autonomous(600, -600, 600, -600, 0.8, 0.8, 0, CatapultaModes.DOWN, 0.4);

            stopResetMotors();
            autonomous(500, 500, 500, 500, 0.8, 0.8, 0, CatapultaModes.DOWN, 0.4);


            Catapulta_score();*/

            telemetry.addData("LeftTarget" , leftT.getCurrentPosition());
            telemetry.addData("Left" , left.getCurrentPosition());
            telemetry.addData("RightTarget" , rightT.getCurrentPosition());
            telemetry.addData("Right" , right.getCurrentPosition());
            telemetry.update();

            telemetry.update();
        }
    }
}

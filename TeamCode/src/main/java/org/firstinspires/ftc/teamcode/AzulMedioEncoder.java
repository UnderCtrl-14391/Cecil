package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class AzulMedioEncoder extends AutoFunction {


    private boolean done = false;




    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {

            Catapulta_score();

            stopResetMotors();
            autonomous(-1200, -1200, -1200, -1200, 0.8, 0.8, 0, CatapultaModes.HOLD , 1.2);

            stopResetMotors();
            autonomous(-540 , 540 , -540 , 540, 0.7 , 0.7 , 0 , CatapultaModes.HOLD , 0.6);

            stopResetMotors();
            autonomous(-1100 , -1100 , 1100 , 1100 , 0.8 , 0.8, 0 , CatapultaModes.HOLD, 1.2);

            stopResetMotors();
            autonomous(2000 , 2000 , 2000 , 2000, 0.5 , 0.5 , 0.9 , CatapultaModes.HOLD , 2.15);

            stopResetMotors();
            autonomous(-570 , -570 , -570 , -570, 0.8 , 0.8 , 0.9 , CatapultaModes.HOLD , 0.5);

            stopResetMotors();
            autonomous(1770 , 1770 , -1770 , -1770, 0.8 , 0.8 , 0.9 , CatapultaModes.DOWN , 1.15);

            stopResetMotors();
            autonomous(600 , -600 , 600 , -600, 0.7 , 0.7 , 0 , CatapultaModes.HOLD , 0.5);

            stopResetMotors();
            autonomous(500 , 500 , 500 , 500, 0.8 , 0.8 , 0 , CatapultaModes.HOLD , 0.4);


            Catapulta_score();
            autonomous(-540 , 540 , -540 , 540, 0.8 , 0.8 , 0 , CatapultaModes.HOLD , 0.4);

            Catapulta_score();
            autonomous(-1100 , -1100 , 1100 , 1100, 0.8 , 0.8 , 0 , CatapultaModes.HOLD , 0.4);

            Catapulta_score();
            autonomous(2000 , 2000 , 2000 , 2000, 0.8 , 0.8 , 0 , CatapultaModes.HOLD , 0.4);







            Catapulta_score();

            telemetry.update();


            }
        }
    }


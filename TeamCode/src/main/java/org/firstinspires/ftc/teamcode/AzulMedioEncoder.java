package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class AzulMedioEncoder extends AutoFunction {

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
            //abaixar catapulta
            autonomous(0, 0, 0, 0, 0, 0, 0, CatapultaModes.DOWN);
            sleep(300);

            //pontuar
            autonomous(0, 0, 0, 0, 0, 0, 0, CatapultaModes.UP);
            sleep(600);

            //sair pro primeiro load
            autonomous(-2200, -2200, -2200, -2200, 0.7, 0.7, 0, CatapultaModes.HOLD);
            sleep(1000);

            //giro load
            autonomous(-700 , 700 , -700 , 700, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
            sleep(900);

            //load
            autonomous(1700 , 1700 , 1700 , 1700, 0.5 , 0.5 , 1 , CatapultaModes.HOLD);
            sleep(1050);

            //caminho pontuar
            autonomous(1666 , 877 , -1666 , -2229, 0.7 , 0.7 , 1 , CatapultaModes.HOLD);
            sleep(1000);

            //----
            telemetry.update();


            }
        }
    }


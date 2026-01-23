package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class AzulMedioEncoder extends AutoFunction {

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {

                autonomous(0, 0, 0, 0, 0, 0, 0, 0, 0);
                sleep(1000);
                //sair pro primeiro load
                autonomous(-2200, -2200, -2200, -2200, 0.7, 0.7, 0, 0, 0);
                sleep(1000);
                telemetry.update();
                //giro load
                autonomous(-700 , 700 , -700 , 700, 0.7 , 0.7 , 0 , 0 , 0);
                sleep(900);
                telemetry.update();
                //load
                autonomous(1700 , 1700 , 1700 , 1700, 0.5 , 0.5 , 0 , 0 , 0);
                sleep(1050);
                telemetry.update();
                //caminho pontuar
                autonomous(1666 , 877 , -1666 , -2229, 0.7 , 0.7 , 0 , 0 , 0);
                sleep(1000);
                telemetry.update();


            }
        }
    }


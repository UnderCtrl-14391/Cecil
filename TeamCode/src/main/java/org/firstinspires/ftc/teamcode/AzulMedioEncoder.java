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
            autonomous(-2250, -2250, -2250, -2250, 0.7, 0.7, 0, CatapultaModes.DOWN);
            sleep(650);

            //giro load
            autonomous(-600 , 600 , -600 , 600, 0.7 , 0.7 , 0 , CatapultaModes.DOWN);
            sleep(400);

            //load - até aqui tá certo
            autonomous(1900 , 1900 , 1900 , 1900, 0.5 , 0.5 , 1 , CatapultaModes.DOWN);
            sleep(700);

            //CAMINHO PONTUAR - RÉ
            autonomous(-500 , -500 , -500 , -500, 0.7 , 0.7 , 1 , CatapultaModes.DOWN);
            sleep(150);

            //caminho pontuar
            autonomous(1700 , 1700 , -1700 , -1700, 0.8 , 0.8 , 0 , CatapultaModes.DOWN);
            sleep(750);

            //GIRO pontuar
            autonomous(600 , -600 , 600 , -600, 0.7 , 0.7 , 0 , CatapultaModes.DOWN);
            sleep(450);

            //CAMINHO PONTUA - ENCOSTA NA PAREDE
            autonomous(500 , 500 , 500 , 500, 0.8 , 0.8 , 0 , CatapultaModes.DOWN);
            sleep(300);

            //ABAIXA
            autonomous(0 , 0 , 0 , 0, 0 , 0 , 0 , CatapultaModes.DOWN);
            sleep(300);

            // PONTUA
            autonomous(0 , 0 , 0 , 0, 0 , 0 , 0 , CatapultaModes.UP);
            sleep(300);


            telemetry.update();


            }
        }
    }


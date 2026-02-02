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
           sleep(100);

            //pontuar
            autonomous(0, 0, 0, 0, 0, 0, 0, CatapultaModes.UP);
           sleep(150);

            //sair pro primeiro load
            autonomous(-2250, -2250, -2250, -2250, 0.8, 0.8, 0, CatapultaModes.DOWN);
            sleep(100);

            //giro load
            autonomous(-600 , 600 , -600 , 600, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
            sleep(100);

            //load - até aqui tá certo
            autonomous(2000 , 2000 , 2000 , 2000, 0.6 , 0.6 , 0.9 , CatapultaModes.HOLD);
            sleep(200);

            //CAMINHO PONTUAR - RÉ
            autonomous(-570 , -570 , -570 , -570, 0.8 , 0.8 , 0.9 , CatapultaModes.HOLD);
            sleep(100);

            //caminho pontuar
            autonomous(1770 , 1770 , -1770 , -1770, 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
            sleep(100);

            //GIRO pontuar
            autonomous(600 , -600 , 600 , -600, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
            sleep(10);

            //CAMINHO PONTUA - ENCOSTA NA PAREDE
            autonomous(500 , 500 , 500 , 500, 0.8 , 0.8 , 0 , CatapultaModes.DOWN);
            sleep(10);


            //PONTUA
            autonomous(0 , 0 , 0 , 0, 0.8 , 0.8 , 0 , CatapultaModes.UP);
            sleep(10);

            //CAMINHO LOAD 2
            autonomous(-1800 , -1800 , -1800 , -1800 , 0.8 , 0.8 , 0 , CatapultaModes.DOWN);
            sleep(100);

            //giro load 2
            autonomous(-550 , 550 , -550 , 550, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
            sleep(100);

            //CAMINHO LOAD 2 - STRAFE
            autonomous(-1900 , -1900 , 1900 , 1900, 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
            sleep(100);

            //LOAD 2
            autonomous(1540 , 1540 , 1540 , 1540, 0.5 , 0.5 , 0.9 , CatapultaModes.HOLD);
            sleep(100);

            //RE - SCORE 2
            autonomous(-500 , -500 , -500 , -500 , 0.8 , 0.8 , 0.9 , CatapultaModes.HOLD);
            sleep(100);

            //STRAFE - SCORE 2
            autonomous(3400 , 3400 , -3400 , -3400 ,0.8 , 0.8 , 0 , CatapultaModes.HOLD);
            sleep(100);

            //GIRO pontuar 2
            autonomous(600 , -600 , 600 , -600, 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
            sleep(100);

            //CAMINHO PONTUA - ENCOSTA NA PAREDE
            autonomous(500 , 500 , 500 , 500, 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
            sleep(100);

            //ABAIXA
            autonomous(0 , 0 , 0 , 0, 0 , 0 , 0 , CatapultaModes.DOWN);
            sleep(100);

            // PONTUA
            autonomous(0 , 0 , 0 , 0, 0 , 0 , 0 , CatapultaModes.UP);
            sleep(100);

            telemetry.update();


            }
        }
    }


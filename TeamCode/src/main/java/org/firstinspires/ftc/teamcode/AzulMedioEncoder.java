package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class AzulMedioEncoder extends AutoFunction {

    private final ElapsedTime runtime = new ElapsedTime();
    private boolean done = false;

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
                //abaixar catapulta
                autonomous(0, 0, 0, 0 ,0 , CatapultaModes.DOWN);
                sleep(100);
                //pontuar
                autonomous(0, 0, 0, 0 , 0, CatapultaModes.UP);
                sleep(100);
                runtime.reset();
                while(runtime.seconds() < 0.5 ){
                    //sair pro primeiro load
                    autonomous( -0.9, -0.9, -0.9 , -0.9 , 0, CatapultaModes.DOWN);
                }
                while(runtime.seconds() < 0.7 ){
                    //giro load
                    autonomous( -0.8, 0.8, -0.8 , 0.8 , 0, CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 1.4){
                    //strafe load
                    autonomous(-0.8 , -0.8 , 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 2.2 ) {
                    //load - até aqui tá certo
                    autonomous( 0.6, 0.6, 0.6 , 0.6 , 0.9 , CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 2.6 ) {
                    //CAMINHO PONTUAR - RÉ
                    autonomous( -0.9, -0.9, -0.9 , -0.9 , 0.9, CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 3.1 ) {
                    //caminho pontuar - strafe
                    autonomous(0.8, 0.8, -0.8, -0.8, 0, CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 3.4) {
                    //GIRO pontuar
                    autonomous(0.8, -0.8, 0.8, -0.8, 0, CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 4.2){
                    //CAMINHO PONTUA - ENCOSTA NA PAREDE
                    autonomous(0.9, 0.9, 0.9, 0.9, 0 ,  CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 4.7){
                    autonomous(0, 0, 0, 0, 0 ,  CatapultaModes.HOLD);

                }

                //PONTUA
                autonomous(0 , 0 , 0 , 0, 0.8  , CatapultaModes.DOWN);
                sleep(10);
                //PONTUA
                autonomous(0 , 0 , 0 , 0, 0.8  , CatapultaModes.UP);
                sleep(10);

                runtime.reset();
                while(runtime.seconds() < 0.5 ){
                    //sair pro primeiro load
                    autonomous( -0.9,
                            //giro load
                            autonomous( -0.8, 0.8, -0.8 , 0.8 , 0, CatapultaModes.HOLD);
                }
                 while(runtime.seconds() < 0.7){
                //strafe load//// -0.9, -0.9 , -0.9 , 0, CatapultaModes.DOWN);
               }
                while(runtime.seconds() < 2.3){
                     autonomous(-0.8 , -0.8 , 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
                }
                while(runtime.seconds() < 2.5) {
                    //load - até aqui tá certo
                    autonomous( 0.6, 0.6, 0.6 , 0.6 , 0.9 , CatapultaModes.HOLD);
                }
                 while(runtime.seconds() < 2.9){
                     //CAMINHO PONTUAR - RÉ
                     autonomous( -0.9, -0.9, -0.9 , -0.9 , 0.9, CatapultaModes.HOLD);
                 }
            /*CAMINHO LOAD 2
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
            autonomous(0 , 0 , 0 , 0, 0 , 0 , 0 , CatapultaModes.UP);*/
            sleep(100);

            telemetry.update();


            }
        }
    }


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class AzulMedioEncoder extends AutoFunction {

    private final ElapsedTime runtime = new ElapsedTime();
    private boolean done = false;

    public void waitSeconds(double seconds){
        runtime.reset();
        while(runtime.seconds() <= seconds){

        }
    }


    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
                stopResetMotors();
                Catapulta_score();
                waitSeconds(0.02);
                
                stopResetMotors();
                autonomous(-2250, -2250, -2250, -2250, 0.8, 0.8, 0, CatapultaModes.DOWN);
                waitSeconds(0.02);

                stopResetMotors();
                autonomous(-600 , 600 , -600 , 600, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
                waitSeconds(0.02);

                stopResetMotors();
                autonomous(2000 , 2000 , 2000 , 2000, 0.6 , 0.6 , 0.9 , CatapultaModes.HOLD);
                waitSeconds(0.02);

                stopResetMotors();
                autonomous(-570 , -570 , -570 , -570, 0.8 , 0.8 , 0.9 , CatapultaModes.HOLD);
                waitSeconds(0.02);

                stopResetMotors();
                autonomous(1770 , 1770 , -1770 , -1770, 0.8 , 0.8 , 0 , CatapultaModes.HOLD);
                waitSeconds(0.02);

                stopResetMotors();
                autonomous(600 , -600 , 600 , -600, 0.7 , 0.7 , 0 , CatapultaModes.HOLD);
                waitSeconds(0.02);

                stopResetMotors();
                autonomous(500 , 500 , 500 , 500, 0.8 , 0.8 , 0 , CatapultaModes.DOWN);
                waitSeconds(0.02);

                Catapulta_score();
                waitSeconds(0.02);

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
            autonomous(0 , 0 , 0 , 0, 0 , 0 , 0 , CatapultaModes.UP);
            sleep(100);*/

            telemetry.update();


            }
        }
    }


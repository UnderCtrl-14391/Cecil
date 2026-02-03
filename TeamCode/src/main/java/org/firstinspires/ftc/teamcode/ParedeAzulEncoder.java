package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous
public class ParedeAzulEncoder extends AutoFunction {

    private final ElapsedTime runtime = new ElapsedTime();
    private boolean done = false;

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
            /*if(!done) {
                autonomous(-1500, -1500, -1500, -1500, 0.8, 0.8, 0, CatapultaModes.DOWN);
               telemetry.addData("done" , done);
               telemetry.addData("encoder", leftT.getCurrentPosition());
               telemetry.update();
               done = true;
            }
            done = false;
            runtime.reset();
            while(runtime.seconds() <= 3){
                autonomous(0,0,0,0,0,0,0 , CatapultaModes.HOLD);
            }
            if(!done){
                autonomous(-2400 , -2400 ,2400 , 2400 , 0.8 , 0.8 , 0 , CatapultaModes.HOLD );
                    done = true;
            }

        //if (runtime.seconds() >= 5.10){autonomous(600,-600,600,-600,0.7,0.7,0, CatapultaModes.HOLD);}
        //sleep(100);

        //if (runtime.seconds() <= 5.90){autonomous(2000,2000,2000,2000,0.8,0.8,0, CatapultaModes.HOLD);}
        //sleep(200);

        //if (runtime.seconds() <= 7.10){autonomous(300,300,300,300,0.8,0.8,0, CatapultaModes.DOWN);}
        //sleep(150);

        //if (runtime.seconds() <= 7.30){autonomous(0,0,0,0,0,0,0, CatapultaModes.UP);}
        //sleep(10);

        //if (runtime.seconds() <= 7.50){autonomous(-600,600,-600,600,0.7,0.7,0,CatapultaModes.DOWN);}
        //sleep(100);

        //autonomous(-2000,-2000,-2000,-2000,0.8,0.8,0,CatapultaModes.HOLD);
        //sleep(1200);

        //autonomous(-5000, -5000, 5000, 5000, 0.8, 0.8, 0, CatapultaModes.HOLD);

        telemetry.update();*/
        }
    }
}
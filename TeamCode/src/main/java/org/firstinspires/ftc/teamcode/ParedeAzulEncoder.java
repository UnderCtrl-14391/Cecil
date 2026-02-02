package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.TimerExample.runtime;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class ParedeAzulEncoder extends AutoFunction {
    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
        autonomous(-1500,-1500,-1500,-1500,0.8,0.8,0, CatapultaModes.DOWN);
        if (runtime.seconds() >= 2)

        //sleep(100);

        autonomous(1,1,1,1,0.1,0.1,0, CatapultaModes.HOLD);
        sleep(3000);

        autonomous(-2400,-2400,2400,2400,0.8,0.8,0,CatapultaModes.HOLD);
        //sleep(100);

        autonomous(600,-600,600,-600,0.7,0.7,0, CatapultaModes.HOLD);
        //sleep(100);

        autonomous(2000,2000,2000,2000,0.8,0.8,0, CatapultaModes.HOLD);
        //sleep(200);

        /*autonomous(300,300,300,300,0.8,0.8,0, CatapultaModes.DOWN);
        //sleep(150);*/

        autonomous(0,0,0,0,0,0,0, CatapultaModes.UP);
        sleep(10);

        autonomous(-600,600,-600,600,0.7,0.7,0,CatapultaModes.DOWN);
        //sleep(100);

        autonomous(-2000,-2000,-2000,-2000,0.8,0.8,0,CatapultaModes.HOLD);
        //sleep(1200);

        autonomous(-5000, -5000, 5000, 5000, 0.8, 0.8, 0, CatapultaModes.HOLD);

        telemetry.update();


        }
    }
}

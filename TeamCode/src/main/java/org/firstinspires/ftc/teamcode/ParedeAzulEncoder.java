package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class ParedeAzulEncoder extends AutoFunction {
    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
        autonomous(0,0,0,0,0,0,0, CatapultaModes.DOWN);
        sleep(3000);

        autonomous(-500,-500,500,500,0.8,0.8,0, CatapultaModes.HOLD);
        //sleep(100);

        autonomous(500,500,500,500,0.8,0.8,0, CatapultaModes.HOLD);
        //sleep(100);

        autonomous(600,-600,600,-600,0.7,0.7,0, CatapultaModes.HOLD);
        //sleep(200);

        autonomous(300,300,300,300,0.8,0.8,0, CatapultaModes.DOWN);
        //sleep(150);

        autonomous(0,0,0,0,0,0,0, CatapultaModes.UP);
        //sleep(100);

        autonomous(-600,600,-600,600,0.7,0.7,0,CatapultaModes.DOWN);
        //sleep(100);

        autonomous(-2000,-2000,-2000,-2000,0.8,0.8,0,CatapultaModes.HOLD);
        //sleep(1200);

        telemetry.update();


        }
    }
}

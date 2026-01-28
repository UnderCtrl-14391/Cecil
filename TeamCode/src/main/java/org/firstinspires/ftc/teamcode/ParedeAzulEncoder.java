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
        sleep(5000);

        autonomous(500,-500,-500,500,0.8,0.8,0, CatapultaModes.DOWN);
        sleep(350);

        autonomous(500,500,500,500,0.8,0.8,0, CatapultaModes.DOWN);
        sleep(400);

        autonomous(600,-600,600,-600,0.7,0.7,0, CatapultaModes.DOWN);
        sleep(600);

        autonomous(0,0,0,0,0,0,0, CatapultaModes.UP);
        sleep(500);

        autonomous(-600,600,-600,600,0.7,0.7,0,CatapultaModes.HOLD);
        sleep(600);

        autonomous(-1200,-1200,-1200,-1200,0.8,0.8,0,CatapultaModes.DOWN);
        sleep(1200);

        telemetry.update();


        }
    }
}

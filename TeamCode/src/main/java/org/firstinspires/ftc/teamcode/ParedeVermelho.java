package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class ParedeVermelho extends AutoFunction {

    private final ElapsedTime runtime = new ElapsedTime();

    public void waitSeconds(double seconds) {
        runtime.reset();
        while (runtime.seconds() <= seconds) {
        }
    }

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
            stopResetMotors();
            autonomous(-1400, -1400, -1400, -1400, 0.8, 0.8, 0, CatapultaModes.DOWN);
            waitSeconds(3);

            stopResetMotors();
            autonomous(1300, 1300, -1300, -1300, 0.8, 0.8, 0, CatapultaModes.HOLD);
            waitSeconds(0);

            stopResetMotors();
            autonomous(-410, 410, -410, 410, 0.7, 0.7, 0, CatapultaModes.HOLD);
            waitSeconds(0);

            stopResetMotors();
            autonomous(2000, 2000, 2000, 2000, 0.8, 0.8, 0, CatapultaModes.HOLD);
            waitSeconds(0);

            Catapulta_score();
            waitSeconds(0);

            stopResetMotors();
            autonomous(600,-600,600,-600,0.7,0.7,0,CatapultaModes.DOWN);
            waitSeconds(0);

            stopResetMotors();
            autonomous(-1400,-1400,-1400,-1400,0.8,0.8,0,CatapultaModes.HOLD);
            waitSeconds(0);

            stopResetMotors();
            autonomous(5000, 5000, -5000, -5000, 0.8, 0.8, 0, CatapultaModes.HOLD);

            telemetry.update();
        }

    }
}

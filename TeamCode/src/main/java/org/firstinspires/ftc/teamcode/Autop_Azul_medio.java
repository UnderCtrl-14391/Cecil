package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Autop_Azul_medio extends AutoFunction {

    @Override
    public void runOpMode() {

        HardwareMap(hardwareMap);

        waitForStart();
        autonomous(0,0,0,0,0,0,0,0,0);
        sleep(1000);
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous
public class Autop_Azul_longe extends LinearOpMode {

    @Override
    public void runOpMode() {
        AutoFunction auto = new AutoFunction();

        waitForStart();
        auto.autonomous(0 , 0 , 0, 0, 0, 0, 0, 0, 0);
    }
}

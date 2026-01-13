package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Autotop_AzulLonge {
    private com.qualcomm.robotcore.hardware.HardwareMap hardwareMap;

    @Override
    public void runOpMode() {
        Autotop_AzulLonge auto = new Autotop_AzulLonge();

        waitForStart();
        auto.autonomous(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class imu extends OpMode {
    double heading;
    DecodeTeletop bench = new DecodeTeletop();

    @Override
    public void init() {
        // Manually assigning the hardwareMap to the bench instance
        // since DecodeTeletop is being used as a hardware class here.
        bench.hardwareMap = hardwareMap;
        
        // Initializing motors and IMU
        bench.right = hardwareMap.get(com.qualcomm.robotcore.hardware.DcMotor.class, "right");
        bench.rightT = hardwareMap.get(com.qualcomm.robotcore.hardware.DcMotor.class, "rightT");
        bench.left = hardwareMap.get(com.qualcomm.robotcore.hardware.DcMotor.class, "left");
        bench.leftT = hardwareMap.get(com.qualcomm.robotcore.hardware.DcMotor.class, "leftT");
        bench.imu = hardwareMap.get(com.qualcomm.robotcore.hardware.IMU.class, "imu");

        com.qualcomm.hardware.rev.RevHubOrientationOnRobot orientation = new com.qualcomm.hardware.rev.RevHubOrientationOnRobot(
                com.qualcomm.hardware.rev.RevHubOrientationOnRobot.LogoFacingDirection.BACKWARD,
                com.qualcomm.hardware.rev.RevHubOrientationOnRobot.UsbFacingDirection.UP);
        bench.imu.initialize(new com.qualcomm.robotcore.hardware.IMU.Parameters(orientation));
    }

    @Override
    public void loop() {
        // Using getHeading() without arguments as defined in DecodeTeletop
        heading = bench.getHeading();
        telemetry.addData("Heading", heading);

        if (heading < 0.5 && heading > -0.5) {
            // Stop motors if heading is centered
            bench.setRight(0.0);
            bench.setLeft(0.0);
        } else if (heading <= -0.5) {
            // Heading is less than -0.5, make motors positive
            bench.setRight(0.5);
            bench.setLeft(0.5);
        } else {
            // Heading is greater than 0.5, make motors negative
            bench.setRight(-0.5);
            bench.setLeft(-0.5);
        }
        telemetry.update();
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TELEMETRY extends LinearOpMode {

    public DcMotor left, right, leftT, rightT, intake, intake2, catapulta1, catapulta2;


    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        leftT = hardwareMap.get(DcMotor.class, "leftT");
        rightT = hardwareMap.get(DcMotor.class, "rightT");
        intake = hardwareMap.get(DcMotor.class, "intake");
        intake2 = hardwareMap.get(DcMotor.class, "intake2");
        catapulta1 = hardwareMap.get(DcMotor.class, "catapulta1");
        catapulta2 = hardwareMap.get(DcMotor.class, "catapulta2");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("LeftTarget" , leftT.getCurrentPosition());
            telemetry.addData("Left" , left.getCurrentPosition());
            telemetry.addData("RightTarget" , rightT.getCurrentPosition());
            telemetry.addData("Right" , rightT.getCurrentPosition());
            telemetry.update();
        }
    }




}

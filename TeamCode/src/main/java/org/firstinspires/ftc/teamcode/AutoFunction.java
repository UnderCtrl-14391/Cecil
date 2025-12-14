package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class AutoFunction {
    private com.qualcomm.robotcore.hardware.HardwareMap hardwareMap;
    public  DcMotor left;
    public DcMotor right;
    public DcMotor leftT;
    public DcMotor rightT;
    public DcMotor intake;
    public DcMotor catapulta1;
    public DcMotor catapulta2;
    public DcMotor fat;

    public void HardwareMap(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        leftT = hardwareMap.get(DcMotor.class, "leftT");
        rightT = hardwareMap.get(DcMotor.class, "rightT");
        intake = hardwareMap.get(DcMotor.class, "intake");
        catapulta1 = hardwareMap.get(DcMotor.class, "catapulta1");
        catapulta2 = hardwareMap.get(DcMotor.class, "catapulta2");
        fat = hardwareMap.get(DcMotor.class, "fat");
    }

    public void autonomous (int rightFront , int leftFront , int rightTarget , int leftTarget , int rightPower , int leftPower , int intakeP , int catapulta , int catapultaPower) {
        //tração
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setTargetPosition(rightFront);
        left.setTargetPosition(leftFront);
        rightT.setTargetPosition(rightTarget);
        leftT.setTargetPosition(leftTarget);
        right.setPower(rightPower);
        rightT.setPower(rightPower);
        left.setPower(leftPower);
        leftT.setPower(leftPower);
        //mecanismos
        intake.setPower(intakeP);
        catapulta1.setTargetPosition(catapulta);
        catapulta2.setTargetPosition(catapulta);
        catapulta1.setPower(catapultaPower);
        catapulta2.setPower(catapultaPower);
    }
}

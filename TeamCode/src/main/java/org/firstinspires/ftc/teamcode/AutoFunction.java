package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class AutoFunction {
    public DcMotor direita;
    public DcMotor direitaTras;
    public DcMotor esquerda;
    public DcMotor esquerdaTras;
    public DcMotor shooterD;
    public DcMotor shooterE;
    public CRServo index2;
    public CRServo index1;
    public DcMotor intakemotor;

    public void autonomous (int rightFront , int leftFront , int rightTarget , int leftTarget , int rightPower , int leftPower , int ShooterPower , int index , int intakePower) {
        direita.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        direitaTras.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        esquerda.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        esquerdaTras.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        direita.setTargetPosition(rightFront);
    }
}

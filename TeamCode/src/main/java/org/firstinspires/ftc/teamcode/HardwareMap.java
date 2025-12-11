package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class HardwareMap {

    private com.qualcomm.robotcore.hardware.HardwareMap hardwareMap;
    public DcMotor direita;
    public DcMotor direitaTras;
    public DcMotor esquerda;
    public DcMotor esquerdaTras;
    public DcMotor shooterD;
    public DcMotor shooterE;
    public CRServo index2;
    public CRServo index1;
    public DcMotor intakemotor;


    public HardwareMap(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        shooterD = hardwareMap.get(DcMotor.class, "shooterD");
        shooterE = hardwareMap.get(DcMotor.class, "shooterE");
        index2 = hardwareMap.get(CRServo.class, "index2");
        index1 = hardwareMap.get(CRServo.class, "index1");
        direitaTras=hardwareMap.get(DcMotor.class, "direitaTras");
        direita = hardwareMap.get(DcMotor.class, "direita");
        esquerdaTras = hardwareMap.get(DcMotor.class , "esquerdaTras");
        esquerda = hardwareMap.get(DcMotor.class, "esquerda");
        intakemotor = hardwareMap.get(DcMotor.class, "intake");
    }

}

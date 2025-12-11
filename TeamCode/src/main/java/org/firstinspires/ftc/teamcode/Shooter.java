package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Shooter {
    DcMotor motorShooterLeft;
    DcMotor motorShooterRight;

    public Shooter(HardwareMap map){
        motorShooterLeft = map.shooterE;
        motorShooterRight = map.shooterD;
    }

    public void spin(){
        motorShooterRight.setPower(1.0);
        motorShooterLeft.setPower(1.0);
    }

    public void stop(){
        motorShooterRight.setPower(0.0);
        motorShooterLeft.setPower(0.0);
    }
}

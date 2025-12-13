package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@TeleOp
public class DecodeTeletop extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime catatime = new ElapsedTime();

    public DcMotor left;
    public DcMotor leftTarget;
    public DcMotor right;
    public DcMotor rightTarget;
    public DcMotor intake;
    public DcMotor catapult1;
    public DcMotor catapult2;
    public DcMotor fat;
    public double INTAKE_IN_POWER = 1.0;
    public double INTAKE_OUT_POWER = -0.7;
    public double INTAKE_OFF_POWER = 0.0;
    public double FAT_UP_POWER = 0.8;
    public double FAT_DOWN_POWER = -0.7;
    public double FAT_OFF_POWER = 0.0;
    public double CATAPULT_SHOOT_POWER = 1.0;
    public double CATAPULT_BACK_POWER = -0.8;
    public double CATAPULT_HOLD_POWER = 0.3;
    private enum CatapultModes {SHOOT, BACK, HOLD}
    private enum FatModes {UP, DOWN, OFF};







    public void runOpMode() throws InterruptedException {

    }
}

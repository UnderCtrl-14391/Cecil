package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class AutoFunction extends LinearOpMode {

    public DcMotor left, right, leftT, rightT, intake, intake2, catapulta1, catapulta2;

    public void HardwareMap(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        leftT = hardwareMap.get(DcMotor.class, "leftT");
        rightT = hardwareMap.get(DcMotor.class, "rightT");
        intake = hardwareMap.get(DcMotor.class, "intake");
        intake2 = hardwareMap.get(DcMotor.class, "intake2");
        catapulta1 = hardwareMap.get(DcMotor.class, "catapulta1");
        catapulta2 = hardwareMap.get(DcMotor.class, "catapulta2");

        // REVERSE left motors so the robot moves forward correctly
        left.setDirection(DcMotorSimple.Direction.FORWARD);
        leftT.setDirection(DcMotorSimple.Direction.FORWARD);
        right.setDirection(DcMotorSimple.Direction.REVERSE);
        rightT.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setDirection(DcMotor.Direction.REVERSE);
        intake2.setDirection(DcMotor.Direction.FORWARD);
        
        // Ensure mechanisms stop when power is 0
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void autonomous(int rightFront, int leftFront, int rightTarget, int leftTarget, double rightPower, double leftPower, double intakeP, int catapultaPos, double catapultaPower) {
        // Reset Encoders
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set Targets
        right.setTargetPosition(rightFront);
        left.setTargetPosition(leftFront);
        rightT.setTargetPosition(rightTarget);
        leftT.setTargetPosition(leftTarget);
        catapulta1.setTargetPosition(catapultaPos);
        catapulta2.setTargetPosition(catapultaPos);

        // Set to RUN_TO_POSITION
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        catapulta1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        catapulta2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Set Powers
        right.setPower(rightPower);
        rightT.setPower(rightPower);
        left.setPower(leftPower);
        leftT.setPower(leftPower);
        
        intake.setPower(intakeP);
        intake2.setPower(intakeP);
        
        catapulta1.setPower(catapultaPower);
        catapulta2.setPower(catapultaPower);

        while (opModeIsActive() &&
                (right.isBusy() ||
                        rightT.isBusy() ||
                        left.isBusy() ||
                        leftT.isBusy() ||
                        catapulta1.isBusy() ||
                        catapulta2.isBusy())){
            idle();

        }

    }

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);
        waitForStart();
        
        // Example: Move forward 1000 ticks with 50% power
        autonomous(1000, 1000, 1000, 1000, 0.5, 0.5, 0, 0, 0);
    }
}

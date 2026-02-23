package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous
public class AutoFunction extends LinearOpMode{

    private final ElapsedTime runtime = new ElapsedTime();

    public DcMotor left, right, leftT, rightT, intake, intake2, catapulta1, catapulta2;
    public double CATAPULTA_UP_POWER = 1.0;
    public double CATAPULTA_DOWN_POWER = -1.0;
    public double CATAPULTA_HOLD_POWER = -0.9; // Small power to resist gravity

    // State tracking
    public enum CatapultaModes {UP, DOWN, HOLD}
    public AutoFunction.CatapultaModes pivotMode = AutoFunction.CatapultaModes.HOLD;
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
        left.setDirection(DcMotor.Direction.FORWARD);
        leftT.setDirection(DcMotor.Direction.FORWARD);
        right.setDirection(DcMotor.Direction.FORWARD);
        rightT.setDirection(DcMotor.Direction.FORWARD);

        intake.setDirection(DcMotor.Direction.FORWARD);
        intake2.setDirection(DcMotor.Direction.REVERSE);
        catapulta1.setDirection(DcMotor.Direction.REVERSE);
        catapulta2.setDirection(DcMotor.Direction.FORWARD);
        
        // Ensure mechanisms stop when power is 0
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    public void setCatapultaModes(CatapultaModes mode){
        switch (mode){
            case UP:
                catapulta1.setPower(1);
                catapulta2.setPower(1);
                break;
            case DOWN:
                catapulta1.setPower(-1);
                catapulta2.setPower(-1);
                break;
            case HOLD:
                catapulta1.setPower(-0.15);
                catapulta2.setPower(-0.15);
                break;
        }
    }


    public void stopMotors(){
        right.setPower(0);
        rightT.setPower(0);
        left.setPower(0);
        leftT.setPower(0);
    }

    public void stopResetMotors(){
        // Reset Encoders
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void Catapulta_score(){
        setCatapultaModes(CatapultaModes.DOWN);
        sleep(100);
        setCatapultaModes(CatapultaModes.UP);
        sleep(100);


    }


    public void autonomous(int rightFront, int leftFront, int rightTarget, int leftTarget ,double rightPower, double leftPower, double intakeP, CatapultaModes catapultaPower , double timerLimit) {

        // Set Targets
        right.setTargetPosition(rightFront);
        left.setTargetPosition(leftFront);
        rightT.setTargetPosition(rightTarget);
        leftT.setTargetPosition(leftTarget);

        // Set to RUN_TO_POSITION
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftT.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Set Powers
        right.setPower(rightPower);
        rightT.setPower(rightPower);
        left.setPower(leftPower);
        leftT.setPower(leftPower);

        intake.setPower(intakeP);
        intake2.setPower(intakeP);

        setCatapultaModes(catapultaPower);

        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < timerLimit && (right.isBusy() || rightT.isBusy() || left.isBusy() || leftT.isBusy())) {
            telemetry.addData("right", right.getCurrentPosition());
            telemetry.update();
        }
        stopMotors();
    }

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);
        waitForStart();
    }    }


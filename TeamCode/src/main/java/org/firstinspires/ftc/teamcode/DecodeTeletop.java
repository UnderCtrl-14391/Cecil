package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class DecodeTeletop extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    public DcMotor left;
    public DcMotor leftTarget;
    public DcMotor right;
    public DcMotor rightTarget;
    public DcMotor intake;
    public DcMotor catapulta1;
    public DcMotor catapulta2;
    public DcMotor fat;

    public double INTAKE_IN_POWER = 1.0;
    public double INTAKE_OUT_POWER = -0.7;
    public double INTAKE_OFF_POWER = 0.0;
    public double FAT_UP_POWER = 0.8;
    public double FAT_DOWN_POWER = -0.7;
    public double FAT_OFF_POWER = 0.0;
    public double CATAPULTA_UP_POWER = 1.0;
    public double CATAPULTA_DOWN_POWER = -0.8;
    public double CATAPULTA_HOLD_POWER = 0.3;

    private enum CatapultaModes {UP, DOWN, HOLD}
    private enum FatModes {UP, DOWN, OFF}

    @Override
    public void runOpMode() {
        // Initialize Hardware
        right = hardwareMap.get(DcMotor.class, "right");
        rightTarget = hardwareMap.get(DcMotor.class, "rightTarget");
        left = hardwareMap.get(DcMotor.class, "left");
        leftTarget = hardwareMap.get(DcMotor.class, "leftTarget");
        intake = hardwareMap.get(DcMotor.class, "intake");
        catapulta1 = hardwareMap.get(DcMotor.class, "catapulta1");
        catapulta2 = hardwareMap.get(DcMotor.class, "catapulta2");
        fat = hardwareMap.get(DcMotor.class, "fat");

        // Set Directions
        right.setDirection(DcMotor.Direction.FORWARD);
        rightTarget.setDirection(DcMotor.Direction.REVERSE);
        left.setDirection(DcMotor.Direction.REVERSE);
        leftTarget.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.FORWARD);
        catapulta1.setDirection(DcMotor.Direction.REVERSE);
        catapulta2.setDirection(DcMotor.Direction.FORWARD);
        fat.setDirection(DcMotor.Direction.REVERSE);

        // Set Zero Power Behavior
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // DRIVE LOGIC (Gamepad 1)
            double axial = -gamepad1.left_stick_y;
            double lateral = -gamepad1.right_stick_x;
            double yaw = -gamepad1.left_stick_x;

            double leftPower = axial + lateral + yaw;
            double rightPower = axial - lateral - yaw;
            double leftTargetPower = axial - lateral + yaw;
            double rightTargetPower = axial + lateral - yaw;

            double max = Math.max(Math.abs(leftPower), Math.abs(rightPower));
            max = Math.max(max, Math.abs(leftTargetPower));
            max = Math.max(max, Math.abs(rightTargetPower));

            if (max > 1.0) {
                leftPower /= max;
                rightPower /= max;
                leftTargetPower /= max;
                rightTargetPower /= max;
            }

            left.setPower(leftPower);
            right.setPower(rightPower);
            leftTarget.setPower(leftTargetPower);
            rightTarget.setPower(rightTargetPower);

            // MECHANISM LOGIC (Gamepad 2)
            
            // Intake
            boolean intakeInButton = gamepad2.right_trigger > 0.2;
            boolean intakeOutButton = gamepad2.left_trigger > 0.2;
            double intakePower;
            if (intakeInButton) {
                intakePower = INTAKE_IN_POWER;
            } else if (intakeOutButton) {
                intakePower = INTAKE_OUT_POWER;
            } else {
                intakePower = INTAKE_OFF_POWER;
            }
            intake.setPower(intakePower);

            // Fat (Linear Slide/Lifter)
            boolean fatUpButton = gamepad2.dpad_up;
            boolean fatDownButton = gamepad2.dpad_down;
            FatModes fatmode;
            double fatPower;
            if (fatUpButton) {
                fatmode = FatModes.UP;
                fatPower = FAT_UP_POWER;
            } else if (fatDownButton) {
                fatmode = FatModes.DOWN;
                fatPower = FAT_DOWN_POWER;
            } else {
                fatmode = FatModes.OFF;
                fatPower = FAT_OFF_POWER;
            }
            fat.setPower(fatPower);

            // Catapult
            boolean catapultUpButton = gamepad2.y;
            boolean catapultDownButton = gamepad2.a;
            CatapultaModes pivotMode;
            if (catapultUpButton) {
                pivotMode = CatapultaModes.UP;
                catapulta1.setPower(CATAPULTA_UP_POWER);
                catapulta2.setPower(CATAPULTA_UP_POWER);
            } else if (catapultDownButton) {
                pivotMode = CatapultaModes.DOWN;
                catapulta1.setPower(CATAPULTA_DOWN_POWER);
                catapulta2.setPower(CATAPULTA_DOWN_POWER);
            } else {
                pivotMode = CatapultaModes.HOLD;
                catapulta1.setPower(CATAPULTA_HOLD_POWER);
                catapulta2.setPower(CATAPULTA_HOLD_POWER);
            }

            // Telemetry
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Drive Powers", "FL:%.2f, FR:%.2f, BL:%.2f, BR:%.2f", 
                leftPower, rightPower, leftTargetPower, rightTargetPower);
            telemetry.addData("Intake Power", "%.2f", intake.getPower());
            telemetry.addData("Foot MODE", "%s", fatmode);
            telemetry.addData("Catapult MODE", "%s", pivotMode);
            telemetry.update();
        }
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class DecodeTeletop extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    public DcMotor left;
    public DcMotor leftT;
    public DcMotor right;
    public DcMotor rightT;
    public DcMotor intake;
    public DcMotor intake2;
    public DcMotor catapulta1;
    public DcMotor catapulta2;
    public Servo fat;
    public double INTAKE_IN_POWER = 1.0;
    public double INTAKE_OUT_POWER = -0.7;
    public double INTAKE_OFF_POWER = 0.0;
    public double FAT_UP_POWER = 0.8;
    public double FAT_DOWN_POWER = -0.7;
    public double FAT_OFF_POWER = 0.0;
    public double CATAPULTA_UP_POWER = -1.0;
    public double CATAPULTA_DOWN_POWER = 1.0;
    public double CATAPULTA_HOLD_POWER = 0.2;

    private enum CatapultaModes {UP, DOWN, HOLD}
    private  CatapultaModes pivotMode;
    private enum FatModes {UP, DOWN, OFF}

    @Override
    public void runOpMode() {
        // Initialize Hardware
        right = hardwareMap.get(DcMotor.class, "right");
        rightT = hardwareMap.get(DcMotor.class, "rightT");
        left = hardwareMap.get(DcMotor.class, "left");
        leftT = hardwareMap.get(DcMotor.class, "leftT");
        intake = hardwareMap.get(DcMotor.class, "intake");
        intake2 = hardwareMap.get(DcMotor.class, "intake2");
        catapulta1 = hardwareMap.get(DcMotor.class, "catapulta1");
        catapulta2 = hardwareMap.get(DcMotor.class, "catapulta2");
        fat = hardwareMap.get(Servo.class , "fat");
        // Set Directions


        intake.setDirection(DcMotor.Direction.REVERSE);
        intake2.setDirection(DcMotor.Direction.FORWARD);
        catapulta1.setDirection(DcMotor.Direction.REVERSE);
        catapulta2.setDirection(DcMotor.Direction.FORWARD);


        // Set Zero Power Behavior
        intake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // DRIVE LOGIC (Gamepad 1)
            double axial = -gamepad1.right_stick_x;//giro
            double lateral = -gamepad1.left_stick_x;//streif
            double yaw = -gamepad1.left_stick_y; // frente

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
            leftT.setPower(leftTargetPower);
            rightT.setPower(rightTargetPower);

            // MECHANISM LOGIC (Gamepad 2)
            
            // Intake
            boolean intakeInButton = gamepad2.left_stick_y > 0.2;
            boolean intakeOutButton = gamepad2.left_stick_y > 0.2;
            double intakePower;
            if (intakeInButton) {
                intakePower = INTAKE_IN_POWER;
            } else if (intakeOutButton) {
                intakePower = INTAKE_OUT_POWER;
            } else {
                intakePower = INTAKE_OFF_POWER;
            }
            intake.setPower(intakePower);
            intake2.setPower(intakePower);

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
            fat.setPosition(fatPower);

            // Catapult
            boolean catapultUpButton = gamepad2.x;
            boolean catapultDownButton = gamepad2.y;
            if(catapultUpButton && catapultDownButton){
                catapulta1.setPower(CATAPULTA_HOLD_POWER);
                catapulta2.setPower(CATAPULTA_HOLD_POWER);
            }
            else if (catapultUpButton) {
                catapulta1.setPower(CATAPULTA_UP_POWER);
                catapulta2.setPower(CATAPULTA_UP_POWER);
            } else if (catapultDownButton) {
                catapulta1.setPower(CATAPULTA_DOWN_POWER);
                catapulta2.setPower(CATAPULTA_DOWN_POWER);
            }
            else {
                catapulta1.setPower(CATAPULTA_HOLD_POWER);
                catapulta2.setPower(CATAPULTA_HOLD_POWER);
            }


           /* boolean catapultUpButton = gamepad2.x;
            CatapultaModes pivotMode;{
            }  if (catapultUpButton) {
                pivotMode = CatapultaModes.UP;
                catapulta1.setPower(CATAPULTA_UP_POWER);
                catapulta2.setPower(CATAPULTA_UP_POWER);
            } else {
                pivotMode = CatapultaModes.HOLD;
                catapulta1.setPower(CATAPULTA_HOLD_POWER);
                catapulta2.setPower(CATAPULTA_HOLD_POWER);
            }
/
            boolean catapultDownButton = gamepad2.y; {
                if (catapultDownButton) {
                    pivotMode = CatapultaModes.DOWN;
                    catapulta1.setPower(CATAPULTA_DOWN_POWER);
                    catapulta2.setPower(CATAPULTA_DOWN_POWER);
                }   else {
                        pivotMode = CatapultaModes.HOLD;
                        catapulta1.setPower(CATAPULTA_HOLD_POWER);
                        catapulta2.setPower(CATAPULTA_HOLD_POWER);
            }*/


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

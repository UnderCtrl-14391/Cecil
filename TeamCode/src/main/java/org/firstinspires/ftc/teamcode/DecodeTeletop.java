package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class DecodeTeletop extends LinearOpMode{

    private final ElapsedTime runtime = new ElapsedTime();
    private final ElapsedTime catatime = new ElapsedTime();

    public DcMotor left;
    public DcMotor leftTarget;
    public DcMotor right;
    public DcMotor rightTarget;
    public DcMotor intake;
    public DcMotor catapulta1;
    public DcMotor catapulta2;
    public DcMotor fat;
    public double INTAKE_IN_POWER = 1.0;
    public float INTAKE_OUT_POWER = (float) (float) -0.7;
    public double INTAKE_OFF_POWER = 0.0;
    public double FAT_UP_POWER = 0.8;
    public double FAT_DOWN_POWER = -0.7;
    public double FAT_OFF_POWER = 0.0;
    public double CATAPULTA_UP_POWER = 1.0;
    public double CATAPULTA_DOWN_POWER = -0.8;
    public double CATAPULTA_HOLD_POWER = 0.3;
    private enum CatapultaModes {SHOOT, BACK, HOLD;
        public static final Object DOWN =0 ;
        public static final Object UP = 0;
        public double setpower;
    }
    private enum FatModes {UP, DOWN, OFF}

    @Override
    public void runOpMode () {
        waitForStart();
        right = hardwareMap.get(DcMotor.class, "right");
        rightTarget = hardwareMap.get(DcMotor.class, "rightTarget");
        left = hardwareMap.get(DcMotor.class, "left");
        leftTarget = hardwareMap.get(DcMotor.class, "leftTarget");
        intake = hardwareMap.get(DcMotor.class, "intake");
        catapulta1 = hardwareMap.get(DcMotor.class, "catapulta1");
        catapulta2 = hardwareMap.get(DcMotor.class, "catapulta2");
        fat = hardwareMap.get(DcMotor.class, "fat");


        right.setDirection(DcMotor.Direction.FORWARD);
        rightTarget.setDirection(DcMotor.Direction.REVERSE);
        left.setDirection(DcMotor.Direction.REVERSE);
        leftTarget.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.FORWARD);
        catapulta1.setDirection(DcMotor.Direction.REVERSE);
        catapulta2.setDirection(DcMotor.Direction.FORWARD);
        fat.setDirection(DcMotor.Direction.REVERSE);


        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        catapulta2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();
        catatime.reset();

        double left = 0;
        double leftTarget = 0;
        double right = 0;
        double rightTarget = 0;
        while (opModeIsActive()) {
            double max;


            double axial = -gamepad1.left_stick_y;
            double lateral = -gamepad1.right_stick_x;
            double yaw = -gamepad1.left_stick_x;

            boolean intakeInButton = gamepad2.left_stick_y > 0.2;
            float intakeOutButton = gamepad2.left_stick_x;

            if (intakeInButton & intakeOutButton) {
                intakeInButton = false;
            }

            boolean fatOutButton = gamepad2.a;
            boolean footUpButton = gamepad2.a;
            if (fatOutButton && footUpButton) {
                fatOutButton = false;

                boolean catapultUpButton;
                if (gamepad2.x){
                      
                }

                if (gamepad2.x) catapultUpButton = true;
                else catapultUpButton = false;
                boolean catapultDownButton;
                if (gamepad2.x = 0.2) catapultDownButton = true;
                else catapultDownButton = false;




                Object pivotMode = null;
                FatModes fatmode = null;
                if (catapultUpButton && catapultDownButton) {
                    catapultUpButton = false;

                    left = axial + lateral + yaw;
                    right = axial - lateral - yaw;
                    leftTarget = axial - lateral + yaw;
                    rightTarget = axial + lateral - yaw;

                    max = Math.max(Math.abs(left), Math.abs(right));
                    max = Math.max(max, Math.abs(leftTarget));
                    max = Math.max(max, Math.abs(rightTarget));

                    if (max > 1.0) {
                        left /= max;
                        right /= max;
                        leftTarget /= max;
                        rightTarget /= max;
                    }

                    left = gamepad1.x ? 1.0 : 0.0;  // X gamepad
                    leftTarget = gamepad1.a ? 1.0 : 0.0;  // A gamepad
                    rightTarget = gamepad1.y ? 1.0 : 0.0;  // Y gamepad
                    right = gamepad1.b ? 1.0 : 0.0;  // B gamepad */

                    double intakePower;
                    if (intakeInButton) {
                        intakePower = INTAKE_IN_POWER;
                    } else if (intakeOutButton) {
                        intakePower = INTAKE_OUT_POWER;
                    } else {
                        intakePower = INTAKE_OFF_POWER;
                    }

                    FatModes FatMode;
                    double fatPower;
                    if (fatOutButton) {
                        fatmode = FatMode.DOWN;
                        fatPower = FAT_DOWN_POWER;
                    } else if (footUpButton) {
                        fatmode = FatMode.UP;
                        fatPower = FAT_UP_POWER;
                    } else {
                        double fatMode = FAT_UP_POWER;
                        fat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                        fatPower = FAT_OFF_POWER;
                    }

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
                    left.setPower(left);
                    right.setPower(right);
                    leftTarget.setPower(leftTarget);
                    rightTarget.setPower(rightTarget);

                    intake.setPower(intakePower);
                    fat.setPower(fatPower);
                }
                String catapult_mode_str;
                if (pivotMode == CatapultaModes.UP) {
                    catapult_mode_str = "UP";
                } else if (pivotMode == CatapultaModes.DOWN) {
                    catapult_mode_str = "DOWN";
                } else {
                    catapult_mode_str = "HOLD";
                }

                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Front left/Right", "%4.2f, %4.2f", left, right);
                telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftTarget, rightTarget);
                telemetry.addData("Intake", "%%4.2f", intake.getPower());
                telemetry.addData("Foot Power", "%4.2f", fat.getPower());
                telemetry.addData("Foot MODE", "%s", fatmode);
                telemetry.addData("Catapult1 Current/Target/power", "%d, %d, %4.2f",
                        catapulta1.getCurrentPosition(), catapulta1.getTargetPosition(), catapulta1.getPower());
                telemetry.addData("Catapult2 Current/Target/power", "%d, %d, %4.2f",
                        catapulta2.getCurrentPosition(), catapulta2.getTargetPosition(), catapulta2.getPower());
                telemetry.addData("Catapult MODE", "%s", catapult_mode_str);
                telemetry.update();
            }


            {

            }
        }
    }}
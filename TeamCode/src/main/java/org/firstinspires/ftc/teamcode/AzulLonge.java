package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous
public class AzulLonge extends AutoFunction{
    private final ElapsedTime runtime = new ElapsedTime();

    public void waitSeconds(double seconds){
        runtime.reset();
        while(runtime.seconds() <= seconds){

        }
    }


    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
            stopResetMotors();
            waitSeconds(23);

            /*autonomous(1400 , 1400 ,1400 , 1400, 0.8 , 0.8 , 0 , AutoFunction.CatapultaModes.DOWN);
            waitSeconds(0.005);

            stopResetMotors();
            autonomous(-1000 , 1000 , -1000 , 1000, 0.7 , 0.7 , 0 , AutoFunction.CatapultaModes.HOLD);*/
        }
    }


}
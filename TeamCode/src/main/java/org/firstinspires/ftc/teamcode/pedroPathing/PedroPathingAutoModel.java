package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.util.Timer;

@Autonomous
public class PedroPathingAutoModel extends OpMode {

    private Follower follower;
    private Timer pathTimer, opModeTimer;

    public enum PathState {
        //START_POSITION_END_POSITION
        // DRIVE > MOVEMENT STATE
        // SHOOT > ATTEMPT TO SCORE ARTIFACT
        DRIVE_START_POS_SHOOT_POS,
        SHOOT_PRELOAD,


    }

    PathState pathState;


    private final Pose startPose = new Pose(20.028169014084504 , 122.60764587525152 , Math.toRadians(143));
    private final Pose shootPose = new Pose(58.607645875251514 , 84.38631790744469 , Math.toRadians(143));
    private PathChain driveStartPoseShootPose;

    public void buildPaths(){
        // put in coordinates for starting pose > shoot pose
        driveStartPoseShootPose = follower.pathBuilder()
                .addPath(new BezierLine(startPose, shootPose))
                .setLinearHeadingInterpolation(startPose.getHeading(), shootPose.getHeading())
                .build();
    }

    public void statePathUpdate(){
        switch (pathState){
            case DRIVE_START_POS_SHOOT_POS:
                follower.followPath(driveStartPoseShootPose , true);
                pathState = PathState.SHOOT_PRELOAD;
                break;
            case SHOOT_PRELOAD:
                //check is follower done its path
                if(follower.isBusy()){
                    //TODO add logic of flywheel shooter
                    telemetry.addLine("Done path 1");
                }
                break;
            default:
                telemetry.addLine("No state commanded");
                break;
        }
    }

    public void setPathState(PathState newState){
        pathState = newState;
        pathTimer.resetTimer();
    }

    @Override
    public void init() {
        pathState = PathState.DRIVE_START_POS_SHOOT_POS;
        pathTimer = new Timer();
        opModeTimer = new Timer();
        follower = Constants.createFollower(hardwareMap);
        //TODO add any other mechanisms that need to be initialized

        buildPaths();
        follower.setPose(startPose);
    }

    public void start(){
        opModeTimer.resetTimer();
        setPathState(PathState.DRIVE_START_POS_SHOOT_POS);
    }


    @Override
    public void loop() {
        follower.update();
        statePathUpdate();

        telemetry.addData("Path State", pathState.toString());
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.addData("path time", pathTimer.getElapsedTimeSeconds());

    }

}

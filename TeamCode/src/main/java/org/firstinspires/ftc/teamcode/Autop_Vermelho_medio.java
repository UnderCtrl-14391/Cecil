package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.PedroPathingAutoModel;


@Autonomous
public class Autop_Vermelho_medio extends OpMode {

    private Follower follower;
    private Timer pathTimer, opModeTimer;

    public enum PathState{
        // SCORE
        //DRIVE LOAD POSITION
        // LOADING POSITION
        //SCORE POSITION
        SCORE_POSITION,
        DRIVE_LOAD_POSITION,
        DRIVE_LOADING,
        SCORE_POSITION_1
    }

    PathState pathState;

    private final Pose startPose = new Pose(127.24346076458752 , 119.7102615694165 , Math.toRadians(37));
    private final Pose loadPose = new Pose (93.33199195171028 , 83.36217303822939 , Math.toRadians(0));
    private final Pose loadingPose1 = new Pose (128.1529175050302 , 83.36217303822939 , Math.toRadians(0));

    private final Pose scorePose = startPose;
    private PathChain driveStartPoseLoadPose, driveLoadPoseLoadingPose1, driveLoadingPose1ScorePose;


    public void buildPaths(){
        driveStartPoseLoadPose = follower.pathBuilder()
                .addPath(new BezierLine(startPose, scorePose))
                .setLinearHeadingInterpolation(startPose.getHeading(), scorePose.getHeading())
                .build();
        driveLoadPoseLoadingPose1 = follower.pathBuilder()
                .addPath(new BezierLine(loadPose, loadingPose1))
                .setLinearHeadingInterpolation(loadPose.getHeading(), loadingPose1.getHeading())
                .build();
        driveLoadingPose1ScorePose = follower.pathBuilder()
                .addPath(new BezierLine(loadingPose1, scorePose))
                .setLinearHeadingInterpolation(loadingPose1.getHeading(), scorePose.getHeading())
                .build();
    }

    public void statePathUpdate(){
        switch (pathState){
            case SCORE_POSITION:
                follower.followPath(driveLoadingPose1ScorePose, true);
                pathState = PathState.DRIVE_LOAD_POSITION;
                break;
            case DRIVE_LOAD_POSITION:
                follower.followPath(driveLoadPoseLoadingPose1, true);
                pathState = PathState.DRIVE_LOADING;
                break;
            case DRIVE_LOADING:
                follower.followPath(driveLoadingPose1ScorePose, true);
                pathState = PathState.SCORE_POSITION;
                break;
            case SCORE_POSITION_1:
                //TODO add logic of catapult
                if(follower.isBusy()){
                    telemetry.addLine("Done path 1");
                }
            default:
                telemetry.addLine("No state commanded");
                break;
        }
    }

    public void setPathState(Autop_Vermelho_medio.PathState newState) {
        pathState = newState;
        pathTimer.resetTimer();
    }



    @Override
    public void init() {
        pathState = PathState.SCORE_POSITION;
        pathTimer = new Timer();
        opModeTimer = new Timer();
        follower = Constants.createFollower(hardwareMap);
        //TODO add any other mechanisms that need to be initialized

        buildPaths();
        follower.setPose(startPose);
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
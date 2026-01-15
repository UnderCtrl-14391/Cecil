package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;


@Autonomous(name = "Autop Vermelho Medio", group = "Autonomous")
public class Autop_Vermelho_medio extends OpMode {

    private Follower follower;
    private Timer pathTimer, opModeTimer;
    private int pathState;
    private Paths paths;

    // Definição da pose inicial
    private final Pose startPose = new Pose(127.243, 119.710, Math.toRadians(37));

    public static class Paths {
        public PathChain SCOREPOINT;
        public PathChain LOADPOS;
        public PathChain LOADING;
        public PathChain SCOREPOS;
        public PathChain LOADPOS2;
        public PathChain LOADING2;
        public PathChain SCOREPOS2;
        public PathChain LOADPOS3;
        public PathChain LOADING3;
        public PathChain SCOREPOS3;
        public PathChain IMURESET;

        public Paths(Follower follower) {
            SCOREPOINT = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(127.243, 119.710),
                                    new Pose(127.243, 119.710)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(37), Math.toRadians(37))
                    .build();

            LOADPOS = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(127.243, 119.710),
                                    new Pose(91.135, 81.817)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(37), Math.toRadians(0))
                    .build();

            LOADING = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(91.135, 81.817),
                                    new Pose(124.634, 82.865)
                            )
                    ).setTangentHeadingInterpolation()
                    .build();

            SCOREPOS = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(124.634, 82.865),
                                    new Pose(127.243, 119.710)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(37))
                    .build();

            LOADPOS2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(127.243, 119.710),
                                    new Pose(96.416, 59.841)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(37), Math.toRadians(0))
                    .build();

            LOADING2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(96.416, 59.841),
                                    new Pose(123.988, 59.791)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                    .build();

            SCOREPOS2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(123.988, 59.791),
                                    new Pose(127.243, 119.710)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(37))
                    .build();

            LOADPOS3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(127.243, 119.710),
                                    new Pose(96.795, 33.765)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(37), Math.toRadians(0))
                    .build();

            LOADING3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(96.795, 33.765),
                                    new Pose(124.312, 34.968)
                            )
                    ).setTangentHeadingInterpolation()
                    .build();

            SCOREPOS3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(124.312, 34.968),
                                    new Pose(127.243, 119.710)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(37))
                    .build();

            IMURESET = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(127.243, 119.710),
                                    new Pose(125.686, 99.028)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(37), Math.toRadians(0))
                    .build();
        }
    }

    public void setPathState(int state) {
        pathState = state;
        pathTimer.resetTimer();
    }

    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                follower.followPath(paths.SCOREPOINT);
                setPathState(1);
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(paths.LOADPOS);
                    setPathState(2);
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(paths.LOADING);
                    setPathState(3);
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(paths.SCOREPOS);
                    setPathState(4);
                }
                break;
            case 4:
                // Autonomous cycle can continue or end here
                if (!follower.isBusy()) {
                    setPathState(-1);
                }
                break;
        }
    }

    @Override
    public void init() {
        pathTimer = new Timer();
        opModeTimer = new Timer();

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startPose);
        
        paths = new Paths(follower);
    }

    @Override
    public void start() {
        opModeTimer.resetTimer();
        setPathState(0);
    }

    @Override
    public void loop() {
        follower.update();
        autonomousPathUpdate();

        telemetry.addData("Path State", pathState);
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.update();
    }
}

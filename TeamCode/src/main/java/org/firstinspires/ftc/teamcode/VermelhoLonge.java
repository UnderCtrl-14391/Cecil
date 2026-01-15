package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous (name = "VermelhoLonge", group = "Autonomous")
public class VermelhoLonge extends OpMode{
    private Follower follower;
    private Timer pathTimer;
    private int pathState;
    private Paths paths;

    public static class Paths {
        public PathChain Path1;
        public PathChain Path2;
        public PathChain Path3;
        public PathChain Path4;
        public PathChain Path5;
        public PathChain Path6;
        public PathChain Path7;
        public PathChain Path8;
        public PathChain Path9;
        public PathChain Path10;
        public PathChain Path11;
        public PathChain Path12;

        public Paths(Follower follower) {
            Path1 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(84.000, 8.000),

                                    new Pose(112.312, 121.993)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(25))

                    .build();

            Path2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(112.312, 121.993),

                                    new Pose(121.000, 126.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(25), Math.toRadians(36))

                    .build();

            Path3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(121.000, 126.500),

                                    new Pose(99.000, 83.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(36), Math.toRadians(0))

                    .build();

            Path4 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(99.000, 83.500),

                                    new Pose(128.000, 83.825)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path5 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(128.000, 83.825),

                                    new Pose(94.888, 83.544)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(60))

                    .build();

            Path6 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(94.888, 83.544),

                                    new Pose(121.000, 126.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(60), Math.toRadians(36))

                    .build();

            Path7 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(121.000, 126.500),

                                    new Pose(97.386, 60.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(36), Math.toRadians(0))

                    .build();

            Path8 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(97.386, 60.000),

                                    new Pose(125.292, 60.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path9 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(125.292, 60.000),

                                    new Pose(120.961, 126.386)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(36))

                    .build();

            Path10 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(120.961, 126.386),

                                    new Pose(121.000, 126.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(36), Math.toRadians(36))

                    .build();

            Path11 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(121.000, 126.500),

                                    new Pose(95.319, 35.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(36), Math.toRadians(0))
                    .setReversed()
                    .build();

            Path12 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(95.319, 35.500),

                                    new Pose(129.224, 35.617)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                    .setReversed()
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
                follower.followPath(paths.Path1);
                if (!follower.isBusy()) {
                    setPathState(1);
                }
                break;
            case 1:
                follower.followPath(paths.Path2);
                if (!follower.isBusy()) {
                    setPathState(2);
                }
                break;
            case 2:
                follower.followPath(paths.Path3);
                if (!follower.isBusy()) {
                    setPathState(3);
                }
                break;
            case 3:
                follower.followPath(paths.Path4);
                if (!follower.isBusy()) {
                    setPathState(4);
                }
                break;
            case 4:
                follower.followPath(paths.Path5);
                if (!follower.isBusy()) {
                    setPathState(5);
                }
                break;
            case 5:
                follower.followPath(paths.Path6);
                if (!follower.isBusy()) {
                    setPathState(6);
                }
                break;
            case 6:
                follower.followPath(paths.Path7);
                if (!follower.isBusy()) {
                    setPathState(7);
                }
                break;
            case 7:
                follower.followPath(paths.Path8);
                if (!follower.isBusy()) {
                    setPathState(8);
                }
                break;
            case 8:
                follower.followPath(paths.Path9);
                if (!follower.isBusy()) {
                    setPathState(9);
                }
                break;
            case 9:
                follower.followPath(paths.Path10);
                if (!follower.isBusy()) {
                    setPathState(10);
                }
                break;
            case 10:
                follower.followPath(paths.Path11);
                if (!follower.isBusy()) {
                    setPathState(11);
                }
                break;
            case 11:
                follower.followPath(paths.Path12);
                if (!follower.isBusy()) {
                    setPathState(12);
                }
                break;
        }
    }

    @Override
    public void init() {
        pathTimer = new Timer();


        follower = Constants.createFollower(hardwareMap);
        paths = new VermelhoLonge.Paths(follower);
        follower.setStartingPose(new Pose(84.000, 8.000, Math.toRadians(90)));
    }

    @Override
    public void start() {
        setPathState(0);

    }

    @Override
    public void loop() {
        follower.update();
        autonomousPathUpdate();

        telemetry.addData("Path State", pathState);
        telemetry.addData("Busy", follower.isBusy());
        telemetry.addData("X", follower.getPose().getX());
        telemetry.addData("Y", follower.getPose().getY());
        telemetry.update();//sim, ta ruim!! parabens
    }
}
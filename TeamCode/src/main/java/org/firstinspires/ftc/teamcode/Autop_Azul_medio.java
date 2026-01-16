package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "Autop Azul Medio", group = "Autonomous")
public class Autop_Azul_medio extends OpMode {

    private Follower follower;
    private Timer pathTimer, opModeTimer;
    private int pathState;
    private Paths paths;

    // Posição inicial do robô
    private final Pose startPose = new Pose(16.756539235412475, 119.7102615694165, Math.toRadians(37));



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
                                    new Pose(16.757, 119.710),

                                    new Pose(16.757, 119.710)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(143))

                    .build();

            LOADPOS = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(16.757, 119.710),

                                    new Pose(52.865, 81.817)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(180))

                    .build();

            LOADING = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(52.865, 81.817),

                                    new Pose(19.366, 82.865)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .setReversed(true)
                    .build();

            SCOREPOS = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(19.366, 82.865),

                                    new Pose(16.757, 119.710)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(143))

                    .build();

            LOADPOS2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(16.757, 119.710),

                                    new Pose(47.584, 59.841)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(180))

                    .build();

            LOADING2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(47.584, 59.841),

                                    new Pose(20.012, 59.791)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))

                    .build();

            SCOREPOS2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(20.012, 59.791),

                                    new Pose(16.757, 119.710)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(143))

                    .build();

            LOADPOS3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(16.757, 119.710),

                                    new Pose(47.205, 33.765)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(180))

                    .build();

            LOADING3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(47.205, 33.765),

                                    new Pose(19.688, 34.968)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .setReversed(true)
                    .build();

            SCOREPOS3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(19.688, 34.968),

                                    new Pose(21.682, 126.954)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(143))

                    .build();

            IMURESET = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(21.682, 126.954),

                                    new Pose(18.314, 99.028)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(180))

                    .build();
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

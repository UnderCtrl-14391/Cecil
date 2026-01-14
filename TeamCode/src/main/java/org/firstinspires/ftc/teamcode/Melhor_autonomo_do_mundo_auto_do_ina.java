package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "Melhor autonomo do mundo auto do ina", group = "Autonomous")
public class Melhor_autonomo_do_mundo_auto_do_ina extends OpMode {

    private Follower follower;
    private Timer pathTimer;
    private int pathState;
    private Paths paths;

    public class Paths {
        public PathChain pontodeinicio;
        public PathChain pegarasbolas;
        public PathChain pontoprairpraarremesar;
        public PathChain Path4;

        public Paths(Follower follower) {
            pontodeinicio = follower.pathBuilder()
                    .addPath(new BezierLine(new Pose(63.946, 8.054), new Pose(45.749, 35.512)))
                    .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                    .build();

            pegarasbolas = follower.pathBuilder()
                    .addPath(new BezierLine(new Pose(45.749, 35.512), new Pose(14.888, 35.390)))
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .build();

            pontoprairpraarremesar = follower.pathBuilder()
                    .addPath(new BezierLine(new Pose(14.888, 35.390), new Pose(72.058, 58.685)))
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(120))
                    .build();

            Path4 = follower.pathBuilder()
                    .addPath(new BezierLine(new Pose(72.058, 58.685), new Pose(35.136, 135.322)))
                    .setLinearHeadingInterpolation(Math.toRadians(120), Math.toRadians(180))
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
                follower.followPath(paths.pontodeinicio);
                setPathState(1);
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(paths.pegarasbolas);
                    setPathState(2);
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(paths.pontoprairpraarremesar);
                    setPathState(3);
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(paths.Path4);
                    setPathState(4);
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    // Autonomous finished
                    setPathState(-1);
                }
                break;
        }
    }

    @Override
    public void init() {
        pathTimer = new Timer();
        // Fixed: The Follower constructor doesn't take just hardwareMap in this version of Pedro Pathing.
        // We use the createFollower helper method from your Constants class.
        follower = Constants.createFollower(hardwareMap);
        paths = new Paths(follower);
        follower.setStartingPose(new Pose(63.946, 8.054, Math.toRadians(90)));
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
        telemetry.update();
    }
}

package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "AzulLonge", group = "Autonomous")
public class AzulLonge extends OpMode {

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
        public PathChain Path11;
        public PathChain Path12;

        public Paths(Follower follower) {

            //ponto de partida
            Path1 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(60.000, 8.000),

                                    new Pose(31.688, 121.993)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(155))

                    .build();

            //caminho para pre-load
            Path2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(31.688, 121.993),

                                    new Pose(23.000, 126.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(155), Math.toRadians(144))

                    .build();

            //ajustamento de angulo do pre-load e arremessar as bolas
            Path3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(23.000, 126.500),

                                    new Pose(45.000, 83.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(144), Math.toRadians(180))

                    .build();

            //caminho para pegar as bolas
            Path4 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(45.000, 83.500),

                                    new Pose(16.000, 83.825)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))

                    .build();

            //pegar as bolas
            Path5 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(16.000, 83.825),

                                    new Pose(49.112, 83.544)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(120))

                    .build();

            //caminho pra arremessar as bolas
            Path6 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(49.112, 83.544),

                                    new Pose(23.000, 126.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(120), Math.toRadians(144))

                    .build();

            //caminho pra pegar as bolas
            Path7 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(23.000, 126.500),

                                    new Pose(46.614, 60.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(144), Math.toRadians(180))

                    .build();

            //pegar as bolas
            Path8 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(46.614, 60.000),

                                    new Pose(18.708, 60.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))

                    .build();

            //camihnho pra arremessar as bolas
            Path9 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(18.708, 60.000),

                                    new Pose(23.000, 126.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(144))

                    .build();

            //caminho q se der tempo pra pegar as bolas
            Path11 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(23.000, 126.500),

                                    new Pose(48.681, 35.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(144), Math.toRadians(144))

                    .build();

            //pegar as bolas se der tempo
            Path12 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(48.681, 35.500),

                                    new Pose(14.776, 35.617)
                            )
                    ).setTangentHeadingInterpolation()

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
                break;
        }
    }

    @Override
    public void init() {
        pathTimer = new Timer();
        
        
        follower = Constants.createFollower(hardwareMap);
        paths = new Paths(follower);
        follower.setStartingPose(new Pose(60.000, 8.000, Math.toRadians(90)));
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

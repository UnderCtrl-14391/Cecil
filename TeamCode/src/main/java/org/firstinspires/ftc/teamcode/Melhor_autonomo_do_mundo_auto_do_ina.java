package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Melhor autonomo do mundo auto do ina", group = "Autonomous")
public class Melhor_autonomo_do_mundo_auto_do_ina extends OpMode{


        public PathChain pontodeinicio;
        public PathChain pegarasbolas;
        public PathChain pontoprairpraarremesar;
        public PathChain Path4;

        public Paths(Follower follower) {
            pontodeinicio = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(63.946, 8.054),

                                    new Pose(45.749, 35.512)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))

                    .build();

            pegarasbolas = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(45.749, 35.512),

                                    new Pose(14.888, 35.390)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))

                    .build();

            pontoprairpraarremesar = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(14.888, 35.390),

                                    new Pose(72.058, 58.685)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(120))

                    .build();

            Path4 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(72.058, 58.685),

                                    new Pose(35.136, 135.322)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(120), Math.toRadians(180))

                    .build();
        }
    }
    public void setPathstate (int State) {
        pathState = state;
        pathTimer.resetTimer;
    }
    @Override
    public void init() {
        pathTimer = new Timer();
    }

    @Override
    public void loop() {

    }

}

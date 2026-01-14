package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.util.Timer;
//import // org.firstinspires.ftc.teamcode.pedroPathing.Constants.FConstants;
//import org.firstinspires.ftc.teamcode.pedroPathing.Constants.LConstants;
import com.qualcomm.robotcore.hardware.configuration.LynxConstants;

import org.firstinspires.ftc.robotcore.internal.ftdi.FtConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "Autop Vermelho Medio", group = "Autonomous")
public class Autop_Vermelho_medio extends OpMode {

    private Follower follower;
    private Timer pathTimer, opModeTimer;
    private int pathState;

    // Definição das poses e caminhos
    private final Pose startPose = new Pose(127.243, 119.710, Math.toRadians(37));

    public PathChain SCORINGPOINT, LOADPOINT, LOADING, SCORINGPOS, LOADPOINT2, LOADING2, SCORINGPOS2, LOADPOINT3, LOADING3, SCOREPOS3, IMURESET;

    /** Este método substitui a sua antiga classe "Paths" */
    public void buildPaths() {
        SCORINGPOINT = follower.pathBuilder()
                .addPath(new BezierLine(new Pose(127.243, 119.710), new Pose(127.243, 119.710)))
                .setLinearHeadingInterpolation(Math.toRadians(37), Math.toRadians(37))
                .build();

        LOADPOINT = follower.pathBuilder()
                .addPath(new BezierLine(new Pose(127.243, 119.710), new Pose(93.332, 83.362)))
                .setLinearHeadingInterpolation(Math.toRadians(37), Math.toRadians(0))
                .build();

        LOADING = follower.pathBuilder()
                .addPath(new BezierLine(new Pose(93.332, 83.362), new Pose(128.153, 83.362)))
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                .build();

        SCORINGPOS = follower.pathBuilder()
                .addPath(new BezierLine(new Pose(128.153, 83.362), new Pose(127.243, 119.710)))
                // Corrigido: Removido o 'null' que causava erro
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(37))
                .build();

        // ... (Os outros caminhos seguem a mesma lógica)
    }

    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0: // Exemplo de estado inicial
                follower.followPath(SCORINGPOINT);
                setPathState(1);
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(LOADPOINT);
                    setPathState(2);
                }
                break;
        }
    }

    public void setPathState(int state) {
        pathState = state;
        pathTimer.resetTimer();
    }

    @Override
    public void init() {
        pathTimer = new Timer();
        opModeTimer = new Timer();

        // Inicializa o seguidor com as constantes do seu projeto
        //follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        follower.setStartingPose(startPose);

        buildPaths();
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
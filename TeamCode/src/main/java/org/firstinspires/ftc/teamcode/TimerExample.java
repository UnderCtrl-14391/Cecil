package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class TimerExample extends AutoFunction {
    private static ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        // This starts/resets the timer when the OpMode begins
        runtime.reset();

        if (opModeIsActive()) {
            // Your autonomous code here
            autonomous(0 , 0 , 0 , 0 , 0.0 , 0.0 , 0.0 , CatapultaModes.HOLD);
            if (runtime.seconds() <= 2){autonomous(0 , 0 , 0 , 0 , 0.0 , 0.0 , 0.0 , CatapultaModes.HOLD);}
            if(runtime.seconds() <= 4 ) {autonomous(0 , 0 , 0 , 0 , 0.0 , 0.0 , 0.0 , CatapultaModes.HOLD);}}
            //tem que testar depois, mas é só continuar com essa mesma estrutura a principio
            while (opModeIsActive() && runtime.seconds() < 30) {
                telemetry.addData("Status", "Running for %.2f seconds", runtime.seconds());
                telemetry.update();
            }
        }
    }


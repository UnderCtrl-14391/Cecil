package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Autotop_AzulLonge extends AutoFunction {

    @Override
    public void runOpMode() {
        // Initialize hardware defined in AutoFunction
        HardwareMap(hardwareMap);

        waitForStart();
        
        // Call the autonomous method defined in AutoFunction
        autonomous(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}

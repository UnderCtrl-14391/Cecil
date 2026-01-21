package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class imu extends OpMode{
    double heading;

      DecodeTeletop bench = new  DecodeTeletop ();

   @Override
   public void init() {
     bench.init(hardwareMap);
   }

   @Override
   public void loop() {
       heading = bench.getHeading(AngleUnit.DEGREES);
       telemetry.addData("Heading", bench.getHeading(AngleUnit.DEGREES));

       if (heading < 0.5 && heading > -0.5) {
           bench.setRight(0.0);
           bench.setLeft(0.0);
           bench.setRight(0.0);
           bench.setRight(0.0);
       }
   }
           else if (heading <0.5){
        bench.setRight(0.5);
        bench.setLeft(0.5);
        bench.setRight(0.5);
        bench.setRight(0.5);
       }
           else{
               bench.setRight(-0.5);
        bench.setLeft(-0.5);
        bench.setRight(-0.5);
        bench.setRight(-0.5);
    }

   }

}
/*
1.return the heading in radians
2.when your heading is <0.5 && greater that -0.5, stop a motor.If its less than -0,5 makes your motor positive, and if its greater than 0.5 makes it negative.
 */









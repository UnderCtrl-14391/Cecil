package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class imu extends OpMode{
      DecodeTeletop bench = new  DecodeTeletop ();

   @Override
   public void init() {
     bench.init(hardwareMap);
   }

   @Override
   public void loop()  {
       telemetry.addData("Heading", bench.getHeading(AngleUnit.DEGREES))


   }

}










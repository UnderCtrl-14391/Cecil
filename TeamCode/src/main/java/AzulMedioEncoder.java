import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutoFunction;

@Autonomous
public class AzulMedioEncoder extends AutoFunction {

    @Override
    public void runOpMode() {
        HardwareMap(hardwareMap);

        waitForStart();
        //Primeiro tiro

        autonomous(0 , 0 , 0, 0, 0, 0, 0, 0, 0);
        sleep(1000);
        //sair pro primeiro load
        autonomous(-1600 , -1600 , -1600, -1600, 0.7 , 0.7 , 0, 0, 0);
        sleep(1000);
        //
    }
}

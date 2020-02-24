package frc.robot.subsystem;

import frc.robot.Robot;
import frc.robot.util.Loggable;
import frc.robot.util.Refreshable;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem implements Loggable, Refreshable {

    private static int kFirstMotorPort = 0;
    private static int kSecondMotorPort = 1;

    private Spark firstMotor;
    private Spark secondMotor;

    public Intake() {
        firstMotor = new Spark(kFirstMotorPort);
        secondMotor = new Spark(kSecondMotorPort);

        firstMotor.setInverted(false);
        secondMotor.setInverted(true);
    }

    @Override
    public void refresh() {
        if(Math.abs(Robot.getInstance().getSubsystemController().Triggers.Left) > 0) {
            firstMotor.setSpeed(Robot.getInstance().getSubsystemController().Triggers.Left);
            secondMotor.setSpeed(Robot.getInstance().getSubsystemController().Triggers.Left);
        }
        
        else {
            firstMotor.setSpeed(-Robot.getInstance().getSubsystemController().Triggers.Right);
            secondMotor.setSpeed(-Robot.getInstance().getSubsystemController().Triggers.Right);
        }
    }

    @Override
    public void log() {

    }

    @Override
    protected void initDefaultCommand() {

    }
}

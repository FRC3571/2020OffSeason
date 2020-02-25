package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystem.DriveTrain;
import frc.robot.util.XboxController;
import edu.wpi.first.wpilibj.command.Command;

public class DriveJoystick extends Command {

    private DriveTrain driveTrain;
    private XboxController controller;

    public DriveJoystick(XboxController controller) {
        this.driveTrain = Robot.getInstance().getDrive();
        this.controller = controller;
        setInterruptible(true);
        requires(driveTrain);
    }

    @Override
    protected void execute() {
        if (driveTrain.ChosenDrive == DriveTrain.DriveMode.AONEJOY) {
            driveTrain.arcadeDrive(controller.rightStick.getY(), -controller.rightStick.getX());
        } else if (driveTrain.ChosenDrive == DriveTrain.DriveMode.ATWOJOY) {
            driveTrain.arcadeDrive(controller.leftStick.getY(), -controller.rightStick.getX());
        } else if (driveTrain.ChosenDrive == DriveTrain.DriveMode.TANK) {
            driveTrain.tankdrive(controller.leftStick.getY(), controller.rightStick.getY());
        }
    }

    @Override
    protected boolean isFinished() {
        return false; // Runs until interrupted
    }

    @Override
    protected void end() {
        driveTrain.arcadeDrive(0, 0);
    }
}

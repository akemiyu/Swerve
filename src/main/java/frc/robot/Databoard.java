package frc.robot;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

public class Databoard {
    public void init() {

    }

    public void periodic() {
        SmartDashboard.putNumber("Pigeon 2 Gyro", RobotContainer.s_Swerve.gyro.getYaw().getValue());

        SwerveModulePosition[] positions = RobotContainer.s_Swerve.getModulePositions();
        for(int i = 0; i < 4; i++) {
            SmartDashboard.putNumber("swerveMod" + i, positions[i].angle.getDegrees());
        }
    }

    public Command getCommand() {return new DataBoardCommand().ignoringDisable(true).withInterruptBehavior(InterruptionBehavior.kCancelIncoming);}
    private class DataBoardCommand extends Command {
        @Override
        public void initialize() {
            init();
        }
        @Override
        public void execute() {
            periodic();
        }
    }
}

package frc.robot.OBlogObjects;

import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;

/**
 * OBlogEnum
 */
public class OBlogEnum {
    /**
     * Used to make widgets with commands to set enum state. Open this file for usage example
     * @param tabName Current tab's name, use this.getName()
     * @param enumName The name of the layout, should be the enum's name
     * @param stateStringSupplier Supplier to get current state as string
     * @return The empty command layout
     */
    public static ShuffleboardLayout getLayout(String tabName, String enumName, Supplier<String> stateStringSupplier) {
        ShuffleboardLayout layout = Shuffleboard.getTab(tabName)
            .getLayout(enumName, BuiltInLayouts.kList)
            .withSize(2, 2)
            .withPosition(0, 0)
            .withProperties(Map.of("Label position", "HIDDEN"));

        layout.addString("State", stateStringSupplier);

        return layout;
    }

    /* Usage exmaple:

        // In the subsystem:

        ShuffleboardLayout rollerCommands = OBlogEnum.getLayout(this.getName(), "Roller State", this::getRollerState);

        rollerCommands.add(new SetArmRollers(RollerState.IN));
        rollerCommands.add(new SetArmRollers(RollerState.OUT));
        rollerCommands.add(new SetArmRollers(RollerState.OFF));

        public String getRollerState() {
            return RollerState.OUT.toString();
        }

        // Add this line in the command's constructor so that the names are set correctly

        public SetArmRollers(RollerState state) {
            SendableRegistry.setName(this, "Set " + this._state.toString());
            ...
        }

    */
}
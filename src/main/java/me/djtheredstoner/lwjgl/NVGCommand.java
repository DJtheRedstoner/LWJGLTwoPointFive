package me.djtheredstoner.lwjgl;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class NVGCommand extends CommandBase {
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }

    @Override
    public String getCommandName() {
        return "nanovg";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        LWJGLTwoPointFive.toOpen = new TestGui();
    }
}

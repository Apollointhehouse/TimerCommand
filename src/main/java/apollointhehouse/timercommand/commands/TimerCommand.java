package apollointhehouse.timercommand.commands;

import apollointhehouse.timercommand.mixin.MinecraftAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Timer;
import net.minecraft.core.net.command.Command;
import net.minecraft.core.net.command.CommandHandler;
import net.minecraft.core.net.command.CommandSender;

public class TimerCommand extends Command {
	public TimerCommand() {
		super("timer");
	}

	@Override
	public boolean execute(CommandHandler commandHandler, CommandSender commandSender, String[] strings) {
		Minecraft mc = Minecraft.getMinecraft(Minecraft.class);
		Timer timer = ((MinecraftAccessor) mc).getTimer();

		if (strings.length < 1) return false;

		if (strings[0].equals("get")) {
			commandHandler.sendCommandFeedback(commandSender, "Current TPS: " + timer.ticksPerSecond);
			return true;
		}

		if (strings[0].equals("set") && strings.length >= 2) {
			try {
				float tps = Float.parseFloat(strings[1]);
				timer.ticksPerSecond = tps;
				commandHandler.sendCommandFeedback(commandSender, "Set TPS to " + tps);
			} catch (NumberFormatException e) {
				commandHandler.sendCommandFeedback(commandSender, "Invalid TPS: " + strings[1] + ", TPS must be a float.");
				return false;
			}
			return true;
		}

		return false;
	}

	@Override
	public boolean opRequired(String[] strings) {
		return true;
	}

	@Override
	public void sendCommandSyntax(CommandHandler commandHandler, CommandSender commandSender) {
		commandHandler.sendCommandFeedback(commandSender, "/timer <set, get> <tps>");
	}
}

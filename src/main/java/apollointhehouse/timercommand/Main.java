package apollointhehouse.timercommand;

import apollointhehouse.timercommand.commands.TimerCommand;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.CommandHelper;


public class Main implements ModInitializer {
    public static final String MOD_ID = "timercommand";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("TimerCommand initialized.");

		// Register commands
		CommandHelper.createCommand(new TimerCommand());
    }
}

package apollointhehouse.timercommand.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = Minecraft.class, remap = false)
public interface MinecraftAccessor {
	@Accessor("timer")
	Timer getTimer();
}

package me.djtheredstoner.lwjgl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(
    modid = "LWJGLTwoPointFive"
)
public class LWJGLTwoPointFive {

    public static GuiScreen toOpen = null;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //TinyFileDialogs.tinyfd_messageBox("Hello, World!", "DJtheRedstoner is the best dev!", "ok", "warning", false);
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new NVGCommand());
    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {
        if (toOpen != null) {
            Minecraft.getMinecraft().displayGuiScreen(toOpen);
            toOpen = null;
        }
    }

}

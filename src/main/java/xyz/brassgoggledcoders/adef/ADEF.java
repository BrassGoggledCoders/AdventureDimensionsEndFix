package xyz.brassgoggledcoders.adef;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.GameType;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "adef", name = "AdventureDimensionsEndFix", version = "@VERSION@")
@EventBusSubscriber
public class ADEF {
	@SubscribeEvent
	public static void onPlayerClone(EntityTravelToDimensionEvent event) {
		FMLLog.warning("1");
		if(event.getEntity().dimension == 1 && event.getDimension() == 1) {
			FMLLog.warning("1.25");
			if(event.getEntity() instanceof EntityPlayer) {
				FMLLog.warning("1.4");
				EntityPlayer player = (EntityPlayer) event.getEntity();
				if(player.isServerWorld() && player instanceof EntityPlayerMP) {
					FMLLog.warning("1.5");
					// if(!event.isWasDeath()) {
					FMLLog.warning("2");
					if(!player.capabilities.isCreativeMode) {
						FMLLog.warning("3");
						player.setGameType(GameType.SURVIVAL);
					}

				}
			}
		}
	}
}

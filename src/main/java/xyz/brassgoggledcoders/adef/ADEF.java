package xyz.brassgoggledcoders.adef;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.GameType;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "adef", name = "AdventureDimensionsEndFix", version = "@VERSION@")
@EventBusSubscriber
public class ADEF {
	@SubscribeEvent
	public static void onPlayerClone(EntityTravelToDimensionEvent event) {
		if(event.getEntity().dimension == 1 && event.getDimension() == 1) {
			if(event.getEntity() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.getEntity();
				if(player.isServerWorld() && player instanceof EntityPlayerMP) {
					if(!player.capabilities.isCreativeMode) {
						player.setGameType(GameType.SURVIVAL);
					}

				}
			}
		}
	}
}

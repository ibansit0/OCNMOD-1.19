package net.ivo.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.ivo.tutorialmod.TutorialMod;
import net.ivo.tutorialmod.item.ModItems;
import net.ivo.tutorialmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.TOOLSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.OCN_ITEM.get(), 12);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader,rand)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02f));
        }

        if(event.getType() == ModVillagers.JUMP_MASTER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EL_QUESO.get(), 15);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader,rand)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack, 10, 8, 0.02f));
        }
    }



}

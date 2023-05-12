package net.ivo.tutorialmod.item;

import net.ivo.tutorialmod.TutorialMod;
import net.ivo.tutorialmod.block.ModBlocks;
import net.ivo.tutorialmod.item.custom.OcnItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);


    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> OCN_ITEM = ITEMS.register("ocn_item",
            () -> new OcnItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> ZIRCON_SWORD = ITEMS.register("zircon_sword",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1).durability(1000)));

    public static final RegistryObject<Item> LECHE_ULI = ITEMS.register("leche_uli",
            () -> new ItemNameBlockItem(ModBlocks.QUESO_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> EL_QUESO = ITEMS.register("el_queso",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .food(new FoodProperties.Builder().effect(() -> new MobEffectInstance(MobEffects.CONFUSION,450),1)
                            .nutrition(5).saturationMod(5f).build())));

    public static final RegistryObject<Item> QUESO_FUNDIDO = ITEMS.register("queso_fundido",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(5f).build())));









    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

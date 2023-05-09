package net.ivo.tutorialmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OcnItem extends Item {
    public OcnItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            OutputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private void OutputRandomNumber(Player player){
        switch(getRandomNumber()){
            case 0:player.sendSystemMessage(Component.literal("Soldi: la golazo AAAH"));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,100));break;
            case 1:player.sendSystemMessage(Component.literal("Ivo: AU"));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,100));break;
            case 2:player.sendSystemMessage(Component.literal("Uli: y viene con un dragon???"));
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION,100));
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,200));break;
            case 3:player.sendSystemMessage(Component.literal("Valen: el emperador francés es Napoleón"));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,100));break;
            case 4:player.sendSystemMessage(Component.literal("Manu: it´s a mont"));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,100));break;
            case 5:player.sendSystemMessage(Component.literal("Axel: *pedo*"));
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,100));break;
            case 6:player.sendSystemMessage(Component.literal("Augusto: axel pelotudo dejame buscar una pizzeria estúpido"));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP,100));break;
            case 7:player.sendSystemMessage(Component.literal("Juanva: na sos un mogólico"));
            player.addEffect(new MobEffectInstance(MobEffects.LUCK,100));break;
            case 8:player.sendSystemMessage(Component.literal("Migue: Pesadillas eteeeeeeernaaaaaaaaaaas"));
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,100));
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION,100));break;
        }
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(9);
    }
}

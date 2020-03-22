package fr.alasdiablo.janoeo.arsenal.event;

import fr.alasdiablo.janoeo.arsenal.init.WoolsArmors;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import java.util.Arrays;
import java.util.List;

public class WoolArmorEvent implements IInitEvent {

    @Override
    public void init() {
        final List<ItemStack> woolArmor = Arrays.asList(
                new ItemStack(WoolsArmors.BLACK_WOOL_BOOTS),
                new ItemStack(WoolsArmors.BLUE_WOOL_BOOTS),
                new ItemStack(WoolsArmors.BROWN_WOOL_BOOTS),
                new ItemStack(WoolsArmors.RED_WOOL_BOOTS),
                new ItemStack(WoolsArmors.WHITE_WOOL_BOOTS),
                new ItemStack(WoolsArmors.YELLOW_WOOL_BOOTS),
                new ItemStack(WoolsArmors.CYAN_WOOL_BOOTS),
                new ItemStack(WoolsArmors.GRAY_WOOL_BOOTS),
                new ItemStack(WoolsArmors.GREEN_WOOL_BOOTS),
                new ItemStack(WoolsArmors.LIGHT_BLUE_WOOL_BOOTS),
                new ItemStack(WoolsArmors.LIGHT_GRAY_WOOL_BOOTS),
                new ItemStack(WoolsArmors.LIME_WOOL_BOOTS)
        );
        MinecraftForge.EVENT_BUS.<LivingFallEvent>addListener(e -> {
            final ItemStack boots = e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET);
            woolArmor.forEach(armor -> {
                if(boots.isItemEqualIgnoreDurability(armor))
                    e.setDamageMultiplier(0.5F);
            });
        });
    }
}

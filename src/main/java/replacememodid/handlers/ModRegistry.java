package replacememodid.handlers;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import replacememodid.ReplaceMeModName;
import replacememodid.item.ItemExampleArmor;
import replacememodid.potion.PotionExample;
import replacememodid.recipe.RecipeExample;

@Mod.EventBusSubscriber(modid = ReplaceMeModName.MODID)
public class ModRegistry {

        public static ItemArmor.ArmorMaterial EXAMPLE_ARMOR = EnumHelper.addArmorMaterial("example_armor", ReplaceMeModName.MODID + ":example_armor", 26, new int[]{2,4,6,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

        public static Item exampleHelmet = new ItemExampleArmor("example_helmet", EXAMPLE_ARMOR, 2, EntityEquipmentSlot.HEAD);
        public static Item exampleChestplate = new ItemExampleArmor("example_chestplate", EXAMPLE_ARMOR, 1, EntityEquipmentSlot.CHEST);
        public static Item exampleLeggings = new ItemExampleArmor("example_leggings", EXAMPLE_ARMOR, 2, EntityEquipmentSlot.LEGS);
        public static Item exampleBoots = new ItemExampleArmor("example_boots", EXAMPLE_ARMOR, 1, EntityEquipmentSlot.FEET);

        public static PotionType examplePotion = new PotionType("example", new PotionEffect(PotionExample.INSTANCE)).setRegistryName(new ResourceLocation(ReplaceMeModName.MODID, "example"));

        public static void init() {

        }

        @SubscribeEvent
        public static void registerItemEvent(RegistryEvent.Register<Item> event) {
                event.getRegistry().registerAll(
                        exampleHelmet,
                        exampleChestplate,
                        exampleLeggings,
                        exampleBoots
                );
        }

        @SubscribeEvent
        public static void registerRecipeEvent(RegistryEvent.Register<IRecipe> event) {
                event.getRegistry().register(new RecipeExample().setRegistryName(new ResourceLocation(ReplaceMeModName.MODID, "example")));
        }

        @SubscribeEvent
        public static void registerPotionEvent(RegistryEvent.Register<Potion> event) {
                event.getRegistry().register(PotionExample.INSTANCE);
        }

        @SubscribeEvent
        public static void registerPotionTypeEvent(RegistryEvent.Register<PotionType> event) {
                event.getRegistry().register(examplePotion);
                PotionHelper.addMix(PotionTypes.THICK, Items.DIAMOND, ModRegistry.examplePotion);
        }
}
package replacememodid.potion;

import net.minecraft.entity.EntityLivingBase;

public class PotionExample extends PotionBase {

    public static final PotionExample INSTANCE = new PotionExample();

    public PotionExample() {
        super("example", false, 0xF3F4F9);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBase, int amplifier) {
        if(entityLivingBase.world.isRemote) return;
    }
}
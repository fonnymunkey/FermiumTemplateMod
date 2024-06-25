package replacememodid.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ExampleRecipeWrapper implements ICraftingRecipeWrapper {

    private final List<ItemStack> inputs;
    private final ItemStack output;

    public ExampleRecipeWrapper() {
        ItemStack catalystStack = new ItemStack(Items.WATER_BUCKET);
        ItemStack reactantStack = new ItemStack(Blocks.DIRT);
        ItemStack outputStack = new ItemStack(Blocks.GRASS);

        this.inputs = Arrays.asList(catalystStack, reactantStack);
        this.output = outputStack;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, this.inputs);
        ingredients.setOutput(VanillaTypes.ITEM, this.output);
    }
}
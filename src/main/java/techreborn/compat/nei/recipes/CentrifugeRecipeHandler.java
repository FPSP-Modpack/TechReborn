package techreborn.compat.nei.recipes;

import java.awt.Rectangle;
import java.util.List;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import reborncore.common.util.ItemUtils;
import techreborn.api.recipe.IBaseRecipeType;
import techreborn.client.gui.GuiCentrifuge;
import techreborn.lib.Reference;

public class CentrifugeRecipeHandler extends GenericRecipeHander implements INeiBaseRecipe {
    @Override
    public void addPositionedStacks(List<PositionedStack> input, List<PositionedStack> outputs, IBaseRecipeType recipeType) {
        int offset = 4;
        if (recipeType.getInputs().size() > 0) {
    		Object iStack = recipeType.useOreDic() ? ItemUtils.getStackWithAllOre(recipeType.getInputs().get(0)) : recipeType.getInputs().get(0);
            PositionedStack pStack = new PositionedStack(iStack, 80 - offset, 35 - offset, false);
            input.add(pStack);
        }
        if (recipeType.getInputs().size() > 1) {
    		Object iStack = recipeType.useOreDic() ? ItemUtils.getStackWithAllOre(recipeType.getInputs().get(1)) : recipeType.getInputs().get(1);
            PositionedStack pStack2 = new PositionedStack(iStack, 50 - offset, 5 - offset, false);
            input.add(pStack2);
        }

        if (recipeType.getOutputsSize() > 0) {
            PositionedStack pStack3 = new PositionedStack(recipeType.getOutput(0), 80 - offset, 5 - offset, false);
            outputs.add(pStack3);
        }

        if (recipeType.getOutputsSize() > 1) {
            PositionedStack pStack4 = new PositionedStack(recipeType.getOutput(1), 110 - offset, 35 - offset, false);
            outputs.add(pStack4);
        }

        if (recipeType.getOutputsSize() > 2) {
            PositionedStack pStack5 = new PositionedStack(recipeType.getOutput(2), 80 - offset, 65 - offset, false);
            outputs.add(pStack5);
        }

        if (recipeType.getOutputsSize() > 3) {
            PositionedStack pStack6 = new PositionedStack(recipeType.getOutput(3), 50 - offset, 35 - offset, false);
            outputs.add(pStack6);
        }
    }

    @Override
    public String getRecipeName() {
        return Reference.centrifugeRecipe;
    }

    @Override
    public String getGuiTexture() {
        return "techreborn:textures/gui/industrial_centrifuge.png";
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiCentrifuge.class;
    }

    @Override
    public INeiBaseRecipe getNeiBaseRecipe() {
        return this;
    }

    @Override
    public void loadTransferRects() {
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(64, 25, 10, 10), getNeiBaseRecipe().getRecipeName(), new Object[0]));
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(94, 25, 10, 10), getNeiBaseRecipe().getRecipeName(), new Object[0]));
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(78, 15, 10, 10), getNeiBaseRecipe().getRecipeName(), new Object[0]));
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(78, 40, 10, 10), getNeiBaseRecipe().getRecipeName(), new Object[0]));
    }
}

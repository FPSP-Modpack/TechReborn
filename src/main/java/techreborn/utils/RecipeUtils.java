package techreborn.utils;

import java.security.InvalidParameterException;

import cpw.mods.fml.common.Loader;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;
import techreborn.items.ItemCells;

public class RecipeUtils {

	public static ItemStack getEmptyCell(int stackSize) {
		if (Loader.isModLoaded("IC2")) {
			ItemStack cell = IC2Items.getItem("cell").copy();
			cell.stackSize = stackSize;
			return cell;
		} else {
			return ItemCells.getCellByName("empty", stackSize);
		}
	}

	public static int getArrayPos(String[] types, String target) {
		for (int index = 0; index < types.length; index++) {
			if (types[index].equalsIgnoreCase(target))
				return index;
		}
		return -1;
	}
}

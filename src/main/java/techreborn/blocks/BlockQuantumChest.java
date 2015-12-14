package techreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import techreborn.Core;
import techreborn.client.GuiHandler;
import techreborn.client.TechRebornCreativeTab;
import techreborn.tiles.TileQuantumChest;

public class BlockQuantumChest extends BlockMachineBase implements IAdvancedRotationTexture {

    public BlockQuantumChest() {
        super(Material.rock);
        setUnlocalizedName("techreborn.quantumChest");
        setCreativeTab(TechRebornCreativeTab.instance);
        setHardness(2.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileQuantumChest();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.isSneaking())
            playerIn.openGui(Core.INSTANCE, GuiHandler.quantumChestID, worldIn, pos.getX(),
                    pos.getY(), pos.getZ());
        return true;
    }


    private final String prefix = "techreborn:blocks/machine/";

    @Override
    public String getFront(boolean isActive) {
        return  prefix + "quantum_chest";
    }

    @Override
    public String getSide(boolean isActive) {
        return prefix + "qchest_side";
    }

    @Override
    public String getTop(boolean isActive) {
        return prefix + "quantum_top";
    }

    @Override
    public String getBottom(boolean isActive) {
        return prefix + "machine_bottom";
    }
}

package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockSakuraLog extends BlockLog {
    public BlockSakuraLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "sakura_log");
        setRegistryName("sakura_log");
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta & 4) {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 1:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 2:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        switch (state.getValue(LOG_AXIS)) {
            case X:
                i |= 1;
                break;
            case Z:
                i |= 2;
                break;
            case NONE:
                i |= 3;
        }

        return i;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{LOG_AXIS});
    }
}

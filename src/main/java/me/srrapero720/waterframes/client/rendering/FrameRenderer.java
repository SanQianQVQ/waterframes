package me.srrapero720.waterframes.client.rendering;

import me.srrapero720.waterframes.client.rendering.core.RenderBox;
import me.srrapero720.waterframes.common.block.entity.DisplayTile;
import net.minecraft.core.Direction;
import team.creative.creativecore.common.util.math.base.Facing;
import team.creative.creativecore.common.util.math.box.AlignedBox;

public class FrameRenderer extends DisplayRenderer {
    @Override
    public Facing facing(DisplayTile tile, Direction direction) {
        return Facing.get(direction);
    }

    @Override
    public AlignedBox box(DisplayTile tile, Direction direction, Facing facing) {
        return RenderBox.get(tile, facing, this.grwSize(), false);
    }

    @Override
    public float grwSize() {
        return 0.001F;
    }
}
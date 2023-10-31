package me.srrapero720.waterframes.util;

import me.srrapero720.waterframes.WaterFrames;
import me.srrapero720.waterframes.common.packets.ActionPacket;
import me.srrapero720.waterframes.common.packets.SyncTickPacket;
import me.srrapero720.waterframes.common.packets.SyncUrlListPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import team.creative.creativecore.common.network.CreativeNetwork;

import java.util.List;

import static me.srrapero720.waterframes.WaterFrames.LOGGER;

public class FrameNet {
    private static final CreativeNetwork NETWORK = new CreativeNetwork("2.0", LOGGER, new ResourceLocation(WaterFrames.ID, "network"));

    public static void sendPlaybackState(BlockPos pos, Level level, boolean playing, int tick) {
        NETWORK.sendToClient(new ActionPacket(pos, playing, tick), level, pos);
    }

    public static void syncPlaybackState(BlockPos pos, boolean playing, int tick) {
        NETWORK.sendToServer(new ActionPacket(pos, playing, tick));
    }

    public static void syncMaxTickTime(BlockPos pos, int maxTick) {
        NETWORK.sendToServer(new SyncTickPacket(pos, maxTick));
    }

    public static void syncUrlList(BlockPos pos, List<String> urlList, int index) {
        NETWORK.sendToServer(new SyncUrlListPacket(pos, urlList, index));
    }

    static void register() {
        NETWORK.registerType(ActionPacket.class, ActionPacket::new);
        NETWORK.registerType(SyncTickPacket.class, SyncTickPacket::new);
    }
}
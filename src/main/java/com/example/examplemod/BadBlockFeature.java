package com.example.examplemod;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

public class BadBlockFeature extends Feature<NoneFeatureConfiguration> {
    private static final Logger LOGGER = LogUtils.getLogger();

    public BadBlockFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        int chunkSize = 16; // Minecraft chunk size is 16x16 blocks
		LOGGER.info("Gonna replace stuff :) "+origin);
        // Loop through all blocks in the chunk area
        for (int x = -chunkSize; x < chunkSize; x++) {
            for (int z = -chunkSize; z < chunkSize; z++) {
                for (int y = world.getMinBuildHeight(); y < world.getMaxBuildHeight(); y++) {
                    BlockPos pos = origin.offset(x, y, z);

                    // Check if position is within the valid build height and is deepslate
                    if (world.getBlockState(pos).is(Blocks.DEEPSLATE)||world.getBlockState(pos).is(Blocks.DIRT)) {
                    	LOGGER.info("HIT!! "+pos);
                        world.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 2);
                    }
                }
            }
        }

        return true;
    }
}


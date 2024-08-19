package com.example.examplemod;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class AddFeatureBiomeModifier implements BiomeModifier {
    private final HolderSet<Biome> biomes;
    private final Holder<PlacedFeature> placedFeature;
    private final GenerationStep.Decoration step;

    public AddFeatureBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> placedFeature, GenerationStep.Decoration step) {
        this.biomes = biomes;
        this.placedFeature = placedFeature;
        this.step = step;
    }

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && this.biomes.contains(biome)) {
            builder.getGenerationSettings().addFeature(this.step, this.placedFeature);
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return Codec.unit(this); // You may need a proper codec implementation
    }
}


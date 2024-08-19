package com.example.examplemod;

import net.minecraft.resources.HolderSetCodec;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import net.minecraftforge.registries.ForgeRegistries;

public final class BadBlockModifier {

    /*public static record AddFeaturesBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features, GenerationStep.Decoration step) implements BiomeModifier {
        public static final Codec<AddFeaturesBiomeModifier> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                HolderSet.codec(ForgeRegistries.BIOMES, Biome.CODEC).fieldOf("biomes").forGetter(AddFeaturesBiomeModifier::biomes),
                HolderSet.codec(ForgeRegistries.PLACED_FEATURES, PlacedFeature.CODEC).fieldOf("features").forGetter(AddFeaturesBiomeModifier::features),
                GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(AddFeaturesBiomeModifier::step)
            ).apply(instance, AddFeaturesBiomeModifier::new)
        );

        @Override
        public Codec<? extends BiomeModifier> codec() {
            return CODEC;
        }

        @Override
        public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
            if (phase == Phase.ADD && this.biomes.contains(biome)) {
                BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
                this.features.forEach(holder -> generationSettings.addFeature(this.step, holder));
            }
        }
    }*/
}


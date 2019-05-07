package com.github.tartaricacid.bakaintouhou.client.particle;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFallingDust;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SakuraParticle extends ParticleFallingDust {
    public SakuraParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float red, float green, float blue) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, red, green, blue);
        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;
    }

    @SideOnly(Side.CLIENT)
    public static class RedFactory implements IParticleFactory {
        public Particle createParticle(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
            int color = 0xE95757;
            float r = (float) (color >> 16 & 255) / 255.0F;
            float g = (float) (color >> 8 & 255) / 255.0F;
            float b = (float) (color & 255) / 255.0F;
            return new SakuraParticle(worldIn, xCoordIn, yCoordIn, zCoordIn, r, g, b);
        }
    }

    @SideOnly(Side.CLIENT)
    public static class PinkFactory implements IParticleFactory {
        public Particle createParticle(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
            int color = 0xF9CECE;
            float r = (float) (color >> 16 & 255) / 255.0F;
            float g = (float) (color >> 8 & 255) / 255.0F;
            float b = (float) (color & 255) / 255.0F;
            return new SakuraParticle(worldIn, xCoordIn, yCoordIn, zCoordIn, r, g, b);
        }
    }

    @SideOnly(Side.CLIENT)
    public static class YellowFactory implements IParticleFactory {
        public Particle createParticle(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
            int color = 0xF2C95A;
            float r = (float) (color >> 16 & 255) / 255.0F;
            float g = (float) (color >> 8 & 255) / 255.0F;
            float b = (float) (color & 255) / 255.0F;
            return new SakuraParticle(worldIn, xCoordIn, yCoordIn, zCoordIn, r, g, b);
        }
    }
}

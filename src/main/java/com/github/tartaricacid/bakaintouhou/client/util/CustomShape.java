package com.github.tartaricacid.bakaintouhou.client.util;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

@SideOnly(Side.CLIENT)
public final class CustomShape {
    public static int SPHERE_OUT_INDEX;
    public static int SPHERE_IN_INDEX;
    public static int CYLINDER_OUT_INDEX;
    public static int CYLINDER_IN_INDEX;

    static {
        genSphere();
        genCylinder();
    }

    private static void genSphere() {
        Sphere sphere = new Sphere();

        sphere.setDrawStyle(GLU.GLU_FILL);
        sphere.setNormals(GLU.GLU_SMOOTH);
        sphere.setOrientation(GLU.GLU_OUTSIDE);

        SPHERE_OUT_INDEX = GlStateManager.glGenLists(1);
        GlStateManager.glNewList(SPHERE_OUT_INDEX, GL11.GL_COMPILE);
        sphere.draw(1, 16, 16);
        GlStateManager.glEndList();

        sphere.setOrientation(GLU.GLU_INSIDE);

        SPHERE_IN_INDEX = GlStateManager.glGenLists(1);
        GlStateManager.glNewList(SPHERE_IN_INDEX, GL11.GL_COMPILE);
        sphere.draw(1, 16, 16);
        GlStateManager.glEndList();
    }

    private static void genCylinder() {
        Cylinder cylinder = new Cylinder();

        cylinder.setDrawStyle(GLU.GLU_FILL);
        cylinder.setNormals(GLU.GLU_SMOOTH);
        cylinder.setOrientation(GLU.GLU_OUTSIDE);

        CYLINDER_OUT_INDEX = GlStateManager.glGenLists(1);
        GlStateManager.glNewList(CYLINDER_OUT_INDEX, GL11.GL_COMPILE);
        cylinder.draw(1, 1, 1, 16, 16);
        GlStateManager.glEndList();

        cylinder.setOrientation(GLU.GLU_INSIDE);

        CYLINDER_IN_INDEX = GlStateManager.glGenLists(1);
        GlStateManager.glNewList(CYLINDER_IN_INDEX, GL11.GL_COMPILE);
        cylinder.draw(1, 1, 1, 16, 16);
        GlStateManager.glEndList();
    }
}

package com.ifels.secondary.key.util;

import com.mojang.blaze3d.platform.Window;
import java.lang.reflect.Method;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.lwjgl.glfw.GLFW;

public class MouseUtil {
    private static final Method MH_ON_PRESS = findMousePressMethod();

    private static Method findMousePressMethod() {
        try {
            for(Method m : MouseHandler.class.getDeclaredMethods()) {
                Class<?>[] p = m.getParameterTypes();
                if (m.getReturnType() == Void.TYPE && p.length == 4 && p[0] == Long.TYPE && p[1] == Integer.TYPE && p[2] == Integer.TYPE && p[3] == Integer.TYPE) {
                    m.setAccessible(true);
                    return m;
                }
            }
        } catch (Throwable t) {
            LogUtil.e("Find MouseHandler press method failed", t);
        }

        LogUtil.w("MouseHandler onPress-like method not found; fallback to Screen.mouseClicked/mouseReleased (JEI overlay may not receive)", new Object[0]);
        return null;
    }

    public static void pressMouseKey(int button) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen != null) {
            if (MH_ON_PRESS != null) {
                try {
                    long win = mc.getWindow().getWindow();
                    int mods = KeyboardUtil.currentModifiers(mc);
                    MH_ON_PRESS.invoke(mc.mouseHandler, win, button, GLFW.GLFW_PRESS, mods);
                    return;
                } catch (Throwable t) {
                    LogUtil.e("Invoke mouse press failed", t);
                }
            }

            double[] pos = getGuiMousePos(mc);
            mc.screen.mouseClicked(pos[0], pos[1], button);
        }
    }

    public static void releaseMouseKey(int button) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen != null) {
            if (MH_ON_PRESS != null) {
                try {
                    long win = mc.getWindow().getWindow();
                    int mods = KeyboardUtil.currentModifiers(mc);
                    MH_ON_PRESS.invoke(mc.mouseHandler, win, button, 0, mods);
                    return;
                } catch (Throwable t) {
                    LogUtil.e("Invoke mouse release failed", t);
                }
            }

            double[] pos = getGuiMousePos(mc);
            mc.screen.mouseReleased(pos[0], pos[1], button);
        }
    }

    public static double[] getGuiMousePos(Minecraft mc) {
        double rawX = mc.mouseHandler.xpos();
        double rawY = mc.mouseHandler.ypos();
        Window win = mc.getWindow();
        double guiX = rawX * (double)win.getGuiScaledWidth() / (double)win.getScreenWidth();
        double guiY = rawY * (double)win.getGuiScaledHeight() / (double)win.getScreenHeight();
        return new double[]{guiX, guiY};
    }
}

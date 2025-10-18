package com.ifels.secondary.key.util;

import com.mojang.blaze3d.platform.InputConstants;
import java.lang.reflect.Method;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class KeyboardUtil {
    private static final Method KH_KEY_PRESS = findKeyboardPressMethod();

    private static Method findKeyboardPressMethod() {
        try {
            for(Method m : KeyboardHandler.class.getDeclaredMethods()) {
                Class<?>[] p = m.getParameterTypes();
                if (m.getReturnType() == void.class
                        && p.length == 5
                        && p[0] == long.class
                        && p[1] == int.class
                        && p[2] == int.class
                        && p[3] == int.class
                        && p[4] == int.class) {

                    m.setAccessible(true);
                    return m;
                }
            }
        } catch (Throwable t) {
            LogUtil.e("Find KeyboardHandler keyPress-like method failed", t);
        }

        return null;
    }

    public static void clickKey(InputConstants.Key key) {
        Minecraft mc = Minecraft.getInstance();
        int keyCode = key.getValue();
        if (KH_KEY_PRESS != null) {
            long win = mc.getWindow().getWindow();
            int scancode = GLFW.glfwGetKeyScancode(keyCode);
            if (scancode == 0) {
                scancode = keyCode;
            }

            int mods = currentModifiers(mc);
            try {
                KH_KEY_PRESS.invoke(mc.keyboardHandler, win, keyCode, scancode, GLFW.GLFW_PRESS, mods);
                KH_KEY_PRESS.invoke(mc.keyboardHandler, win, keyCode, scancode, GLFW.GLFW_RELEASE, mods);
                return;
            } catch (Throwable t) {
                LogUtil.e("Invoke KeyboardHandler key press failed", t);
            }
        }

        KeyMapping.set(key, true);
        KeyMapping.click(key);
        KeyMapping.set(key, false);
    }

    public static int currentModifiers(Minecraft mc) {
        long win = mc.getWindow().getWindow();
        int mods = 0;
        if (InputConstants.isKeyDown(win, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(win,  GLFW.GLFW_KEY_RIGHT_SHIFT)) {
            mods |= GLFW.GLFW_MOD_SHIFT;
        }

        if (InputConstants.isKeyDown(win, GLFW.GLFW_KEY_LEFT_CONTROL) || InputConstants.isKeyDown(win, GLFW.GLFW_KEY_RIGHT_CONTROL)) {
            mods |= GLFW.GLFW_MOD_CONTROL;
        }

        if (InputConstants.isKeyDown(win, GLFW.GLFW_KEY_LEFT_ALT) || InputConstants.isKeyDown(win, GLFW.GLFW_KEY_RIGHT_ALT)) {
            mods |= GLFW.GLFW_MOD_ALT;
        }

        if (InputConstants.isKeyDown(win, GLFW.GLFW_KEY_LEFT_SUPER) || InputConstants.isKeyDown(win, GLFW.GLFW_KEY_RIGHT_SUPER)) {
            mods |= GLFW.GLFW_MOD_SUPER;
        }

        return mods;
    }
}

package com.ifels.secondary.key.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

import java.lang.reflect.Method;

public class KeyboardUtil {
    private static final Method KH_KEY_PRESS = findKeyboardPressMethod();

    private static Method findKeyboardPressMethod() {
        try {
            for (Method m : KeyboardHandler.class.getDeclaredMethods()) {
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

    public static void pressKey(InputConstants.Key key, boolean withModifiers) {
        LogUtil.i("pressKey keyCode {}, withModifiers {}", key.getValue(), withModifiers);
        Minecraft mc = Minecraft.getInstance();
        int keyCode = key.getValue();
        if (KH_KEY_PRESS != null) {
            long win = mc.getWindow().getWindow();
            int scancode = GLFW.glfwGetKeyScancode(keyCode);
            if (scancode == 0) {
                scancode = keyCode;
            }

            int mods = withModifiers ? currentModifiers(mc) : 0;
            try {
                KH_KEY_PRESS.invoke(mc.keyboardHandler, win, keyCode, scancode, GLFW.GLFW_PRESS, mods);
            } catch (Throwable t) {
                LogUtil.e("Invoke KeyboardHandler key press failed", t);
            }
        }
    }

    public static void releaseKey(InputConstants.Key key, boolean withModifiers) {
        Minecraft mc = Minecraft.getInstance();
        int keyCode = key.getValue();
        if (KH_KEY_PRESS != null) {
            long win = mc.getWindow().getWindow();
            int scancode = GLFW.glfwGetKeyScancode(keyCode);
            if (scancode == 0) {
                scancode = keyCode;
            }

            int mods = withModifiers ? currentModifiers(mc) : 0;
            try {
                KH_KEY_PRESS.invoke(mc.keyboardHandler, win, keyCode, scancode, GLFW.GLFW_RELEASE, mods);
            } catch (Throwable t) {
                LogUtil.e("Invoke KeyboardHandler key press failed", t);
            }
        }
    }


    public static void clickKey(InputConstants.Key key) {
        clickKey(key, true);
    }


    public static void clickKey(InputConstants.Key key, boolean withModifiers) {
        Minecraft mc = Minecraft.getInstance();
        int keyCode = key.getValue();
        if (KH_KEY_PRESS != null) {
            long win = mc.getWindow().getWindow();
            int scancode = GLFW.glfwGetKeyScancode(keyCode);
            if (scancode == 0) {
                scancode = keyCode;
            }

            int mods = withModifiers ? currentModifiers(mc) : 0;
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
        if (InputConstants.isKeyDown(win, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(win, GLFW.GLFW_KEY_RIGHT_SHIFT)) {
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

    public static boolean isMatchKey(InputEvent.Key e, KeyMapping keyMapping) {
        if (e.getKey() != keyMapping.getKey().getValue()) {
            return false;
        }
        KeyModifier mappingModifier = keyMapping.getKeyModifier();
        int eventModify = e.getModifiers();
        switch (mappingModifier) {
            case ALT -> {
                return eventModify == GLFW.GLFW_MOD_ALT;
            }
            case SHIFT -> {
                return eventModify == GLFW.GLFW_MOD_SHIFT;
            }
            case CONTROL -> {
                return eventModify == GLFW.GLFW_MOD_CONTROL;
            }
            case NONE -> {
                return true;
            }
        }
        return true;
    }
}

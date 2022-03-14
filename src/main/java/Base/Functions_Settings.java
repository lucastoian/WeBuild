package main.java.Base;

import main.java.Elements.BrowserElement;

import java.lang.reflect.Field;

public class Functions_Settings {
    public static BrowserElement getPageElementByString(String className, String fieldName) throws Exception {
        Class<?> c = getClassByString(className);
        Field f  = c.getDeclaredField(fieldName);
        f.setAccessible(true);
        BrowserElement elem = (BrowserElement) f.get((Object)null);
        f.setAccessible(false);
        return elem;
    }
    public static Class<?> getClassByString(String className) throws Exception {
        String[] var1 = new String[]{"pages.", "fragments.", "fragments.parts."};
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String pkg = var1[var3];
            Class<?> c = tryGetClassByString(pkg + className);
            if (c != null) {
                return c;
            }
        }

        return null;
    }
    public static Class<?> tryGetClassByString(String className) throws Exception {
        try {
            return Class.forName("test.java." + className);
        } catch (ClassNotFoundException var2) {
            return null;
        }
    }
}

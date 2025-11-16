package com.ishland.earlyloadingscreen;

import com.ishland.earlyloadingscreen.platform_cl.LaunchPoint;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.spongepowered.asm.mixin.injection.InjectionPoint;

import java.util.Collection;

public class MixinEarlyLaunch extends InjectionPoint {

    public static final String SMALL_REMINDER = "The following \"Unable to register injection point\" can be safely ignored. ";

    static {
        EarlyLaunch.load0(LaunchPoint.mixinEarly);
        System.out.println(SMALL_REMINDER);
    }

    @Override
    public boolean find(String s, InsnList insnList, Collection<AbstractInsnNode> collection) {
        return false;
    }
}

package com.ishland.earlyloadingscreen;

import com.ishland.earlyloadingscreen.patch.FabricLoaderInvokePatch;
import com.ishland.earlyloadingscreen.patch.SodiumOSDetectionPatch;
import com.ishland.earlyloadingscreen.platform_cl.Config;

public class Launch {

    static {
        final ClassLoader classLoader = Launch.class.getClassLoader();
        SharedConstants.LOGGER.info("Loading EarlyLoadingScreen on ClassLoader {}", classLoader.getClass().getName());

        Config.init();
        if (Config.ENABLE_ENTRYPOINT_INFORMATION) {
            FabricLoaderInvokePatch.init();
        }
        SodiumOSDetectionPatch.init();
        LoadingScreenManager.init();
    }

    public static void init() {
    }

    public static void initAndCreateWindow(boolean wait) {
        LoadingScreenManager.createWindow();
        if (wait) {
            LoadingScreenManager.spinWaitInit();
        }
    }

}

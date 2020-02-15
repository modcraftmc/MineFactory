package be.manugame.satisfactorycraft.proxy;

import java.io.File;

public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        System.out.println("pre init côté serveur");
    }

    @Override
    public void init()
    {
        super.init();
    }
}

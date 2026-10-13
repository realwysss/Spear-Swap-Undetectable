/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.fabricmc.loader.api.FabricLoader
 */
package dev.sprswp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import net.fabricmc.loader.api.FabricLoader;

public class Cfg {
    public boolean on = true;
    public boolean totm = true;
    public int hndMn = 0;
    public int hndMx = 1;
    public int swpMn = 1;
    public int swpMx = 2;
    public int bckMn = 1;
    public int bckMx = 3;
    static Cfg c = new Cfg();
    static final Gson gsn = new GsonBuilder().setPrettyPrinting().create();

    static Path pth() {
        return FabricLoader.getInstance().getConfigDir().resolve("sprswp.json");
    }

    static void lod() {
        try {
            if (Files.exists(Cfg.pth(), new LinkOption[0])) {
                c = (Cfg)gsn.fromJson(Files.readString(Cfg.pth()), Cfg.class);
            }
        }
        catch (Exception e) {
            c = null;
        }
        if (c == null) {
            c = new Cfg();
        }
        Cfg.fx();
    }

    static void sav() {
        Cfg.fx();
        try {
            Files.writeString(Cfg.pth(), (CharSequence)gsn.toJson((Object)c), new OpenOption[0]);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static void fx() {
        Cfg.c.hndMn = Math.clamp((long)Cfg.c.hndMn, 0, 20);
        Cfg.c.hndMx = Math.clamp((long)Cfg.c.hndMx, Cfg.c.hndMn, 20);
        Cfg.c.swpMn = Math.clamp((long)Cfg.c.swpMn, 1, 20);
        Cfg.c.swpMx = Math.clamp((long)Cfg.c.swpMx, Cfg.c.swpMn, 20);
        Cfg.c.bckMn = Math.clamp((long)Cfg.c.bckMn, 1, 20);
        Cfg.c.bckMx = Math.clamp((long)Cfg.c.bckMx, Cfg.c.bckMn, 20);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.shedaniel.clothconfig2.api.AbstractConfigListEntry
 *  me.shedaniel.clothconfig2.api.ConfigBuilder
 *  me.shedaniel.clothconfig2.api.ConfigCategory
 *  me.shedaniel.clothconfig2.api.ConfigEntryBuilder
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.class_2561
 *  net.minecraft.class_304
 *  net.minecraft.class_437
 */
package dev.sprswp;

import dev.sprswp.Cfg;
import dev.sprswp.Rng;
import dev.sprswp.SprSwp;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_437;

public class CfgScrn {
    static class_437 mk(class_437 prnt) {
        ConfigBuilder bldr = ConfigBuilder.create().setParentScreen(prnt).setTitle((class_2561)class_2561.method_43471((String)"sprswp.ttl")).setSavingRunnable(Cfg::sav);
        ConfigEntryBuilder configIn = bldr.entryBuilder();
        ConfigCategory configctgry = bldr.getOrCreateCategory((class_2561)class_2561.method_43471((String)"sprswp.gnrl"));
        configctgry.addEntry((AbstractConfigListEntry)configIn.startBooleanToggle((class_2561)class_2561.method_43471((String)"sprswp.on"), Cfg.c.on).setDefaultValue(true).setTooltip(new class_2561[]{class_2561.method_43471((String)"sprswp.on.tip")}).setSaveConsumer(v -> {
            Cfg.c.on = v;
        }).build());
        configctgry.addEntry((AbstractConfigListEntry)configIn.startKeyCodeField((class_2561)class_2561.method_43471((String)"key.sprswp.go"), KeyBindingHelper.getBoundKeyOf((class_304)SprSwp.ky)).setDefaultValue(SprSwp.ky.method_1429()).setAllowMouse(true).setTooltip(new class_2561[]{class_2561.method_43471((String)"sprswp.ky.tip")}).setKeySaveConsumer(SprSwp::stKy).build());
        configctgry.addEntry((AbstractConfigListEntry)configIn.startBooleanToggle((class_2561)class_2561.method_43471((String)"sprswp.totm"), Cfg.c.totm).setDefaultValue(true).setTooltip(new class_2561[]{class_2561.method_43471((String)"sprswp.totm.tip")}).setSaveConsumer(v -> {
            Cfg.c.totm = v;
        }).build());
        configctgry.addEntry((AbstractConfigListEntry)new Rng((class_2561)class_2561.method_43471((String)"sprswp.hnddly"), (class_2561)class_2561.method_43471((String)"sprswp.hnddly.tip"), 0, 20, Cfg.c.hndMn, Cfg.c.hndMx, 0, 1, v -> {
            Cfg.c.hndMn = v[0];
            Cfg.c.hndMx = v[1];
        }));
        configctgry.addEntry((AbstractConfigListEntry)new Rng((class_2561)class_2561.method_43471((String)"sprswp.swpdly"), (class_2561)class_2561.method_43471((String)"sprswp.swpdly.tip"), 1, 20, Cfg.c.swpMn, Cfg.c.swpMx, 1, 2, v -> {
            Cfg.c.swpMn = v[0];
            Cfg.c.swpMx = v[1];
        }));
        configctgry.addEntry((AbstractConfigListEntry)new Rng((class_2561)class_2561.method_43471((String)"sprswp.bckdly"), (class_2561)class_2561.method_43471((String)"sprswp.bckdly.tip"), 1, 20, Cfg.c.bckMn, Cfg.c.bckMx, 1, 3, v -> {
            Cfg.c.bckMn = v[0];
            Cfg.c.bckMx = v[1];
        }));
        return bldr.build();
    }
}


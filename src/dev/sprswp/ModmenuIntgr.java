/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.terraformersmc.modmenu.api.ConfigScreenFactory
 *  com.terraformersmc.modmenu.api.ModMenuApi
 */
package dev.sprswp;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.sprswp.CfgScrn;

public class ModmenuIntgr
implements ModMenuApi {
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return CfgScrn::mk;
    }
}


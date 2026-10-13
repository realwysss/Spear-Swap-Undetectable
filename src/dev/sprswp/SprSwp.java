/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2960
 *  net.minecraft.class_304
 *  net.minecraft.class_304$class_11900
 *  net.minecraft.class_310
 *  net.minecraft.class_3489
 *  net.minecraft.class_3675$class_306
 *  net.minecraft.class_3675$class_307
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  net.minecraft.class_8710
 */
package dev.sprswp;

import dev.sprswp.Cfg;
import dev.sprswp.Hs;
import dev.sprswp.mxn.McAcc;
import java.util.Random;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2960;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3489;
import net.minecraft.class_3675;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import net.minecraft.class_8710;

public class SprSwp
implements ClientModInitializer {
    static class_304 ky;
    static int stg;
    static int tmr;
    static int spr;
    static int hnd;
    static int bck;
    static int wt;
    static final Random rnd;

    public void onInitializeClient() {
        Cfg.lod();
        ky = KeyBindingHelper.registerKeyBinding((class_304)new class_304("key.sprswp.go", class_3675.class_307.field_1668, 82, class_304.class_11900.method_74698((class_2960)class_2960.method_60655((String)"sprswp", (String)"main"))));
        ClientTickEvents.START_CLIENT_TICK.register(SprSwp::tck);
        PayloadTypeRegistry.playC2S().register(Hs.ID, Hs.CDC);
        PayloadTypeRegistry.playS2C().register(Hs.ID, Hs.CDC);
        ClientPlayNetworking.registerGlobalReceiver(Hs.ID, (pl, cx) -> {});
        ClientPlayConnectionEvents.JOIN.register((h, sndr, mc) -> sndr.sendPacket((class_8710)new Hs()));
    }

    static void stKy(class_3675.class_306 k) {
        class_310 mc = class_310.method_1551();
        ky.method_1422(k);
        class_304.method_1426();
        mc.field_1690.method_1640();
    }

    static void tck(class_310 mc) {
        boolean prs = false;
        while (ky.method_1436()) {
            prs = true;
        }
        class_746 p = mc.field_1724;
        if (p == null || mc.field_1761 == null || !p.method_5805()) {
            stg = 0;
            return;
        }
        if (stg == 0) {
            if (!prs || !Cfg.c.on || mc.field_1755 != null) {
                return;
            }
            SprSwp.strt(p);
            if (stg == 0) {
                return;
            }
        }
        if (tmr > 0) {
            --tmr;
            return;
        }
        class_1661 iv = p.method_31548();
        if (stg == 1) {
            iv.method_61496(hnd);
            stg = 2;
            tmr = SprSwp.rn(Cfg.c.swpMn, Cfg.c.swpMx) - 1;
            return;
        }
        if (stg == 2) {
            if (mc.field_1755 != null || !SprSwp.lng(iv.method_5438(spr)) || ++wt > 60) {
                stg = 3;
                return;
            }
            if (p.method_75202(iv.method_5438(spr), -1)) {
                return;
            }
            iv.method_61496(spr);
            ((McAcc)mc).atk();
            stg = 3;
            tmr = SprSwp.rn(Cfg.c.bckMn, Cfg.c.bckMx) - 1;
            return;
        }
        if (stg == 3) {
            if (iv.method_67532() != bck) {
                iv.method_61496(bck);
            }
            stg = 0;
        }
    }

    static void strt(class_746 p) {
        int h;
        class_1661 iv = p.method_31548();
        int cur = iv.method_67532();
        int s = SprSwp.fndSpr(iv);
        if (s < 0) {
            return;
        }
        int n = h = SprSwp.isHnd(iv, cur) ? cur : SprSwp.fndHnd(iv, s);
        if (h < 0) {
            return;
        }
        spr = s;
        hnd = h;
        bck = cur;
        wt = 0;
        stg = h == cur ? 2 : 1;
        tmr = SprSwp.rn(Cfg.c.hndMn, Cfg.c.hndMx);
    }

    static boolean isHnd(class_1661 iv, int i) {
        class_1799 st = iv.method_5438(i);
        if (st.method_7960()) {
            return true;
        }
        return Cfg.c.totm && st.method_31574(class_1802.field_8288);
    }

    static int fndSpr(class_1661 iv) {
        for (int i = 0; i < 9; ++i) {
            if (!SprSwp.lng(iv.method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    static boolean lng(class_1799 st) {
        if (!st.method_31573(class_3489.field_63257)) {
            return false;
        }
        for (class_6880 e : st.method_58657().method_57534()) {
            if (!e.method_55840().endsWith(":lunge")) continue;
            return true;
        }
        return false;
    }

    static int fndHnd(class_1661 iv, int s) {
        int i;
        if (Cfg.c.totm) {
            for (i = 0; i < 9; ++i) {
                if (i == s || !iv.method_5438(i).method_31574(class_1802.field_8288)) continue;
                return i;
            }
        }
        for (i = 0; i < 9; ++i) {
            if (i == s || !iv.method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    static int rn(int a, int b) {
        if (b < a) {
            b = a;
        }
        return a + rnd.nextInt(b - a + 1);
    }

    static {
        rnd = new Random();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.shedaniel.clothconfig2.gui.entries.TooltipListEntry
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_339
 *  net.minecraft.class_357
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 *  net.minecraft.class_6379
 */
package dev.sprswp;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import me.shedaniel.clothconfig2.gui.entries.TooltipListEntry;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_339;
import net.minecraft.class_357;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_5250;
import net.minecraft.class_5348;
import net.minecraft.class_6379;

public class Rng
extends TooltipListEntry<int[]> {
    final int lo;
    final int hi;
    final int[] v;
    final int[] og;
    final int[] dflt;
    final Sldr a;
    final Sldr b;
    final class_4185 rst;
    final List<class_339> wdgs;

    public Rng(class_2561 nm, class_2561 tip, int lo, int hi, int mn, int mx, int dMn, int dMx, Consumer<int[]> sv) {
        super(nm, () -> Optional.of(new class_2561[]{tip}));
        this.lo = lo;
        this.hi = hi;
        this.v = new int[]{mn, mx};
        this.og = new int[]{mn, mx};
        this.dflt = new int[]{dMn, dMx};
        this.saveCallback = sv;
        this.a = new Sldr(0);
        this.b = new Sldr(1);
        class_5250 rt = class_2561.method_43471((String)"text.cloth-config.reset_value");
        this.rst = class_4185.method_46430((class_2561)rt, bt -> {
            this.v[0] = this.dflt[0];
            this.v[1] = this.dflt[1];
            this.a.syn();
            this.b.syn();
        }).method_46434(0, 0, class_310.method_1551().field_1772.method_27525((class_5348)rt) + 6, 20).method_46431();
        this.wdgs = List.of(this.a, this.b, this.rst);
    }

    double frc(int x) {
        return (double)(x - this.lo) / (double)(this.hi - this.lo);
    }

    public int[] getValue() {
        return new int[]{this.v[0], this.v[1]};
    }

    public Optional<int[]> getDefaultValue() {
        return Optional.of(new int[]{this.dflt[0], this.dflt[1]});
    }

    public boolean isEdited() {
        return super.isEdited() || this.v[0] != this.og[0] || this.v[1] != this.og[1];
    }

    public List<? extends class_364> method_25396() {
        return this.wdgs;
    }

    public List<? extends class_6379> narratables() {
        return this.wdgs;
    }

    public void render(class_332 dc, int idx, int y, int x, int w, int h, int mX, int mY, boolean hvr, float dlt) {
        super.render(dc, idx, y, x, w, h, mX, mY, hvr, dlt);
        class_310 mc = class_310.method_1551();
        boolean ed = this.isEditable();
        this.rst.field_22763 = ed && (this.v[0] != this.dflt[0] || this.v[1] != this.dflt[1]);
        this.a.field_22763 = ed;
        this.b.field_22763 = ed;
        dc.method_27535(mc.field_1772, this.getFieldName(), x, y + 6, this.getPreferredTextColor());
        int rw = this.rst.method_25368();
        int sw = (150 - rw - 4) / 2;
        this.rst.method_46421(x + w - rw);
        this.a.method_46421(x + w - 150);
        this.b.method_46421(x + w - 150 + sw + 2);
        this.a.method_25358(sw);
        this.b.method_25358(sw);
        this.rst.method_46419(y);
        this.a.method_46419(y);
        this.b.method_46419(y);
        this.a.method_25394(dc, mX, mY, dlt);
        this.b.method_25394(dc, mX, mY, dlt);
        this.rst.method_25394(dc, mX, mY, dlt);
    }

    class Sldr
    extends class_357 {
        final int i;

        Sldr(int i) {
            super(0, 0, 70, 20, (class_2561)class_2561.method_43473(), Rng.this.frc(Rng.this.v[i]));
            this.i = i;
            this.method_25346();
        }

        protected void method_25346() {
            this.method_25355((class_2561)class_2561.method_43469((String)(this.i == 0 ? "sprswp.mn" : "sprswp.mx"), (Object[])new Object[]{Rng.this.v[this.i]}));
        }

        protected void method_25344() {
            Rng.this.v[this.i] = Rng.this.lo + (int)Math.round(this.field_22753 * (double)(Rng.this.hi - Rng.this.lo));
            if (this.i == 0 && Rng.this.v[0] > Rng.this.v[1]) {
                Rng.this.v[1] = Rng.this.v[0];
                Rng.this.b.syn();
            }
            if (this.i == 1 && Rng.this.v[1] < Rng.this.v[0]) {
                Rng.this.v[0] = Rng.this.v[1];
                Rng.this.a.syn();
            }
        }

        void syn() {
            this.field_22753 = Rng.this.frc(Rng.this.v[this.i]);
            this.method_25346();
        }
    }
}


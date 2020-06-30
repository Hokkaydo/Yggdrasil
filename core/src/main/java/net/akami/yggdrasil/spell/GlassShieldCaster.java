package net.akami.yggdrasil.spell;

import net.akami.yggdrasil.api.item.InteractiveItemHandler;
import net.akami.yggdrasil.api.spell.AbstractSpellCaster;
import net.akami.yggdrasil.api.spell.ElementType;
import net.akami.yggdrasil.api.spell.Spell;
import net.akami.yggdrasil.api.utils.YggdrasilMath;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class GlassShieldCaster extends AbstractSpellCaster {

    private InteractiveItemHandler handler;

    public GlassShieldCaster(InteractiveItemHandler handler) {
        this.handler = handler;
    }

    @Override
    protected Supplier<Spell> loadGenerator() {
        return () -> new GlassShieldSpell(handler);
    }

    @Override
    protected List<ElementType> loadSequence() {
        return Arrays.asList(
                ElementType.AIR,
                ElementType.EARTH,
                ElementType.WATER
        );
    }

    @Override
    protected BiFunction<Float, Integer, Float> loadManaUsage() {
        return YggdrasilMath.instantStandardPolynomialFunction(20);
    }
}

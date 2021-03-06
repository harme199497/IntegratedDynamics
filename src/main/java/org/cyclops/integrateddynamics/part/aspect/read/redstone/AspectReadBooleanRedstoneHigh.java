package org.cyclops.integrateddynamics.part.aspect.read.redstone;

/**
 * Aspect that can detect when a redstone level is maximum.
 * @author rubensworks
 */
public class AspectReadBooleanRedstoneHigh extends AspectReadBooleanRedstoneBase {
    @Override
    protected boolean getValue(int redstoneLevel) {
        return redstoneLevel == 15;
    }

    @Override
    protected String getUnlocalizedBooleanRedstoneType() {
        return "high";
    }
}

package org.cyclops.integrateddynamics.core.parts;

import net.minecraft.util.EnumFacing;
import org.cyclops.cyclopscore.datastructure.DimPos;

import java.util.Map;

/**
 * A interface for containers that can hold {@link org.cyclops.integrateddynamics.core.parts.IPart}s.
 * @author rubensworks
 */
public interface IPartContainer {

    /**
     * @return The position this container is at.
     */
    public DimPos getPosition();

    /**
     * @return The parts inside this container.
     */
    public Map<EnumFacing, IPart<?, ?>> getParts();

    /**
     * Set the part for a side.
     * @param side The side to place the part on.
     * @param part The part.
     * @param <P> The type of part.
     * @param <S> The type of part state.
     */
    public <P extends IPart<P, S>, S extends IPartState<P>> void setPart(EnumFacing side, IPart<P, S> part);

    /**
     * Get the part of a side, can be null.
     * @param side The side.
     * @return The part or null.
     */
    public IPart getPart(EnumFacing side);

    /**
     * @param side The side.
     * @return If the given side has a part.
     */
    public boolean hasPart(EnumFacing side);

    /**
     * Remove the part from a side, can return null if there was no part on that side.
     * @param side The side.
     * @return The removed part or null.
     */
    public IPart removePart(EnumFacing side);

    /**
     * Set the state of a part.
     * @param side The side.
     * @param partState The part state.
     */
    public void setPartState(EnumFacing side, IPartState partState);

    /**
     * Get the state of a part.
     * @param side The side.
     * @return The part state.
     */
    public IPartState getPartState(EnumFacing side);

}

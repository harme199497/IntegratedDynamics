package org.cyclops.integrateddynamics.core.evaluate.variable;

import org.cyclops.integrateddynamics.core.evaluate.InvalidValueTypeException;

/**
 * An immutable value.
 * @author rubensworks
 */
public interface IValue {

    /**
     * @return The type of this variable.
     */
    public IValueType getType();

    /**
     * Safely downcast this value.
     * @param valueType The type of value to cast to.
     * @param <V> The actual value type.
     * @return The downcasted value.
     * @throws org.cyclops.integrateddynamics.core.evaluate.InvalidValueTypeException If this value could not be cast to the given type.
     */
    public <V extends IValue> V cast(IValueType<V> valueType) throws InvalidValueTypeException;

}

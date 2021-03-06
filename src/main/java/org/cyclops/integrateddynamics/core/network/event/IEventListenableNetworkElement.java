package org.cyclops.integrateddynamics.core.network.event;

import org.cyclops.integrateddynamics.core.network.INetworkElement;
import org.cyclops.integrateddynamics.core.network.INetworkEventListener;

import javax.annotation.Nullable;

/**
 * Network elements that can delegate to elements that are automatically subscribed to the {@link NetworkEventBus}.
 * @param <D> The type of delegate that will be used as event listener for this network. Could be self or null.
 * @author rubensworks
 */
public interface IEventListenableNetworkElement<D extends INetworkEventListener<?>> extends INetworkElement {

    /**
     * This listener will never be saved as an instance, this network element is always used as delegator to this listener.
     * @return The event listener.
     */
    public @Nullable D getNetworkEventListener();

}

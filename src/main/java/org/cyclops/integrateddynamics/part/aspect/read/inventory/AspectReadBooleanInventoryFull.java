package org.cyclops.integrateddynamics.part.aspect.read.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import org.cyclops.cyclopscore.datastructure.DimPos;
import org.cyclops.integrateddynamics.api.part.PartTarget;
import org.cyclops.integrateddynamics.api.part.aspect.property.IAspectProperties;
import org.cyclops.integrateddynamics.core.evaluate.variable.ValueTypeBoolean;

/**
 * Aspect that checks if all slots contain at least one item.
 * @author rubensworks
 */
public class AspectReadBooleanInventoryFull extends AspectReadBooleanInventoryBase {

    @Override
    protected String getUnlocalizedBooleanWorldType() {
        return "full";
    }

    @Override
    protected ValueTypeBoolean.ValueBoolean getValue(PartTarget target, IAspectProperties properties) {
        DimPos dimPos = target.getTarget().getPos();
        TileEntity tile = dimPos.getWorld().getTileEntity(dimPos.getBlockPos());
        if(tile instanceof IInventory) {
            IInventory inventory = (IInventory) tile;
            for(int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack itemStack = inventory.getStackInSlot(i);
                if(itemStack == null) {
                    return ValueTypeBoolean.ValueBoolean.of(false);
                }
            }
        }
        return ValueTypeBoolean.ValueBoolean.of(true);
    }
}

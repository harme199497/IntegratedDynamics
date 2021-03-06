package org.cyclops.integrateddynamics.core.evaluate.operator;

import org.cyclops.cyclopscore.helper.L10NHelpers;
import org.cyclops.integrateddynamics.core.evaluate.EvaluationException;
import org.cyclops.integrateddynamics.core.evaluate.variable.IValue;
import org.cyclops.integrateddynamics.core.evaluate.variable.IValueType;
import org.cyclops.integrateddynamics.core.evaluate.variable.IVariable;

import java.util.List;

/**
 * Relation on value types.
 * @author rubensworks
 */
public interface IOperator {

    /**
     * @return The unique name of this operator that will also be used for display.
     */
    public String getSymbol();

    /**
     * @return The unique name for this operator, only used for internal storage.
     */
    public String getUniqueName();

    /**
     * @return The unique unlocalized name for this operator.
     */
    public String getUnlocalizedName();

    /**
     * @return The unique unlocalized category name for this operator.
     */
    public String getUnlocalizedCategoryName();

    /**
     * @return The localized full name for this operator, includes category name
     */
    public String getLocalizedNameFull();

    /**
     * Add tooltip lines for this aspect when hovered in a gui.
     * @param lines The list to add lines to.
     * @param appendOptionalInfo If shift-to-show info should be added.
     */
    public void loadTooltip(List<String> lines, boolean appendOptionalInfo);

    /**
     * @return The ordered types of values that are used as input for this operator.
     */
    public IValueType[] getInputTypes();

    /**
     * @return The type of value that is achieved when this operator is executed.
     */
    public IValueType getOutputType();

    /**
     * Get the output value type depending on the active input of the operator.
     * @param input The input that would be given during evaluation.
     * @return The type of value that is achieved when this operator is executed.
     */
    public IValueType getConditionalOutputType(IVariable[] input);

    /**
     * Evaluate the given input values for this operator.
     * @param input The ordered input values.
     * @return The output value.
     * @throws EvaluationException When something went wrong while evaluating.
     */
    public IValue evaluate(IVariable[] input) throws EvaluationException;

    /**
     * @return The required input length.
     */
    public int getRequiredInputLength();

    /**
     * Check the given input value types for this operator.
     * @param input The ordered input value types.
     * @return An error or null if valid.
     */
    public L10NHelpers.UnlocalizedString validateTypes(IValueType[] input);

    /**
     * @return The render pattern for this operator inside the logic programmer.
     */
    public IConfigRenderPattern getRenderPattern();

}

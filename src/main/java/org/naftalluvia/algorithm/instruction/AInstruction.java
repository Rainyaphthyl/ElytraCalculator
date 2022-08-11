package org.naftalluvia.algorithm.instruction;

import org.naftalluvia.algorithm.BundleOperation;

/**
 * An abstract trail of operations during a sequence of ticks, including firework usage and aim direction adjustment.
 */
public abstract class AInstruction {
    /**
     * @return A bundle of scheduled operations during the next tick.
     */
    public abstract BundleOperation next();

    /**
     * @return Whether the operations exist during the next tick.
     */
    public abstract boolean hasNext();
}

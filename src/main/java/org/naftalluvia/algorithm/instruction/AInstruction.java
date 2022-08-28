package org.naftalluvia.algorithm.instruction;

import org.jetbrains.annotations.NotNull;
import org.naftalluvia.algorithm.BundleOperation;
import org.naftalluvia.mathutil.VecSight;

/**
 * An abstract trail of operations during a sequence of ticks (either time limited or infinite), including firework usage and aim direction adjustment.
 */
public abstract class AInstruction implements Comparable<AInstruction> {
    /**
     * The return value should vary on the instruction iterator moving.
     *
     * @return The initial pitch and yaw in the instruction.
     */
    public abstract VecSight getRotationInit();

    /**
     * Gets the next operation WITHOUT moving the iterator forward.
     * Returns {@code null} only if {@code hasNext() == false}.
     *
     * @return A bundle of scheduled operations during the next tick.
     */
    public abstract BundleOperation getNext();

    /**
     * Moves the iterator to the next tick. The initial rotation shall also be changed.
     */
    public abstract void prepareNext();

    /**
     * @return Whether the operations exist during the next tick.
     */
    public abstract boolean hasNext();

    /**
     * Gets the next operation, and then moves the iterator to the next tick. Returns {@code null} only if the instruction ends.
     *
     * @return A bundle of scheduled operations during the next tick.
     */
    public BundleOperation next() {
        BundleOperation operation = null;
        if (this.hasNext()) {
            operation = this.getNext();
            this.prepareNext();
        }
        return operation;
    }

    /**
     * Switch to the «historical version» of the instruction at the certain tick.
     *
     * @param orderTick The serial number of the tick to switch.
     */
    public abstract void jumpToTick(int orderTick);

    public abstract int getCurrentTick();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public int compareTo(@NotNull AInstruction o) {
        return this.equals(o) ? 0 : Integer.compare(this.hashCode(), o.hashCode());
    }
}

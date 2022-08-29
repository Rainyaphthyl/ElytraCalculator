package org.naftalluvia.algorithm.instruction;

import org.naftalluvia.algorithm.BundleOperation;

import java.util.Objects;

public abstract class AFiniteInstruction extends AInstruction {
    protected final int limitTicks;

    protected AFiniteInstruction(int limitTicks) {
        this.limitTicks = Math.max(limitTicks, 0);
    }

    /**
     * Returns {@code true} if {@code instruction} generates the same operations with {@code this}.
     */
    public final boolean isEquivalentTo(AFiniteInstruction instruction) {
        boolean equivalent = instruction != null && Objects.equals(this.getRotationInit().pitch(), instruction.getRotationInit().pitch());
        if (equivalent) {
            BundleOperation opHere = this.next();
            BundleOperation opInst = instruction.next();
            while (equivalent && (opHere != null || opInst != null)) {
                if (!Objects.equals(opHere, opInst)) {
                    equivalent = false;
                }
                opHere = this.next();
                opInst = instruction.next();
            }
        }
        return equivalent;
    }
}

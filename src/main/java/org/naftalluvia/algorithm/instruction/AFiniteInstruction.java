package org.naftalluvia.algorithm.instruction;

import org.naftalluvia.algorithm.BundleOperation;

import java.util.Objects;

public abstract class AFiniteInstruction extends AInstruction {
    /**
     * Returns {@code true} if {@code instruction} generates the same operations with {@code this}.
     */
    public boolean isEquivalentTo(AFiniteInstruction instruction) {
        boolean equivalent = instruction != null && this.getRotationInit().equals(instruction.getRotationInit());
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

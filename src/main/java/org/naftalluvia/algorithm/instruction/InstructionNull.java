package org.naftalluvia.algorithm.instruction;

import org.naftalluvia.algorithm.BundleOperation;

/**
 * Instruction of "No Operations"
 */
public class InstructionNull extends AInstruction {
    @Override
    public BundleOperation next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}

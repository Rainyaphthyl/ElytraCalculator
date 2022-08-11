package org.naftalluvia.algorithm.instruction;

import org.naftalluvia.algorithm.BundleOperation;

/**
 * Instruction of "No Operations" in finite ticks.
 */
public class InstructionAfk extends AInstruction {
    private int ticksCountdown;

    public InstructionAfk(int limitTicks) {
        this.ticksCountdown = limitTicks;
    }

    @Override
    public BundleOperation getNext() {
        return BundleOperation.OPERATION_AFK;
    }

    @Override
    public void prepareNext() {
        --this.ticksCountdown;
    }

    @Override
    public boolean hasNext() {
        return this.ticksCountdown > 0;
    }
}

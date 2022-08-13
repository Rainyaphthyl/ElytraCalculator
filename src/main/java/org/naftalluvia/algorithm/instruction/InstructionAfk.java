package org.naftalluvia.algorithm.instruction;

import org.naftalluvia.algorithm.BundleOperation;
import org.naftalluvia.mathutil.VecSight;

import java.util.Objects;

/**
 * Instruction of "No Operations" in finite ticks.
 */
public class InstructionAfk extends AInstruction {
    private final float initPitch;
    private final float initYaw;
    private int ticksCountdown;

    public InstructionAfk(float initPitch, float initYaw, int limitTicks) {
        this.initPitch = initPitch;
        this.initYaw = initYaw;
        this.ticksCountdown = limitTicks;
    }

    @Override
    public VecSight getRotationInit() {
        return new VecSight(this.initPitch, this.initYaw);
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof InstructionAfk) {
            if (obj == this) {
                return true;
            } else {
                return ((InstructionAfk) obj).ticksCountdown == this.ticksCountdown && Objects.equals(((InstructionAfk) obj).getRotationInit(), this.getRotationInit());
            }
        } else {
            return false;
        }
    }
}

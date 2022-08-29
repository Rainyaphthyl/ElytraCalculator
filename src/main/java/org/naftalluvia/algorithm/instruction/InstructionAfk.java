package org.naftalluvia.algorithm.instruction;

import org.naftalluvia.algorithm.BundleOperation;
import org.naftalluvia.mathutil.VecSight;

import java.util.Objects;

/**
 * Instruction of "No Operations" in finite ticks.
 */
public class InstructionAfk extends AFiniteInstruction {
    private final float initPitch;
    private final float initYaw;

    public InstructionAfk(float initPitch, float initYaw, int limitTicks) {
        super(limitTicks);
        this.initPitch = initPitch;
        this.initYaw = initYaw;
    }

    @Override
    public VecSight getRotationInit() {
        return new VecSight(this.initPitch, this.initYaw);
    }

    @Override
    public VecSight getRotationCurrent() {
        return this.getRotationInit();
    }

    @Override
    public BundleOperation getNext() {
        return BundleOperation.OPERATION_AFK;
    }

    @Override
    public void prepareNext() {
        this.prepareTickNext();
    }

    @Override
    public boolean hasNext() {
        return this.getTickCurrent() < this.limitTicks;
    }

    @Override
    public void jumpToTick(int orderTick) {
        this.setTickCurrent(orderTick);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof InstructionAfk) {
            if (obj == this) {
                return true;
            } else {
                return this.limitTicks == ((InstructionAfk) obj).limitTicks && Objects.equals(this.getRotationInit(), ((InstructionAfk) obj).getRotationInit());
            }
        } else if (obj instanceof AFiniteInstruction) {
            return this.isEquivalentTo((AFiniteInstruction) obj);
        } else {
            return false;
        }
    }
}

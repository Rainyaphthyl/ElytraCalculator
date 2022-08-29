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
    private final int limitTicks;
    private int currTicks;

    public InstructionAfk(float initPitch, float initYaw, int limitTicks) {
        this.initPitch = initPitch;
        this.initYaw = initYaw;
        this.limitTicks = limitTicks;
        this.currTicks = 0;
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
        ++this.currTicks;
    }

    @Override
    public boolean hasNext() {
        return this.limitTicks < 0 || this.currTicks < this.limitTicks;
    }

    @Override
    public void jumpToTick(int orderTick) {
        this.currTicks = orderTick;
    }

    @Override
    public int getTickCurrent() {
        return this.currTicks;
    }

    @Override
    public int getLimitTicks() {
        return this.limitTicks;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof InstructionAfk) {
            if (obj == this) {
                return true;
            } else {
                InstructionAfk objInst = (InstructionAfk) obj;
                return (this.limitTicks == objInst.limitTicks || (this.limitTicks < 0 && objInst.limitTicks < 0))
                        && Objects.equals(this.getRotationInit(), objInst.getRotationInit());
            }
        } else if (obj instanceof AFiniteInstruction) {
            return this.isEquivalentTo((AFiniteInstruction) obj);
        } else {
            return false;
        }
    }
}

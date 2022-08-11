package org.naftalluvia.algorithm;

import org.naftalluvia.algorithm.instruction.AInstruction;
import org.naftalluvia.model.BundleMovement;
import org.naftalluvia.model.EntityPlayer;
import org.naftalluvia.model.World;

/**
 * Predicting the trail of movement by a sequence of scheduled operations during the following ticks.
 */
public class PredictorProgrammed {
    private final AInstruction instruction;
    private BundleMovement movementInitial;

    public PredictorProgrammed(AInstruction instruction, BundleMovement movementInitial) {
        System.out.printf("Instruction %s\n\t in Predictor %s\n", instruction, this);
        this.instruction = instruction;
        if (this.instruction != null) {
            System.out.println("Initializing world for simulation...");
            this.movementInitial = movementInitial;
        }
    }

    public static BundleMovement predictFinalState(AInstruction program, BundleMovement initial) {
        PredictorProgrammed predictor = new PredictorProgrammed(program, initial);
        return predictor.getStateFinal();
    }

    public boolean isInitialized() {
        return this.instruction != null && this.movementInitial != null;
    }

    public BundleMovement getStateFinal() {
        if (!this.isInitialized()) {
            return null;
        }
        World world = new World();
        EntityPlayer player = new EntityPlayer(world, this.movementInitial, this.instruction.getRotationInit());
        world.spawnEntity(player);
        for (BundleOperation operation = this.instruction.next(); operation != null; operation = this.instruction.next()) {
            world.tick();
        }
        return player.getBundleMovement();
    }

    public BundleMovement getStateAfter(int ticks) {
        return null;
    }
}

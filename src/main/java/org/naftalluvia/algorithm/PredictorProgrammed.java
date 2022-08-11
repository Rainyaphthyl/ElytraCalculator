package org.naftalluvia.algorithm;

import org.naftalluvia.algorithm.instruction.AInstruction;
import org.naftalluvia.model.BundleParameters;
import org.naftalluvia.model.EntityPlayer;
import org.naftalluvia.model.World;

/**
 * Predicting the trail of movement by a sequence of scheduled operations during the following ticks.
 */
public class PredictorProgrammed {
    private final AInstruction instruction;
    private final World worldTest = new World();

    public PredictorProgrammed(AInstruction instruction) {
        System.out.printf("Instruction %s\n\t in Predictor %s\n", instruction, this);
        this.instruction = instruction;
    }

    public void initialize(BundleParameters bundleParameters) {
        if (this.instruction != null && bundleParameters != null) {
            System.out.println("Initializing world for simulation...");
            EntityPlayer player = new EntityPlayer(this.worldTest, bundleParameters.position(), bundleParameters.rotation(), bundleParameters.momentum());
        }
    }
}

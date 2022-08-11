package org.naftalluvia.algorithm;

import org.naftalluvia.algorithm.instruction.AInstruction;

/**
 * Predicting the trail of movement by a sequence of scheduled operations during the following ticks.
 */
public class PredictorProgrammed {
    public PredictorProgrammed(AInstruction instruction) {
        System.out.printf("Operation Trail (%s) in Predictor (%s)\n", instruction, this);
    }
}

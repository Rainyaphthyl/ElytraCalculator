package org.naftalluvia.algorithm;

import org.naftalluvia.algorithm.operationtrail.ATrailOperation;

/**
 * Predicting the trail of movement by a sequence of scheduled operations during the following ticks.
 */
public class PredictorProgrammed {
    public PredictorProgrammed(ATrailOperation trailOperation) {
        System.out.printf("Operation Trail (%s) in Predictor (%s)\n", trailOperation, this);
    }
}

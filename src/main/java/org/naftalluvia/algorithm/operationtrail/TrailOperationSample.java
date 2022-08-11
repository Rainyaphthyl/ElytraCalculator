package org.naftalluvia.algorithm.operationtrail;

import org.naftalluvia.algorithm.BundleOperation;

public class TrailOperationSample extends ATrailOperation{
    /**
     * @return 1
     */
    @Override
    public BundleOperation next() {
        return null;
    }

    /**
     * @return 1
     */
    @Override
    public boolean hasNext() {
        return false;
    }
}

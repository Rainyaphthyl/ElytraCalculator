import org.naftalluvia.algorithm.operationtrail.ATrailOperation;
import org.naftalluvia.algorithm.BundleOperation;
import org.naftalluvia.algorithm.PredictorProgrammed;

public class TestPredictorInit {
    public static void main(String[] args) {
        PredictorProgrammed predictor = new PredictorProgrammed(new ATrailOperation() {
            @Override
            public BundleOperation next() {
                return BundleOperation.NULL_OPERATION;
            }

            @Override
            public boolean hasNext() {
                return true;
            }
        });
    }
}

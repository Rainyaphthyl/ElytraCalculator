import org.naftalluvia.algorithm.instruction.AInstruction;
import org.naftalluvia.algorithm.BundleOperation;
import org.naftalluvia.algorithm.PredictorProgrammed;

public class TestPredictorInit {
    public static void main(String[] args) {
        PredictorProgrammed predictor = new PredictorProgrammed(new AInstruction() {
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

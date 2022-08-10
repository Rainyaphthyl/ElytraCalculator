import org.naftalluvia.algorithm.ATrailOperation;
import org.naftalluvia.algorithm.BundleOperation;
import org.naftalluvia.algorithm.Predictor;

public class TestPredictorInit {
    public static void main(String[] args) {
        Predictor predictor = new Predictor(new ATrailOperation() {
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

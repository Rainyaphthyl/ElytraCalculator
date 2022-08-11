import org.naftalluvia.algorithm.PredictorProgrammed;
import org.naftalluvia.algorithm.instruction.InstructionAfk;

public class TestPredictorInit {
    public static void main(String[] args) {
        PredictorProgrammed predictor = new PredictorProgrammed(new InstructionAfk(2000));
    }
}

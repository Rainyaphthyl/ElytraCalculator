import org.naftalluvia.algorithm.PredictorProgrammed;
import org.naftalluvia.algorithm.instruction.InstructionAfk;
import org.naftalluvia.model.BundleMovement;

public class TestPredictorInit {
    public static void main(String[] args) {
        PredictorProgrammed predictor = new PredictorProgrammed(new InstructionAfk(45.0F, -90.0F, 2000), new BundleMovement(0.5, 4096.0, 0.5, 0.0, -0.3, 0.0));
        BundleMovement movementFinal = predictor.getStateFinal();
        if (movementFinal != null) {
            System.out.printf("position = %s, motion = %s\n", movementFinal.position(), movementFinal.momentum());
        }
    }
}

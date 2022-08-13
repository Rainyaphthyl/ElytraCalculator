import org.naftalluvia.algorithm.instruction.InstructionAfk;

public class TestInstructionEquals {
    public static void main(String[] args) {
        InstructionAfk inst1 = new InstructionAfk(0.0F, 0.0F, 100);
        InstructionAfk inst2 = new InstructionAfk(0.0F, 0.0F, 100);
        boolean flag = inst1.isEquivalentTo(inst2);
        System.out.println(flag);
    }
}

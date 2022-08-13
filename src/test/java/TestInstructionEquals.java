import org.naftalluvia.algorithm.instruction.InstructionAfk;

public class TestInstructionEquals {
    public static void main(String[] args) {
        InstructionAfk inst1 = new InstructionAfk(0.0F, 0.0F, 100);
        InstructionAfk inst2 = new InstructionAfk(0.0F, 0.0F, 100);
        boolean flag1 = inst1.isEquivalentTo(inst2);
        int diff = inst1.compareTo(inst2);
        System.out.println(flag1);
        System.out.println(diff);
    }
}

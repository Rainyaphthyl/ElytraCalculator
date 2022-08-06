import org.naftalluvia.mathutil.Vec3d;
import org.naftalluvia.mathutil.Vec3i;

public class TestElytraCalculator {

    public static void main(String[] args) {
        System.out.println("Now loading...");
        Vec3d posD = new Vec3d(11, 45, 14);
        Vec3i posI = new Vec3i(16, 256, 65536);
        Vec3i motion = new Vec3i(8, 64, -512);
        System.out.printf("%s + %s = %s\n", posI, posD, posD.add(posI.toVec3d()));
        System.out.printf("%s + %s = %s\n", posI, motion, posI.add(motion));
    }
}

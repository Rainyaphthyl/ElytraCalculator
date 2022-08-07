import org.naftalluvia.algorithm.EntityMoving;
import org.naftalluvia.mathutil.Vec3d;
import org.naftalluvia.mathutil.VecSight;

public class TestElytraCalculator {

    public static void main(String[] args) {
        System.out.println("Now loading...");
        EntityMoving point = new EntityMoving(new Vec3d(0.0, 0.0, 0.0), new VecSight(0.0F, 0.0F), new Vec3d(0.0, 0.0, 0.0));
        for (int i = 0; i < 1200; i++) {
            point.update();
            System.out.printf("tick %4d: %s, %s\n", i, point.getPosition(), point.getMomentum());
        }
    }
}

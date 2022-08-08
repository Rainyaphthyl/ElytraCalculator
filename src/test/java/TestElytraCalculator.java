import org.naftalluvia.algorithm.EntityMoving;
import org.naftalluvia.mathutil.MathHelper;
import org.naftalluvia.mathutil.Vec3d;
import org.naftalluvia.mathutil.VecSight;

public class TestElytraCalculator {

    public static void main(String[] args) {
        System.out.println("Now loading...");
        EntityMoving point = new EntityMoving(new Vec3d(0.0, 0.0, 0.0), new VecSight(0.0F, -90.0F), new Vec3d(0.0, -1.0, 0.0));
        for (int i = 0; i < 3600; i++) {
            if (i % 20 == 0) {
                Vec3d position = point.getPosition();
                Vec3d motion = point.getMomentum();
                System.out.printf("sec %4d: [%9.3f, %9.3f, %9.3f], [%6.3f, %6.3f, %6.3f]\n", i / 20,
                        MathHelper.roundTo(position.x(), 3),
                        MathHelper.roundTo(position.y(), 3),
                        MathHelper.roundTo(position.z(), 3),
                        MathHelper.roundTo(motion.x() * 20, 3),
                        MathHelper.roundTo(motion.y() * 20, 3),
                        MathHelper.roundTo(motion.z() * 20, 3));
            }
            point.update();
        }
    }
}

import org.naftalluvia.model.EntityPlayer;
import org.naftalluvia.model.World;
import org.naftalluvia.mathutil.MathHelper;
import org.naftalluvia.mathutil.Vec3d;
import org.naftalluvia.mathutil.VecSight;

public class TestInit {

    public static void main(String[] args) {
        System.out.println("Now loading...");
        World worldLab = new World();
        EntityPlayer point = new EntityPlayer(worldLab, new Vec3d(0.0, 0.0, 0.0), new VecSight(0.0F, -90.0F), new Vec3d(0.0, -1.0, 0.0));
        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                Vec3d position = point.getPosition();
                Vec3d motion = point.getMomentum();
                System.out.printf("sec %4d: [%11.3f, %11.3f, %11.3f], [%8.3f, %8.3f, %8.3f]\n", i / 20,
                        MathHelper.roundTo(position.x(), 3),
                        MathHelper.roundTo(position.y(), 3),
                        MathHelper.roundTo(position.z(), 3),
                        MathHelper.roundTo(motion.x() * 20, 3),
                        MathHelper.roundTo(motion.y() * 20, 3),
                        MathHelper.roundTo(motion.z() * 20, 3));
            }
            point.onUpdate();
        }
    }
}

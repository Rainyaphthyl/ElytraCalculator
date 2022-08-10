import org.naftalluvia.mathutil.MathHelper;
import org.naftalluvia.mathutil.Vec3d;
import org.naftalluvia.mathutil.VecSight;
import org.naftalluvia.model.EntityPlayer;
import org.naftalluvia.model.World;

public class TestWorldTick {

    public static void main(String[] args) {
        System.out.println("Now loading...");
        World worldLab = new World();
        EntityPlayer pointPlayer = new EntityPlayer(
                worldLab, new Vec3d(0.0, 0.0, 0.0),
                new VecSight(45.0F, -90.0F),
                new Vec3d(0.0, 0.0, 0.0)
        );
        worldLab.spawnEntity(pointPlayer);
        pointPlayer.launchFirework(3);
        for (int i = 0; i <= 1200; i++) {
            if (i % 20 == 0) {
                System.out.printf("tick %4d: ", i / 20);
                printlnPlayer(pointPlayer);
            }
            worldLab.tick();
        }
    }

    public static void printlnPlayer(EntityPlayer point) {
        if (point != null) {
            Vec3d position = point.getPosition();
            Vec3d motion = point.getMomentum();
            System.out.printf("[%11.3f, %11.3f, %11.3f], [%8.3f, %8.3f, %8.3f]\n",
                    MathHelper.roundTo(position.x(), 3),
                    MathHelper.roundTo(position.y(), 3),
                    MathHelper.roundTo(position.z(), 3),
                    MathHelper.roundTo(motion.x() * 20, 3),
                    MathHelper.roundTo(motion.y() * 20, 3),
                    MathHelper.roundTo(motion.z() * 20, 3)
            );
        }
    }
}

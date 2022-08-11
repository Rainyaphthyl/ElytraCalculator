package org.naftalluvia.algorithm;

/**
 * A bundle of player operations scheduled, e.g.
 * <ul>
 *     <li>launching fireworks;</li>
 *     <li>adjusting pitch & yaw;</li>
 * </ul>
 * <p>Disable fireworks by switching firework level to -1.</p>
 * <p>The adjustment of pitch & yaw should be "continuous".</p>
 */
public record BundleOperation(int levelFireworks, float incrementPitch, float incrementYaw) {
    public static BundleOperation OPERATION_AFK = new BundleOperation(-1, 0.0F, 0.0F);

}

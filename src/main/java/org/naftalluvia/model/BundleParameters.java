package org.naftalluvia.model;

import org.naftalluvia.mathutil.Vec3d;
import org.naftalluvia.mathutil.VecSight;

public record BundleParameters(Vec3d position, Vec3d momentum, VecSight rotation) {
}

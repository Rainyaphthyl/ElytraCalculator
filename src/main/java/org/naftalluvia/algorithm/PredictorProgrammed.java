package org.naftalluvia.algorithm;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.naftalluvia.algorithm.instruction.AInstruction;
import org.naftalluvia.model.BundleMovement;
import org.naftalluvia.model.EntityPlayer;
import org.naftalluvia.model.World;

import java.util.Objects;
import java.util.TreeMap;

/**
 * Predicting the trail of movement by a sequence of scheduled operations during the following ticks.
 */
public class PredictorProgrammed {
    private static final TreeMap<BundleMovement, TreeMap<AInstruction, PredictorProgrammed>> CACHE_MAP_INSTANCES = new TreeMap<>();

    private final TreeMap<Integer, EntityPlayer> cacheMapPlayers = new TreeMap<>();
    private final AInstruction instruction;
    private final BundleMovement movementInitial;

    private PredictorProgrammed(AInstruction instruction, BundleMovement movementInitial) {
        System.out.printf("Instruction %s\n\t in Predictor %s\n", instruction, this);
        this.instruction = instruction;
        if (this.instruction != null) {
            System.out.println("Initializing world for simulation...");
            this.movementInitial = movementInitial;
        } else {
            this.movementInitial = null;
        }
    }

    @Contract("_, _ -> new")
    public static @NotNull PredictorProgrammed getInstance(AInstruction instruction, BundleMovement movementInitial) {
        return new PredictorProgrammed(instruction, movementInitial);
    }

    public static BundleMovement predictFinalState(AInstruction program, BundleMovement initial) {
        PredictorProgrammed predictor = new PredictorProgrammed(program, initial);
        return predictor.getStateFinal();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PredictorProgrammed) {
            if (this == obj) {
                return true;
            } else {
                return Objects.equals(((PredictorProgrammed) obj).instruction, this.instruction) && Objects.equals(((PredictorProgrammed) obj).movementInitial, this.movementInitial);
            }
        } else {
            return false;
        }
    }

    public boolean isInitialized() {
        return this.instruction != null && this.movementInitial != null;
    }

    public BundleMovement getStateFinal() {
        if (!this.isInitialized()) {
            return null;
        }
        World world = new World();
        EntityPlayer player = new EntityPlayer(world, this.movementInitial, this.instruction.getRotationInit());
        world.spawnEntity(player);
        for (BundleOperation operation = this.instruction.next(); operation != null; operation = this.instruction.next()) {
            world.tick();
        }
        return player.getBundleMovement();
    }

    public BundleMovement getStateAfter(int ticks) {
        return null;
    }

}

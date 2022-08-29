package org.naftalluvia.algorithm;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.naftalluvia.algorithm.instruction.AInstruction;
import org.naftalluvia.model.BundleMovement;
import org.naftalluvia.model.EntityPlayer;
import org.naftalluvia.model.World;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Predicting the trail of movement by a sequence of scheduled operations during the following ticks.
 */
public class PredictorProgrammed {
    private static final TreeMap<BundleMovement, TreeMap<AInstruction, PredictorProgrammed>> CACHE_MAP_INSTANCES = new TreeMap<>();
    /**
     * The bundle of movement DURING a certain tick, i.e. AFTER a certain number of ticks. If {@code key = 0}, then {@code value = movementInitial};
     */
    private final TreeMap<Integer, BundleMovement> cacheMapTicksParameters = new TreeMap<>();
    private final AInstruction instruction;
    private final BundleMovement movementInitial;

    private PredictorProgrammed(AInstruction instruction, BundleMovement movementInitial) {
        System.out.printf("Instruction %s\n\t in Predictor %s\n", instruction, this);
        this.instruction = instruction;
        this.movementInitial = this.instruction == null ? null : movementInitial;
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
                return Objects.equals(this.instruction, ((PredictorProgrammed) obj).instruction) && Objects.equals(this.movementInitial, ((PredictorProgrammed) obj).movementInitial);
            }
        } else {
            return false;
        }
    }

    public boolean isInitialized() {
        return this.instruction != null && this.movementInitial != null;
    }

    public synchronized BundleMovement getStateFinal() {
        if (!this.isInitialized()) {
            return null;
        }
        World world = new World();
        EntityPlayer player = new EntityPlayer(world, this.movementInitial, this.instruction.getRotationInit());
        world.spawnEntity(player);
        for (BundleOperation operation = this.instruction.next(); operation != null; operation = this.instruction.next()) {
            world.tick();
            this.cacheMapTicksParameters.putIfAbsent(this.instruction.getTickCurrent(), player.getBundleMovement());
        }
        return player.getBundleMovement();
    }

    public synchronized BundleMovement getStateAfter(final int ticks) {
        World world = new World();
        int ticksPossible = 0;
        Iterator<Integer> iterator = this.cacheMapTicksParameters.keySet().iterator();
        for (int i = 0; i <= ticks && iterator.hasNext(); i = iterator.next()) {
            ticksPossible = i;
        }
        BundleMovement movementCurrent = ticksPossible == 0 ? this.movementInitial : this.cacheMapTicksParameters.get(ticksPossible);
        this.instruction.jumpToTick(ticksPossible);
        EntityPlayer player = new EntityPlayer(world, movementCurrent, this.instruction.getRotationCurrent());
        world.spawnEntity(player);
        BundleOperation operation = this.instruction.next();
        for (int i = ticksPossible; i < ticks && operation != null; ++i) {
            world.tick();
            this.cacheMapTicksParameters.putIfAbsent(this.instruction.getTickCurrent(), player.getBundleMovement());
            operation = this.instruction.next();
        }
        return player.getBundleMovement();
    }

}

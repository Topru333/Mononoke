package com.topru.mononoke.util;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.*;

public class VoxelShapeHelper {

    public static VoxelShape combineAll(Collection<VoxelShape> shapes) {
        VoxelShape result = VoxelShapes.empty();
        for (VoxelShape shape : shapes) {
            result = VoxelShapes.combineAndSimplify(result, shape, IBooleanFunction.OR);
        }
        return result.simplify();
    }

    public static VoxelShape combineAll(VoxelShape... shapes) {
        VoxelShape result = VoxelShapes.empty();
        for (VoxelShape shape : shapes) {
            result = VoxelShapes.combineAndSimplify(result, shape, IBooleanFunction.OR);
        }
        return result.simplify();
    }

    public static Map<Direction, VoxelShape> getRotatedShapes(VoxelShape shape) {
        Map<Direction, VoxelShape> map = new HashMap<>();
        map.put(Direction.NORTH, shape);
        map.put(Direction.EAST, rotateShape(shape, RotationAmount.NINETY));
        map.put(Direction.SOUTH, rotateShape(shape, RotationAmount.HUNDRED_EIGHTY));
        map.put(Direction.WEST, rotateShape(shape, RotationAmount.TWO_HUNDRED_SEVENTY));
        return map;
    }

    public static VoxelShape rotateShape(VoxelShape shape, RotationAmount rotationAmount) {
        if (shape.isEmpty()) {
            return shape;
        }
        Set<VoxelShape> rotatedShapes = new HashSet<>();

        shape.forEachBox((x1, y1, z1, x2, y2, z2) -> {
            x1 = (x1 * 16) - 8; x2 = (x2 * 16) - 8;
            z1 = (z1 * 16) - 8; z2 = (z2 * 16) - 8;

            if (rotationAmount == RotationAmount.NINETY) {
                rotatedShapes.add(Block.makeCuboidShape(8 - z1, y1 * 16, 8 + x1, 8 - z2, y2 * 16, 8 + x2));
            } else if (rotationAmount == RotationAmount.HUNDRED_EIGHTY) {
                rotatedShapes.add(Block.makeCuboidShape(8 - x1, y1 * 16, 8 - z1, 8 - x2, y2 * 16, 8 - z2));
            } else if (rotationAmount == RotationAmount.TWO_HUNDRED_SEVENTY) {
                rotatedShapes.add(Block.makeCuboidShape(8 + z1, y1 * 16, 8 - x1, 8 + z2, y2 * 16, 8 - x2));
            }
        });
        return rotatedShapes.stream().reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    }

    public enum RotationAmount {
        NINETY,
        HUNDRED_EIGHTY,
        TWO_HUNDRED_SEVENTY
    }

}

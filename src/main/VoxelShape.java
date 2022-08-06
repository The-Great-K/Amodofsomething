Stream.of(
Block.box(6, 4, -2, 10, 5, 2),
Block.box(6, 5, -1, 7, 7, 2),
Block.box(9, 5, -1, 10, 7, 2),
Block.box(10, 10, 10, 12, 16, 12),
Block.box(4, 10, 10, 6, 16, 12),
Block.box(10, 10, 4, 12, 16, 6),
Block.box(4, 10, 4, 6, 16, 6),
Block.box(1, 2, 1, 15, 11, 15),
Block.box(2, 2, 2, 14, 10, 14),
Block.box(0, 0, 0, 16, 2, 16)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
package net.lilkahuna.farmersmilkshake.block;

import java.util.function.Supplier;

import net.lilkahuna.farmersmilkshake.FarmersMilkshake;
import net.lilkahuna.farmersmilkshake.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmersMilkshake.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    /**
     * Registered block with some properties
     */
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = 
        registerBlock("sapphire_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));

    // register the block and block item
    @SuppressWarnings("unused")
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Register the block item, not just the placeble block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
        
    
}

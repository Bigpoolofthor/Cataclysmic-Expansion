package nintenno.cataclysmic.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import nintenno.cataclysmic.CataclysmicExpansion;

import java.util.function.Function;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", Item::new);
    //Registers the items into the game

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(CataclysmicExpansion.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CataclysmicExpansion.MOD_ID, name)))));
    }
    public static void registerModItems() {
        //Debug message when game is loading
        CataclysmicExpansion.LOGGER.info("Registering Mod Items for " + CataclysmicExpansion.MOD_ID);
        //Item Group manager
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries ->
            fabricItemGroupEntries.add(RUBY)

        );
    }

}

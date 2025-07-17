package nintenno.cataclysmic.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import nintenno.cataclysmic.CataclysmicExpansion;

public class ModItems {

    public static final Item BRONZEINGOT = registerItem(new Item.Settings(),"bronzeingot");

    private static void addItemstoIngreadientGroup(FabricItemGroupEntries entries) {

        entries.add(BRONZEINGOT);
    }

    private static Item registerItem(Item.Settings itemSettings, String name) {
        Identifier id = Identifier.of(CataclysmicExpansion.MOD_ID);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM,id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));

    }

    public static void registerModItems() {
        CataclysmicExpansion.LOGGER.info("Registering Mod Items for " + CataclysmicExpansion.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoIngreadientGroup);
    }
}

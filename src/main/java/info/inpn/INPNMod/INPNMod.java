/* default
package info.inpn.INPNMod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = INPNMod.MODID, version = INPNMod.VERSION)
public class INPNMod
{
    public static final String MODID = "INPNmod";
    public static final String VERSION = "0.0.0.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
*/
package info.inpn.INPNMod;

//多分ブロック関連

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;


@Mod(modid = INPNMod.MODID,name = INPNMod.MOD_NAME, version = INPNMod.VERSION)
public class INPNMod
{
    public static final String MODID = "INPNmod";
    public static final String MOD_NAME = "大日本ペイント帝国海軍MOD";
    public static final String VERSION = "β";

    @ObjectHolder(MODID)
    public static class BLOCKS{
        public static final Block core = null;
    }

    @ObjectHolder(MODID)
    public static class ITEMS{
        public static final Item core = null;
    }

    /**
     * アイテム登録用イベント
     */
    @SubscribeEvent
    protected static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(
                new ItemBlock(BLOCKS.core).setRegistryName(MODID, "コ↑ア下")
        );
    }

    /**
     * ブロック登録用イベント
     */
    @SubscribeEvent
    protected static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(
                new Block(Material.ROCK)
                        .setRegistryName(MODID, "ココア･コアcore")/*登録名の設定*/
                        .setCreativeTab(CreativeTabs.BUILDING_BLOCKS)/*クリエイティブタブの選択*/
                        .setUnlocalizedName("core")/*システム名の設定*/
                        .setHardness(1.5F)/*硬さ*/
                        .setResistance(1.0F)/*爆破耐性*/
        );
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        if (event.getSide().isClient())
            ModelLoader.setCustomModelResourceLocation(ITEMS.core, 0, new ModelResourceLocation(ITEMS.core.getRegistryName(), "inventory"));
    }
}
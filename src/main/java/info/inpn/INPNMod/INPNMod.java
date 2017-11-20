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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Metadata;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = INPNMod.MODID, version = INPNMod.VERSION,name = INPNMod.MODNAME, useMetadata = true)
public class INPNMod
{

	public static final String MODID = "inpnmod";
	public static final String VERSION = "β";
	public static final String MODVERSION = "0.0.0";
	public static final String MODNAME = "大日本ペイント帝国海軍MOD";
	@Metadata(MODID)
	public static ModMetadata meta;

	public static Item unko = null;
	public static Block unko_block = null;
	public static Item unko_block_item = null;
	public static Item cookie = null;
	public static Item inm_sword = null;
	public static CreativeTabs ctab = new CreativeTab("INPN");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
		//Infoファイルを読み込む
		Modinfo.loadInfo(meta);

		//システム関連

		//基本アイテム
		unko = new Item()
				.setCreativeTab(ctab)
				.setUnlocalizedName("unko")
				.setRegistryName(MODID,"unko")
				.setMaxStackSize(64);
		unko_block = new Block(Material.CLAY)
				.setCreativeTab(ctab)
                .setUnlocalizedName("unko_block")
                .setRegistryName(MODID, "unko_block")
                .setHardness(0.5F)
                .setResistance(0.1F);
		unko_block_item = new ItemBlock(unko_block)
				.setCreativeTab(ctab)
				.setUnlocalizedName("unko_block")
				.setRegistryName(MODID,"unko_block")
				.setMaxStackSize(64);
		cookie = new Item()
				.setCreativeTab(ctab)
				.setUnlocalizedName("cookie☆")
				.setRegistryName(MODID,"cookie☆")
				.setMaxStackSize(64);
		//淫夢之一太刀
		inm_sword = new Sword(EnumHelper.addToolMaterial("inm_sword",1,931810893,5,114510,1))
				.setCreativeTab(ctab)
				.setUnlocalizedName("inm_sword")
				.setRegistryName(MODID,"inm_sword");

		ForgeRegistries.ITEMS.register(unko);
		ForgeRegistries.BLOCKS.register(unko_block);
		ForgeRegistries.ITEMS.register(unko_block_item);
		ForgeRegistries.ITEMS.register(cookie);
		ForgeRegistries.ITEMS.register(inm_sword);
		GameRegistry.addSmelting(Items.COOKIE,new ItemStack(INPNMod.cookie),0.7f);

		if(event.getSide().isClient()) {
			ModelLoader.setCustomModelResourceLocation(unko,0,new ModelResourceLocation("inpnmod:unko"));
            ModelLoader.setCustomModelResourceLocation(unko_block_item, 0, new ModelResourceLocation("inpnmod:unko_block"));
			ModelLoader.setCustomModelResourceLocation(cookie,0,new ModelResourceLocation("inpnmod:cookie"));
			ModelLoader.setCustomModelResourceLocation(inm_sword,0,new ModelResourceLocation("inpnmod:inm_sword"));
		}
    }
}
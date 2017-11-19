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

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Metadata;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = INPNMod.MODID, version = INPNMod.VERSION,name = INPNMod.MODNAME, useMetadata = true)
public class INPNMod
{

	public static final String MODID = "inpnmod";
	public static final String VERSION = "β";
	public static final String MODNAME = "大日本ペイント帝国海軍MOD";
	@Metadata(MODID)
	public static ModMetadata meta;
	@EventHandler
    public void preInit(FMLPreInitializationEvent event){
		//Infoファイルを読み込む
		Modinfo.loadInfo(meta);
    }
}
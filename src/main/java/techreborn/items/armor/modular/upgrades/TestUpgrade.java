package techreborn.items.armor.modular.upgrades;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import techreborn.api.armor.ModularArmorUtils;
import techreborn.api.armor.UpgradeHolder;
import techreborn.items.armor.modular.BaseArmorUprgade;
import techreborn.lib.ModInfo;

import java.util.UUID;

@Deprecated
public class TestUpgrade extends BaseArmorUprgade {

	protected static final UUID SPEED_MODIFIER = UUID.randomUUID();

	public TestUpgrade() {
		super(new ResourceLocation(ModInfo.MOD_ID, "test"));
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void tick(UpgradeHolder holder, EntityPlayer player) {
		//System.out.println("Hello " + player.getDisplayNameString());
	}

	@Override
	public boolean hurt(UpgradeHolder holder, LivingHurtEvent event) {
		//Note fall dame is not blocked by armor so it needs to be handled sepratly
		if(!event.getSource().isUnblockable()){
			event.setAmount(event.getAmount() / 8); //Reduces standard damage by 8
		} else if (event.getSource() == DamageSource.FALL){
			event.setCanceled(true); // Fall damage protection
		}
		return false;
	}

	@Override
	public double getSpeed(UpgradeHolder holder) {
		return 2F;
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(UpgradeHolder holder) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();

		multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(SPEED_MODIFIER, "Speed modifier", 0.1F, 0));

		return multimap;
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void removeFOV(FOVUpdateEvent event){
		//TODO improve this, remove the attributes get the fov and put them back might work better
		long count = ModularArmorUtils.getHoldersOnPlayer(event.getEntity()).stream().filter(holder -> holder.getUpgrade() instanceof TestUpgrade).count();
		if(count == 0){
			return;
		}
		float speed = 0.1F * count;
		float fov = (speed / event.getEntity().capabilities.getWalkSpeed() + 1) / 2;
		event.setNewfov(event.getFov() / fov);
	}
}

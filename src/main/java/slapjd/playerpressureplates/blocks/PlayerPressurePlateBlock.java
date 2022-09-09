package slapjd.playerpressureplates.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;

//much of this is yoinked from minecraft
public class PlayerPressurePlateBlock extends PressurePlateBlock {

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param settings
     */
    public PlayerPressurePlateBlock(Settings settings) {
        //In theory activationrule should never be used but
        //just in case i'm gonna set it to MOBS as it's the closest
        super(ActivationRule.MOBS, settings);
    }

    //Ignore activationrule and just look for players
    @Override
    protected int getRedstoneOutput(World world, BlockPos pos) {
        List<PlayerEntity> list;
        Box box = BOX.offset(pos);
        list = world.getNonSpectatingEntities(PlayerEntity.class, box);
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (entity.canAvoidTraps()) continue;
                return 15;
            }
        }
        return 0;
    }
}

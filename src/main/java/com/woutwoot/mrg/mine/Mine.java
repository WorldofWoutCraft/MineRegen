package com.woutwoot.mrg.mine;

import com.woutwoot.mrg.generators.MineGenerator;
import org.bukkit.Location;
import org.bukkit.block.Block;

/**
 * @author woutwoot
 *         Created by on 18/01/2015 - 10:01.
 */
public interface Mine {

    public String getName();
    public void setName(String name);
    public void regen();
    public boolean isBlock(Location l);

    public void setGen(MineGenerator gen);
    public MineGenerator getGen();
    public void scheduleNewResetTask(Block b);

}

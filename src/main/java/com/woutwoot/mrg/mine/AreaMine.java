package com.woutwoot.mrg.mine;

import com.woutwoot.mrg.Main;
import com.woutwoot.mrg.Vars;
import com.woutwoot.mrg.generators.GeneratorDefault;
import com.woutwoot.mrg.generators.MineGenerator;
import com.woutwoot.mrg.tasks.ResetTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * @author woutwoot
 *         Created by on 18/01/2015 - 10:14.
 */
public class AreaMine implements Mine {

    private String name;
    private Location c1;
    private Location c2;
    private MineGenerator gen = new GeneratorDefault();

    public AreaMine(String name, Location c1, Location c2){
        this.setName(name);
        this.c1 = c1;
        this.c2 = c2;
        this.setGen(new GeneratorDefault());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void regen() {
        for(Block b : getBlocksInMine()){
            b.setType(gen.getRandomisedMaterial());
        }
    }

    @Override
    public boolean isBlock(Location l) {
        return isInside(l);
    }

    @Override
    public void setGen(MineGenerator gen) {
        this.gen = gen;
    }

    @Override
    public MineGenerator getGen() {
        return gen;
    }

    @Override
    public void scheduleNewResetTask(Block b) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new ResetTask(b, this), Vars.delay);
    }

    private Boolean isInside(Location loc) {
        double xMin;
        double xMax;
        double yMin;
        double yMax;
        double zMin;
        double zMax;
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        xMin = Math.min(c1.getX(), c2.getX());
        xMax = Math.max(c1.getX(), c2.getX());
        yMin = Math.min(c1.getY(), c2.getY());
        yMax = Math.max(c1.getY(), c2.getY());
        zMin = Math.min(c1.getZ(), c2.getZ());
        zMax = Math.max(c1.getZ(), c2.getZ());
        return (x >= xMin && x <= xMax && y >= yMin && y <= yMax && z >= zMin && z <= zMax);
    }

    private List<Block> getBlocksInMine(){
        List<Block> blocks = new ArrayList<>();
        int xMin = Math.min(c1.getBlockX(), c2.getBlockX());
        int xMax = Math.max(c1.getBlockX(), c2.getBlockX());
        int yMin = Math.min(c1.getBlockY(), c2.getBlockY());
        int yMax = Math.max(c1.getBlockY(), c2.getBlockY());
        int zMin = Math.min(c1.getBlockZ(), c2.getBlockZ());
        int zMax = Math.max(c1.getBlockZ(), c2.getBlockZ());
        for(int i = xMin; xMin <= xMax; i++){
            for(int j = yMin; yMin <= yMax; j++){
                for(int k = zMin; zMin <= zMax; k++){
                    blocks.add(c1.getWorld().getBlockAt(i, j, k));
                }
            }
        }
        return blocks;
    }

}

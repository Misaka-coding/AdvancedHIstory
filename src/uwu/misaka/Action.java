package uwu.misaka;

import mindustry.game.EventType;
import mindustry.gen.Player;
import mindustry.world.Block;
import mindustry.world.Tile;

import java.util.Date;

public class Action {
    public String type;
    public Block block;
    public String playerUUID;
    public String playerName;
    public Date date;
    public int tileX;
    public int tileY;
    public String config;

    public Action(String type, Block b, Player p, String config,int x, int y){
        this.type=type;
        this.block=b;
        this.playerName=p.name();
        this.playerUUID=p.uuid();
        this.config=config;
        this.date=new Date();
        this.tileX=x;
        this.tileY=y;
    }

    public Action build(EventType.BlockBuildEndEvent e){
        return new Action("b",e.tile.block(),e.unit.getPlayer(),config,e.tile.x,e.tile.y);
    }
    public Action destroy(EventType.BlockBuildEndEvent e){
        return new Action("d",e.tile.block(),e.unit.getPlayer(),config,e.tile.x,e.tile.y);
    }
    public Action Config(EventType.ConfigEvent e){
        return new Action("b",e.tile.block(),e.player,config,e.tile.tileX(),e.tile.tileY());
    }
}

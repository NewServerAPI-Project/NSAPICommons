package net.cg360.nsapi.commons.event.filter;

import net.cg360.nsapi.commons.event.BaseEvent;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class FilterDynamicPlayerWhitelist implements EventFilter {

    protected Supplier<Player[]> supplier;
    protected boolean onlyPlayerEvents; // Ignore entity events in the check


    public FilterDynamicPlayerWhitelist(Supplier<Player[]> supplier) { this(supplier, false); }
    public FilterDynamicPlayerWhitelist(Supplier<Player[]> supplier, boolean onlyPlayerEvents) {
        this.supplier = supplier;
        this.onlyPlayerEvents = onlyPlayerEvents;
    }



    @Override
    public boolean checkEvent(BaseEvent eventIn) {
        return new FilterStaticPlayerWhitelist(supplier.get()).checkEvent(eventIn);
    }
}

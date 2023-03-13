/**
 * Albin, Khaled, Gabriel
 * */

package lab6.event;

import lab6.state.*;
import lab6.tools.Pair;

public class Plockhändelse extends Event {
    private double tid;
    private Kunder kund;

    public Plockhändelse(double tid, Kunder kund) {
        super("Plock", tid, kund);
        this.tid = tid;
        this.kund = kund;
    }

    @Override
    public void effect() {
        state.notify(this);
        if (state.FreeKassor() > 0) {
            state.DecreaseFreeKassor();
            double nextPay = this.state.GetNextPay(this.tid);
            Betalningshändelse betalningshändelse = new Betalningshändelse(nextPay, this.kund);
            eventQueue.addEvent(betalningshändelse);
        } else {
            state.GetQueue().add(this.kund);
            state.IncreaseNumberOfQueuedCustomers();
        }
    }
}

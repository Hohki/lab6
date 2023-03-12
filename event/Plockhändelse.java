package lab6.event;

import lab6.state.*;
import lab6.tools.Pair;

public class Plockhändelse extends Event {
    private Pair pair;

    public Plockhändelse(String str, Pair pair) {
        super("Plock", pair);
        this.pair = pair;
    }

    @Override
    public void effect() {
        if (state.FreeKassor() > 0) {
            state.DecreaseFreeKassor();
            double nextPay = this.state.GetNextPay(this.pair.tid());
            Pair newPay = new Pair(this.pair.kund(), nextPay);
            Betalningshändelse betalningshändelse = new Betalningshändelse("Betal", newPay);
            eventQueue.addEvent(betalningshändelse);
        } else {
            state.GetQueue().add(pair.kund());
            state.IncreaseNumberOfQueuedCustomers();
        }
    }
}

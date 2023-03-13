package lab6.state;

import lab6.event.*;


public class StoreState extends State {
    private Kassakö Kassakö;
    private CustomerFactory createCustomer;

    final int numberOfKassor;
    final int maxCustomer;
    final double closeTime;
    final double lambda;
    final double pickMin;
    final double pickMax;
    final double payMin;
    final double payMax;
    final long seed;

    private int customer;
    private int payedCustomers;
    private int missedCustomers;
    private int queuedCustomers;
    private int freeKassor;
    private double freeKassorTime;
    private double queueTime;
    private double lastPay;
    private ExponentialRandomStream nextArrival;
    private UniformRandomStream nextPlock;
    private UniformRandomStream nextPay;
    private Kunder currentEvent;
    private boolean store;
    private boolean allowView = true;

    public StoreState(int numberOfKassor, int maxCustomer, double closeTime,
                      double lambda, double pickMin, double pickMax, double payMin, double payMax, long seed, boolean allowView) {
        this.Kassakö = new Kassakö();
        this.createCustomer = new CustomerFactory();
        this.nextArrival = new ExponentialRandomStream(lambda, seed);
        this.nextPlock = new UniformRandomStream(pickMin, pickMax, seed);
        this.nextPay = new UniformRandomStream(payMin, payMax, seed);

        this.numberOfKassor = numberOfKassor;
        this.maxCustomer = maxCustomer;
        this.closeTime = closeTime;
        this.lambda = lambda;
        this.pickMin = pickMin;
        this.pickMax = pickMax;
        this.payMin = payMin;
        this.payMax = payMax;
        this.seed = seed;

        this.lastPay = 0.0d;
        this.customer = 0;
        this.payedCustomers = 0;
        this.missedCustomers = 0;
        this.freeKassor = numberOfKassor;
        this.queueTime = 0;
        this.allowView = allowView;

    }

    public double GetCloseTime() {
        return this.closeTime;
    }
    public double GetLambda() {
        return this.lambda;
    }

    public double GetPlockMax() {
        return this.pickMax;
    }

    public double GetPlockMin() {
        return this.pickMin;
    }

    public double GetPayMax() {
        return this.payMax;
    }

    public double GetPayMin() {
        return this.payMin;
    }

    public int GetNumberOfCustomers() {
        return this.customer;
    }

    public void IncreaseNumberOfCustomer() {
        this.customer = this.customer + 1;
    }

    public int NumberOfPayedCustomers() {
        return this.payedCustomers;
    }

    public void IncreaseNumberOfPayedCustomers() {
        this.payedCustomers = this.payedCustomers + 1;
    }

    public int NumberOfQueuedCustomers() {
        return this.queuedCustomers;
    }

    public void IncreaseNumberOfQueuedCustomers() {
        this.queuedCustomers = this.queuedCustomers + 1;
    }

    public Kassakö CurrentlyQueued() {
        return this.Kassakö;
    }

    public int GetNumberOfKassor() {
        return this.numberOfKassor;
    }

    public int GetMaxCustomer() {
        return this.maxCustomer;
    }

    public long GetSeed() {
        return this.seed;
    }

    public boolean GetStore() {
        return this.store;
    }

    public void SetStoreState(boolean state) {
        this.store = state;
    }

    public Kassakö GetQueue() {
        return this.Kassakö;
    }

    public double GetNextArrival(double time) {
        return this.nextArrival.next() + time;
    }

    public double GetNextPlock(double time) {
        return this.nextPlock.next() + time;
    }

    public double GetNextPay(double time) {
        return this.nextPay.next() + time;
    }

    public int NumberOfCustomers() {
        return this.customer;
    }

    public void IncreaseCustomers() {
        this.customer = this.customer + 1;
    }

    public void DecreaseCustomers() throws Exception {
        if (this.customer == 0) {
            throw new RuntimeException("Number of customers is already 0");
        }
        this.customer = this.customer - 1;
    }

    public int MissedCustomers() {
        return this.missedCustomers;
    }

    public void IncreaseMissedCustomers() {
        this.missedCustomers = this.missedCustomers + 1;
    }

    public double GetFreeKassorTime() {
        return this.freeKassorTime;
    }

    public void IncreaseFreeKassorTime(double time) {
        this.freeKassorTime = this.freeKassorTime + time;
    }

    public double GetQueueTime() {
        return this.queueTime;
    }

    public void IncreaseQueueTime(double queueTime) {
        this.queueTime = this.queueTime + queueTime;
    }

    public int FreeKassor() {
        return this.freeKassor;
    }

    public void IncreaseFreeKassor() {
        this.freeKassor = this.freeKassor + 1;
    }

    public void DecreaseFreeKassor() {
        this.freeKassor = this.freeKassor - 1;
    }

    public Kunder CurrentEvent() {
        return currentEvent;
    }

    public void SetCurrentEvent(Kunder currentEvent) {
        this.currentEvent = currentEvent;
    }

    public double getLastPay() {
        return this.lastPay;
    }

    public boolean getALlowView() {
        return this.allowView;
    }




    @Override
    public void notify(Event event) {
        if (event instanceof Betalningshändelse) {
            this.lastPay = event.tid();
        }

        if (!(event instanceof Ankomsthändelse && this.store) && !(event instanceof Stopphändelse)) {
            double time = event.tid() - this.CurrentTime();

            double queueTime = this.GetQueue().size() * time;
            double freeKassaTid = this.FreeKassor() * time;

            this.IncreaseQueueTime(queueTime);
            this.IncreaseFreeKassorTime(freeKassaTid);
        }
        super.notify(event);
    }
}

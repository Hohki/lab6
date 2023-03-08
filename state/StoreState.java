package lab6.state;

public class StoreState extends State {
	private Kassakö Kassakö;
	private CreateCustomer CreateCustomer;
	
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
	private ExponentialRandomStream nextArrival;
	private UniformRandomStream nextPlock;
	private UniformRandomStream nextPay;
	private Kunder currentEvent;
	private boolean store;
	
	public StoreState(int numberOfKassor, int maxCustomer, double closeTime,
					  double lambda, double pickMin, double pickMax, double payMin, double payMax, long seed) {
		this.Kassakö = new Kassakö();
		this.CreateCustomer = new CreateCustomer();
		this.nextArrival = new ExponentialRandomStream(seed);
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
		
		this.customer = 0;
		this.payedCustomers = 0;
		this.missedCustomers = 0;
		this.freeKassor = numberOfKassor;
		this.queueTime = 0;
		this.store = false;
		
	}
	
	public int GetNumberOfCustomers() {
		return this.customer;
	}
	
	public void IncreaseNumberOfCustomer() {
		this.customer = this.customer + 1;
	}
	
	public void DecreaseNumberOfCustomers() {
		this.customer = this.customer - 1;
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
	
	public double GetNextArrival() {
		return this.nextArrival.next();
	}
	
	public double GetNextPlock() {
		return this.nextPlock.next();
	}
	
	public double GetNextPay() {
		return this.nextPay.next();
	}
	
	public int NumberOfCustomers() {
		return this.customer;
	}
	
	public void IncreaseCustomers() {
		this.customer = this.customer + 1;
	}
	
	public void DecreaseCustomers () throws Exception {
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
	
	public void AddToQueueTime(double queueTime) {
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
}

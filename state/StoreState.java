package lab6.state;

import java.util.ArrayList;

public class StoreState extends State {
	ArrayList<Kunder> customers = new ArrayList<Kunder>();
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
	private int payingCustomers;
	private int missedCustomers;
	private int freeKassor;
	private double missedCashierTime;
	private double queueTime;
	private ExponentialRandomStream nextArrival;
	private UniformRandomStream nextPlock;
	private UniformRandomStream nextPay;
	private Kunder currentEvent;
	
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
		this.payingCustomers = 0;
		this.missedCustomers = 0;
		this.freeKassor = numberOfKassor;
		this.missedCashierTime = 0.0d;
		this.queueTime = 0;
		
	}
	public void MakeCustomer() {
		this.CreateCustomer.CreateCustomers();
	}
	
	public String GetQueue() {
		return this.Kassakö.toString();
	}
	
	public void AddToQueue(Kunder kund) {
		((Kassakö) this.Kassakö).add(kund);
	}
	
	public void RemoveFromQueue() {
		((lab6.state.Kassakö) this.Kassakö).removeFirst();
	}
	
	public int GetLength() {
		return ((Kassakö) this.Kassakö).size();
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
	
	public double MissedCashierTime() {
		return this.missedCashierTime;
	}
	
	private void AddMissedCashierTime(double missedCashierTime) {
		this.missedCashierTime = this.missedCashierTime + missedCashierTime;
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

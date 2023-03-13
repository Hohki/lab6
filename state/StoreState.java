/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import lab6.event.*;

public class StoreState extends State {
	private KassaQueue KassaQueue;
	private CustomerFactory createCustomer;

	final int numberOfKassor;
	final int maxCustomer;
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
	private double lastEvent;
	private ExponentialRandomStream nextArrival;
	private UniformRandomStream nextPlock;
	private UniformRandomStream nextPay;
	private Event currentEvent;
	private boolean store;
	private boolean allowView = true;
	final double closeTime;

	/**
	 * Konstruktor för StoreState.
	 * 
	 * @param lambda lambda
	 * @param pickMin pickMin
	 * @param pickMax pickMax
	 * @param payMin payMin
	 * @param payMax payMax
	 * @param seed seed
	 * @param allowView allowView
	 * @param closeTime closeTime
	 **/
	public StoreState(int numberOfKassor, int maxCustomer, double lambda, double pickMin, double pickMax, double payMin,
			double payMax, long seed, boolean allowView, double closeTime) {
		this.KassaQueue = new KassaQueue();
		this.createCustomer = new CustomerFactory();
		this.nextArrival = new ExponentialRandomStream(lambda, seed);
		this.nextPlock = new UniformRandomStream(pickMin, pickMax, seed);
		this.nextPay = new UniformRandomStream(payMin, payMax, seed);

		this.numberOfKassor = numberOfKassor;
		this.maxCustomer = maxCustomer;
		this.lambda = lambda;
		this.pickMin = pickMin;
		this.pickMax = pickMax;
		this.payMin = payMin;
		this.payMax = payMax;
		this.seed = seed;
		this.lastEvent = 0;

		this.lastPay = 0.0d;
		this.customer = 0;
		this.payedCustomers = 0;
		this.missedCustomers = 0;
		this.freeKassor = numberOfKassor;
		this.queueTime = 0;
		this.allowView = allowView;
		this.closeTime = closeTime;
	}

	/**
	 * Getter för lambda.
	 * @return lambda
	 */
	public double GetLambda() {
		return this.lambda;
	}

	/**
	 * Getter för PlockMax.
	 * @return pickMax
	 */

	public double GetPlockMax() {
		return this.pickMax;
	}

	/**
	 * Getter för PlockMin.
	 * @return pickMin
	 */

	public double GetPlockMin() {
		return this.pickMin;
	}

	/**
	 * Getter för PayMax.
	 * @return payMax
	 */

	public double GetPayMax() {
		return this.payMax;
	}

	/**
	 * Getter för PayMin.
	 * @return payMin
	 */

	public double GetPayMin() {
		return this.payMin;
	}

	/**
	 * Getter för antal kunder.
	 * @return customer
	 **/

	public int GetNumberOfCustomers() {
		return this.customer;
	}

	/**
	 * Lägger till en till antal kunder.
	 */

	public void IncreaseNumberOfCustomer() {
		this.customer = this.customer + 1;
	}

	/**
	 * Getter för antal betalda kunder.
	 * @return payedCustomers
	 */

	public int NumberOfPayedCustomers() {
		return this.payedCustomers;
	}

	/**
	 * Lägger till en till betalade kunder.
	 */

	public void IncreaseNumberOfPayedCustomers() {
		this.payedCustomers = this.payedCustomers + 1;
	}

	/**
	 * Getter för antal kunder i kön.
	 * @return queuedCustomers
	 */

	public int NumberOfQueuedCustomers() {
		return this.queuedCustomers;
	}

	/**
	 * Lägger till en kund i antal i kö.
	 */

	public void IncreaseNumberOfQueuedCustomers() {
		this.queuedCustomers = this.queuedCustomers + 1;
	}

	/**
	 * Getter för Kassakö
	 * @return kassaQueue
	 */

	public KassaQueue CurrentlyQueued() {
		return this.KassaQueue;
	}

	/**
	 * Getter för antal kassor.
	 * @return numberOfKassor
	 */

	public int GetNumberOfKassor() {
		return this.numberOfKassor;
	}

	/**
	 * Getter för max antal kunder.
	 * @return maxCustomer
	 */

	public int GetMaxCustomer() {
		return this.maxCustomer;
	}

	/**
	 * Getter för seed.
	 * @return seed
	 */

	public long GetSeed() {
		return this.seed;
	}

	/**
	 * Getter för om butiken är öppen eller inte.
	 * @return store
	 */

	public boolean GetStore() {
		return this.store;
	}

	/**
	 * Setter för store.
	 */

	public void SetStoreState(boolean state) {
		this.store = state;
	}

	/**
	 * Getter för kön.
	 * @return kassakö
	 */

	public KassaQueue GetQueue() {
		return this.KassaQueue;
	}

	/**
	 * Getter för nästa ankomst.
	 * @param time
	 * @return nextArrival.next() + time
	 */

	public double GetNextArrival(double time) {
		return this.nextArrival.next() + time;
	}

	/**
	 * Getter för nästa plock.
	 * 
	 * @param time
	 * @return nextPlock.next() + time
	 */

	public double GetNextPlock(double time) {
		return this.nextPlock.next() + time;
	}

	/**
	 * Getter för nästa betalning.
	 * 
	 * @param time
	 * @return nextPay.next() + time
	 */

	public double GetNextPay(double time) {
		return this.nextPay.next() + time;
	}

	/**
	 * Lägger till till customer.
	 */

	public void IncreaseCustomers() {
		this.customer = this.customer + 1;
	}

	/**
	 * Tar bort från customer.
	 */

	public void DecreaseCustomers() {
		this.customer = this.customer - 1;
	}

	/**
	 * Getter för missade kunder.
	 * @return missedCustomers
	 */

	public int MissedCustomers() {
		return this.missedCustomers;
	}

	/**
	 * Lägger till kund till missade kunder.
	 */

	public void IncreaseMissedCustomers() {
		this.missedCustomers = this.missedCustomers + 1;
	}

	/**
	 * Getter för tid Kassor varit lediga.
	 * @return freeKassorTime
	 **/

	public double GetFreeKassorTime() {
		return this.freeKassorTime;
	}

	/**
	 * Ökar tiden kassor varit lediga.
	 **/

	public void IncreaseFreeKassorTime(double time) {
		this.freeKassorTime = this.freeKassorTime + time;
	}

	/**
	 * Getter för kötiden.
	 * @return queueTime
	 **/

	public double GetQueueTime() {
		return this.queueTime;
	}

	/**
	 * Ökar på kötiden.
	 **/

	public void IncreaseQueueTime(double queueTime) {
		this.queueTime = this.queueTime + queueTime;
	}

	/**
	 * Getter för antal lediga kassor.
	 * @return freeKassor
	 **/

	public int FreeKassor() {
		return this.freeKassor;
	}

	/**
	 * Ökar antal lediga kassor.
	 **/

	public void IncreaseFreeKassor() {
		this.freeKassor = this.freeKassor + 1;
	}

	/**
	 * Minskar antal lediga kassor.
	 **/

	public void DecreaseFreeKassor() {
		this.freeKassor = this.freeKassor - 1;
	}

	/**
	 * Returnerar nuvarande event.
	 * @return currentEvent
	 **/

	public Event CurrentEvent() {
		return currentEvent;
	}

	/**
	 * Sätter nuvarande event till event.
	 * @param currentEvent
	 **/

	public void SetCurrentEvent(Event currentEvent) {
		this.currentEvent = currentEvent;
	}

	/**
	 * Getter för sista betalning.

	 * @return lastPay
	 **/

	public double getLastPay() {
		return this.lastPay;
	}

	/**
	 * Getter för om StoreView får skrivas ut.
	 * @return allowView
	 **/

	public boolean getALlowView() {
		return this.allowView;
	}

	/**
	 * Getter för sista eventet.
	 * @return lastEvent
	 **/

	public double lastEvent() {
		return this.lastEvent;
	}

	/**
	 * Sätter vad sista eventet är.
	 * @param time
	 **/

	public void setLastEvent(double time) {
		lastEvent = time;
	}

	/**
	 * Getter för när butiken stänger.
	 * @return closeTime
	 **/

	public double GetCloseTime() {
		return this.closeTime;
	}

	/**
	 * Notifierar Observers. Räknar ut sista betalningen. Räknar ut kötid samt ledig
	 * tid i kassa.
	 * @param event
	 **/

	@Override
	public void notify(Event event) {
		if (event instanceof BetalningsEvent) {
			this.lastPay = event.tid();
		}
		if (!(event instanceof StoppEvent)) {
			double time = event.tid() - lastEvent();

			double queueTime = this.GetQueue().size() * time;
			double freeKassaTid = this.FreeKassor() * time;

			this.IncreaseQueueTime(queueTime);
			this.IncreaseFreeKassorTime(freeKassaTid);
			setLastEvent(event.tid());
		}

		setChanged();
		notifyObservers(event);

	}
}

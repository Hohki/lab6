/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import lab6.event.*;
/**
 * 
 * Class for StoreState.
 *
 */
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
	 * constructor for StoreState.
	 * @param numberOfKassor numberOfKassor
	 * @param maxCustomer maxCustomer
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
	 * Getter for lambda.
	 * @return lambda
	 */
	public double GetLambda() {
		return this.lambda;
	}

	/**
	 * Getter for PlockMax.
	 * @return pickMax
	 */

	public double GetPlockMax() {
		return this.pickMax;
	}

	/**
	 * Getter for PlockMin.
	 * @return pickMin
	 */

	public double GetPlockMin() {
		return this.pickMin;
	}

	/**
	 * Getter for PayMax.
	 * @return payMax
	 */

	public double GetPayMax() {
		return this.payMax;
	}

	/**
	 * Getter for PayMin.
	 * @return payMin
	 */

	public double GetPayMin() {
		return this.payMin;
	}

	/**
	 * Getter for number of customers.
	 * @return customer
	 **/

	public int GetNumberOfCustomers() {
		return this.customer;
	}

	/**
	 * Adds 1 to number of customers.
	 */

	public void IncreaseNumberOfCustomer() {
		this.customer = this.customer + 1;
	}

	/**
	 * Getter for number of payed customers.
	 * @return payedCustomers
	 */

	public int NumberOfPayedCustomers() {
		return this.payedCustomers;
	}

	/**
	 * Adds 1 to number of payed customers.
	 */

	public void IncreaseNumberOfPayedCustomers() {
		this.payedCustomers = this.payedCustomers + 1;
	}

	/**
	 * Getter for number of customers in the Queue.
	 * @return queuedCustomers
	 */

	public int NumberOfQueuedCustomers() {
		return this.queuedCustomers;
	}

	/**
	 * Adds 1 to number of customers in queue.
	 */

	public void IncreaseNumberOfQueuedCustomers() {
		this.queuedCustomers = this.queuedCustomers + 1;
	}

	/**
	 * Getter for KassaQueue.
	 * @return kassaQueue
	 */

	public KassaQueue CurrentlyQueued() {
		return this.KassaQueue;
	}

	/**
	 * Getter for number of kassor.
	 * @return numberOfKassor
	 */

	public int GetNumberOfKassor() {
		return this.numberOfKassor;
	}

	/**
	 * Getter for max number of customers.
	 * @return maxCustomer
	 */

	public int GetMaxCustomer() {
		return this.maxCustomer;
	}

	/**
	 * Getter for seed.
	 * @return seed
	 */

	public long GetSeed() {
		return this.seed;
	}

	/**
	 * Getter for if the store is open or not.
	 * @return store
	 */

	public boolean GetStore() {
		return this.store;
	}

	/**
	 * Setter for if the store is open or not.
	 * @param state state
	 */

	public void SetStoreState(boolean state) {
		this.store = state;
	}

	/**
	 * Getter för KassaQueue.
	 * @return kassakö
	 */

	public KassaQueue GetQueue() {
		return this.KassaQueue;
	}

	/**
	 * Getter för next arrival
	 * @param time time
	 * @return nextArrival.next() + time
	 */

	public double GetNextArrival(double time) {
		return this.nextArrival.next() + time;
	}

	/**
	 * Getter for next plock.
	 * @param time time
	 * @return nextPlock.next() + time
	 */

	public double GetNextPlock(double time) {
		return this.nextPlock.next() + time;
	}

	/**
	 * Getter for next payment.
	 * @param time time
	 * @return nextPay.next() + time
	 */

	public double GetNextPay(double time) {
		return this.nextPay.next() + time;
	}

	/**
	 * Adds 1 to number of customer.
	 */

	public void IncreaseCustomers() {
		this.customer = this.customer + 1;
	}

	/**
	 * Removes 1 from number of customers.
	 */

	public void DecreaseCustomers() {
		this.customer = this.customer - 1;
	}

	/**
	 * Getter for number of missed customers.
	 * @return missedCustomers
	 */

	public int MissedCustomers() {
		return this.missedCustomers;
	}

	/**
	 * Adds 1 to number of missed customers.
	 */

	public void IncreaseMissedCustomers() {
		this.missedCustomers = this.missedCustomers + 1;
	}

	/**
	 * Getter for time Kassor has been free.
	 * @return freeKassorTime
	 **/

	public double GetFreeKassorTime() {
		return this.freeKassorTime;
	}

	/**
	 * Increases the time Kassor has been free.
	 * @param time time
	 **/

	public void IncreaseFreeKassorTime(double time) {
		this.freeKassorTime = this.freeKassorTime + time;
	}

	/**
	 * Getter for queue time.
	 * @return queueTime
	 **/

	public double GetQueueTime() {
		return this.queueTime;
	}

	/**
	 * Increases the queue time.
	 * @param queueTime queueTime
	 **/

	public void IncreaseQueueTime(double queueTime) {
		this.queueTime = this.queueTime + queueTime;
	}

	/**
	 * Getter for number of free customers.
	 * @return freeKassor
	 **/

	public int FreeKassor() {
		return this.freeKassor;
	}

	/**
	 * Increases the number of free Kassor.
	 **/

	public void IncreaseFreeKassor() {
		this.freeKassor = this.freeKassor + 1;
	}

	/**
	 * Decreases the number of free customers.
	 **/

	public void DecreaseFreeKassor() {
		this.freeKassor = this.freeKassor - 1;
	}

	/**
	 * Returns the current event.
	 * @return currentEvent
	 **/

	public Event CurrentEvent() {
		return currentEvent;
	}

	/**
	 * Sets currentEvent to currentEvent.
	 * @param currentEvent currentEvent.
	 **/

	public void SetCurrentEvent(Event currentEvent) {
		this.currentEvent = currentEvent;
	}

	/**
	 * Getter for last payment.
	 * @return lastPay
	 **/

	public double getLastPay() {
		return this.lastPay;
	}

	/**
	 * Getter for if StoreView is allowed to get written out or not.
	 * @return allowView
	 **/

	public boolean getALlowView() {
		return this.allowView;
	}

	/**
	 * Getter for the time of the last event.
	 * @return lastEvent
	 **/

	public double lastEvent() {
		return this.lastEvent;
	}

	/**
	 * Sets the time of the last event to time.
	 * @param time time
	 **/

	public void setLastEvent(double time) {
		lastEvent = time;
	}

	/**
	 * Getter for when the store closes.
	 * @return closeTime
	 **/

	public double GetCloseTime() {
		return this.closeTime;
	}

	/**
	 * Notifies Observers. Calculates the amount of time there has been 
	 * people in the Queues and calculates the time kassor has been free.
	 * @param event event
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

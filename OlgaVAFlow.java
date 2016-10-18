package iristk.app.olgaVA;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class OlgaVAFlow extends iristk.flow.Flow {

	private Integer number;
	private Integer guesses;

	private void initVariables() {
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer value) {
		this.number = value;
	}

	public Integer getGuesses() {
		return this.guesses;
	}

	public void setGuesses(Integer value) {
		this.guesses = value;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("number")) return this.number;
		if (name.equals("guesses")) return this.guesses;
		return null;
	}


	public OlgaVAFlow() {
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 10
			try {
				EXECUTION: {
					int count = getCount(721748895) + 1;
					incrCount(721748895);
					// Line: 11
					number = 3;
					// Line: 12
					guesses = 0;
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					state0.setText("Hello ! I am Olga.");
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 10, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state1 = new iristk.flow.DialogFlow.say();
					state1.setText("I am bored Today! How are you doing ?");
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 10, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state2 = new iristk.flow.DialogFlow.say();
					state2.setText("Lets play a car game. What you think?");
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 10, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
					state3.setText("In above four cars, which one you think the fastest car !");
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 10, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 22
					Guess state4 = new Guess();
					flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 22, 25)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 10, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Guess extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 27
			try {
				EXECUTION: {
					int count = getCount(463345942) + 1;
					incrCount(463345942);
					iristk.flow.DialogFlow.listen state5 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 27, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 27, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 30
			try {
				count = getCount(195600860) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(195600860);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 31
							guesses++;
							// Line: 32
							if (asInteger(event.get("sem:number")) == number) {
								iristk.flow.DialogFlow.say state6 = new iristk.flow.DialogFlow.say();
								state6.setText(concat("That was correct, you only needed", guesses, "guesses."));
								if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 32, 53)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 34
								CheckAgain state7 = new CheckAgain();
								flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 34, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 35
							} else if (asInteger(event.get("sem:number")) == 1) {
								iristk.flow.DialogFlow.say state8 = new iristk.flow.DialogFlow.say();
								state8.setText("Sorry Audi is not the fastest car, May be it was in 2000.");
								if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 32, 53)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 37
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 37, 15)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 38
							} else if (asInteger(event.get("sem:number")) == 2) {
								iristk.flow.DialogFlow.say state9 = new iristk.flow.DialogFlow.say();
								state9.setText("Sorry Lamborghini the fastest car untill 2015, not anymore.");
								if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 32, 53)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 40
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 40, 15)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 41
							} else if (asInteger(event.get("sem:number")) == 4) {
								iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
								state10.setText("Sorry Volkswagen is a family sadan not a sports car to be the fastest one.");
								if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 32, 53)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 43
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 43, 15)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 30, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 49
			try {
				EXECUTION: {
					int count = getCount(1588970020) + 1;
					incrCount(1588970020);
					iristk.flow.DialogFlow.say state11 = new iristk.flow.DialogFlow.say();
					state11.setText("Do you want to play again?");
					if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 49, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state12 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 49, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 49, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 53
			try {
				count = getCount(1407343478) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1407343478);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state13 = new iristk.flow.DialogFlow.say();
							state13.setText("Okay, let's play again.");
							if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 53, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 55
							Start state14 = new Start();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 55, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 53, 58));
			}
			// Line: 57
			try {
				count = getCount(245565335) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(245565335);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state15 = new iristk.flow.DialogFlow.say();
							state15.setText("Okay, goodbye");
							if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 57, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 59
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 57, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 64
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(183264084);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state16 = new iristk.flow.DialogFlow.say();
						state16.setText("I am sorry, I didn't hear anything.");
						if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 64, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 66
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 66, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 64, 38));
			}
			// Line: 68
			try {
				count = getCount(1490180672) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1490180672);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state17 = new iristk.flow.DialogFlow.say();
						state17.setText("I am sorry, I didn't get that.");
						if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 68, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 70
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 70, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 68, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}

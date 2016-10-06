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

	private Record name;

	private void initVariables() {
		name = asRecord(new Record());
	}

	public Record getName() {
		return this.name;
	}

	public void setName(Record value) {
		this.name = value;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("name")) return this.name;
		return null;
	}


	public OlgaVAFlow() {
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends Dialog implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 9
			try {
				EXECUTION: {
					int count = getCount(1031980531) + 1;
					incrCount(1031980531);
					// Line: 10
					if (count == 1) {
						iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
						state0.setText("Hello ! I am Olga your Robo friend to help you with your daily activities");
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 10, 35)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					iristk.flow.DialogFlow.say state1 = new iristk.flow.DialogFlow.say();
					state1.setText("May I know you name please?");
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 9, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 9, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 9, 18));
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
			// Line: 19
			try {
				count = getCount(1305193908) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:name")) {
						incrCount(1305193908);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 20
							name.adjoin(asRecord(event.get("sem:name")));
							// Line: 21
							CheckName state3 = new CheckName();
							flowThread.gotoState(state3, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 21, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 19, 65));
			}
			// Line: 23
			try {
				count = getCount(463345942) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(463345942);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state4 = new iristk.flow.DialogFlow.say();
						state4.setText(concat("Sorry, I", concat("<str cond=\"count > 1\">", "still", "</str>"), "didn't get that"));
						if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 23, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 25
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 25, 23)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 23, 42));
			}
			// Line: 27
			try {
				count = getCount(1334729950) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1334729950);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state5 = new iristk.flow.DialogFlow.say();
						state5.setText(concat("Sorry, I", concat("<str cond=\"count > 1\">", "still", "</str>"), "didn't hear anything"));
						if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 27, 44)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 29
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 29, 23)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 27, 44));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckName extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 34
			try {
				EXECUTION: {
					int count = getCount(1973336893) + 1;
					incrCount(1973336893);
					// Line: 35
					if (!name.has("firstName")) {
						// Line: 36
						RequestFirstName state6 = new RequestFirstName();
						flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 36, 49)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 37
					} else if (!name.has("age")) {
						// Line: 38
						RequestAge state7 = new RequestAge();
						flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 38, 43)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 39
					} else if (eq(name.get("age:type"), "milkshake") && !name.has("age:flavor")) {
						// Line: 40
						RequestFlavor state8 = new RequestFlavor();
						flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 40, 46)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 41
					} else if (!name.has("side")) {
						// Line: 42
						RequestSide state9 = new RequestSide();
						flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 42, 44)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 43
					} else {
						// Line: 44
						Done state10 = new Done();
						flowThread.gotoState(state10, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 44, 37)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 34, 18));
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


	private class RequestFirstName extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 50
			try {
				EXECUTION: {
					int count = getCount(1066376662) + 1;
					incrCount(1066376662);
					iristk.flow.DialogFlow.say state11 = new iristk.flow.DialogFlow.say();
					state11.setText("Your First name is");
					if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 50, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state12 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 50, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 50, 18));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 54
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(183264084);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 55
							name.putIfNotNull("firstName:type", "hamburger");
							// Line: 56
							CheckName state13 = new CheckName();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 56, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 54, 64));
			}
			// Line: 58
			try {
				count = getCount(460332449) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(460332449);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 59
							name.putIfNotNull("firstName:type", "none");
							// Line: 60
							CheckName state14 = new CheckName();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 60, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 58, 63));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class RequestAge extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 65
			try {
				EXECUTION: {
					int count = getCount(517938326) + 1;
					incrCount(517938326);
					iristk.flow.DialogFlow.say state15 = new iristk.flow.DialogFlow.say();
					state15.setText("your age is");
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 65, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state16 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 65, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 65, 18));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 69
			try {
				count = getCount(914424520) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(914424520);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state17 = new iristk.flow.DialogFlow.say();
							state17.setText("So How old are you");
							if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 69, 64)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.listen state18 = new iristk.flow.DialogFlow.listen();
							if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 69, 64)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 69, 64));
			}
			// Line: 73
			try {
				count = getCount(110718392) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(110718392);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 74
							name.putIfNotNull("age:type", "none");
							// Line: 75
							CheckName state19 = new CheckName();
							flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 75, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 73, 63));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class RequestFlavor extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 80
			try {
				EXECUTION: {
					int count = getCount(204349222) + 1;
					incrCount(204349222);
					iristk.flow.DialogFlow.say state20 = new iristk.flow.DialogFlow.say();
					state20.setText("What flavor do you want in your milkshake?");
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 80, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state21 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 80, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 80, 18));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 84
			try {
				count = getCount(231685785) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:flavor")) {
						incrCount(231685785);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 85
							name.putIfNotNull("age:flavor", event.get("sem:flavor"));
							// Line: 86
							CheckName state22 = new CheckName();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 86, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 84, 67));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class RequestSide extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 91
			try {
				EXECUTION: {
					int count = getCount(1973538135) + 1;
					incrCount(1973538135);
					iristk.flow.DialogFlow.say state23 = new iristk.flow.DialogFlow.say();
					state23.setText("Do you want anything on the side, such as fries or sallad?");
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 91, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state24 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 91, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 91, 18));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 95
			try {
				count = getCount(1865127310) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1865127310);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state25 = new iristk.flow.DialogFlow.say();
							state25.setText("So what do you want on the side?");
							if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 95, 64)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.listen state26 = new iristk.flow.DialogFlow.listen();
							if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 95, 64)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 95, 64));
			}
			// Line: 99
			try {
				count = getCount(1694819250) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1694819250);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 100
							name.putIfNotNull("side:type", "none");
							// Line: 101
							CheckName state27 = new CheckName();
							flowThread.gotoState(state27, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 101, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 99, 63));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Done extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 106
			try {
				EXECUTION: {
					int count = getCount(474675244) + 1;
					incrCount(474675244);
					iristk.flow.DialogFlow.say state28 = new iristk.flow.DialogFlow.say();
					state28.setText("Okay, thanks for your Information");
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 106, 18)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 108
					log(name.toStringIndent());
					// Line: 109
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\DJ\\IrisTK\\app\\OlgaVA\\src\\iristk\\app\\olgaVA\\OlgaVAFlow.xml"), 106, 18));
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


}

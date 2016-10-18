package iristk.app.olgaVA;

import iristk.app.chess.ChessWindow;
import iristk.flow.FlowEventInfo;
import iristk.flow.FlowException;
import iristk.flow.FlowListener;
import iristk.flow.State;
import iristk.system.Event;
import iristk.system.InitializationException;
import iristk.system.IrisGUI;
import iristk.system.IrisModule;

public class OlgaVA extends IrisModule implements FlowListener {

	public OlgaWindow olgaWindow;
	public OlgaVA(IrisGUI gui) {
		olgaWindow = new OlgaWindow();
		olgaWindow.init();
		//gui.add(comp)
		gui.addDockPanel("olga-Image", "Images", olgaWindow, true);
		gui.setVisible(true);
	}
	public void setGameListener(OlgaVASystem olgaVASystem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEvent(Event event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFlowEvent(Event event, FlowEventInfo info) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSendEvent(Event event, FlowEventInfo info) {
		Event event1= new Event();
		//addEventListener(event1);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGotoState(State toState, FlowEventInfo info) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCallState(State toState, FlowEventInfo info) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onReturnState(State fromState, State toState,
			FlowEventInfo flowEventInfo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFlowException(FlowException e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init() throws InitializationException {
		// TODO Auto-generated method stub
		
	}

}

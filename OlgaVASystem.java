/*******************************************************************************
 * Copyright (c) 2014 Gabriel Skantze.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Gabriel Skantze - initial API and implementation
 ******************************************************************************/
package iristk.app.olgaVA;

import iristk.speech.SpeechGrammarContext;
import iristk.speech.Voice.Gender;
import iristk.speech.windows.WindowsRecognizerFactory;
import iristk.speech.windows.WindowsSynthesizer;
import iristk.system.IrisUtils;
import iristk.system.SimpleDialogSystem;
import iristk.util.Language;
import iristk.app.chess.ChessFlow;
import iristk.app.chess.ChessGame;
import iristk.cfg.SRGSGrammar;
import iristk.flow.FlowModule;

public class OlgaVASystem {

	private OlgaVA olgaVA;
	public OlgaVASystem() throws Exception {
		// Create the system
		SimpleDialogSystem system = new SimpleDialogSystem(this.getClass());
		
		// Set the language of the system
		system.setLanguage(Language.ENGLISH_US);
		
		// Uncomment this if you want to turn on logging
		//system.setupLogging(new File("c:/iristk_logging"), true);
		
		// Set up the GUI
		system.setupGUI();
		
		// Add the recognizer to the system
		system.setupRecognizer(new WindowsRecognizerFactory());
		
		// Add a synthesizer to the system		
		system.setupSynthesizer(new WindowsSynthesizer(), Gender.FEMALE);
		
		olgaVA = new OlgaVA(system.getGUI());
		// Listen for events in the chess game
		
		olgaVA.setGameListener(this);
		olgaVA.start();
		
		
		// Add the flow
		OlgaVAFlow olgaFlow = new OlgaVAFlow();
		//olgaFlow.setNumber(1);
		system.addModule(new FlowModule(olgaFlow));
		
		// Load a grammar in the recognizer
		system.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(system.getPackageFile("OlgaVAGrammar.xml"))));
		
		// Start the interaction
		system.sendStartSignal();
	}

	public static void main(String[] args) throws Exception {
		new OlgaVASystem();
	}

}

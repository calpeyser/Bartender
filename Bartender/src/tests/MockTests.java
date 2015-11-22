package tests;

import static org.junit.Assert.*;
import hardware.HardwareCapabilities;
import hardware.HardwareConfig;
import hardware.HardwareEvent;
import hardware.HardwarePrimitiveActions;

import org.junit.Before;
import org.junit.Test;

import simplebartender.CanisterConfigFactory;
import simplebartender.DrinkMenuState;
import simplebartender.LandingState;
import simplebartender.MockCanisterConfigFactory;
import simplebartender.MockHardwareConfig;
import simplebartender.MockHardwarePrimitiveActions;
import simplebartender.PumpsetHardwareCapabilities;
import simplebartender.SimpleBartenderMessages;
import simplebartender.SimpleStateManager;
import testutils.Log;
import testutils.WroteToDisplayMessage;
import control.BartenderController;
import control.StateManager;
import drinkdata.MockRecipeProvider;
import drinkdata.RecipeProvider;

public class MockTests {

	private MockHardwarePrimitiveActions hardwarePrimitiveActions;
	private BartenderController controller;
	private Log log;
	
	@Before
	public void setUp() throws Exception {
		RecipeProvider recipeProvider = new MockRecipeProvider();
		HardwareConfig hardwareConfig = new MockHardwareConfig(recipeProvider);
		hardwarePrimitiveActions = new MockHardwarePrimitiveActions();
		log = hardwarePrimitiveActions.getLog();
		CanisterConfigFactory canisterConfigFactory = new MockCanisterConfigFactory();
		HardwareCapabilities hardwareCapabilties = new PumpsetHardwareCapabilities(hardwarePrimitiveActions, hardwareConfig, canisterConfigFactory);
		StateManager stateManager = new SimpleStateManager(hardwareCapabilties, recipeProvider);
		controller = new BartenderController(stateManager);
	}

	@Test
	public void startsInLandingState() {
		assertEquals(controller.getCurrentState().getClass(), LandingState.class);
	}
	
	@Test
	public void startsWithLandingStateMessage() {
		WroteToDisplayMessage message = log.peek(WroteToDisplayMessage.class);
		assertEquals(SimpleBartenderMessages.LANDING_MENU_MESSAGE, message.toString());
	}

	@Test
	public void switchesToDrinkMenuOnEnterKey() {
		controller.handleEvent(HardwareEvent.ButtonEnter);
		assertEquals(controller.getCurrentState().getClass(), DrinkMenuState.class);	
	}
	
}

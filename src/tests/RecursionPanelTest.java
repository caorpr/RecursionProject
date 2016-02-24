package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import math.view.RecursionPanel;
import java.awt.Component;
import javax.swing.JButton;
import math.controller.RecursionController;

/**
 * @author Cody Henrichsen
 * @version 0.x Feb 17, 2016
 */
public class RecursionPanelTest
{

	private RecursionPanel testPanel;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		testPanel = new RecursionPanel(new RecursionController());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		testPanel = null;
	}

	@Test
	public void testSetupPanel()
	{
		assertTrue("Minimum count of GUI components not met.", testPanel.getComponentCount() >= 4);
	}
	
	public void testSetupListeners()
	{
		for(Component current : testPanel.getComponents())
		{
			if(current instanceof JButton)
			{
				assertTrue("Listener not created for button", ((JButton)current).getActionListeners()[0] != null );
			}
		}
	}

}

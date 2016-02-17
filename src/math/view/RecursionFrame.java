package math.view;
import javax.swing.JFrame;

import math.controller.RecursionController;

public class RecursionFrame extends JFrame
{
		private RecursionController baseController;
		private RecursionPanel basePanel;
		public RecursionFrame(RecursionController baseController)
		{
			this.baseController = baseController;
		}
		
		
		private void setupFrame()
		{
			this.setVisible(true);
		}
		
		
}


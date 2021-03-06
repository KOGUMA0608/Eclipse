package lesson05.sample3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample3 extends JFrame
{
    private SamplePanel sp;

    public static void main(String args[])
    {
	Sample3 sm = new Sample3();
    }
    public Sample3()
    {
	super("サンプル");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300, 300);
	sp = new SamplePanel();
	add(sp, BorderLayout.CENTER);
	setVisible(true);
    }
    public class SamplePanel extends JPanel
    {
	private ArrayList<Shape> shapelist
	    = new ArrayList<Shape>();

	public SamplePanel()
	{
	    addMouseListener(new SampleMouseListener());
	}
	public void paint(Graphics g)
	{
	    super.paint(g);
	    Iterator<Shape> it = shapelist.iterator();
	    while(it.hasNext()) {
		Shape sh = it.next();
		sh.draw(g);
	    }
	}
	public class SampleMouseListener extends MouseAdapter
	{
	    public void mousePressed(MouseEvent e)
	    {
		shapelist.add(new ShadeCircle(
		   new Char(e.getX(), e.getY())));
		repaint();
	    }
	}
    }
}

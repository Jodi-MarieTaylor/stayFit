

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

import java.awt.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalScrollBarUI;



public class OpenCardListener extends JPanel{

	private JFrame frame;
    /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 1;
    /** Color of shadow */
    protected Color shadowColor = Color.black;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(20, 20);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 5;
    /** The offset of shadow.  */
    protected int shadowOffset = 4;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 150;
	
	 //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)
	ImageIcon backImage = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/background.jpg");
	ImageIcon caloriesIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/FireIcon2.png");
	ImageIcon minutesIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/TimeIcon2.png");
	ImageIcon movementIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/RunningIcon2.png");
	ImageIcon lifetimeIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/StarIcon2.png");
	ImageIcon timeseriesIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/BarGraphIcon2.png");
	ImageIcon bestdayIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/BlueStarIcon2.png");
	ImageIcon exitIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/closebutton2.png");
	ImageIcon rightarrowIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/rightArrow2.png");
	ImageIcon leftarrowIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/leftArrow2.png");
	ImageIcon trophyIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/Trophy.png");
	ImageIcon cardIcon =new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/dash.png");
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaloriesPanel window = new CaloriesPanel();
					window.frame.setSize(1000,600);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public OpenCardListener(int num) {
		initialize(num);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int num) {
		
		//main frame
		/*frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		CardLayout cl = new CardLayout(0,0);
		this.setLayout(new CardLayout(0,0));
		JPanel panel_3 = new JPanel();
		this.add(panel_3, "3");
		panel_3.setLayout(cl);
		cl.show(panel_3, "2");
		BackgroundPanel dashPanel = new BackgroundPanel(backImage);
		dashPanel.setBackground(new Color(0, 128, 0));
		panel_3.add(dashPanel, "2");
		JPanel cardPanel= new JPanel();
		
		
		if (num==1){
			calpanel calPanel = new calpanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
			calPanel.setOpaque(false);
			//cardPanel.add(life, "9");
			dashPanel.setLayout(new BorderLayout(0, 0));
			dashPanel.add(calPanel, BorderLayout.CENTER);;;;
			
	         
			cardPanel.setLayout(new BorderLayout(0, 0));
			
			}

		if (num==2){
			minpanel minPanel = new minpanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
			minPanel.setOpaque(false);
			//cardPanel.add(life, "9");
			dashPanel.setLayout(new BorderLayout(0, 0));
			dashPanel.add(minPanel, BorderLayout.CENTER);       
			cardPanel.setLayout(new BorderLayout(0, 0));
			
			}
		
		if (num==3){
			movepanel movePanel = new movepanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
			movePanel.setOpaque(false);
			//cardPanel.add(life, "9");
			dashPanel.setLayout(new BorderLayout(0, 0));
			dashPanel.add(movePanel, BorderLayout.CENTER);       
			cardPanel.setLayout(new BorderLayout(0, 0));
			
			}
		
		
		
		if (num==4){
		lifepanel life = new lifepanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
		life.setOpaque(false);
		//cardPanel.add(life, "9");
		dashPanel.setLayout(new BorderLayout(0, 0));
		dashPanel.add(life, BorderLayout.CENTER);;;;
		
		cardPanel.setLayout(new BorderLayout(0, 0));
		
		}
		if (num==5){
			timepanel timePanel = new timepanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
			timePanel.setOpaque(false);
			//cardPanel.add(life, "9");
			dashPanel.setLayout(new BorderLayout(0, 0));
			dashPanel.add(timePanel, BorderLayout.CENTER);       
			cardPanel.setLayout(new BorderLayout(0, 0));
			
			}
		
		if (num==6){
			bestpanel bestPanel = new bestpanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
			bestPanel.setOpaque(false);
			//cardPanel.add(life, "9");
			dashPanel.setLayout(new BorderLayout(0, 0));
			dashPanel.add(bestPanel, BorderLayout.CENTER);       
			cardPanel.setLayout(new BorderLayout(0, 0));
			
			}
		
		/*Trophy*/
		
		//setting the panel for trophy
		JPanel panel_15 = new JPanel();
		panel_15.setOpaque(false);
		dashPanel.add(panel_15, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105,180));
		JButton trophyButton = new JButton("");
		trophyButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		trophyButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		trophyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		trophyButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		trophyButton.setContentAreaFilled(false);
		trophyButton.setHorizontalAlignment(SwingConstants.RIGHT);
		trophyButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		trophyButton.setVerticalAlignment(SwingConstants.BOTTOM);
		trophyButton.setBorder(null);
		trophyButton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/Trophy2.png"));
		
		JButton btnJodimarie = new JButton("Jodi-Marie");
		btnJodimarie.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnJodimarie.setForeground(new Color(255, 255, 255));
		btnJodimarie.setContentAreaFilled(false);
		btnJodimarie.setBorder(null);
		
		JButton timeseriesButton = new JButton("");
		timeseriesButton.setContentAreaFilled(false);
		timeseriesButton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/BarGraphIcon2.png"));
		timeseriesButton.setBorder(null);
		timeseriesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");	
            	OpenCardListener opencard = new OpenCardListener(5);
        		panel_3.add(opencard,"10") ;	
        		cl.show(panel_3,"10");
            	
            }});
		
		
		JButton bestButton = new JButton("");
		bestButton.setBorder(null);
		bestButton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/BlueStarIcon2.png"));
		bestButton.setContentAreaFilled(false);
		bestButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");	
            	OpenCardListener opencard = new OpenCardListener(6);
        		panel_3.add(opencard,"10") ;	
        		cl.show(panel_3,"10");
            	
            }});
		
		
		
		JButton caloriesButton = new JButton("");
		caloriesButton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/FireIcon2.png"));
		caloriesButton.setContentAreaFilled(false);
		caloriesButton.setBorder(null);
		caloriesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");	
            	OpenCardListener opencard = new OpenCardListener(1);
        		panel_3.add(opencard,"10") ;	
        		cl.show(panel_3,"10");
            	
            }});
		
		JButton movementButton = new JButton("");
		movementButton.setContentAreaFilled(false);
		movementButton.setBorder(null);
		movementButton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/RunningIcon2.png"));
		movementButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");	
            	OpenCardListener opencard = new OpenCardListener(3);
        		panel_3.add(opencard,"10") ;	
        		cl.show(panel_3,"10");
            	
            }});
		
		
		JButton minutesButton = new JButton("");
		minutesButton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/TimeIcon2.png"));
		minutesButton.setBorder(null);
		minutesButton.setContentAreaFilled(false);
		minutesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");	
            	OpenCardListener opencard = new OpenCardListener(2);
        		panel_3.add(opencard,"10") ;	
        		cl.show(panel_3,"10");
            	
            }});
		
		JButton lifetimeButton = new JButton("");
		lifetimeButton.setContentAreaFilled(false);
		lifetimeButton.setBorder(null);
		lifetimeButton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/StarIcon2.png"));
		lifetimeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");	
            	OpenCardListener opencard = new OpenCardListener(2);
        		panel_3.add(opencard,"10") ;	
        		cl.show(panel_3,"10");
            	
            }});
		
		
		
		JButton homebutton = new JButton("");
		homebutton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                //cl.show(panel_3,"2");	
	            	DashBoardPanel dash= new DashBoardPanel();
	        		panel_3.add(dash,"11");	
	        		cl.show(panel_3,"11");
	            	
	            }});
		
		
		homebutton.setContentAreaFilled(false);
		homebutton.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/home2.png"));
		homebutton.setBorder(null);
		 homebutton .addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	
	               	
	            	//cl.show(panel_3,"9");	
	            	OpenCardListener opencard = new OpenCardListener(6);
	        		panel_3.add(opencard,"10") ;	
	        		cl.show(panel_3,"10");
	            	
	            }});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(timeseriesButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bestButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caloriesButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(movementButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(minutesButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lifetimeButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(homebutton)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(btnJodimarie, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(trophyButton))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(homebutton, GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
						.addComponent(caloriesButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(timeseriesButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnJodimarie, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addComponent(bestButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(movementButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(minutesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(trophyButton, Alignment.LEADING)
						.addComponent(lifetimeButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		trophyButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	JFrame trophyframe= new JFrame("Goals and Accolades");
	                trophyframe.setVisible(true);
	                trophyframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             	JPanel trophypanel=new JPanel();
	             	
	              
	            	trophyframe.getContentPane().add(trophypanel);      	
	            	
	            	trophyframe.pack();
	            	trophyframe.setSize(600,600);
	               	
	            }});
		panel_15.setLayout(new BorderLayout(0, 0));
		panel_15.add(panel);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(105, 105, 105,180));
		
	
		/*Today Title*/
		
		Date dateAndTime = Calendar.getInstance().getTime();// can be used to display time if added to panel
		dashPanel.add(panel_16, BorderLayout.NORTH);
		panel_16.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_6 = new JButton("");
		button_6.setContentAreaFilled(false);
		button_6.setBorder(null);
		button_6.setOpaque(false);
		button_6.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/smallleftarrow.png"));
		panel_16.add(button_6);
		JLabel lblToday = new JLabel("Today");
		lblToday.setBackground(new Color(105, 105, 105,180));
		lblToday.setForeground(new Color(255, 255, 255));
		lblToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblToday.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		panel_16.add(lblToday);
		
		JButton button_7 = new JButton("");
		button_7.setContentAreaFilled(false);
		button_7.setBorder(null);
		button_7.setIcon(new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/smallrightarrow.png"));
		panel_16.add(button_7);
		
		
		
	}
	
 
}
class MyScrollbarUI extends MetalScrollBarUI {

    private Image imageThumb, imageTrack;
    private JButton b = new JButton() {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }

    };

    MyScrollbarUI() {
        imageThumb = ScrollbarImage.create(32, 32, Color.darkGray);
        imageTrack = ScrollbarImage.create(32, 32, Color.gray.darker());
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        g.setColor(Color.white);
        ((Graphics2D) g).drawImage(imageThumb,
            r.x, r.y, r.width, r.height, null);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        ((Graphics2D) g).drawImage(imageTrack,
            r.x, r.y, r.width, r.height, null);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return b;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return b;
    }
}

class ScrollbarImage {

    static public Image create(int w, int h, Color c) {
        BufferedImage bi = new BufferedImage(
            w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setPaint(c);
        g2d.fillRect(0, 0, w, h);
        g2d.dispose();
        return bi;
    }
}

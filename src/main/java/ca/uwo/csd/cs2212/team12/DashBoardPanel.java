package ca.uwo.csd.cs2212.team12;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

//import net.miginfocom.swing.MigLayout;








import javax.swing.LayoutStyle.ComponentPlacement;




public class DashBoardPanel extends JPanel {

    private JFrame frame;
    private API api = new RealAPI();
    public void setAPI(API api){
        this.api = api;}

    //Images from the resource folder used throughout the programme
    ImageIcon backImage = new ImageIcon("../src/main/resources/background.jpg");
    ImageIcon caloriesIcon = new ImageIcon("../src/main/resources/FireIcon2.png");
    ImageIcon minutesIcon = new ImageIcon("../src/main/resources/TimeIcon2.png");
    ImageIcon movementIcon = new ImageIcon("../src/main/resources/RunningIcon2.png");
    ImageIcon lifetimeIcon = new ImageIcon("../src/main/resources/StarIcon2.png");
    ImageIcon timeseriesIcon = new ImageIcon("../src/main/resources/BarGraphIcon2.png");
    ImageIcon bestdayIcon = new ImageIcon("../src/main/resources/BlueStarIcon2.png");
    ImageIcon exitIcon = new ImageIcon("../src/main/resources/closebutton2.png");
    ImageIcon rightarrowIcon = new ImageIcon("../src/main/resources/rightArrow2.png");
    ImageIcon leftarrowIcon = new ImageIcon("../src/main/resources/leftArrow2.png");
    ImageIcon trophyIcon = new ImageIcon("../src/main/resources/Trophy.png");
    ImageIcon cardIcon =new ImageIcon("../src/main/resources/dash.png");


    /**
     * Create the application.
     */
    public DashBoardPanel() {
        initialize();
    }
    
    /**
     * Sets the API the dashboard will get values from.
     * 
     * @param api an interface that can be used as either the test API or the realAPI
     */
    public DashBoardPanel(API api) {
        this.api = api;
        initialize();
    }

    /**
     * Initialize the contents of the panels; sub-panels, labels, borders and etc.
     */
    private void initialize() {

        //main frame

        final CardLayout cl = new CardLayout(0,0);
        this.setLayout(new CardLayout(0,0));

        final JPanel panel_3 = new JPanel();
        this.add(panel_3, "3");
        panel_3.setLayout(cl);
        //panel_1.setBackground(Color.RED);


        BackgroundPanel dashPanel = new BackgroundPanel(backImage);
        //dashPanel.setBackground(new Color(0, 128, 0));
        panel_3.add(dashPanel,"1");


        /**Note the card panel holds all the card its at the center of the dash panel,
         * the arrows, trophy and etc are on other sub-panels of the dashpanel
         */
        final JPanel cardPanel = new JPanel();
        cardPanel.setOpaque(false);
        cardPanel.setBounds(new Rectangle(200, 200, 200, 200));
        dashPanel.setLayout(new BorderLayout(0, 0));
        dashPanel.add(cardPanel, BorderLayout.CENTER);
        //BasicInternalFrameUI bi = (BasicInternalFrameUI)internalFrame_5.getUI(); //could be used to hide internal frame title bar
        //bi.setNorthPane(null);
        cardPanel.setLayout(new GridLayout(2, 3, 20, 20));
        cardPanel.setLayout(new GridLayout(2, 3, 20, 50));;
        
        /**
         *These are the individual cards, which are buttons with nested components.
         *each of these are on the card panel.         * 
         */
		
        /*Calories card*/

        //Calories Button
        final  JButton caloriesButton = new JButton("");
        caloriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        caloriesButton.setBorder(null);
        caloriesButton.setContentAreaFilled(false);
        caloriesButton.setOpaque(false);
        caloriesButton.setMinimumSize(new Dimension(15, 11));
        caloriesButton.setMaximumSize(new Dimension(15, 11));
        caloriesButton.setPreferredSize(new Dimension(15, 11));
        caloriesButton.setIcon(cardIcon);
        caloriesButton.setLayout(new BorderLayout());
        caloriesButton.setBorder(BorderFactory.createEmptyBorder());
        caloriesButton.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(1);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});



        //card panel for calories
        JPanel pl= new JPanel();
        pl.setForeground(new Color(255, 255, 255));
        pl.setOpaque(false);
        caloriesButton.add(pl,BorderLayout.NORTH);

        //exit button for the calories card
        JButton calExit = new JButton("");
        calExit. addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( caloriesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
            }

        });




        //the label for the title of the calories card
        JLabel lblCalories_1 = new JLabel("Calories");
        lblCalories_1.setFont(new Font("Verdana", Font.BOLD, 14));
        lblCalories_1.setForeground(new Color(255, 255, 255));
        lblCalories_1.setIcon(caloriesIcon);
        calExit.setContentAreaFilled(false);
        calExit.setBorder(null);
        calExit.setBorderPainted(false);
        calExit.setIcon(exitIcon);
        GroupLayout gl_pl = new GroupLayout(pl);
        gl_pl.setHorizontalGroup(
                gl_pl.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblCalories_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(125)
                                .addComponent(calExit, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
        );
        gl_pl.setVerticalGroup(
                gl_pl.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(lblCalories_1)
                                        .addComponent(calExit))
                                .addGap(11))
        );
        pl.setLayout(gl_pl);
        calExit. addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( caloriesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
            }

        });


        cardPanel.add(caloriesButton);

        JPanel calinfoPanel= new JPanel();
        calinfoPanel.setOpaque(false);
        caloriesButton.add(calinfoPanel, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("Calories Burned: " + api.getCalBurned());
        lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.WHITE);
        GroupLayout gl_calinfoPanel = new GroupLayout(calinfoPanel);
        gl_calinfoPanel.setHorizontalGroup(
                gl_calinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel)
        );
        gl_calinfoPanel.setVerticalGroup(
                gl_calinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_calinfoPanel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblNewLabel))
        );
        calinfoPanel.setLayout(gl_calinfoPanel);

		 /*Minutes card*/

        //Minutes Button
        final JButton minutesButton = new JButton("");
        minutesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minutesButton.setContentAreaFilled(false);
        minutesButton.setOpaque(false);
        minutesButton.setBorder(null);
        minutesButton.setIcon(cardIcon);
        minutesButton.setBorder(null);
        minutesButton.setLayout(new BorderLayout());
        minutesButton .addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {


                //cl.show(panel_3,"4");
                OpenCardListener opencard = new OpenCardListener(2);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");


            }});

        //card panel for minutes
        JPanel pl2= new JPanel();
        pl2.setOpaque(false);
        pl2.setForeground(new Color(255, 255, 255));
        pl2.setForeground(new Color(255, 255, 255));
        minutesButton.add(pl2,BorderLayout.NORTH);
        cardPanel.add(minutesButton);//adding it to the cardpanel
        //button for minute exit
        JButton minExit = new JButton("");
        minExit.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( minutesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
            }

        });


        minExit .setContentAreaFilled(false);
        minExit .setBorder(null);
        minExit.setBorderPainted(false);
        minExit .setIcon(exitIcon);

        //the label for the title of the minutes card
        JLabel lblMinutes = new JLabel("Minutes");
        lblMinutes.setFont(new Font("Verdana", Font.BOLD, 13));
        lblMinutes.setForeground(new Color(255, 255, 255));
        lblMinutes.setIcon(minutesIcon);


        GroupLayout gl_pl2 = new GroupLayout(pl2);
        gl_pl2.setHorizontalGroup(
                gl_pl2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl2.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblMinutes)
                                .addGap(130)
                                .addComponent(minExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl2.setVerticalGroup(
                gl_pl2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl2.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl2.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblMinutes)
                                        .addComponent(minExit)))
        );
        pl2.setLayout(gl_pl2);

        JPanel mininfoPanel= new JPanel();
        mininfoPanel.setOpaque(false);
        minutesButton.add(mininfoPanel, BorderLayout.CENTER);

        JLabel lblActiveMinutes = new JLabel("Active Minutes: " + api.getActiveMinutes());
        lblActiveMinutes.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblActiveMinutes.setForeground(Color.WHITE);

        JLabel lblSedentayr = new JLabel("Sedentary Minutes: "  + api.getSedentaryMinutes());
        lblSedentayr.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblSedentayr.setForeground(Color.WHITE);
        GroupLayout gl_mininfoPanel = new GroupLayout(mininfoPanel);
        gl_mininfoPanel.setHorizontalGroup(
                gl_mininfoPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_mininfoPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_mininfoPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblActiveMinutes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(lblSedentayr, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)))
        );
        gl_mininfoPanel.setVerticalGroup(
                gl_mininfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mininfoPanel.createSequentialGroup()
                                .addGap(21)
                                .addComponent(lblActiveMinutes, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(lblSedentayr)
                                .addContainerGap())
        );
        mininfoPanel.setLayout(gl_mininfoPanel);

		 /*Movement card */

        //Movement Button
        final JButton movementButton = new JButton("");
        movementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        movementButton.setContentAreaFilled(false);
        movementButton.setBorder(null);
        movementButton.setIcon(cardIcon);
        movementButton.setBorder(null);
        movementButton.setLayout(new BorderLayout());
        movementButton.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {

                //cl.show(panel_3,"6");
                OpenCardListener opencard = new OpenCardListener(3);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});


        //card panel for movement
        JPanel pl3= new JPanel();
        pl3.setOpaque(false);
        movementButton.add(pl3, BorderLayout.NORTH);

        //the label for the title of the movements card
        JLabel lblMovements = new JLabel("Movements");
        lblMovements.setForeground(new Color(255, 255, 255));
        lblMovements.setFont(new Font("Verdana", Font.BOLD, 13));
        lblMovements.setIcon(movementIcon);


        //exit button for movement
        JButton moveExit = new JButton("");
        moveExit. addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( movementButton);
                cardPanel.invalidate();
                cardPanel.repaint();
            }

        });
        moveExit.setContentAreaFilled(false);
        moveExit.setBorder(null);
        moveExit.setIcon(exitIcon);
        moveExit.setBorderPainted(false);
        GroupLayout gl_pl3 = new GroupLayout(pl3);
        gl_pl3.setHorizontalGroup(
                gl_pl3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl3.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblMovements)
                                .addGap(115)
                                .addComponent(moveExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl3.setVerticalGroup(
                gl_pl3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl3.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl3.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblMovements)
                                        .addComponent(moveExit)))
        );
        pl3.setLayout(gl_pl3);




        cardPanel.add(movementButton);;

        JPanel moveinfoPanel= new JPanel();
        moveinfoPanel.setOpaque(false);
        movementButton.add(moveinfoPanel, BorderLayout.CENTER);

        JLabel lblSteps = new JLabel("Steps: " + api.getSteps());
        lblSteps.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblSteps.setForeground(Color.WHITE);

        JLabel lblFloors = new JLabel("Floors: "   + api.getFloors());
        lblFloors.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblFloors.setForeground(Color.WHITE);

        JLabel lblDistance = new JLabel("Distance: "   + api.getDistance());
        lblDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblDistance.setForeground(Color.WHITE);
        GroupLayout gl_moveinfoPanel = new GroupLayout(moveinfoPanel);
        gl_moveinfoPanel.setHorizontalGroup(
                gl_moveinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_moveinfoPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_moveinfoPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_moveinfoPanel.createSequentialGroup()
                                                .addComponent(lblFloors, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                                .addGap(10))
                                        .addComponent(lblSteps, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addGroup(gl_moveinfoPanel.createSequentialGroup()
                                                .addComponent(lblDistance, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        gl_moveinfoPanel.setVerticalGroup(
                gl_moveinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_moveinfoPanel.createSequentialGroup()
                                .addGap(8)
                                .addComponent(lblDistance)
                                .addGap(18)
                                .addComponent(lblFloors)
                                .addGap(20)
                                .addComponent(lblSteps)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        moveinfoPanel.setLayout(gl_moveinfoPanel);

		 /*Lifetime  card*/


        //Lifetime button
        final JButton lifetimeButton = new JButton("");
        lifetimeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lifetimeButton.setContentAreaFilled(false);
        lifetimeButton.setBorder(null);
        lifetimeButton.setIcon(cardIcon);
        lifetimeButton.setLayout(new BorderLayout());
        lifetimeButton .addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {

                //cl.show(panel_3,"7");
                OpenCardListener opencard = new OpenCardListener(4);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");
            }});



        //card panel for lifetime
        JPanel pl4= new JPanel();
        pl4.setOpaque(false);
        pl4.setFont(new Font("Verdana", Font.BOLD, 13));
        pl4.setForeground(new Color(255, 255, 255));
        lifetimeButton.add(pl4,BorderLayout.NORTH);

        //the label for the title of the lifetime card
        JLabel lblLifetime_1 = new JLabel("Lifetime");
        lblLifetime_1.setForeground(new Color(255, 255, 255));
        lblLifetime_1.setFont(new Font("Verdana", Font.BOLD, 13));
        lblLifetime_1.setIcon(lifetimeIcon);

        //exit button for lifetime card
        final JButton lifeExit= new JButton("");
        lifeExit.setContentAreaFilled(false);
        lifeExit. addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove(lifetimeButton);
                cardPanel.invalidate();
                //cardPanel.revalidate();
                cardPanel.repaint();
            }

        });
        lifeExit.setIcon(exitIcon);
        lifeExit.setBorder(null);
        lifeExit.setBorderPainted(false);
        GroupLayout gl_pl4 = new GroupLayout(pl4);
        gl_pl4.setHorizontalGroup(
                gl_pl4.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl4.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblLifetime_1)
                                .addGap(125)
                                .addComponent(lifeExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl4.setVerticalGroup(
                gl_pl4.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl4.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl4.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblLifetime_1)
                                        .addComponent(lifeExit)))
        );
        pl4.setLayout(gl_pl4);
        cardPanel.add(lifetimeButton);;

        JPanel lifeinfoPanel= new JPanel();
        lifeinfoPanel.setOpaque(false);
        lifetimeButton.add(lifeinfoPanel, BorderLayout.CENTER);

        JLabel lblNewLabel_2 = new JLabel("Lifetime Floors: "   + api.getLifeTimeFloors());
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblNewLabel_2.setForeground(Color.WHITE);

        JLabel lblNewLabel_1 = new JLabel("Lifetime Steps: "   + api.getLifetimeSteps());
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));

        JLabel lblLifetimeCalories = new JLabel("Lifetime Distance: "   + api.getLifetimeDistance());
        lblLifetimeCalories.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblLifetimeCalories.setForeground(Color.WHITE);
        GroupLayout gl_lifeinfoPanel = new GroupLayout(lifeinfoPanel);
        gl_lifeinfoPanel.setHorizontalGroup(
                gl_lifeinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_lifeinfoPanel.createSequentialGroup()
                                .addGroup(gl_lifeinfoPanel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(Alignment.LEADING, gl_lifeinfoPanel.createSequentialGroup()
                                                .addGap(8)
                                                .addComponent(lblNewLabel_2))
                                        .addGroup(Alignment.LEADING, gl_lifeinfoPanel.createSequentialGroup()
                                                .addGap(9)
                                                .addGroup(gl_lifeinfoPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblLifetimeCalories, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 106, Short.MAX_VALUE)
                                                        .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                                .addGap(0))
        );
        gl_lifeinfoPanel.setVerticalGroup(
                gl_lifeinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_lifeinfoPanel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblNewLabel_2)
                                .addGap(21)
                                .addComponent(lblNewLabel_1)
                                .addGap(23)
                                .addComponent(lblLifetimeCalories)
                                .addContainerGap())
        );
        lifeinfoPanel.setLayout(gl_lifeinfoPanel);
			 /*Time Series card*/

        //Time Series button
        final JButton timeseriesButton = new JButton("");
        timeseriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        timeseriesButton.setContentAreaFilled(false);
        timeseriesButton.setBorder(null);
        timeseriesButton.setIcon(cardIcon);
        timeseriesButton.setLayout(new BorderLayout());
        timeseriesButton.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {

                //cl.show(panel_3,"8");
                OpenCardListener opencard = new OpenCardListener(5);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});


        //card panel for time series
        JPanel pl5= new JPanel();
        pl5.setOpaque(false);
        pl5.setFont(new Font("Verdana", Font.BOLD, 13));
        pl5.setForeground(new Color(255, 255, 255));

        timeseriesButton.add(pl5,BorderLayout.NORTH);

        //the label for the title of the time series card
        JLabel lblTimeSeries = new JLabel("Time Series");
        lblTimeSeries.setForeground(Color.WHITE);
        lblTimeSeries.setFont(new Font("Verdana", Font.BOLD, 13));
        lblTimeSeries.setIcon(timeseriesIcon);

        //Exit button for time series card
        JButton timeExit = new JButton("");
        timeExit. addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( timeseriesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
            }

        });
        timeExit.setContentAreaFilled(false);
        timeExit.setIcon(exitIcon);
        timeExit.setBorder(null);
        timeExit.setBorderPainted(false);
        GroupLayout gl_pl5 = new GroupLayout(pl5);
        gl_pl5.setHorizontalGroup(
                gl_pl5.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl5.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblTimeSeries)
                                .addGap(105)
                                .addComponent(timeExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl5.setVerticalGroup(
                gl_pl5.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl5.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl5.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblTimeSeries)
                                        .addComponent(timeExit)))
        );
        pl5.setLayout(gl_pl5);

        cardPanel.add(timeseriesButton);

			 /*Best Days*/


        //Best Days button

        final JButton bestdayButton = new JButton("");
        bestdayButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bestdayButton.setContentAreaFilled(false);
        bestdayButton.setBorder(null);
        bestdayButton.setIcon(cardIcon);
        bestdayButton.setLayout(new BorderLayout());
        bestdayButton.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {


                //cl.show(panel_3,"9");
                OpenCardListener opencard = new OpenCardListener(6);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});

        //card panel for best day
        JPanel pl6= new JPanel();
        pl6.setOpaque(false);
        pl6.setFont(new Font("Verdana", Font.BOLD, 13));
        pl6.setForeground(new Color(255, 255, 255));
        bestdayButton.add(pl6,BorderLayout.NORTH);

        //the label for the title of the best days card
        JLabel lblBestDays_1 = new JLabel("Best Days");
        lblBestDays_1.setFont(new Font("Verdana", Font.BOLD, 13));
        lblBestDays_1.setForeground(Color.WHITE);
        lblBestDays_1.setIcon(bestdayIcon);

        //exit button for best days card
        JButton bestExit = new JButton("");
        bestExit. addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( bestdayButton);
                cardPanel.invalidate();
                cardPanel.repaint();
            }

        });
        bestExit.setContentAreaFilled(false);
        bestExit.setBorder(null);
        bestExit.setIcon(exitIcon);
        bestExit.setBorderPainted(false);
        GroupLayout gl_pl6 = new GroupLayout(pl6);
        gl_pl6.setHorizontalGroup(
                gl_pl6.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl6.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblBestDays_1)
                                .addGap(125)
                                .addComponent(bestExit))
        );
        gl_pl6.setVerticalGroup(
                gl_pl6.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl6.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl6.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblBestDays_1)
                                        .addComponent(bestExit)))
        );
        pl6.setLayout(gl_pl6);
        cardPanel.add(bestdayButton);

        JPanel bestinfoPanel= new JPanel();
        bestinfoPanel.setOpaque(false);
        bestdayButton.add(bestinfoPanel, BorderLayout.CENTER);

        JLabel lblBestFloors = new JLabel("Best Floors: "   + api.getBestFloors());
        lblBestFloors.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblBestFloors.setForeground(Color.WHITE);

        JLabel lblBestSteps = new JLabel("Best Steps: "   + api.getBestSteps());
        lblBestSteps.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblBestSteps.setForeground(Color.WHITE);

        JLabel lblBestDistance = new JLabel("Best Distance: "   + api.getBestDistance());
        lblBestDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblBestDistance.setForeground(Color.WHITE);
        GroupLayout gl_bestinfoPanel = new GroupLayout(bestinfoPanel);
        gl_bestinfoPanel.setHorizontalGroup(
                gl_bestinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bestinfoPanel.createSequentialGroup()
                                .addGap(11)
                                .addComponent(lblBestFloors, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(21))
                        .addGroup(gl_bestinfoPanel.createSequentialGroup()
                                .addGap(12)
                                .addComponent(lblBestSteps, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14))
                        .addGroup(Alignment.TRAILING, gl_bestinfoPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBestDistance, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_bestinfoPanel.setVerticalGroup(
                gl_bestinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bestinfoPanel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblBestFloors)
                                .addGap(21)
                                .addComponent(lblBestSteps)
                                .addGap(25)
                                .addComponent(lblBestDistance)
                                .addContainerGap())
        );
        bestinfoPanel.setLayout(gl_bestinfoPanel);
        /**
         * End of the card panel and it's subcomponent set up.
         */

        
        
        /**
         * The left and right arrows are on the actual daspanel,
         * in the west and east borers of it's layout respectively.         * 
         */
        
        //Left Arrow
        JButton leftarrow = new JButton("");
        leftarrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        leftarrow.setBorder(null);
        leftarrow.setBorderPainted(false);
        leftarrow.setContentAreaFilled(false);
        leftarrow.setOpaque(false);
        leftarrow.setIcon(leftarrowIcon);
        dashPanel.add(leftarrow, BorderLayout.WEST);


        //RightArrow
        JButton rightarrow = new JButton("");
        rightarrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rightarrow.setBorder(null);
        rightarrow.setContentAreaFilled(false);
        rightarrow.setBorderPainted(false);
        rightarrow.setOpaque(false);
        rightarrow.setIcon(rightarrowIcon);
        dashPanel.add(rightarrow, BorderLayout.EAST);

        
        
        /**
         *panel_15 is a panel that acts as a taskbar in the south border of the dashpanel, 
         *holding the settings, trophy and other buttons 
         */
        
		/*Trophy*/

        //setting the panel for trophy
        JPanel panel_15 = new JPanel();
        panel_15.setOpaque(false);
        dashPanel.add(panel_15, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(105, 105, 105,180));
        GroupLayout gl_panel_15 = new GroupLayout(panel_15);
        gl_panel_15.setHorizontalGroup(
                gl_panel_15.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        gl_panel_15.setVerticalGroup(
                gl_panel_15.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_15.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        );
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
        trophyButton.setBorderPainted(false);
        trophyButton.setIcon(new ImageIcon("../src/main/resources/Trophy2.png"));

        JButton btnJodimarie = new JButton("Jodi-Marie");
        btnJodimarie.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        btnJodimarie.setForeground(new Color(255, 255, 255));
        btnJodimarie.setContentAreaFilled(false);
        btnJodimarie.setBorder(null);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(323, Short.MAX_VALUE)
                                .addComponent(btnJodimarie, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(trophyButton))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(btnJodimarie, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(trophyButton, Alignment.LEADING))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        trophyButton.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {
            	TrophyPanel trophypanel = new TrophyPanel();
                panel_3.add( trophypanel,"11") ;    
                cl.show(panel_3,"11");

            }});
        panel_15.setLayout(gl_panel_15);
        /**
         * End of panel_15 set up
         */
        
        
        
        /**
         * panel_16 acts as a title bar,
         * holding the date in the north border of the dashpanel.         * 
         */
        JPanel panel_16 = new JPanel();
        panel_16.setOpaque(false);
        panel_16.setBackground(new Color(169, 169, 169,100));


		/*Today Title*/

        Date dateAndTime = Calendar.getInstance().getTime();// can be used to display time if added to panel
        dashPanel.add(panel_16, BorderLayout.NORTH);
        JLabel lblToday = new JLabel("Today");
        lblToday.setBackground(new Color(105, 105, 105,180));
        lblToday.setOpaque(true);
        lblToday.setForeground(new Color(255, 255, 255));
        lblToday.setHorizontalAlignment(SwingConstants.CENTER);
        lblToday.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        GroupLayout gl_panel_16 = new GroupLayout(panel_16);
        gl_panel_16.setHorizontalGroup(
                gl_panel_16.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblToday, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        gl_panel_16.setVerticalGroup(
                gl_panel_16.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_16.createSequentialGroup()
                                .addComponent(lblToday, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        panel_16.setLayout(gl_panel_16);
        /**
         * End of panel_16 set up 
         */

        //CaloriesPanel panel_1 = new CaloriesPanel();
        //panel_3.add(panel_1, "5");

        JButton settingsbutton = new JButton("");
        settingsbutton.setContentAreaFilled(false);
        settingsbutton.setBorder(null);
        settingsbutton.setBorderPainted(false);
        settingsbutton.setIcon(new ImageIcon("../src/main/resources/Gear-icon2.png"));
        GroupLayout gl_panel1= new GroupLayout(panel);
        gl_panel1.setHorizontalGroup(
                gl_panel1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel1.createSequentialGroup()
                                .addContainerGap(292, Short.MAX_VALUE)
                                .addComponent(btnJodimarie, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(settingsbutton)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(trophyButton))
        );
        gl_panel1.setVerticalGroup(
                gl_panel1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel1.createSequentialGroup()
                                .addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(settingsbutton)
                                        .addComponent(trophyButton)
                                        .addComponent(btnJodimarie, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                .addContainerGap())
        );
        panel.setLayout(gl_panel1);

    }

}

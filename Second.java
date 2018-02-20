import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class sec extends JFrame{
	public JButton calc;
	public JTextField field;
	public JTextField low;
	public JTextField high;
	public JTextField max;
	public JPanel panel;
	public JPanel panel2;
	public JPanel panel3;
	public JPanel panel4;
	public JPanel panel5;
	public JPanel panel6;
	public JPanel panel7;
	public JPanel panel8;
	public JPanel panel9;
	public JPanel panel10;
	public JPanel panel11;
	public JLabel la;
	GridBagConstraints g = new GridBagConstraints();
	public int x;
	public int num1;
	public int a;
	public int b;
	public int c;
	public double d;
	public double num2;
	public double num3;
	public int num4;
	public sec(){
		super("Heart Rate Calculator");
		setLayout(new GridLayout());
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();
		la = new JLabel("Target and Maximum Heart Rate Calculator");
		JLabel lq = new JLabel("DISCLAIMER: This may not be your actual heart rate. Consult a doctor to find accurate results");
		lq.setFont(new Font("Serif", Font.PLAIN, 8));
		panel11.add(lq);
		
		la.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(la);
		
		JLabel l = new JLabel("1. Enter Your Age ");
		
		JLabel lo = new JLabel("2. Click Calculate");
		
		JLabel t = new JLabel();
		
		panel9.add(t);
		panel2.add(l);
		panel3.add(lo);
		
		
		low = new JTextField();
		high = new JTextField();
		max = new JTextField();
		
		low.setPreferredSize(new Dimension(120, 60));
		high.setPreferredSize(new Dimension(120, 60));
		max.setPreferredSize(new Dimension(120, 60));
		
		low.setEditable(false);
		high.setEditable(false);
		max.setEditable(false);
		
		panel4.add(low);
		panel5.add(high);
		panel6.add(max);
		
		JLabel label = new JLabel("Lower Bound- 50%");
		JLabel lab = new JLabel("Upper Bound- 85%");
		JLabel lab2 = new JLabel("Max HeartRate- 100%");
		panel4.add(label);
		panel5.add(lab);
		panel6.add(lab2);
		calc = new JButton("Calculate");
		calc.setPreferredSize(new Dimension(120, 60));
		panel7.add(calc);

		
		field = new JTextField("37");
		field.setPreferredSize(new Dimension(120, 60));
		panel8.add(field);
		field.addKeyListener(
			new KeyListener(){

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					char a = e.getKeyChar();
					if(!(Character.isDigit(a)) || a == KeyEvent.VK_BACK_SPACE || a == KeyEvent.VK_DELETE){
						e.consume();
					}
					
				}
				
			}
				
		);
		calc.addActionListener(
				new ActionListener(){

					
					public void actionPerformed(ActionEvent f) {
						try{
							if(Integer.parseInt(field.getText()) <= 220){
								double l = maxheart(Integer.parseInt(field.getText()));
								a = (int) l;
								if(a == l){
									max.setText(Integer.toString(a)+ " BPM");
								}
								else{
									field.setText("Invalid Input");
								}
								double w = lowheart(Integer.parseInt(field.getText()));
								b = (int) Math.round(w);
								low.setText(Integer.toString(b)+ " BPM");
								double y = highheart(Integer.parseInt(field.getText()));
								c = (int) Math.round(y);
								high.setText(Integer.toString(c)+ " BPM");
								t.setText("Your target zone is between "+ b+" BPM and "+ c+ " BPM. Your maximum heart rate is "+ a+ " BPM.");
							}
							else{
								field.setText("Invalid Input");
							}
						}catch(Exception e){
							field.setText("Invalid Input");
						}
					}
					
				}
				
				
				
		);
		
		
		//label.setBounds(200,200, 120, 25);
//		add(label);
		panel10.add(panel);
		panel10.add(panel2);
		panel10.add(panel3);
		panel10.add(panel8);
		panel10.add(panel7);
		panel10.add(panel4);
		panel10.add(panel5);
		panel10.add(panel6);
		panel10.add(panel9);
		panel10.add(panel11);
		panel10.setLayout(new BoxLayout(panel10, BoxLayout.PAGE_AXIS));
		panel10.add(Box.createVerticalGlue());
		add(panel10);
	}
	
	public double maxheart(int a){
		int b = 220-a;
		return(b);
	}
	public double lowheart(int a){
		double c = (220-a) * 0.5;
		return(c);
	}
	public double highheart(int a){
		double d = (220-a) * 0.85;
		return(d);
	}
}

package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class jframe {
	public static String ipinfinal;
	public static String ipinfinal1;

	public String ipaddress() throws UnknownHostException {
		InetAddress ip;
		ip = Inet4Address.getLocalHost();
		String hadd = ip.getHostAddress();
		return hadd;
	}

	public String iphost() throws UnknownHostException {
		InetAddress ip;
		ip = Inet4Address.getLocalHost();
		String hname = ip.getHostName();
		return hname;

	}

	public void putadd(String URI) {
		InetAddress ip;
		try {
			ip = Inet4Address.getByName(URI);
			ipinfinal = ip.getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println("The Address is unreachable");
		}
	}
	/*
	 * public void putip(byte[] ip) { InetAddress ip1; try { ip1 =
	 * Inet4Address.getByAddress(ip); ipinfinal1 = ip1.getHostName(); } catch
	 * (UnknownHostException e) { System.out.println("The Address is unreachable");
	 * } }
	 */

	public static void main(String[] args) throws UnknownHostException {
		JFrame f = new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("world.jpg")));
		JLabel label = new JLabel("KNOW YOUR IP", SwingConstants.HORIZONTAL);
		label.setVisible(true);
		f.add(label);
		jframe ipshow = new jframe();
		f.setSize(400, 500);
		f.setVisible(true);
		f.setTitle("Know Your IP");
		JButton bhip = new JButton("GET IP");
		bhip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "Your IP Address is: " + ipshow.ipaddress());
				} catch (UnknownHostException e1) {
					System.out.println("Sorry can't find your IP!!");
				}
			}

		});
		bhip.setBounds(130, 100, 100, 40);
		bhip.setEnabled(true);
		f.add(bhip);
		JButton bhname = new JButton("GET HOST NAME");
		bhname.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "Your host name is: " + ipshow.iphost());
				} catch (UnknownHostException e2) {
					System.out.println("Sorry can't find your HOST!!");
				}
			}

		});
		bhname.setBounds(120, 200, 130, 40);
		bhname.setEnabled(true);
		f.add(bhname);
		JButton bhadin = new JButton("FIND ANY IP");
		bhadin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str1 = JOptionPane.showInputDialog("Enter the url");
				String URI = str1;
				ipshow.putadd(URI);
				JOptionPane.showMessageDialog(null, ipinfinal, "IP Address of " + str1 + " is:",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		bhadin.setBounds(120, 300, 140, 40);
		bhadin.setEnabled(true);
		f.add(bhadin);
		/*
		 * JButton bhnamein = new JButton("FIND ANY HOSTNAME");
		 * bhnamein.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub String str1 = JOptionPane.showInputDialog("Enter the IP"); byte[]
		 * ip = Integer.parseInt(str1); ipshow.putip(ip);;
		 * //JOptionPane.showMessageDialog( null, "The IP Address of " +URI+ "is" +);
		 * JOptionPane.showMessageDialog(null, ipinfinal1, "IP Address of "+str1+" is:",
		 * JOptionPane.INFORMATION_MESSAGE); } }); bhnamein.setBounds(120,400,190, 40);
		 * bhnamein.setEnabled(true); f.add(bhnamein);
		 */
		JButton exit = new JButton("CLOSE");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		exit.setBounds(120, 400, 130, 40);
		exit.setEnabled(true);
		f.add(exit);
	}
}

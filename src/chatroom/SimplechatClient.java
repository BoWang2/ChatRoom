package chatroom;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimplechatClient {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go()
	{
		JFrame frame = new JFrame("simple chat client");
		JPanel mainPanel  = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("send"); 
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		setUpNetworking();
		frame.setSize(400,500);
		frame.setVisible(true);
	}//close go
	
	
	
	public void setUpNetworking()
	{
		try {
			sock = new Socket("127.0.0.1",5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
			
		}catch (IOException ex)
		{
			ex.printStackTrace();
		}//close setUpNetworking
		
		
		
		
		public class SendButtonListener implements ActionListner
		{
			public void actionPerformed(ActionEvent ev)
			{
				try {
					writer.println(outgoing.getText());
					writer.flush();
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
					
				}
				outgoing.setText("");
				outgoing.requestFocus();
			}
			
		}//close the inner class of SendbuttonListener 
		public static void main(String[] args)
		{
			new SimplechatClient().go();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}

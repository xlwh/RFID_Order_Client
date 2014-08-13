package login;



import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.*;

import socketclient.SocketClient;
import userClient.LowerUserClient;
import userClient.ManagerClient;
import userClient.SuperUserClient;




//import com.sun.corba.se.pept.transport.Connection;

public class Login extends JFrame implements ActionListener{
	SocketClient c;
	Vector<String> v_result= new Vector<String>();
  /**
	 * 
	 */
	private static final long serialVersionUID = -7074080447312106651L;

  private JPanel jp = new JPanel();                  //������ſؼ��Ļ���
  private JLabel jl_up = new JLabel();
  private JLabel jl1 = new JLabel("��             ��           ��:");         //�����û�����ʾ��ǩ
  private JLabel jl2 = new JLabel("��                           ��:");         //����������ʾ��ǩ
  private JLabel jl3 = new JLabel("");                            //�������ڵ�½��ʾ��ǩ
  private JTextField hostport = new JTextField();                 //�����˿ں������
  private JTextField hostaddress = new JTextField();              //����IP��ַ�����
  private JTextField jtf = new JTextField();                      //�����û��������
  private JPasswordField jpwf = new JPasswordField();             //�������������
  private JRadioButton[] jrbArray = {new JRadioButton("����Ա",true)
		                            ,new JRadioButton("�����û�")
  									,new JRadioButton("��ͨ�û�")};  //������ѡ��ť
  private ButtonGroup bg = new ButtonGroup();                     //������
  private JButton jb2 = new JButton("��¼");                     //������¼������ť
  private JButton jb1 = new JButton("����");                     //�������ð�ť
  
  
  public Login(){     //������                                        
	  this.addListener();
	  this.initialFrame();
  }
  
  public void addListener(){
	  this.jb1.addActionListener(this);
	  this.jb2.addActionListener(this);
	  this.jtf.addActionListener(this);
	  this.jpwf.addActionListener(this);
	  this.hostport.addActionListener(this);
	  this.hostaddress.addActionListener(this);
	
  }
  
  public void initialFrame(){
	  jp.setLayout(null);
	  jp.setBackground(new java.awt.Color(211, 255, 255));
	  
	  
	  this.jl_up.setBounds(0, 0, 300, 70);
	  String picPath = System.getProperty("user.dir")+ File.separator + "picture" + File.separator + "login.jpg"; 
      Icon icon = new ImageIcon(picPath);
      jl_up.setIcon(icon); 
      this.add(jl_up);

	  this.jl1.setBounds(30,100,150,25);this.add(jl1);this.jtf.setBounds(150,100,100,25);this.add(jtf);
	  this.jl2.setBounds(30,140,150,25);this.add(jl2);this.jpwf.setBounds(150,140,100,25);this.add(jpwf);
	  
	  this.jrbArray[0].setBounds(30,190,80,25);this.jrbArray[0].setBackground(new java.awt.Color(211, 255, 255));bg.add(jrbArray[0]);this.add(jrbArray[0]);        //��ѡ��
	  this.jrbArray[1].setBounds(110,190,80,25);this.jrbArray[1].setBackground(new java.awt.Color(211, 255, 255));bg.add(jrbArray[1]);this.add(jrbArray[1]);
	  this.jrbArray[2].setBounds(190,190,80,25);this.jrbArray[2].setBackground(new java.awt.Color(211, 255, 255));bg.add(jrbArray[2]);this.add(jrbArray[2]);
	  
	  this.jb1.setBounds(50,230,80,25);this.add(jb1);                       //ȷ�����ð�ť
	  this.jb2.setBounds(150,230,80,25);this.add(jb2);
	  
	  this.jl3.setBounds(30,260,150,25);this.jp.add(jl3);this.add(jp);
	  
	  this.setTitle("��¼");
	  Image image = new ImageIcon("ico.ico").getImage();                   //��ȡͼ��
	  this.setIconImage(image);                                            //���ô���ͼ��
	  this.setResizable(false);                              //���ô��岻�ɵ�����С
	  this.setIconImage(image);this.setTitle("��¼����");//���ô����ͼ��ͱ���
 	 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//�õ���Ļ��dimension����С��ֵ
 	 int centerX = screensize.width/2;//�õ���Ļ��ȵ��м����ص�
 	 int centerY = screensize.height/2;//�õ���Ļ�߶ȵ��м����ص�
 	 int w =300;//��������
 	 int h =320;//������߶�
 	 this.setBounds(centerX-w/2,centerY-h/2,w,h);//���ô����������Ļ���룻
 	                                                //setBounts:�ƶ�������������С��ʹ������µ��н���� r���� r.x �� r.y ָ���������λ�ã��� r.width �� r.height ָ��������´�С 
 	 this.setVisible(true); 
	 
 	 this.hostaddress.requestFocus(true);
 	 this.hostaddress.setText("127.0.0.1");
 	 this.hostport.setText("3306");
  }
  
  
  @SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e){
	  String sql = null;
	  String pwd = this.jpwf.getText().trim();
	  String id = this.jtf.getText().trim();
	  
	  int type = 0;
	   
	  if(e.getSource() == this.jb2){
		  this.jl3.setText("������֤��Ϣ�����Ժ�.........");
		  if(id.equals("")){
			  JOptionPane.showMessageDialog(this, "�������û���","����",JOptionPane.ERROR_MESSAGE);       //��������Ի���
				jl3.setText("");
			  return;
		  }
		 
		  else if(pwd.equals("")){
			  JOptionPane.showMessageDialog(this, "����������",  "����",JOptionPane.ERROR_MESSAGE);       //��������Ի���
				jl3.setText("");
			  return;
		  }
	 else{
		
		 if( this.jrbArray[0].isSelected()){         //�û����ͣ�
			 type = 0;
		 }
		 else if( this.jrbArray[1].isSelected()){         //�û����ͣ�
			 type = 1;
		 }
		 else if( this.jrbArray[2].isSelected()){         //�û����ͣ�
			 type = 2;
		 }
		 
		 
		 
		  
		//����Ա��¼
		if(type == 0){                                      
		sql = "select manager_id from manager where " +
		"manager_Id = '" + id + "'and pwd = '" + pwd + "'";
			try {
					 c = new SocketClient(sql,1);                           //ʵ����Client����
					 c.send();                                        //��sql��䷢�͸��������˴���
					 v_result = new Vector<String>();
					 v_result = c.getV_result();	                  //�õ���ѯ���ݿ��Ľ��
				} catch(Exception e1){e1.printStackTrace(); }                        //��ѯ���ݿ�
		   if(v_result.size()!=0){
				 ManagerClient mc =new ManagerClient();
				 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//�õ���Ļ��dimension����С��ֵ
		    	 int centerX = screensize.width/2;//�õ���Ļ��ȵ��м����ص�
		    	 int centerY = screensize.height/2;//�õ���Ļ�߶ȵ��м����ص�
		    	 int w =900;//��������
		    	 int h =750;//������߶�
		    	 mc.setBounds(centerX-w/2,centerY-h/2,w,h);//���ô����������Ļ���룻
				  mc.setVisible(true); }
			else {
				 	 JOptionPane.showMessageDialog(this, "�û������������",
						     "����",JOptionPane.ERROR_MESSAGE);       //��������Ի���
					 jl3.setText("");
			}
		}
		
		
		//�����û���¼
		else if (type == 1){                                               //��ͨ�û���¼
				 sql = "select user_Id from superusers where " +
				 "user_Id = '" + id + "'and pwd = '" + pwd + "'";
				 try {
					 c = new SocketClient(sql,1);                           //ʵ����Client����
					 c.send();                                        //��sql��䷢�͸��������˴���
					 v_result = new Vector<String>();
					 v_result = c.getV_result();	                  //�õ���ѯ���ݿ��Ľ��
					} catch(Exception e1){e1.printStackTrace(); }                        //��ѯ���ݿ�
				   if(v_result.size()!=0){
					  SuperUserClient superuser= new SuperUserClient(id);
					 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//�õ���Ļ��dimension����С��ֵ
			    	 int centerX = screensize.width/2;//�õ���Ļ��ȵ��м����ص�
			    	 int centerY = screensize.height/2;//�õ���Ļ�߶ȵ��м����ص�
			    	 int w =900;//��������
			    	 int h =750;//������߶�
			    	 superuser.setBounds(centerX-w/2,centerY-h/2,w,h);//���ô����������Ļ���룻
			    	 superuser.setVisible(true);
				   }
				  else {
				 	 JOptionPane.showMessageDialog(this, "�û������������",
						     "����",JOptionPane.ERROR_MESSAGE);       //��������Ի���
					 jl3.setText("");
				 }}
		
		
		
		//��ͨ�û���¼
		  else if (type == 2){                                               //��ͨ�û���¼
			sql = "select lower_userId from lowerusers where " +
			"lower_userId = '" + id + "'and pwd = '" + pwd + "'";
			   try {
			    c = new SocketClient(sql,1);                           //ʵ����Client����
				 c.send();                                        //��sql��䷢�͸��������˴���
				 v_result = new Vector<String>();
				 v_result = c.getV_result();	                  //�õ���ѯ���ݿ��Ľ��
				} catch(Exception e1){e1.printStackTrace(); }                        //��ѯ���ݿ�
				if(v_result.size()!=0){
					LowerUserClient loweruser = new LowerUserClient(id);
					System.out.println(loweruser.getUserId());
//					loweruser.setUserId("122");
					Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//�õ���Ļ��dimension����С��ֵ
			    	 int centerX = screensize.width/2;//�õ���Ļ��ȵ��м����ص�
			    	 int centerY = screensize.height/2;//�õ���Ļ�߶ȵ��м����ص�
			    	 int w =900;//��������
			    	 int h =750;//������߶�
			    	 loweruser.setBounds(centerX-w/2,centerY-h/2,w,h);//���ô����������Ļ���룻
			    	 loweruser.setVisible(true);
					System.out.println(loweruser.getUserId());
				}
				 else {
				 JOptionPane.showMessageDialog(this, "�û������������",
				   "����",JOptionPane.ERROR_MESSAGE);       //��������Ի���
					 jl3.setText("");
						}	   
			 }
		 }
	  }
		
	  else if(e.getSource() == this.jb1){
			  this.jtf.setText("");
			  this.jpwf.setText("");
	  }
	  else if(e.getSource() == jtf){
		  this.jpwf.requestFocus(true);
	  }
	  else if(e.getSource()== jpwf){
		  this.jb1.requestFocus(true);
	  }
	  else if (e.getSource()== this.hostaddress){
		  this.hostport.requestFocus(true);
	  }
	  else if(e.getSource() == hostport){
		  this.jtf.requestFocus(true);
	  }
	  
  }
  
  public void close()
  {
	  this.setVisible(false);
  }
  
  
  public static void main(String args[]){
	  Login lg = new Login();
	  //lg.close();
	  
  }
  
  
  
  }
 
  


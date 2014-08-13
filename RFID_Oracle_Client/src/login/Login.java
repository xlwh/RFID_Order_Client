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

  private JPanel jp = new JPanel();                  //用来存放控件的画板
  private JLabel jl_up = new JLabel();
  private JLabel jl1 = new JLabel("用             户           号:");         //创建用户名提示标签
  private JLabel jl2 = new JLabel("密                           码:");         //创建密码提示标签
  private JLabel jl3 = new JLabel("");                            //创建正在登陆提示标签
  private JTextField hostport = new JTextField();                 //创建端口号输入框
  private JTextField hostaddress = new JTextField();              //创建IP地址输入框
  private JTextField jtf = new JTextField();                      //创建用户名输入框
  private JPasswordField jpwf = new JPasswordField();             //创建密码输入框
  private JRadioButton[] jrbArray = {new JRadioButton("管理员",true)
		                            ,new JRadioButton("超级用户")
  									,new JRadioButton("普通用户")};  //创建单选按钮
  private ButtonGroup bg = new ButtonGroup();                     //创建组
  private JButton jb2 = new JButton("登录");                     //创建登录操作按钮
  private JButton jb1 = new JButton("重置");                     //创建重置按钮
  
  
  public Login(){     //构造器                                        
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
	  
	  this.jrbArray[0].setBounds(30,190,80,25);this.jrbArray[0].setBackground(new java.awt.Color(211, 255, 255));bg.add(jrbArray[0]);this.add(jrbArray[0]);        //单选框
	  this.jrbArray[1].setBounds(110,190,80,25);this.jrbArray[1].setBackground(new java.awt.Color(211, 255, 255));bg.add(jrbArray[1]);this.add(jrbArray[1]);
	  this.jrbArray[2].setBounds(190,190,80,25);this.jrbArray[2].setBackground(new java.awt.Color(211, 255, 255));bg.add(jrbArray[2]);this.add(jrbArray[2]);
	  
	  this.jb1.setBounds(50,230,80,25);this.add(jb1);                       //确定重置按钮
	  this.jb2.setBounds(150,230,80,25);this.add(jb2);
	  
	  this.jl3.setBounds(30,260,150,25);this.jp.add(jl3);this.add(jp);
	  
	  this.setTitle("登录");
	  Image image = new ImageIcon("ico.ico").getImage();                   //获取图标
	  this.setIconImage(image);                                            //设置窗口图标
	  this.setResizable(false);                              //设置窗体不可调整大小
	  this.setIconImage(image);this.setTitle("登录窗口");//设置窗体的图标和标题
 	 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//得到屏幕的dimension（大小）值
 	 int centerX = screensize.width/2;//得到屏幕宽度的中间像素点
 	 int centerY = screensize.height/2;//得到屏幕高度得中间像素点
 	 int w =300;//本窗体宽度
 	 int h =320;//本窗体高度
 	 this.setBounds(centerX-w/2,centerY-h/2,w,h);//设置窗体出现在屏幕中央；
 	                                                //setBounts:移动组件并调整其大小，使其符合新的有界矩形 r。由 r.x 和 r.y 指定组件的新位置，由 r.width 和 r.height 指定组件的新大小 
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
		  this.jl3.setText("正在验证信息，请稍后.........");
		  if(id.equals("")){
			  JOptionPane.showMessageDialog(this, "请输入用户名","错误",JOptionPane.ERROR_MESSAGE);       //弹出错误对话框
				jl3.setText("");
			  return;
		  }
		 
		  else if(pwd.equals("")){
			  JOptionPane.showMessageDialog(this, "请输入密码",  "错误",JOptionPane.ERROR_MESSAGE);       //弹出错误对话框
				jl3.setText("");
			  return;
		  }
	 else{
		
		 if( this.jrbArray[0].isSelected()){         //用户类型：
			 type = 0;
		 }
		 else if( this.jrbArray[1].isSelected()){         //用户类型：
			 type = 1;
		 }
		 else if( this.jrbArray[2].isSelected()){         //用户类型：
			 type = 2;
		 }
		 
		 
		 
		  
		//管理员登录
		if(type == 0){                                      
		sql = "select manager_id from manager where " +
		"manager_Id = '" + id + "'and pwd = '" + pwd + "'";
			try {
					 c = new SocketClient(sql,1);                           //实例化Client对象
					 c.send();                                        //将sql语句发送给服务器端处理
					 v_result = new Vector<String>();
					 v_result = c.getV_result();	                  //得到查询数据库后的结果
				} catch(Exception e1){e1.printStackTrace(); }                        //查询数据库
		   if(v_result.size()!=0){
				 ManagerClient mc =new ManagerClient();
				 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//得到屏幕的dimension（大小）值
		    	 int centerX = screensize.width/2;//得到屏幕宽度的中间像素点
		    	 int centerY = screensize.height/2;//得到屏幕高度得中间像素点
		    	 int w =900;//本窗体宽度
		    	 int h =750;//本窗体高度
		    	 mc.setBounds(centerX-w/2,centerY-h/2,w,h);//设置窗体出现在屏幕中央；
				  mc.setVisible(true); }
			else {
				 	 JOptionPane.showMessageDialog(this, "用户名或密码错误",
						     "错误",JOptionPane.ERROR_MESSAGE);       //弹出错误对话框
					 jl3.setText("");
			}
		}
		
		
		//超级用户登录
		else if (type == 1){                                               //普通用户登录
				 sql = "select user_Id from superusers where " +
				 "user_Id = '" + id + "'and pwd = '" + pwd + "'";
				 try {
					 c = new SocketClient(sql,1);                           //实例化Client对象
					 c.send();                                        //将sql语句发送给服务器端处理
					 v_result = new Vector<String>();
					 v_result = c.getV_result();	                  //得到查询数据库后的结果
					} catch(Exception e1){e1.printStackTrace(); }                        //查询数据库
				   if(v_result.size()!=0){
					  SuperUserClient superuser= new SuperUserClient(id);
					 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//得到屏幕的dimension（大小）值
			    	 int centerX = screensize.width/2;//得到屏幕宽度的中间像素点
			    	 int centerY = screensize.height/2;//得到屏幕高度得中间像素点
			    	 int w =900;//本窗体宽度
			    	 int h =750;//本窗体高度
			    	 superuser.setBounds(centerX-w/2,centerY-h/2,w,h);//设置窗体出现在屏幕中央；
			    	 superuser.setVisible(true);
				   }
				  else {
				 	 JOptionPane.showMessageDialog(this, "用户名或密码错误",
						     "错误",JOptionPane.ERROR_MESSAGE);       //弹出错误对话框
					 jl3.setText("");
				 }}
		
		
		
		//普通用户登录
		  else if (type == 2){                                               //普通用户登录
			sql = "select lower_userId from lowerusers where " +
			"lower_userId = '" + id + "'and pwd = '" + pwd + "'";
			   try {
			    c = new SocketClient(sql,1);                           //实例化Client对象
				 c.send();                                        //将sql语句发送给服务器端处理
				 v_result = new Vector<String>();
				 v_result = c.getV_result();	                  //得到查询数据库后的结果
				} catch(Exception e1){e1.printStackTrace(); }                        //查询数据库
				if(v_result.size()!=0){
					LowerUserClient loweruser = new LowerUserClient(id);
					System.out.println(loweruser.getUserId());
//					loweruser.setUserId("122");
					Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//得到屏幕的dimension（大小）值
			    	 int centerX = screensize.width/2;//得到屏幕宽度的中间像素点
			    	 int centerY = screensize.height/2;//得到屏幕高度得中间像素点
			    	 int w =900;//本窗体宽度
			    	 int h =750;//本窗体高度
			    	 loweruser.setBounds(centerX-w/2,centerY-h/2,w,h);//设置窗体出现在屏幕中央；
			    	 loweruser.setVisible(true);
					System.out.println(loweruser.getUserId());
				}
				 else {
				 JOptionPane.showMessageDialog(this, "用户名或密码错误",
				   "错误",JOptionPane.ERROR_MESSAGE);       //弹出错误对话框
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
 
  


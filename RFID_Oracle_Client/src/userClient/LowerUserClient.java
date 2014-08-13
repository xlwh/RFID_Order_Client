package userClient;




import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.*;
import javax.swing.tree.*;

import socketclient.SocketClient;

import loweruserclient.*;

//class MyNode{                              //自定义的初始化树节点的数据对象的类
//	private String values;             //声明values属性
//	private String id;                 //用于确定节点的id属性
//	public MyNode(String values ,String id){  //构造器
//		this.values = values;                //设置values的值
//		this.id = id;                       //设置id的值
//	}
//	public String toString (){             //复写toString 方法；返回values的值
//		return this.values;                
//	}
//	public String getid(){return this.id;} //id 的get方法
//}



public class LowerUserClient extends JFrame {
   
     /**
	 * 
	 */
	private static final long serialVersionUID = -8819436400484769795L;
	/**
	 * 
	 */
	public String userId ;//登录用户的学生号
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	SocketClient c;
	Vector<String> v_result ;
	String sql;
	
	
	
     
     //声明树的各个节点
     private DefaultMutableTreeNode dmtnRoot = new DefaultMutableTreeNode(new MyNode("普通用户客户端","0"));//创建根节点
     //创建一级节点
     //private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("借还管理","1"));  
     private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("自行车需求","1"));
     private DefaultMutableTreeNode dmtn2 = new DefaultMutableTreeNode(new MyNode("我的自行车","2"));
     private DefaultMutableTreeNode dmtn3 = new DefaultMutableTreeNode(new MyNode("用户信息","3"));
     private DefaultMutableTreeNode dmtn4 = new DefaultMutableTreeNode(new MyNode("退出","4"));

    
     private DefaultTreeModel dtm = new DefaultTreeModel(dmtnRoot);//创建跟节点
     private JTree jt = new JTree(dtm);//创建树状列表控件

     
     private javax.swing.JLabel jlb_up;
     private javax.swing.JPanel jp_left;
     private javax.swing.JPanel jp_up;
     private javax.swing.JPanel jpy;
     private javax.swing.JSplitPane jsp1;
     private javax.swing.JScrollPane jspz;
     JLabel jl_notify ;
     
     CardLayout cl;           //声明卡片布局引用
    
     //声明功能模块引用，（声明语句将在后面各模块的开发过程中逐一添加）
     
     //////////-----------------------1、添加模块声明-----------------------------/////////
            
     //--------------------------------------------------------------
     
     
     public LowerUserClient(){    //构造器
    	// this.userId = userId;
    	 this.initComponents();  //初始化主窗体
    	 this.initialJpy();     //初始化画板
    	 this.initialPanel();  //初始化各功能模块对象
    	 this.initialTree();     //初始化树列表控件
    	 this.addListener(); //为节点注册监听器
    	 
     }
     
     public LowerUserClient(String user){    //构造器
     	 this.userId = user;
     	 this.initComponents();  //初始化主窗体
     	 this.initialJpy();     //初始化画板
     	 this.initialPanel();  //初始化各功能模块对象
     	 this.initialTree();     //初始化树列表控件
     	 this.addListener(); //为节点注册监听器
     	 
      }
     
     //2.6.2
     
     public void initialPanel() {//初始化各功能模块
    	
    	 
    	 //----------------------创建个功能模块实例------------------
    	
    	 
    	 //---------------------------------------------------------
     }  
     
     public void initialTree(){ //初始化树状列表控件的方法
    	 dmtnRoot.add(dmtn1);
    	 dmtnRoot.add(dmtn2);//将各节点添加到根节点
    	 dmtnRoot.add(dmtn3);//将各节点添加到根节点
    	 dmtnRoot.add(dmtn4);//将各节点添加到根节点
    	
     }
     
     public void initialJpy(){                //将个功能模块添加到画板
    	 jpy.setLayout(new CardLayout());    //将画板设置成卡片布局模式
    	 cl = (CardLayout)jpy.getLayout();   //得到画板卡片布局模式的引用

    	// jpy.add(changepwdteacher, "changepwdteacher");
    
    	 //---------------待添加-----------
    	 
    	 
    	 
     }
//     
//     public void initialJFrame(){       //设置窗体的标题，大小，及其可见性
//    	 this.add(jsp1);jsp1.setDividerLocation(200);//将分割窗体添加到窗体，并设置分割窗体的位置
//    	 jsp1.setDividerSize(4);       //设置分割窗体的宽度
//    	 
//    	 //String picPath = "d:" + File.separator + "workspace" + File.separator + "xs.jpg"; 
//    	 // Icon icon = new ImageIcon(picPath);
//    	 // this.setIcon(icon);
//    	  
//    	 Image image = new ImageIcon("ico.gif").getImage();//加载窗体图标对象
//    	 this.setIconImage(image); this.setTitle("用户客户端");//设置窗体的图标和标题
//    	 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//得到屏幕的dimension（大小）值
//    	 int centerX = screensize.width/2;//得到屏幕宽度的中间像素点
//    	 int centerY = screensize.height/2;//得到屏幕高度得中间像素点
//    	 int w =900;//本窗体宽度
//    	 int h =650;//本窗体高度
//    	 this.setBounds(centerX-w/2,centerY-h/2,w,h);//设置窗体出现在屏幕中央；
//    	                                                //setBounts:移动组件并调整其大小，使其符合新的有界矩形 r。由 r.x 和 r.y 指定组件的新位置，由 r.width 和 r.height 指定组件的新大小 
//    	 this.setVisible(true);                         //设置窗体可见
//    	// this.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体全屏
//    	 
//     }
     
     
     private void initComponents() {
    	 
    
    		
    		
    		

    	 this.setTitle("普通用户客户端");
         jp_up = new javax.swing.JPanel();
         jlb_up = new javax.swing.JLabel();
         jsp1 = new javax.swing.JSplitPane();
         jp_left = new javax.swing.JPanel();
         
         
         /*************************************************************************
          * 注意修改点
          * ************************************************************************/
         jspz = new JScrollPane(jt);       //创建滚动窗口
         jpy = new javax.swing.JPanel();
         

        
       
         
	
    	 
    	 String sql ="Select eqp_type,num,authorize_flag from requirement where loweruser_id = '"+userId +"' AND dispose_flag='1'";
    	 System.out.println("-------------------2013-06-23:--"+sql);
    	 try {
    		 c = new SocketClient(sql,3);                           //实例化Client对象
    		 c.send();                                        //将sql语句发送给服务器端处理
    		 v_result = new Vector<String>();
    		 v_result = c.getV_result();	                  //得到查询数据库后的结果
    		} catch(Exception e){e.printStackTrace(); }                        //查询数据库
    	 
    	
    	
         for(int i =0;i<v_result.size();i=i+3){
//        	 jl_notify = new JLabel("通知：");
//        	 jl_notify.setBounds(10, 10, 100, 30);
//        	 jpy.add(jl_notify);
        	 
        	 if(v_result.get(i+2).equals("1")){
        		 String type = "主机";
        		 if(v_result.get(i).equals("0"))type="自行车";
        		 if(v_result.get(i).equals("0"))type="其它";
        		 String info = "授权：用户提交"+v_result.get(i+1)+"个"+type+"的需求申请授权成功，请及时领取设备！！";
        	     jl_notify = new JLabel(info);
        	     jl_notify.setBounds(10,40+i*50,  100, 30);
        	     jpy.add(jl_notify);
        	 }
        	 if(v_result.get(i+2).equals("0")){
        		 String type = "自行车";
        		 if(v_result.get(i).equals("0"))type="自行车";
        	   if(v_result.get(i).equals("0"))type="其它";
        		 String info = "未授权：用户提交"+v_result.get(i+1)+"个"+type+"的需求申请授权失败，可提出其他需求申请！！";
        	     jl_notify = new JLabel(info);
        	     jl_notify.setBounds(10,40+i*50,  100, 30);
        	     jpy.add(jl_notify);
        	 }
        	 
         }
         jpy.repaint();
         
        
         
        // setBounds(300, 300, 900, 900);


         jp_up.setBackground(new java.awt.Color(0, 51, 204));

         jlb_up.setBackground(new java.awt.Color(0, 0, 204));
         jlb_up.setFont(new java.awt.Font("宋体", 1, 36)); // NOI18N
         jlb_up.setForeground(new java.awt.Color(0, 0, 204));
         jlb_up.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
         
         String picPath = System.getProperty("user.dir")+ File.separator + "picture" + File.separator + "system2.jpg"; 
         Icon icon = new ImageIcon(picPath);
         jlb_up.setIcon(icon); // NOI18N
         
         
         jlb_up.setText("南邮自行车管理系统");
         jlb_up.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

         javax.swing.GroupLayout jp_upLayout = new javax.swing.GroupLayout(jp_up);
         jp_up.setLayout(jp_upLayout);
         jp_upLayout.setHorizontalGroup(
             jp_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jlb_up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
         jp_upLayout.setVerticalGroup(
             jp_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jlb_up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );

         jsp1.setBackground(new java.awt.Color(204, 204, 255));
         jsp1.setDividerLocation(150);

         jp_left.setBackground(new java.awt.Color(204, 204, 255));

         jspz.setBackground(new java.awt.Color(204, 204, 255));

         javax.swing.GroupLayout jp_leftLayout = new javax.swing.GroupLayout(jp_left);
         jp_left.setLayout(jp_leftLayout);
         jp_leftLayout.setHorizontalGroup(
             jp_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jspz, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
         );
         jp_leftLayout.setVerticalGroup(
             jp_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jspz, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
         );

         jsp1.setLeftComponent(jp_left);

         jpy.setBackground(new java.awt.Color(204, 204, 255));

         javax.swing.GroupLayout jpyLayout = new javax.swing.GroupLayout(jpy);
         jpy.setLayout(jpyLayout);
         jpyLayout.setHorizontalGroup(
             jpyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGap(0, 581, Short.MAX_VALUE)
         );
         jpyLayout.setVerticalGroup(
             jpyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGap(0, 460, Short.MAX_VALUE)
         );

         jsp1.setRightComponent(jpy);

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jp_up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(jsp1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(jp_up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jsp1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
         );


       pack();
     }// </editor-fold>
     
     
     //2.6.3
     public void addListener(){
    	 jt.addMouseListener(
    			 new MouseAdapter(){
    				 public void mouseClicked(MouseEvent e){       														 	//实现mouseClicked方法
    					 DefaultMutableTreeNode dmtntemp =  (DefaultMutableTreeNode)jt.getLastSelectedPathComponent();		//得到当前选中节点对象
    					 MyNode mynode = (MyNode)dmtntemp.getUserObject();      											//得到自定义节点对象
    					 String id = mynode.getid();     																	//得到选中节点的id
    					 
    					 jpy.removeAll();
    					 jpy.repaint();
    					 
    					 //根据id值显示不同的卡片
    					 if(id.equals("0")){System.out.println("欢迎页面");}
    					 
    					 else if (id.equals("1")){System.out.println("资产需求"); 
//    					 jpy.add(myequipment, "myequipment");           													 //将searchequipment对象添加到jpy画板
//						  cl.show(jpy, "myequipment");                      												 //将searchequipment对象添加到卡片
//						  myequipment.setFocusable(true);
    					 }
    					 else if (id.equals("2")){System.out.println("我的资产");
//    					 jpy.add(equipmentordered, "equipmentordered");                                                      //将searchequipment对象添加到jpy画板
//						  cl.show(jpy, "equipmentordered");                     											 //将searchequipment对象添加到卡片
//						  equipmentordered.setFocusable(true);
    					 }
    					 else if (id.equals("3")){ System.out.println("用户信息"); }
    					
    					 else if (id.equals("4")){System.out.println("退出");
    					 int i = JOptionPane.showConfirmDialog(jpy, "您确定要退出系统吗？","询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						 if(i==0){System.exit(0);}
    					 }
    				 }
    			 });
    	 jt.setToggleClickCount(1);//将展开节点的鼠标单击次数设置为1
     }
     
     
    
//     public static void main(String args[]){
//    	 String user ="123";
//    	 LowerUserClient luc =  new LowerUserClient();
//    	 luc.userId = user;
//    	 luc.setVisible(true);
//     }
     
     
     
     
}


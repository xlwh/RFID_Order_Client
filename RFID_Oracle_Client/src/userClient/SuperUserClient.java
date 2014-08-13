package userClient;


import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.tree.*;

import superuserclient.*;

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



public class SuperUserClient extends JFrame {
   
     /**
	 * 
	 */
	private static final long serialVersionUID = 703826588965541613L;

	public String userId =null;//登录用户的学生号
     
     public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	//声明树的各个节点
     private DefaultMutableTreeNode dmtnRoot = new DefaultMutableTreeNode(new MyNode("超级用户客户端","0"));//创建根节点
     //创建一级节点
     //private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("借还管理","1"));  
     private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("自行车管理","1"));
     private DefaultMutableTreeNode dmtn2 = new DefaultMutableTreeNode(new MyNode("用户管理","2"));
     private DefaultMutableTreeNode dmtn3 = new DefaultMutableTreeNode(new MyNode("系统","3"));

    //创建二级节点
     private DefaultMutableTreeNode dmtn11 = new DefaultMutableTreeNode(new MyNode("我的自行车","11"));
     private DefaultMutableTreeNode dmtn12 = new DefaultMutableTreeNode(new MyNode("预定自行车","12"));
     private DefaultMutableTreeNode dmtn13 = new DefaultMutableTreeNode(new MyNode("归还自行车","13"));
     private DefaultMutableTreeNode dmtn14 = new DefaultMutableTreeNode(new MyNode("报修自行车","14"));


     private DefaultMutableTreeNode dmtn21 = new DefaultMutableTreeNode(new MyNode("用户操作","21"));
     private DefaultMutableTreeNode dmtn22 = new DefaultMutableTreeNode(new MyNode("用户信息反馈","22"));
     private DefaultMutableTreeNode dmtn23 = new DefaultMutableTreeNode(new MyNode("用户信息提醒","23"));

     
     private DefaultMutableTreeNode dmtn31 = new DefaultMutableTreeNode(new MyNode("密码修改","31"));
     private DefaultMutableTreeNode dmtn32 = new DefaultMutableTreeNode(new MyNode("基本信息查询","32"));
     private DefaultMutableTreeNode dmtn33 = new DefaultMutableTreeNode(new MyNode("退出","33"));
     
     private DefaultTreeModel dtm = new DefaultTreeModel(dmtnRoot);//创建跟节点
     private JTree jt = new JTree(dtm);//创建树状列表控件
//     private JScrollPane jspz = new JScrollPane(jt);       //创建滚动窗口
//     private JPanel jpy= new JPanel();                     //创建面板
//     private JSplitPane jsp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jspz,jpy);//创建分割窗口，水平分割，jspz在左边，jpy在右边
//    
     
     private javax.swing.JLabel jlb_up;
     private javax.swing.JPanel jp_left;
     private javax.swing.JPanel jp_up;
     private javax.swing.JPanel jpy;
     private javax.swing.JSplitPane jsp1;
     private javax.swing.JScrollPane jspz;
     
     
     CardLayout cl;           //声明卡片布局引用
    
     //声明功能模块引用，（声明语句将在后面各模块的开发过程中逐一添加）
     
     //////////-----------------------1、添加模块声明-----------------------------/////////
             MyEquipment myequipment ;        //查询模块声明
             EquipmentOrdered equipmentordered;//预定模块
             EquipmentRequireMended equipmentrequiremended ;
             PwdModify userpwdmodify;
  
     //--------------------------------------------------------------
     
     
     public SuperUserClient(){    //构造器
    	// this.userId = userId;
    	 this.initComponents();  //初始化主窗体
    	 this.initialJpy();     //初始化画板
    	 this.initialPanel();  //初始化各功能模块对象
    	 this.initialTree();     //初始化树列表控件
    	 this.addListener(); //为节点注册监听器
    	 
     }
     
     public SuperUserClient(String user){    //构造器
     	 this.userId = user;
//     	 System.out.println("*************************************************"+userId);
     	 this.initComponents();  //初始化主窗体
     	 this.initialJpy();     //初始化画板
     	 this.initialPanel();  //初始化各功能模块对象
     	 this.initialTree();     //初始化树列表控件
     	 this.addListener(); //为节点注册监听器
     	 
      }
     
     //2.6.2
     
     public void initialPanel() {//初始化各功能模块
    	
    	 
    	 //----------------------创建个功能模块实例------------------
    	
    	 myequipment = new MyEquipment(userId);
    	 equipmentordered = new EquipmentOrdered(userId);
    	 equipmentrequiremended = new EquipmentRequireMended(userId);
    	 userpwdmodify = new PwdModify(userId);
    	 //---------------------------------------------------------
     }  
     
     public void initialTree(){ //初始化树状列表控件的方法
    	 dmtnRoot.add(dmtn1);
    	 
    	 
    	 
    	 
    	 dmtn1.add(dmtn11);dmtn1.add(dmtn12);dmtn1.add(dmtn13);dmtn1.add(dmtn14);  
    	 
    	 dmtnRoot.add(dmtn2);//将各节点添加到根节点
    	 dmtn2.add(dmtn21);dmtn2.add(dmtn22);dmtn2.add(dmtn23); 

    	 dmtnRoot.add(dmtn3);//将各节点添加到根节点
    	 dmtn3.add(dmtn31);dmtn3.add(dmtn32);dmtn3.add(dmtn33);
    	
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
         Date now ;
         DateFormat d1 = DateFormat.getDateTimeInstance();
         now = new Date(); 
         String str_now = d1.format(now);

    	 this.setTitle("超级用户"+userId+"                                                     登录时间为："+ str_now);
         jp_up = new javax.swing.JPanel();
         jlb_up = new javax.swing.JLabel();
         jsp1 = new javax.swing.JSplitPane();
         jp_left = new javax.swing.JPanel();
         
         
         /*************************************************************************
          * 注意修改点
          * ************************************************************************/
         jspz = new JScrollPane(jt);       //创建滚动窗口
         jpy = new javax.swing.JPanel();

       
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
    					 
    					 //根据id值显示不同的卡片
    					 if(id.equals("0")){System.out.println("欢迎页面");}
    					 
    					 else if (id.equals("11")){System.out.println("进入我的资产界面"); 
    					 jpy.add(myequipment, "myequipment");           													 //将searchequipment对象添加到jpy画板
						  cl.show(jpy, "myequipment");                      												 //将searchequipment对象添加到卡片
						  myequipment.setFocusable(true);
    					 }
    					 else if (id.equals("12")){System.out.println("进入设备预定界面");
    					 jpy.add(equipmentordered, "equipmentordered");                                                      //将searchequipment对象添加到jpy画板
						  cl.show(jpy, "equipmentordered");                     											 //将searchequipment对象添加到卡片
						  equipmentordered.setFocusable(true);
    					 }
    					 else if (id.equals("13")){ System.out.println("进入设备退还界面"); }
    					                               
    					 else if (id.equals("14")){System.out.println("维修反馈");
    					 jpy.add(equipmentrequiremended, "equipmentrequiremended");            								//将searchequipment对象添加到jpy画板
						 cl.show(jpy, "equipmentrequiremended");                     										//将searchequipment对象添加到卡片
						 equipmentrequiremended.setFocusable(true);
    					 }
    					 
  
    					 else if (id.equals("21")){System.out.println("用户操作");}
    					 else if (id.equals("22")){System.out.println("用户反馈");
    					 }
    					 else if (id.equals("22")){System.out.println("用户提醒");
    					 }
    					 
    					 
    					 
    					 else if (id.equals("31")){System.out.println("密码修改页面");
    					 jpy.add(userpwdmodify, "userpwdmodify");            												//将searchequipment对象添加到jpy画板
						 cl.show(jpy, "userpwdmodify");                      												//将searchequipment对象添加到卡片
						 userpwdmodify.setFocusable(true);
    					 }
    					 else if (id.equals("32")){System.out.println("基本信息查询页面");}
    					 else if (id.equals("33")){System.out.println("退出");
    					 int i = JOptionPane.showConfirmDialog(jpy, "您确定要退出系统吗？","询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						 if(i==0){System.exit(0);}
    					 }
    				 }
    			 });
    	 jt.setToggleClickCount(1);//将展开节点的鼠标单击次数设置为1
     }
     
     
    
//     public static void main(String args[]){
//    	 SuperUserClient s = new SuperUserClient("1221101");
//    	 System.out.println("**"+s.getUserId());
//     }
     
     
     
     
}


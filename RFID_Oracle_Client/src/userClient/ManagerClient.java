package userClient;



import java.awt.CardLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.tree.*;

import routeShow.RouteShow_V1;

import managerclient.*;

class MyNode{                              //自定义的初始化树节点的数据对象的类
	private String values;             //声明values属性
	private String id;                 //用于确定节点的id属性
	public MyNode(String values ,String id){  //构造器
		this.values = values;                //设置values的值
		this.id = id;                       //设置id的值
	}
	public String toString (){             //复写toString 方法；返回values的值
		return this.values;                
	}
	public String getid(){return this.id;} //id 的get方法
}



public class ManagerClient extends JFrame {
    
     
     //声明树的各个节点
     private DefaultMutableTreeNode dmtnRoot = new DefaultMutableTreeNode(new MyNode("管理员客户端","0"));//创建根节点
     //创建一级节点
     private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("借还管理","1"));  
     private DefaultMutableTreeNode dmtn2 = new DefaultMutableTreeNode(new MyNode("自行车管理","2"));
     private DefaultMutableTreeNode dmtn3 = new DefaultMutableTreeNode(new MyNode("位置信息","3"));
     private DefaultMutableTreeNode dmtn4 = new DefaultMutableTreeNode(new MyNode("用户管理","4"));
     private DefaultMutableTreeNode dmtn5 = new DefaultMutableTreeNode(new MyNode("读写器管理","5"));
     private DefaultMutableTreeNode dmtn6 = new DefaultMutableTreeNode(new MyNode("标签管理","6"));
     private DefaultMutableTreeNode dmtn7 = new DefaultMutableTreeNode(new MyNode("系统维护","7"));

    //创建二级节点
     private DefaultMutableTreeNode dmtn11 = new DefaultMutableTreeNode(new MyNode("自行车预定信息","11"));
     private DefaultMutableTreeNode dmtn13 = new DefaultMutableTreeNode(new MyNode("自行车借出","13"));
     private DefaultMutableTreeNode dmtn14 = new DefaultMutableTreeNode(new MyNode("自行车归还","14"));

    // private DefaultMutableTreeNode dmtn21 = new DefaultMutableTreeNode(new MyNode("资产采购","21"));
     private DefaultMutableTreeNode dmtn22 = new DefaultMutableTreeNode(new MyNode("自行车入库","22"));
     //private DefaultMutableTreeNode dmtn23 = new DefaultMutableTreeNode(new MyNode("资产分配","23"));
     private DefaultMutableTreeNode dmtn24 = new DefaultMutableTreeNode(new MyNode("自行车查询","24"));
     private DefaultMutableTreeNode dmtn25 = new DefaultMutableTreeNode(new MyNode("自行车盘点","25"));
     private DefaultMutableTreeNode dmtn26 = new DefaultMutableTreeNode(new MyNode("自行车报修","26"));
     private DefaultMutableTreeNode dmtn27 = new DefaultMutableTreeNode(new MyNode("自行车报废报废","27"));   
     // private DefaultMutableTreeNode dmtn221 = new DefaultMutableTreeNode(new MyNode("基本信息查询","221"));
     
     
     private DefaultMutableTreeNode dmtn31 = new DefaultMutableTreeNode(new MyNode("位置轨迹","31"));
     
     private DefaultMutableTreeNode dmtn41 = new DefaultMutableTreeNode(new MyNode("用户操作","41"));
     
     private DefaultMutableTreeNode dmtn51 = new DefaultMutableTreeNode(new MyNode("读写器操作","51"));
     
     private DefaultMutableTreeNode dmtn61 = new DefaultMutableTreeNode(new MyNode("标签操作","61"));
     
     private DefaultMutableTreeNode dmtn71 = new DefaultMutableTreeNode(new MyNode("管理员信息","71"));
     private DefaultMutableTreeNode dmtn72 = new DefaultMutableTreeNode(new MyNode("系统日志","72"));
     private DefaultMutableTreeNode dmtn73 = new DefaultMutableTreeNode(new MyNode("数据备份","73"));
     private DefaultMutableTreeNode dmtn74 = new DefaultMutableTreeNode(new MyNode("退出","74"));
     
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
     SearchEquipment searchequipment;          //查询模块声明
     Usermanager usermanager;                  //用户管理
     OrderedInformation orderedinformation;    //预定信息查看
     MendInformation mendinformation;          //报修信息
     AbandonInformation abandoninformation;    //报废信息
     ReaderInformation readerinformation;      //读写器信息管理
     PutIntoStorage putintostorage;            //设备入库
     Check check;                              //盘点
     //DistributeEquipment distributeequipment;  //设备分配
     EquipmentBorrowed equipmentborrowed;     //资产借用
     EquipmentReturn equipmentreturn;         //资产归还
     
     RouteShow_V1 routeshow ;
     //--------------------------------------------------------------
     
     
     public ManagerClient(){    //构造器t
    	// this.initialJFrame();  //初始化主窗体
    	 this.initComponents();
    	
    	 this.initialJpy();     //初始化画板
    	 this.initialPanel();  //初始化各功能模块对象
    	 this.initialTree();     //初始化树列表控件
    	 this.addListener(); //为节点注册监听器
    	 
     }
     
     
     //2.6.2
     
     public void initialPanel() {//初始化各功能模块
    	
    	 
    	 //----------------------创建个功能模块实例------------------
    	
    	 searchequipment = new SearchEquipment();
    	 usermanager = new Usermanager();
    	 orderedinformation = new OrderedInformation();
    	 mendinformation = new MendInformation();
    	 abandoninformation = new AbandonInformation();
    	 readerinformation = new ReaderInformation();
    	 putintostorage = new PutIntoStorage();
    	 check = new Check();
    	 //distributeequipment = new DistributeEquipment();
    	 equipmentborrowed = new EquipmentBorrowed();
    	 equipmentreturn = new EquipmentReturn();
    	 
    	 routeshow = new RouteShow_V1();
    	 //---------------------------------------------------------
     }  
     
     public void initialTree(){ //初始化树状列表控件的方法
    	 dmtnRoot.add(dmtn1); dmtnRoot.add(dmtn2); dmtnRoot.add(dmtn3);//将各节点添加到根节点
    	 dmtnRoot.add(dmtn4);dmtnRoot.add(dmtn5);dmtnRoot.add(dmtn6);dmtnRoot.add(dmtn7);
    	 
    	 dmtn1.add(dmtn11);dmtn1.add(dmtn13);dmtn1.add(dmtn14);       
    	 
    	 dmtn2.add(dmtn22); dmtn2.add(dmtn24);dmtn2.add(dmtn25);dmtn2.add(dmtn26);dmtn2.add(dmtn27);
    	 
    	 dmtn3.add(dmtn31);

    	 dmtn4.add(dmtn41);
    	 
    	 dmtn5.add(dmtn51);
    	 
    	 dmtn6.add(dmtn61);
    	 
    	 dmtn7.add(dmtn71);dmtn7.add(dmtn72);dmtn7.add(dmtn73); dmtn7.add(dmtn74); 
    	
     }
     
     public void initialJpy(){                //将个功能模块添加到画板
    	 jpy.setLayout(new CardLayout());    //将画板设置成卡片布局模式
    	 cl = (CardLayout)jpy.getLayout();   //得到画板卡片布局模式的引用

    	// jpy.add(changepwdteacher, "changepwdteacher");
    
    	 //---------------待添加-----------
    	 
    	 
    	 
     }
   
     
     private void initComponents() {

    	 this.setTitle("管理员客户端");
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
    				 public void mouseClicked(MouseEvent e){        //实现mouseClicked方法
    					 DefaultMutableTreeNode dmtntemp =  (DefaultMutableTreeNode)jt.getLastSelectedPathComponent();//得到当前选中节点对象
    					 MyNode mynode = (MyNode)dmtntemp.getUserObject();       //得到自定义节点对象
    					 String id = mynode.getid();     //得到选中节点的id
    					 
    					 //根据id值显示不同的卡片
    					 if(id.equals("0")){System.out.println("欢迎页面");
    					  jpy.removeAll();
    					  jpy.repaint();
    					 }
    					 
    					 
    					 
    					 
    					 else if (id.equals("11")){System.out.println("进入自行车预定信息查询界面"); 
    					                           	jpy.add(orderedinformation, "orderedinformation");            //将searchequipment对象添加到jpy画板
    					                           	cl.show(jpy, "orderedinformation");                      //将searchequipment对象添加到卡片
						                           	orderedinformation.setFocusable(true);
						                           	}                   //将此 Component 的焦点状态设置为指定值。此值覆盖 Component 的默认焦点状态
    					 else if (id.equals("13")){System.out.println("进入自行车借出界面");
    					 							jpy.add(equipmentborrowed, "equipmentborrowed");            //将searchequipment对象添加到jpy画板
    					 							cl.show(jpy, "equipmentborrowed");                      //将searchequipment对象添加到卡片
    					 							equipmentborrowed.setFocusable(true);
    					 							}
    					 else if (id.equals("14")){ System.out.println("进入自行车归还"); 
    					 							jpy.add(equipmentreturn, "equipmentreturn");            //将searchequipment对象添加到jpy画板
    					 							cl.show(jpy, "equipmentreturn");                      //将searchequipment对象添加到卡片
    					 							equipmentreturn.setFocusable(true);
    					 							}
    					      
    					 
    					
    					 else if (id.equals("22")){System.out.println("自行车入库界面");
    					 							jpy.add(putintostorage, "putintostoraget");            //将searchequipment对象添加到jpy画板
    					 							putintostorage.setVisible(true);
    					 							cl.show(jpy, "putintostorage");                      //将searchequipment对象添加到卡片
    					 							
    					 							putintostorage.setFocusable(true);
    					 							}
    					 else if (id.equals("24")){System.out.println("自行车查询界面");
    					 							jpy.add(searchequipment, "searchequipment");            //将searchequipment对象添加到jpy画板
    					 							cl.show(jpy, "searchequipment");                      //将searchequipment对象添加到卡片
    					 							searchequipment.setFocusable(true);
    					 							}
    					 else if (id.equals("25")){System.out.println("自行车盘点界面");
    					 							jpy.add(check, "check");            //将searchequipment对象添加到jpy画板
    					 							cl.show(jpy, "check");                      //将searchequipment对象添加到卡片
    					 							check.setFocusable(true);
    					 							}
    					 else if (id.equals("26")){System.out.println("自行车报修界面");
    					 							jpy.add(mendinformation, "mendinformation");            //将searchequipment对象添加到jpy画板
    					 							cl.show(jpy, "mendinformation");                      //将searchequipment对象添加到卡片
    					 							mendinformation.setFocusable(true);
    					 							}
    					 else if (id.equals("27")){System.out.println("自行车报废界面");
    					 							jpy.add(abandoninformation, "abandoninformation");            //将searchequipment对象添加到jpy画板
    					 							cl.show(jpy, "abandoninformation");                      //将searchequipment对象添加到卡片
    					 							abandoninformation.setFocusable(true);
    					 							}

    					 
  
    					 else if (id.equals("31")){System.out.println("移动轨迹");
							jpy.add(routeshow, "routeshow");            //将searchequipment对象添加到jpy画板
							cl.show(jpy, "routeshow");                      //将searchequipment对象添加到卡片
							routeshow.setFocusable(true);
							}
    					 
    					 
    					 
    					 
    					 else if (id.equals("41")){System.out.println("用户操作");
    					 							jpy.add(usermanager, "usermanager");            //将ChangPwdTeacher对象添加到jpy画板
    					 							cl.show(jpy, "usermanager");                        //将ChangPwdTeacher对象添加到卡片
    					 							usermanager.setFocusable(true);
    					 							}
    					 
    					 
    					 
    					 else if (id.equals("51")){System.out.println("读写器操作");
    					 							jpy.add(readerinformation, "readerinformation");            //将searchequipment对象添加到jpy画板
    					 							cl.show(jpy, "readerinformation");                      //将searchequipment对象添加到卡片
    					 							readerinformation.setFocusable(true);
    					 							}
    					 
    					 
    					 
    					 else if (id.equals("61")){System.out.println("标签操作");
							
							//该功能尚未实现
    					 
    					 
    					 
    					 }

    					 
    					 
    					 
    					 
    					 else if (id.equals("71")){System.out.println("管理员信息");
							
    					 
							}
    					 else if (id.equals("72")){System.out.println("系统日志");
							
    					 
							}
    					 else if (id.equals("73")){System.out.println("数据备份");
							
    					 
							}
    					 else if (id.equals("74")){System.out.println("退出");
    					 int i = JOptionPane.showConfirmDialog(jpy, "您确定要退出系统吗？","询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						 if(i==0){System.exit(0);}
    					 }
    				 }
    			 });
    	 jt.setToggleClickCount(1);//将展开节点的鼠标单击次数设置为1
     }
     
     
    
     public static void main(String args[]){
    	  new ManagerClient();

     }
     
     
     
     
}

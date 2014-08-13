package userClient;



import java.awt.CardLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.tree.*;

import routeShow.RouteShow_V1;

import managerclient.*;

class MyNode{                              //�Զ���ĳ�ʼ�����ڵ�����ݶ������
	private String values;             //����values����
	private String id;                 //����ȷ���ڵ��id����
	public MyNode(String values ,String id){  //������
		this.values = values;                //����values��ֵ
		this.id = id;                       //����id��ֵ
	}
	public String toString (){             //��дtoString ����������values��ֵ
		return this.values;                
	}
	public String getid(){return this.id;} //id ��get����
}



public class ManagerClient extends JFrame {
    
     
     //�������ĸ����ڵ�
     private DefaultMutableTreeNode dmtnRoot = new DefaultMutableTreeNode(new MyNode("����Ա�ͻ���","0"));//�������ڵ�
     //����һ���ڵ�
     private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("�軹����","1"));  
     private DefaultMutableTreeNode dmtn2 = new DefaultMutableTreeNode(new MyNode("���г�����","2"));
     private DefaultMutableTreeNode dmtn3 = new DefaultMutableTreeNode(new MyNode("λ����Ϣ","3"));
     private DefaultMutableTreeNode dmtn4 = new DefaultMutableTreeNode(new MyNode("�û�����","4"));
     private DefaultMutableTreeNode dmtn5 = new DefaultMutableTreeNode(new MyNode("��д������","5"));
     private DefaultMutableTreeNode dmtn6 = new DefaultMutableTreeNode(new MyNode("��ǩ����","6"));
     private DefaultMutableTreeNode dmtn7 = new DefaultMutableTreeNode(new MyNode("ϵͳά��","7"));

    //���������ڵ�
     private DefaultMutableTreeNode dmtn11 = new DefaultMutableTreeNode(new MyNode("���г�Ԥ����Ϣ","11"));
     private DefaultMutableTreeNode dmtn13 = new DefaultMutableTreeNode(new MyNode("���г����","13"));
     private DefaultMutableTreeNode dmtn14 = new DefaultMutableTreeNode(new MyNode("���г��黹","14"));

    // private DefaultMutableTreeNode dmtn21 = new DefaultMutableTreeNode(new MyNode("�ʲ��ɹ�","21"));
     private DefaultMutableTreeNode dmtn22 = new DefaultMutableTreeNode(new MyNode("���г����","22"));
     //private DefaultMutableTreeNode dmtn23 = new DefaultMutableTreeNode(new MyNode("�ʲ�����","23"));
     private DefaultMutableTreeNode dmtn24 = new DefaultMutableTreeNode(new MyNode("���г���ѯ","24"));
     private DefaultMutableTreeNode dmtn25 = new DefaultMutableTreeNode(new MyNode("���г��̵�","25"));
     private DefaultMutableTreeNode dmtn26 = new DefaultMutableTreeNode(new MyNode("���г�����","26"));
     private DefaultMutableTreeNode dmtn27 = new DefaultMutableTreeNode(new MyNode("���г����ϱ���","27"));   
     // private DefaultMutableTreeNode dmtn221 = new DefaultMutableTreeNode(new MyNode("������Ϣ��ѯ","221"));
     
     
     private DefaultMutableTreeNode dmtn31 = new DefaultMutableTreeNode(new MyNode("λ�ù켣","31"));
     
     private DefaultMutableTreeNode dmtn41 = new DefaultMutableTreeNode(new MyNode("�û�����","41"));
     
     private DefaultMutableTreeNode dmtn51 = new DefaultMutableTreeNode(new MyNode("��д������","51"));
     
     private DefaultMutableTreeNode dmtn61 = new DefaultMutableTreeNode(new MyNode("��ǩ����","61"));
     
     private DefaultMutableTreeNode dmtn71 = new DefaultMutableTreeNode(new MyNode("����Ա��Ϣ","71"));
     private DefaultMutableTreeNode dmtn72 = new DefaultMutableTreeNode(new MyNode("ϵͳ��־","72"));
     private DefaultMutableTreeNode dmtn73 = new DefaultMutableTreeNode(new MyNode("���ݱ���","73"));
     private DefaultMutableTreeNode dmtn74 = new DefaultMutableTreeNode(new MyNode("�˳�","74"));
     
     private DefaultTreeModel dtm = new DefaultTreeModel(dmtnRoot);//�������ڵ�
     private JTree jt = new JTree(dtm);//������״�б�ؼ�
//     private JScrollPane jspz = new JScrollPane(jt);       //������������
//     private JPanel jpy= new JPanel();                     //�������
//     private JSplitPane jsp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jspz,jpy);//�����ָ�ڣ�ˮƽ�ָjspz����ߣ�jpy���ұ�
//    
     private javax.swing.JLabel jlb_up;
     private javax.swing.JPanel jp_left;
     private javax.swing.JPanel jp_up;
     private javax.swing.JPanel jpy;
     private javax.swing.JSplitPane jsp1;
     private javax.swing.JScrollPane jspz;
     
     
     
     CardLayout cl;           //������Ƭ��������
    
     //��������ģ�����ã���������佫�ں����ģ��Ŀ�����������һ��ӣ�
     
     //////////-----------------------1�����ģ������-----------------------------/////////
     SearchEquipment searchequipment;          //��ѯģ������
     Usermanager usermanager;                  //�û�����
     OrderedInformation orderedinformation;    //Ԥ����Ϣ�鿴
     MendInformation mendinformation;          //������Ϣ
     AbandonInformation abandoninformation;    //������Ϣ
     ReaderInformation readerinformation;      //��д����Ϣ����
     PutIntoStorage putintostorage;            //�豸���
     Check check;                              //�̵�
     //DistributeEquipment distributeequipment;  //�豸����
     EquipmentBorrowed equipmentborrowed;     //�ʲ�����
     EquipmentReturn equipmentreturn;         //�ʲ��黹
     
     RouteShow_V1 routeshow ;
     //--------------------------------------------------------------
     
     
     public ManagerClient(){    //������t
    	// this.initialJFrame();  //��ʼ��������
    	 this.initComponents();
    	
    	 this.initialJpy();     //��ʼ������
    	 this.initialPanel();  //��ʼ��������ģ�����
    	 this.initialTree();     //��ʼ�����б�ؼ�
    	 this.addListener(); //Ϊ�ڵ�ע�������
    	 
     }
     
     
     //2.6.2
     
     public void initialPanel() {//��ʼ��������ģ��
    	
    	 
    	 //----------------------����������ģ��ʵ��------------------
    	
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
     
     public void initialTree(){ //��ʼ����״�б�ؼ��ķ���
    	 dmtnRoot.add(dmtn1); dmtnRoot.add(dmtn2); dmtnRoot.add(dmtn3);//�����ڵ���ӵ����ڵ�
    	 dmtnRoot.add(dmtn4);dmtnRoot.add(dmtn5);dmtnRoot.add(dmtn6);dmtnRoot.add(dmtn7);
    	 
    	 dmtn1.add(dmtn11);dmtn1.add(dmtn13);dmtn1.add(dmtn14);       
    	 
    	 dmtn2.add(dmtn22); dmtn2.add(dmtn24);dmtn2.add(dmtn25);dmtn2.add(dmtn26);dmtn2.add(dmtn27);
    	 
    	 dmtn3.add(dmtn31);

    	 dmtn4.add(dmtn41);
    	 
    	 dmtn5.add(dmtn51);
    	 
    	 dmtn6.add(dmtn61);
    	 
    	 dmtn7.add(dmtn71);dmtn7.add(dmtn72);dmtn7.add(dmtn73); dmtn7.add(dmtn74); 
    	
     }
     
     public void initialJpy(){                //��������ģ����ӵ�����
    	 jpy.setLayout(new CardLayout());    //���������óɿ�Ƭ����ģʽ
    	 cl = (CardLayout)jpy.getLayout();   //�õ����忨Ƭ����ģʽ������

    	// jpy.add(changepwdteacher, "changepwdteacher");
    
    	 //---------------�����-----------
    	 
    	 
    	 
     }
   
     
     private void initComponents() {

    	 this.setTitle("����Ա�ͻ���");
         jp_up = new javax.swing.JPanel();
         jlb_up = new javax.swing.JLabel();
         jsp1 = new javax.swing.JSplitPane();
         jp_left = new javax.swing.JPanel();
         
         
         /*************************************************************************
          * ע���޸ĵ�
          * ************************************************************************/
         jspz = new JScrollPane(jt);       //������������
         jpy = new javax.swing.JPanel();

       
        // setBounds(300, 300, 900, 900);


         jp_up.setBackground(new java.awt.Color(0, 51, 204));

         jlb_up.setBackground(new java.awt.Color(0, 0, 204));
         jlb_up.setFont(new java.awt.Font("����", 1, 36)); // NOI18N
         jlb_up.setForeground(new java.awt.Color(0, 0, 204));
         jlb_up.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
         
         String picPath = System.getProperty("user.dir")+ File.separator + "picture" + File.separator + "system2.jpg"; 
         Icon icon = new ImageIcon(picPath);
         jlb_up.setIcon(icon); // NOI18N
         
         
         jlb_up.setText("�������г�����ϵͳ");
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
    				 public void mouseClicked(MouseEvent e){        //ʵ��mouseClicked����
    					 DefaultMutableTreeNode dmtntemp =  (DefaultMutableTreeNode)jt.getLastSelectedPathComponent();//�õ���ǰѡ�нڵ����
    					 MyNode mynode = (MyNode)dmtntemp.getUserObject();       //�õ��Զ���ڵ����
    					 String id = mynode.getid();     //�õ�ѡ�нڵ��id
    					 
    					 //����idֵ��ʾ��ͬ�Ŀ�Ƭ
    					 if(id.equals("0")){System.out.println("��ӭҳ��");
    					  jpy.removeAll();
    					  jpy.repaint();
    					 }
    					 
    					 
    					 
    					 
    					 else if (id.equals("11")){System.out.println("�������г�Ԥ����Ϣ��ѯ����"); 
    					                           	jpy.add(orderedinformation, "orderedinformation");            //��searchequipment������ӵ�jpy����
    					                           	cl.show(jpy, "orderedinformation");                      //��searchequipment������ӵ���Ƭ
						                           	orderedinformation.setFocusable(true);
						                           	}                   //���� Component �Ľ���״̬����Ϊָ��ֵ����ֵ���� Component ��Ĭ�Ͻ���״̬
    					 else if (id.equals("13")){System.out.println("�������г��������");
    					 							jpy.add(equipmentborrowed, "equipmentborrowed");            //��searchequipment������ӵ�jpy����
    					 							cl.show(jpy, "equipmentborrowed");                      //��searchequipment������ӵ���Ƭ
    					 							equipmentborrowed.setFocusable(true);
    					 							}
    					 else if (id.equals("14")){ System.out.println("�������г��黹"); 
    					 							jpy.add(equipmentreturn, "equipmentreturn");            //��searchequipment������ӵ�jpy����
    					 							cl.show(jpy, "equipmentreturn");                      //��searchequipment������ӵ���Ƭ
    					 							equipmentreturn.setFocusable(true);
    					 							}
    					      
    					 
    					
    					 else if (id.equals("22")){System.out.println("���г�������");
    					 							jpy.add(putintostorage, "putintostoraget");            //��searchequipment������ӵ�jpy����
    					 							putintostorage.setVisible(true);
    					 							cl.show(jpy, "putintostorage");                      //��searchequipment������ӵ���Ƭ
    					 							
    					 							putintostorage.setFocusable(true);
    					 							}
    					 else if (id.equals("24")){System.out.println("���г���ѯ����");
    					 							jpy.add(searchequipment, "searchequipment");            //��searchequipment������ӵ�jpy����
    					 							cl.show(jpy, "searchequipment");                      //��searchequipment������ӵ���Ƭ
    					 							searchequipment.setFocusable(true);
    					 							}
    					 else if (id.equals("25")){System.out.println("���г��̵����");
    					 							jpy.add(check, "check");            //��searchequipment������ӵ�jpy����
    					 							cl.show(jpy, "check");                      //��searchequipment������ӵ���Ƭ
    					 							check.setFocusable(true);
    					 							}
    					 else if (id.equals("26")){System.out.println("���г����޽���");
    					 							jpy.add(mendinformation, "mendinformation");            //��searchequipment������ӵ�jpy����
    					 							cl.show(jpy, "mendinformation");                      //��searchequipment������ӵ���Ƭ
    					 							mendinformation.setFocusable(true);
    					 							}
    					 else if (id.equals("27")){System.out.println("���г����Ͻ���");
    					 							jpy.add(abandoninformation, "abandoninformation");            //��searchequipment������ӵ�jpy����
    					 							cl.show(jpy, "abandoninformation");                      //��searchequipment������ӵ���Ƭ
    					 							abandoninformation.setFocusable(true);
    					 							}

    					 
  
    					 else if (id.equals("31")){System.out.println("�ƶ��켣");
							jpy.add(routeshow, "routeshow");            //��searchequipment������ӵ�jpy����
							cl.show(jpy, "routeshow");                      //��searchequipment������ӵ���Ƭ
							routeshow.setFocusable(true);
							}
    					 
    					 
    					 
    					 
    					 else if (id.equals("41")){System.out.println("�û�����");
    					 							jpy.add(usermanager, "usermanager");            //��ChangPwdTeacher������ӵ�jpy����
    					 							cl.show(jpy, "usermanager");                        //��ChangPwdTeacher������ӵ���Ƭ
    					 							usermanager.setFocusable(true);
    					 							}
    					 
    					 
    					 
    					 else if (id.equals("51")){System.out.println("��д������");
    					 							jpy.add(readerinformation, "readerinformation");            //��searchequipment������ӵ�jpy����
    					 							cl.show(jpy, "readerinformation");                      //��searchequipment������ӵ���Ƭ
    					 							readerinformation.setFocusable(true);
    					 							}
    					 
    					 
    					 
    					 else if (id.equals("61")){System.out.println("��ǩ����");
							
							//�ù�����δʵ��
    					 
    					 
    					 
    					 }

    					 
    					 
    					 
    					 
    					 else if (id.equals("71")){System.out.println("����Ա��Ϣ");
							
    					 
							}
    					 else if (id.equals("72")){System.out.println("ϵͳ��־");
							
    					 
							}
    					 else if (id.equals("73")){System.out.println("���ݱ���");
							
    					 
							}
    					 else if (id.equals("74")){System.out.println("�˳�");
    					 int i = JOptionPane.showConfirmDialog(jpy, "��ȷ��Ҫ�˳�ϵͳ��","ѯ��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						 if(i==0){System.exit(0);}
    					 }
    				 }
    			 });
    	 jt.setToggleClickCount(1);//��չ���ڵ����굥����������Ϊ1
     }
     
     
    
     public static void main(String args[]){
    	  new ManagerClient();

     }
     
     
     
     
}

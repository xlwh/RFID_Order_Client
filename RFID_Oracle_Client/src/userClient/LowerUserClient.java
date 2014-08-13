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

//class MyNode{                              //�Զ���ĳ�ʼ�����ڵ�����ݶ������
//	private String values;             //����values����
//	private String id;                 //����ȷ���ڵ��id����
//	public MyNode(String values ,String id){  //������
//		this.values = values;                //����values��ֵ
//		this.id = id;                       //����id��ֵ
//	}
//	public String toString (){             //��дtoString ����������values��ֵ
//		return this.values;                
//	}
//	public String getid(){return this.id;} //id ��get����
//}



public class LowerUserClient extends JFrame {
   
     /**
	 * 
	 */
	private static final long serialVersionUID = -8819436400484769795L;
	/**
	 * 
	 */
	public String userId ;//��¼�û���ѧ����
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	SocketClient c;
	Vector<String> v_result ;
	String sql;
	
	
	
     
     //�������ĸ����ڵ�
     private DefaultMutableTreeNode dmtnRoot = new DefaultMutableTreeNode(new MyNode("��ͨ�û��ͻ���","0"));//�������ڵ�
     //����һ���ڵ�
     //private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("�軹����","1"));  
     private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode(new MyNode("���г�����","1"));
     private DefaultMutableTreeNode dmtn2 = new DefaultMutableTreeNode(new MyNode("�ҵ����г�","2"));
     private DefaultMutableTreeNode dmtn3 = new DefaultMutableTreeNode(new MyNode("�û���Ϣ","3"));
     private DefaultMutableTreeNode dmtn4 = new DefaultMutableTreeNode(new MyNode("�˳�","4"));

    
     private DefaultTreeModel dtm = new DefaultTreeModel(dmtnRoot);//�������ڵ�
     private JTree jt = new JTree(dtm);//������״�б�ؼ�

     
     private javax.swing.JLabel jlb_up;
     private javax.swing.JPanel jp_left;
     private javax.swing.JPanel jp_up;
     private javax.swing.JPanel jpy;
     private javax.swing.JSplitPane jsp1;
     private javax.swing.JScrollPane jspz;
     JLabel jl_notify ;
     
     CardLayout cl;           //������Ƭ��������
    
     //��������ģ�����ã���������佫�ں����ģ��Ŀ�����������һ��ӣ�
     
     //////////-----------------------1�����ģ������-----------------------------/////////
            
     //--------------------------------------------------------------
     
     
     public LowerUserClient(){    //������
    	// this.userId = userId;
    	 this.initComponents();  //��ʼ��������
    	 this.initialJpy();     //��ʼ������
    	 this.initialPanel();  //��ʼ��������ģ�����
    	 this.initialTree();     //��ʼ�����б�ؼ�
    	 this.addListener(); //Ϊ�ڵ�ע�������
    	 
     }
     
     public LowerUserClient(String user){    //������
     	 this.userId = user;
     	 this.initComponents();  //��ʼ��������
     	 this.initialJpy();     //��ʼ������
     	 this.initialPanel();  //��ʼ��������ģ�����
     	 this.initialTree();     //��ʼ�����б�ؼ�
     	 this.addListener(); //Ϊ�ڵ�ע�������
     	 
      }
     
     //2.6.2
     
     public void initialPanel() {//��ʼ��������ģ��
    	
    	 
    	 //----------------------����������ģ��ʵ��------------------
    	
    	 
    	 //---------------------------------------------------------
     }  
     
     public void initialTree(){ //��ʼ����״�б�ؼ��ķ���
    	 dmtnRoot.add(dmtn1);
    	 dmtnRoot.add(dmtn2);//�����ڵ���ӵ����ڵ�
    	 dmtnRoot.add(dmtn3);//�����ڵ���ӵ����ڵ�
    	 dmtnRoot.add(dmtn4);//�����ڵ���ӵ����ڵ�
    	
     }
     
     public void initialJpy(){                //��������ģ����ӵ�����
    	 jpy.setLayout(new CardLayout());    //���������óɿ�Ƭ����ģʽ
    	 cl = (CardLayout)jpy.getLayout();   //�õ����忨Ƭ����ģʽ������

    	// jpy.add(changepwdteacher, "changepwdteacher");
    
    	 //---------------�����-----------
    	 
    	 
    	 
     }
//     
//     public void initialJFrame(){       //���ô���ı��⣬��С������ɼ���
//    	 this.add(jsp1);jsp1.setDividerLocation(200);//���ָ����ӵ����壬�����÷ָ���λ��
//    	 jsp1.setDividerSize(4);       //���÷ָ��Ŀ��
//    	 
//    	 //String picPath = "d:" + File.separator + "workspace" + File.separator + "xs.jpg"; 
//    	 // Icon icon = new ImageIcon(picPath);
//    	 // this.setIcon(icon);
//    	  
//    	 Image image = new ImageIcon("ico.gif").getImage();//���ش���ͼ�����
//    	 this.setIconImage(image); this.setTitle("�û��ͻ���");//���ô����ͼ��ͱ���
//    	 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();//�õ���Ļ��dimension����С��ֵ
//    	 int centerX = screensize.width/2;//�õ���Ļ��ȵ��м����ص�
//    	 int centerY = screensize.height/2;//�õ���Ļ�߶ȵ��м����ص�
//    	 int w =900;//��������
//    	 int h =650;//������߶�
//    	 this.setBounds(centerX-w/2,centerY-h/2,w,h);//���ô����������Ļ���룻
//    	                                                //setBounts:�ƶ�������������С��ʹ������µ��н���� r���� r.x �� r.y ָ���������λ�ã��� r.width �� r.height ָ��������´�С 
//    	 this.setVisible(true);                         //���ô���ɼ�
//    	// this.setExtendedState(JFrame.MAXIMIZED_BOTH);//����ȫ��
//    	 
//     }
     
     
     private void initComponents() {
    	 
    
    		
    		
    		

    	 this.setTitle("��ͨ�û��ͻ���");
         jp_up = new javax.swing.JPanel();
         jlb_up = new javax.swing.JLabel();
         jsp1 = new javax.swing.JSplitPane();
         jp_left = new javax.swing.JPanel();
         
         
         /*************************************************************************
          * ע���޸ĵ�
          * ************************************************************************/
         jspz = new JScrollPane(jt);       //������������
         jpy = new javax.swing.JPanel();
         

        
       
         
	
    	 
    	 String sql ="Select eqp_type,num,authorize_flag from requirement where loweruser_id = '"+userId +"' AND dispose_flag='1'";
    	 System.out.println("-------------------2013-06-23:--"+sql);
    	 try {
    		 c = new SocketClient(sql,3);                           //ʵ����Client����
    		 c.send();                                        //��sql��䷢�͸��������˴���
    		 v_result = new Vector<String>();
    		 v_result = c.getV_result();	                  //�õ���ѯ���ݿ��Ľ��
    		} catch(Exception e){e.printStackTrace(); }                        //��ѯ���ݿ�
    	 
    	
    	
         for(int i =0;i<v_result.size();i=i+3){
//        	 jl_notify = new JLabel("֪ͨ��");
//        	 jl_notify.setBounds(10, 10, 100, 30);
//        	 jpy.add(jl_notify);
        	 
        	 if(v_result.get(i+2).equals("1")){
        		 String type = "����";
        		 if(v_result.get(i).equals("0"))type="���г�";
        		 if(v_result.get(i).equals("0"))type="����";
        		 String info = "��Ȩ���û��ύ"+v_result.get(i+1)+"��"+type+"������������Ȩ�ɹ����뼰ʱ��ȡ�豸����";
        	     jl_notify = new JLabel(info);
        	     jl_notify.setBounds(10,40+i*50,  100, 30);
        	     jpy.add(jl_notify);
        	 }
        	 if(v_result.get(i+2).equals("0")){
        		 String type = "���г�";
        		 if(v_result.get(i).equals("0"))type="���г�";
        	   if(v_result.get(i).equals("0"))type="����";
        		 String info = "δ��Ȩ���û��ύ"+v_result.get(i+1)+"��"+type+"������������Ȩʧ�ܣ�����������������룡��";
        	     jl_notify = new JLabel(info);
        	     jl_notify.setBounds(10,40+i*50,  100, 30);
        	     jpy.add(jl_notify);
        	 }
        	 
         }
         jpy.repaint();
         
        
         
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
    				 public void mouseClicked(MouseEvent e){       														 	//ʵ��mouseClicked����
    					 DefaultMutableTreeNode dmtntemp =  (DefaultMutableTreeNode)jt.getLastSelectedPathComponent();		//�õ���ǰѡ�нڵ����
    					 MyNode mynode = (MyNode)dmtntemp.getUserObject();      											//�õ��Զ���ڵ����
    					 String id = mynode.getid();     																	//�õ�ѡ�нڵ��id
    					 
    					 jpy.removeAll();
    					 jpy.repaint();
    					 
    					 //����idֵ��ʾ��ͬ�Ŀ�Ƭ
    					 if(id.equals("0")){System.out.println("��ӭҳ��");}
    					 
    					 else if (id.equals("1")){System.out.println("�ʲ�����"); 
//    					 jpy.add(myequipment, "myequipment");           													 //��searchequipment������ӵ�jpy����
//						  cl.show(jpy, "myequipment");                      												 //��searchequipment������ӵ���Ƭ
//						  myequipment.setFocusable(true);
    					 }
    					 else if (id.equals("2")){System.out.println("�ҵ��ʲ�");
//    					 jpy.add(equipmentordered, "equipmentordered");                                                      //��searchequipment������ӵ�jpy����
//						  cl.show(jpy, "equipmentordered");                     											 //��searchequipment������ӵ���Ƭ
//						  equipmentordered.setFocusable(true);
    					 }
    					 else if (id.equals("3")){ System.out.println("�û���Ϣ"); }
    					
    					 else if (id.equals("4")){System.out.println("�˳�");
    					 int i = JOptionPane.showConfirmDialog(jpy, "��ȷ��Ҫ�˳�ϵͳ��","ѯ��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						 if(i==0){System.exit(0);}
    					 }
    				 }
    			 });
    	 jt.setToggleClickCount(1);//��չ���ڵ����굥����������Ϊ1
     }
     
     
    
//     public static void main(String args[]){
//    	 String user ="123";
//    	 LowerUserClient luc =  new LowerUserClient();
//    	 luc.userId = user;
//    	 luc.setVisible(true);
//     }
     
     
     
     
}


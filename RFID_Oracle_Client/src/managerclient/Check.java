/*
 *功能未实现
 * */


package managerclient;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import socketclient.SocketClient;

import commobject.LocationTypeArray;

/**
 *
 * @author DELL
 */
public class Check extends javax.swing.JPanel {
	 String sql1;
	 String sql2;
	 SocketClient c;
	 Vector<String> v_result;
	// Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jb_download;
    private javax.swing.JButton jb_ok;
    private javax.swing.JComboBox jcb_check_location;
    private javax.swing.JComboBox jcb_eqp_type;
    private javax.swing.JTextField jtf_check_time;
    // End of variables declaration
	
	/** Creates new form Check */
    public Check() {
    	initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcb_check_location = new javax.swing.JComboBox();
        jcb_eqp_type = new javax.swing.JComboBox();
        jtf_check_time = new javax.swing.JTextField();
        jb_ok = new javax.swing.JButton();
        jb_download = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel1.setText("盘点设备信息创建");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel2.setText("盘点地点选择：");

        jLabel3.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel3.setText("盘点设备类型：");

        jLabel4.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel4.setText("盘点时间：");

        jcb_check_location.setModel(new javax.swing.DefaultComboBoxModel(LocationTypeArray.location));
        jcb_check_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_check_locationActionPerformed(evt);
            }
        });

        jcb_eqp_type.setModel(new javax.swing.DefaultComboBoxModel(LocationTypeArray.type));
        jcb_eqp_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_eqp_typeActionPerformed(evt);
            }
        });

        jtf_check_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_check_timeActionPerformed(evt);
            }
        });

        jb_ok.setText("确定");
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });

        jb_download.setText("下载");
        jb_download.setEnabled(false);
        jb_download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_downloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_ok)
                                .addGap(129, 129, 129)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_download)
                            .addComponent(jtf_check_time, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jcb_eqp_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcb_check_location, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(107, 107, 107)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_check_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcb_eqp_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_check_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_download)
                    .addComponent(jb_ok))
                .addGap(170, 170, 170))
        );
    }// </editor-fold>

private void jcb_check_locationActionPerformed(java.awt.event.ActionEvent evt) {
jcb_eqp_type.requestFocus();
}

private void jcb_eqp_typeActionPerformed(java.awt.event.ActionEvent evt) {
jtf_check_time.requestFocus();
}

private void jtf_check_timeActionPerformed(java.awt.event.ActionEvent evt) {
jb_ok.requestFocus();
}

//确定按钮的响应事件
private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {    
jb_download.setEnabled(true);

String str11=null,str12=null,str13=null;String str14 = null;//存储“设备地点”的查询条件
String str21 = null;                    //存储“设备类型”的查询条件
String str22 = null;             
String str23 = null;               

//--------------------”设备地点“查询条件解析---------
int i = jcb_check_location.getSelectedIndex() ;
	if (i == 0) {str11 = "南邮北门";str12 = "南邮南门";str13 = "南邮西门";str14 = "其他";}
	else{str11 = str12 = str13 = str14= (String) jcb_check_location.getSelectedItem();
 }

//----------------------”设备类型“的查询条件解析--------------------
int j = jcb_eqp_type.getSelectedIndex();
if(j == 0){str21 = "自行车";str23 ="其它";}
else{str21 = str22 = str23 = (String) jcb_eqp_type.getSelectedItem(); }

     //------------------盘点时间--------------------------------
      String check_time = jtf_check_time.getText();
      
      sql1 ="SELECT count(*) from all_tables where TABLE_NAME = 'CHECK_EQP' and OWNER='SCOTT'"; 
      try {
  		 c = new SocketClient(sql1,1);                           //实例化Client对象
  		 c.send();                                        //将sql语句发送给服务器端处理
  		 v_result = new Vector<String>();
  		 v_result = c.getV_result();	                  //得到查询数据库后的结果
  		} catch(Exception e){e.printStackTrace(); }       //查询数据库
 
  		if(v_result.get(0).equals("1")){
  			System.out.println("需要删除check_eqp表");
  			sql1 = "drop table CHECK_EQP";
  			try {
  		  		 c = new SocketClient(sql1);                           //实例化Client对象
  		  		 c.send();                                        //将sql语句发送给服务器端
  		  		
  			} catch(Exception e){e.printStackTrace(); }       //查询数据库
  		}
  		
      sql2 = "create  table check_eqp as select * from view_check_equipment";
System.out.println("sql2语句为：" + sql2);
String result = "0";
try {
	  c = new SocketClient(sql2);
	  c.send();
	  result = c.getResult();
   } catch(Exception e){e.printStackTrace(); }                        //查询数据库 

	 	if(result.split("\\/")[0].equals("0")){
  	 		JOptionPane.showMessageDialog(this, "盘点任务生成失败","错误",	JOptionPane.INFORMATION_MESSAGE);
  	 		
  	 	}
  	 	else{
  	 		JOptionPane.showMessageDialog(this, "盘点任务生成成功","消息",	JOptionPane.INFORMATION_MESSAGE);
  	 	}

}


//下载按键的响应事件
private void jb_downloadActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
}

public static void main(String args[]) {
	JFrame jf = new JFrame();
	Check seqp = new Check();
	jf.add(seqp);
	jf.setBounds(10,10,600,600);
	jf.setVisible(true);

	
}
  
}

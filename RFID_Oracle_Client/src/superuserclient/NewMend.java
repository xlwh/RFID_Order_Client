/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewMend.java
 *
 * Created on 2012-9-2, 20:08:33
 */
package superuserclient;

import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

import socketclient.SocketClient;




/**
 *
 * @author DELL
 */
public class NewMend extends javax.swing.JFrame {
   
    String userId;
    String str_eqp_Id;
    String sql;
    SocketClient c;
    Vector<String> v_result;
	
    public NewMend(String userId,String eqp_Id) {
    	this.str_eqp_Id = eqp_Id;
    	this.userId = userId;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jb_ok = new javax.swing.JButton();
        jtf_userId = new javax.swing.JTextField();
        jtf_eqp_Id = new javax.swing.JTextField();
        jtf_eqp_type = new javax.swing.JTextField();
        jtf_location = new javax.swing.JTextField();
        jtf_time = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_reason = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("圆幼", 1, 14)); // NOI18N
        jLabel1.setText("报修详情");

        jLabel2.setText("     报修人：");

        jLabel3.setText("    自行车序列号：");

        jLabel4.setText("自行车类型类型：");

        jLabel5.setText("使用地点：");

        jLabel6.setText("报修时间:");

        jLabel7.setText("报修原因：");

        jb_ok.setText("确定");;
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });

        jtf_userId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_usernameActionPerformed(evt);
            }
        });

        jtf_eqp_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_eqp_IdActionPerformed(evt);
            }
        });

        jtf_eqp_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_eqp_typeActionPerformed(evt);
            }
        });

        jtf_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_locationActionPerformed(evt);
            }
        });

        jtf_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_timeActionPerformed(evt);
            }
        });

        jta_reason.setColumns(20);
        jta_reason.setRows(5);
        jta_reason.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jta_reasonAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jta_reason);

        javax.swing.GroupLayout jpLayout = new javax.swing.GroupLayout(jp);
        jp.setLayout(jpLayout);
        jpLayout.setHorizontalGroup(
            jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_eqp_Id, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jtf_eqp_type, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jtf_time, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jtf_location, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jtf_userId, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_ok)
                    .addGroup(jpLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLayout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(160, 160, 160))
        );
        jpLayout.setVerticalGroup(
            jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_eqp_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jtf_eqp_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtf_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addComponent(jb_ok)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

private void jtf_usernameActionPerformed(java.awt.event.ActionEvent evt) {
        jtf_eqp_Id.requestFocus();
}

private void jtf_eqp_IdActionPerformed(java.awt.event.ActionEvent evt) {
      jtf_eqp_type.requestFocus();
}

private void jtf_eqp_typeActionPerformed(java.awt.event.ActionEvent evt) {
     jtf_location.requestFocus();
}

private void jtf_locationActionPerformed(java.awt.event.ActionEvent evt) {
    jtf_time.requestFocus();
}

private void jtf_timeActionPerformed(java.awt.event.ActionEvent evt) {
    jta_reason.requestFocus();
}

private void jta_reasonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jta_reasonAncestorAdded
    jb_ok.requestFocus();
}    

String str_eqpType;
String str_eqpLocation;
String str_now;
String str_reason;

private void jpAncestorAdded(javax.swing.event.AncestorEvent evt) {
	str_reason = jta_reason.getText().trim();
	if(str_reason.equals("")){str_reason.equals("原因未定");}
//	  jtf_userId.setEnabled(false);
//	  jtf_eqp_Id.setEnabled(false);
//	  jtf_eqp_type.setEnabled(false);
//	  jtf_location.setEnabled(false);
//	  jtf_time.setEnabled(false);
	
	Date now ;
    DateFormat d1 = DateFormat.getDateInstance();
    now = new Date(); 
    str_now = d1.format(now); 
    
	sql = "select equipment.eqp_type,room.eqp_location from equipment,room where room.eqp_Id = equipment.eqp_Id And equipment.eqp_Id = '" + str_eqp_Id+"'";
	try {
		 c = new SocketClient(sql,2);                           //实例化Client对象
		 c.send();                                        //将sql语句发送给服务器端处理
		 v_result = new Vector<String>();
		 v_result = c.getV_result();	                  //得到查询数据库后的结果
		} catch(Exception e){e.printStackTrace(); }
System.out.println("v_result 的结果为：" + v_result);
    	 str_eqpType = v_result.get(0);
    	 str_eqpLocation = v_result.get(1);
	   
	  jtf_userId.setText(userId); 
	  jtf_eqp_Id.setText(str_eqp_Id);
	  jtf_eqp_type.setText(str_eqpType);
	  jtf_location.setText(str_eqpLocation);
	  jtf_time.setText(str_now);
}

/*
 * 按下确定按键后，更新数据库
 * */
private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {
	sql = "insert into mend(eqp_Id,super_user_Id,mend_time,mend_reason) values('"+str_eqp_Id+"','"+userId+"',to_date('"+str_now+"','yyyy-MM-dd'),'"+str_reason+"')";
	try {
		 c = new SocketClient(sql);                             //实例化Client对象
		 c.send();                                        //将sql语句发送给服务器端处理
		} catch(Exception e){e.printStackTrace(); }                           //查询数据库
	sql = "update storage set eqp_mend_sign= '1' where eqp_Id ='" + str_eqp_Id+"'";
	try {
		 c = new SocketClient(sql);                           //实例化Client对象
		 c.send();                                        //将sql语句发送给服务器端处理
		} catch(Exception e){e.printStackTrace(); }
	this.setVisible(false);
}

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_ok;
    private javax.swing.JPanel jp;
    private javax.swing.JTextArea jta_reason;
    private javax.swing.JTextField jtf_eqp_Id;
    private javax.swing.JTextField jtf_eqp_type;
    private javax.swing.JTextField jtf_location;
    private javax.swing.JTextField jtf_time;
    private javax.swing.JTextField jtf_userId;
    // End of variables declaration//GEN-END:variables
    
    
    public static void main(String args[]) {
        NewMend newmend = new NewMend("1221101","1");
        newmend.setBounds(50,100,420,500);
        newmend.setVisible(true);
        }
}

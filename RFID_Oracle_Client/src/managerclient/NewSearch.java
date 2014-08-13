package managerclient;

import java.io.File;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import socketclient.SocketClient;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewSearch.java
 *
 * Created on 2013-6-26, 11:14:48
 */

/**
 *
 * @author DELL
 */
public class NewSearch extends javax.swing.JFrame {

	
    Vector <String> head_borrowed ;
    Vector<Vector> data_borrowed;
    DefaultTableModel dtm_borrowed;
    
    
    SocketClient c;
	Vector<String> v_result ;
	String sql;
    
    
    Vector<String> v_eqp_Id_found;
    
    
    /** Creates new form NewSearch */
    public NewSearch(Vector<String> v_eqp_Id_found) {
    	this.v_eqp_Id_found = v_eqp_Id_found;
System.out.println(v_eqp_Id_found);
        initComponents();
    }
    public NewSearch() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_borrowed = new javax.swing.JTable();
        jb_download = new javax.swing.JButton();
        jb_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(new java.awt.Color(204, 2, 2));

        jLabel1.setFont(new java.awt.Font("����", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/picture/newsearch.jpg"))); // NOI18N
       
        String picPath1 = System.getProperty("user.dir")+ File.separator + "picture" + File.separator + "newsearch.jpg"; 
        Icon icon1 = new ImageIcon(picPath1);
        jLabel1.setIcon(icon1); // NOI18N
        
        jLabel1.setText("�ʲ��������");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jt_borrowed.setBackground(new java.awt.Color(255, 255, 255));
        jt_borrowed.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        head_borrowed = new Vector<String>();                         //���ñ���ͷ
        {
        	head_borrowed.add("�豸���к�");
        	//head_borrowed.add("�豸����");
            head_borrowed.add("�ֿ��");
            head_borrowed.add("�����");
            head_borrowed.add("�к�");
            head_borrowed.add("λ�ú�");
           }
        data_borrowed= new Vector<Vector>();    //����
        
         for(int i = 0;i<v_eqp_Id_found.size();i++){
          String sql = "select eqp_id,storage_id,area_id,row_id,location_Id from storagelocation where eqp_id = '"+ v_eqp_Id_found.get(i)+"'";
        System.out.println(sql);
         try {
        	  c = new SocketClient(sql,5);                           //ʵ����Client����
        	  c.send();                                        //��sql��䷢�͸��������˴���
        	  v_result = new Vector<String>();
        	  v_result = c.getV_result();                       //�õ���ѯ���ݿ��Ľ��
       	} catch(Exception e){e.printStackTrace(); }       //��ѯ���ݿ�
        Vector<String> result = new Vector<String>();
        result.add(v_result.get(0));
        result.add(v_result.get(1)+"�Ųֿ�");
        result.add(v_result.get(2)+"������");
        result.add("��"+v_result.get(3)+"��");
        result.add(v_result.get(4)+"��λ��");
       	data_borrowed.add(result);
        }
                              
        dtm_borrowed = new DefaultTableModel(data_borrowed,head_borrowed);              //���������ģ��
        jt_borrowed= new javax.swing.JTable(dtm_borrowed);                    //����JTable��ʵ��
        jt_borrowed.setRowHeight(30);
        jScrollPane1.setViewportView(jt_borrowed);
       


        jb_download.setBackground(new java.awt.Color(255, 255, 255));
        //jb_download.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/picture/dowonload.jpg"))); // NOI18N
        
        String picPath2 = System.getProperty("user.dir")+ File.separator + "picture" + File.separator + "dowonload.jpg"; 
        Icon icon2 = new ImageIcon(picPath2);
        jb_download.setIcon(icon2); // NOI18N
        
        jb_download.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 255), null, null));
        jb_download.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_downloadActionPerformed(evt);
            }
        });

        jb_back.setBackground(new java.awt.Color(255, 255, 255));
      //  jb_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/picture/back.jpg"))); // NOI18N
        
        String picPath3 = System.getProperty("user.dir")+ File.separator + "picture" + File.separator + "back.jpg"; 
        Icon icon3 = new ImageIcon(picPath3);
        jb_back.setIcon(icon3); // NOI18N
        
        jb_back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 255), null, null));
        jb_back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_back.setPreferredSize(new java.awt.Dimension(95, 65));
        jb_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jb_download, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(jb_back, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jb_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_download, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

private void jb_downloadActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
	/*
	 * ��ɽ��������ص��ֳֻ�
	 * */
	
	
	
	
	
}

private void jb_backActionPerformed(java.awt.event.ActionEvent evt) {

this.setVisible(false);
	
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	Vector<String> d = new Vector<String>();
    	d.add("1111");
    	d.add("2222");
      NewSearch ns = new NewSearch(d);
      ns.setVisible(true);
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_back;
    private javax.swing.JButton jb_download;
    private javax.swing.JTable jt_borrowed;
    // End of variables declaration
}
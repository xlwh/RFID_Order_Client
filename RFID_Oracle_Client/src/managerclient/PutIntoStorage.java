/*
 * ��������豸��Ϣ������¼�빤������������豸���ͺ�����
 * 
 * ����RFID��ȡ����豸��Ϣ����֤����
 * */
package managerclient;

import txtStorage.StorageTxt;

/**
 *
 * @author DELL
 */
public class PutIntoStorage extends javax.swing.JPanel {
 
	static final String fileAddress = "D:\\storageInputNum.txt";
	
	int eqpType = 0;
	int eqpNum=0;
	StorageTxt st;
	
    /** Creates new form PutIntoStorage */
    public PutIntoStorage() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcb_type = new javax.swing.JComboBox();
        jtf_num = new javax.swing.JTextField();
        jb_reset = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("��Բ", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLabel1.setSize(100, 30);
        jLabel1.setText("�����Ϣ¼�� ");
       

        jLabel2.setText("���г����ͣ�");

        jLabel3.setText("���������");

        jcb_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "���г�","����" }));
        jcb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_typeActionPerformed(evt);
            }
        });

        jb_reset.setText("����");
        jb_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_resetActionPerformed(evt);
            }
        });

        jb_ok.setText("ȷ��");
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_reset)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtf_num, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(142, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_ok)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_reset)
                    .addComponent(jb_ok))
                .addGap(119, 119, 119))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jcb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_typeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcb_typeActionPerformed

private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_resetActionPerformed
jtf_num.setText("");

}//GEN-LAST:event_jb_resetActionPerformed

private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed

	eqpType = jcb_type.getSelectedIndex();
	eqpNum =Integer.parseInt(jtf_num.getText()) ;
	String str = eqpType + "," + eqpNum + "\r\n";     //����豸���ͺ�����
	st = new StorageTxt();
	st.writeStr(fileAddress, str);

	
}//GEN-LAST:event_jb_okActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_ok;
    private javax.swing.JButton jb_reset;
    private javax.swing.JComboBox jcb_type;
    private javax.swing.JTextField jtf_num;
    // End of variables declaration//GEN-END:variables
}
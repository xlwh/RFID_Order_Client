/*
 * To change this template, choose Tools | Templates

 * and open the template in the editor.
 */

/*
 * PanelLocation.java
 *
 * Created on 2013-6-20, 16:36:54
 */
/**
 *
 * @author DELL
 */
package routeShow;
import java.awt.Color;
import java.awt.Graphics;

public class PanelLocation extends javax.swing.JPanel {

    String name ;
    /** Creates new form PanelLocation */
    public PanelLocation(String name) {
        initComponents();
        jlb.setText(name);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jlb.setFont(new java.awt.Font("����", 1, 24));
        jlb.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlb;
    // End of variables declaration//GEN-END:variables

    public void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        g.setColor(new java.awt.Color(145, 170, 213));
        g.drawOval(0, 0, w - 1, h - 1);

    }

}

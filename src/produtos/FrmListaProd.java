package produtos;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import vendas.FrmCaixa;

/**
 *
 * @author hugov
 */
public class FrmListaProd extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmListaProd
     */
    public FrmListaProd() {
        initComponents();
        tabela.getTableHeader().setDefaultRenderer(new principal.EstiloTabelaHeader());
        tabela.setDefaultRenderer(Object.class, new principal.EstiloTabelaRenderer());
        // puxa um registro armazenado na tabela Produtos no banco de dados
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        ProdutosDAO.listarCategoria("");
        
        cmbTipo.addItemListener(new ItemListener(){
            
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (cmbTipo.getSelectedIndex() == 0){
                    ProdutosDAO.listarCategoria("");
                }
                if (cmbTipo.getSelectedIndex() == 1){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 2){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 3){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 4){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 5){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 6){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 7){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 8){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
                if (cmbTipo.getSelectedIndex() == 9){
                    ProdutosDAO.listarCategoria(cmbTipo.getSelectedItem().toString());
                }
            }
        });
    }
    
    public void calcular(){
        String preco;
        String qtd;
        float total = 0.0f;
        float precoFormatado = 0.0f;
        int quantidade;
        float calculo = 0.0f;
        
        for (int i = 0; i < vendas.FrmCaixa.tabela.getRowCount(); i++){
        
            preco = vendas.FrmCaixa.tabela.getValueAt(i, 3).toString();
            qtd = vendas.FrmCaixa.tabela.getValueAt(i, 4).toString();
            precoFormatado = Float.parseFloat(preco);
            quantidade = Integer.parseInt(qtd);
            calculo = quantidade * precoFormatado;
            total = total + calculo;
            vendas.FrmCaixa.tabela.setValueAt(Math.rint(calculo * 100) / 100, i, 5);
        }
        //Função Math.rint() faz o arrendondamento de valores monetários
        vendas.FrmCaixa.txtTotal.setText("" + Math.rint(total * 100) / 100);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtBusca = new app.bolivia.swing.JCTextField();
        lblBusca = new javax.swing.JLabel();
        cmbTipo = new org.bolivia.combo.SComboBoxBlue();
        lblTipo = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(715, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TIPO PRODUTO", "NOME PRODUTO", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabela);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBusca.setBackground(new java.awt.Color(34, 102, 145));
        txtBusca.setBorder(null);
        txtBusca.setForeground(new java.awt.Color(255, 255, 255));
        txtBusca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBusca.setOpaque(false);
        txtBusca.setPhColor(new java.awt.Color(255, 255, 255));
        txtBusca.setPlaceholder("CÓDIGO/NOME");
        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });
        jPanel4.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        lblBusca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel4.add(lblBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 52));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO PRODUTO", "BEBIDAS", "CARNES", "DOCES", "FRUTAS", "LACTINEOS", "LEGUMES", "MASSA", "SOPA", "VERDURAS" }));
        cmbTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        jPanel4.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 183, -1));

        lblTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/tipopro.png"))); // NOI18N
        jPanel4.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, 52));

        btnEnviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis1.png"))); // NOI18N
        btnEnviar.setText("Enviar Produto");
        btnEnviar.setBorder(null);
        btnEnviar.setBorderPainted(false);
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEnviar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis2.png"))); // NOI18N
        btnEnviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 100, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        txtBusca.setText(txtBusca.getText().toUpperCase());
        ProdutosDAO.listarCategoria(txtBusca.getText());
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
    
        if (tabela.getRowCount() > 0){
            String qtd = null;
            DefaultTableModel modelo = (DefaultTableModel) vendas.FrmCaixa.tabela.getModel();
            int numColunas = 6;
            String dados[] = new String[numColunas];
            
            int linha = tabela.getSelectedRow();
            
            //se não tiver linha selecionada, o usuário deve ser informado
            if (linha == -1){
                JOptionPane.showMessageDialog(null, "Selecione um produto", "Produtos para o caixa", JOptionPane.WARNING_MESSAGE);
            } else {
                String cod = tabela.getValueAt(linha, 0).toString();
                String tipoProduto = tabela.getValueAt(linha, 1).toString();
                String nome = tabela.getValueAt(linha, 2).toString();
                String preco = tabela.getValueAt(linha, 3).toString();
                int posicao = 0;
                int itens = 0;
                qtd = JOptionPane.showInputDialog(this, "Quantidade: ", "Produtos", JOptionPane.INFORMATION_MESSAGE);
                while (!ProdutosDAO.isNumber(qtd)){
                    qtd = JOptionPane.showInputDialog(null, "Insira valores numéricos maiores do que 0:", 
                            "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                
                if (qtd.equals("") || qtd.equals("0")){
                    JOptionPane.showMessageDialog(null, "Insira valores maiores do que 0",
                            "Quantidade Produtos", JOptionPane.WARNING_MESSAGE);
                } else {
                    for (int i = 0; i < vendas.FrmCaixa.tabela.getRowCount(); i++){
                        Object comprovante = vendas.FrmCaixa.tabela.getValueAt(i, 0);
                        Object quantidadeNova = vendas.FrmCaixa.tabela.getValueAt(i, 4);
                        
                        if (cod.equals(comprovante)){
                            posicao = i;
                            int quantidadeTotal = Integer.parseInt(qtd) + Integer.parseInt((String) quantidadeNova);  
                            String quantidadeTotalFormat = String.valueOf(quantidadeTotal);
                            vendas.FrmVendas.tabela.setValueAt(quantidadeTotalFormat, i, 4); 
                            itens++;
                            calcular();
                            vendas.FrmCaixa.txtRecebido.setText("");
                            vendas.FrmCaixa.txtTroco.setText("");
                        }
                    }    
                    
                    if (itens == 0) {
                        dados[0] = cod;
                        dados[1] = tipoProduto;
                        dados[2] = nome;
                        dados[3] = preco;
                        dados[4] = qtd;

                        modelo.addRow(dados);

                        vendas.FrmCaixa.tabela.setModel(modelo);
                        calcular();
                        vendas.FrmCaixa.txtRecebido.setText("");
                        vendas.FrmCaixa.txtTroco.setText("");
                    }
                }               
            }        
        } else {
            JOptionPane.showMessageDialog(null, "Não há registros", "Produtos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private org.bolivia.combo.SComboBoxBlue cmbTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblTipo;
    public static javax.swing.JTable tabela;
    private app.bolivia.swing.JCTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
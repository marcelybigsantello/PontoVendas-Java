package principal;

import ConexaoBD.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static principal.MenuPrincipal.txtUsuario;
import static principal.Sessao.conn;

/**
 *
 * @author Marcely Biguzzi Santello
 */
public class Login extends javax.swing.JFrame {
   
    SplashScreen inicio;
    private final String caminhoIconeInfo = "/imagens/principal/info.png";
    
    //Construtor sem parametros
    public Login() {
        initComponents();
    }
    
    //Construtor passando um objeto SplashScreen como parametro
    public Login(SplashScreen inicio){
        this.inicio = inicio;
        setProgress(0, "Carregando os componentes do sistema");
        initComponents();
        setProgress(20, "Conectando ao Banco de Dados");
        setProgress(40, "Carregando os módulos do sistema");
        setProgress(60, "Carregamento dos módulos concluído");
        setProgress(80, "Inicializando interfaces");
        setProgress(90, "Interfaces inicializadas");
        setProgress(100, "Sistema pronto! Seja bem-vindo!!");
        this.setSize(410, 500);
        this.txtUsuario.setText("");
        this.txtSenha.setText("");
        
    }
    
    private void setProgress(int percent, String info){
        inicio.getJLabel().setText(info);
        inicio.getProgressBar().setValue(percent);
        
        try{
            //delay de 2000 ms, ou, 2 segundos
            Thread.sleep(100);
        } catch(InterruptedException ex){
            JOptionPane.showMessageDialog(this, "Não foi possível carregar a barra de inicialização\n");
        }
    }
    
    public String identificarPerfil (){
        String usuario = txtUsuario.getText();        
        String perfil = Sessao.armazenarPerfil(usuario);
        
        if (perfil.equals("ADMINISTRADOR")){
            dispose();     //encerra a janela de login
            MenuPrincipal menu = new MenuPrincipal();
            JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema de Compras " + usuario + "!",
                    "Administrador", 1, new ImageIcon(getClass().getResource(caminhoIconeInfo)));

            menu.txtUsuario.setText(usuario);
            menu.setVisible(true);
        } else {
            dispose();     //encerrar a janela de login 
            MenuPrincipalPadrao menuComum = new MenuPrincipalPadrao();  //inicializa o menu com o perfil padrão de usuário
            JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema de Compras " + usuario + "!",
                    "Usuário Padrão", 1, new ImageIcon(getClass().getResource(caminhoIconeInfo)));

            menuComum.lblUsuario.setText(usuario);
            menuComum.setVisible(true);
        }
        return perfil;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLogin = new javax.swing.JPanel();
        painelImgCab = new javax.swing.JPanel();
        imgTopoForm = new javax.swing.JLabel();
        painelCentral = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new app.bolivia.swing.JCTextField();
        txtSenha = new jpass.JRPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        painelRodape = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(0, 0));
        setName("telaPrincipal"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelLogin.setLayout(new java.awt.BorderLayout());

        imgTopoForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/imagemLogin.jpg"))); // NOI18N
        imgTopoForm.setPreferredSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout painelImgCabLayout = new javax.swing.GroupLayout(painelImgCab);
        painelImgCab.setLayout(painelImgCabLayout);
        painelImgCabLayout.setHorizontalGroup(
            painelImgCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImgCabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgTopoForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelImgCabLayout.setVerticalGroup(
            painelImgCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImgCabLayout.createSequentialGroup()
                .addComponent(imgTopoForm, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        painelLogin.add(painelImgCab, java.awt.BorderLayout.PAGE_START);

        painelCentral.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/user.png"))); // NOI18N
        painelCentral.add(jLabel3, java.awt.BorderLayout.LINE_START);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(34, 102, 145));
        txtUsuario.setBorder(null);
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.setName("txtUsuario"); // NOI18N
        txtUsuario.setOpaque(false);
        txtUsuario.setPhColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setPlaceholder("USUARIO");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, -1));

        txtSenha.setBackground(new java.awt.Color(34, 102, 145));
        txtSenha.setBorder(null);
        txtSenha.setForeground(new java.awt.Color(255, 255, 255));
        txtSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSenha.setName("txtSenha"); // NOI18N
        txtSenha.setOpaque(false);
        txtSenha.setPhColor(new java.awt.Color(255, 255, 255));
        txtSenha.setPlaceholder("SENHA");
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 180, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/campoLoginUs.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/campoLoginPass.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        painelCentral.add(jPanel1, java.awt.BorderLayout.CENTER);

        painelRodape.setPreferredSize(new java.awt.Dimension(635, 60));
        painelRodape.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/entrar2.png"))); // NOI18N
        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.setName("btnEntrar"); // NOI18N
        btnEntrar.setOpaque(false);
        btnEntrar.setPreferredSize(new java.awt.Dimension(135, 45));
        btnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/entrar1.png"))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        painelRodape.add(btnEntrar);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/sair2.png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.setBorderPainted(false);
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.setOpaque(false);
        btnSair.setPreferredSize(new java.awt.Dimension(135, 45));
        btnSair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/sair1.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        painelRodape.add(btnSair);

        painelCentral.add(painelRodape, java.awt.BorderLayout.PAGE_END);

        painelLogin.add(painelCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelLogin);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        /*MenuPrincipal tela = new MenuPrincipal();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);*/
        String us = txtUsuario.getText();
        String pass = txtSenha.getText();
        
        if (us.equals("") || pass.equals("")){
            JOptionPane.showMessageDialog(this, "Preencha os campos usuário e senha corretamente", "Login", 0, 
                    new ImageIcon(getClass().getResource(caminhoIconeInfo)));
        }
        else{
            
            Sessao.usuario = Sessao.logarUsuario(us, pass);
            //Logando o usuário e identificando o perfil
            identificarPerfil();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int retorno = 0;
        retorno = JOptionPane.showConfirmDialog(null, "Você realmente deseja sair do sistema?",
                "Confirmação de saída", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (retorno == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        // TODO add your handling code here:
        txtUsuario.setText(txtUsuario.getText().toUpperCase());
    }//GEN-LAST:event_txtUsuarioKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login tela = new Login();
                //tela centralizada
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel imgTopoForm;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JPanel painelImgCab;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPanel painelRodape;
    private jpass.JRPasswordField txtSenha;
    private app.bolivia.swing.JCTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
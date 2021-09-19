package mvc.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class Vista extends javax.swing.JFrame {

    
    public Vista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgPersona = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblImageC = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jcbSexo = new javax.swing.JComboBox<>();
        txtSueldo = new javax.swing.JTextField();
        txtCupo = new javax.swing.JTextField();
        btnExaminar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jdcFechanacimiento = new com.toedter.calendar.JDateChooser();
        Fondo = new javax.swing.JPanel();
        Encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnRefresacar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        PiePagina = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersona = new javax.swing.JTable();
        lblFoto = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(570, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 38, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Nombres:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 83, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 128, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Telefono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 179, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Sexo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 266, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Sueldo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 312, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Cupo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 365, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Foto:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 38, -1, -1));

        lblImageC.setBackground(new java.awt.Color(255, 255, 51));
        lblImageC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel1.add(lblImageC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 215, 275));

        txtNombres.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 79, 221, -1));

        txtID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 34, 221, -1));

        txtApellidos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 124, 221, -1));

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 216, 221, -1));

        jcbSexo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "FEMENINO", "MASCULINO" }));
        jPanel1.add(jcbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 261, 221, -1));

        txtSueldo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 308, 221, -1));

        txtCupo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtCupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 361, 221, -1));

        btnExaminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnExaminar.setText("EXAMINAR");
        jPanel1.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 353, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 442, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 442, -1, -1));

        jdcFechanacimiento.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdcFechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 160, -1));

        javax.swing.GroupLayout dlgPersonaLayout = new javax.swing.GroupLayout(dlgPersona.getContentPane());
        dlgPersona.getContentPane().setLayout(dlgPersonaLayout);
        dlgPersonaLayout.setHorizontalGroup(
            dlgPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgPersonaLayout.setVerticalGroup(
            dlgPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(0, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Encabezado.setBackground(new java.awt.Color(0, 255, 153));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("BUSCADOR");

        txtBuscador.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnCrear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCrear.setText("Crear");

        btnRefresacar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRefresacar.setText("Refresca");

        btnEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEditar.setText("Editar");

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnImprimir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnImprimir.setText("IMPRIMIR");

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresacar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addContainerGap())
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnRefresacar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnImprimir)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        Fondo.add(Encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 100));

        PiePagina.setBackground(new java.awt.Color(102, 0, 204));

        jLabel2.setText("persona 1.0");

        javax.swing.GroupLayout PiePaginaLayout = new javax.swing.GroupLayout(PiePagina);
        PiePagina.setLayout(PiePaginaLayout);
        PiePaginaLayout.setHorizontalGroup(
            PiePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PiePaginaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(847, Short.MAX_VALUE))
        );
        PiePaginaLayout.setVerticalGroup(
            PiePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PiePaginaLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );

        Fondo.add(PiePagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 920, 50));

        tblPersona.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRES", "APELLIDOS", "EDAD", "TELEFONO", "SEXO", "SUELDO", "CUPO", "FOTO"
            }
        ));
        jScrollPane1.setViewportView(tblPersona);

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 640, 430));
        Fondo.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 220, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getPiePagina() {
        return PiePagina;
    }

    public void setPiePagina(JPanel PiePagina) {
        this.PiePagina = PiePagina;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnExaminar() {
        return btnExaminar;
    }

    public void setBtnExaminar(JButton btnExaminar) {
        this.btnExaminar = btnExaminar;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public JButton getBtnRefresacar() {
        return btnRefresacar;
    }

    public void setBtnRefresacar(JButton btnRefresacar) {
        this.btnRefresacar = btnRefresacar;
    }

    public JDialog getDlgPersona() {
        return dlgPersona;
    }

    public void setDlgPersona(JDialog dlgPersona) {
        this.dlgPersona = dlgPersona;
    }

    

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JComboBox<String> getJcbSexo() {
        return jcbSexo;
    }

    public void setJcbSexo(JComboBox<String> jcbSexo) {
        this.jcbSexo = jcbSexo;
    }

    public JDateChooser getJdcFechanacimiento() {
        return jdcFechanacimiento;
    }

    public void setJdcFechanacimiento(JDateChooser jdcFechanacimiento) {
        this.jdcFechanacimiento = jdcFechanacimiento;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public void setLblFoto(JLabel lblFoto) {
        this.lblFoto = lblFoto;
    }

    public JTable getTblPersona() {
        return tblPersona;
    }

    public void setTblPersona(JTable tblPersona) {
        this.tblPersona = tblPersona;
    }

    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(JTextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public JTextField getTxtBuscador() {
        return txtBuscador;
    }

    public void setTxtBuscador(JTextField txtBuscador) {
        this.txtBuscador = txtBuscador;
    }

    public JTextField getTxtCupo() {
        return txtCupo;
    }

    public void setTxtCupo(JTextField txtCupo) {
        this.txtCupo = txtCupo;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(JTextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public JTextField getTxtSueldo() {
        return txtSueldo;
    }

    public void setTxtSueldo(JTextField txtSueldo) {
        this.txtSueldo = txtSueldo;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JLabel getLblImageC() {
        return lblImageC;
    }

    public void setLblImageC(JLabel lblImageC) {
        this.lblImageC = lblImageC;
    }
    
    
            
            
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Encabezado;
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel PiePagina;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRefresacar;
    private javax.swing.JDialog dlgPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbSexo;
    private com.toedter.calendar.JDateChooser jdcFechanacimiento;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblImageC;
    private javax.swing.JTable tblPersona;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtCupo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables





}

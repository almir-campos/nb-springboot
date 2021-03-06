/*
 * Copyright 2016 Alessandro Falappa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.alexfalappa.nbspringboot.templates.applproperties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.api.project.Project;
import org.netbeans.modules.maven.api.NbMavenProject;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;

import static com.github.alexfalappa.nbspringboot.templates.applproperties.ApplWizardIterator.WIZ_BASE_NAME;
import static com.github.alexfalappa.nbspringboot.templates.applproperties.ApplWizardIterator.WIZ_LOCATION;
import static com.github.alexfalappa.nbspringboot.templates.applproperties.ApplWizardIterator.WIZ_PROFILE;

public final class ApplVisualPanel1 extends JPanel implements DocumentListener {

    private final ApplWizardPanel1 panel;
    private NbMavenProject nbProj;
    private File resourceFolder = new File(System.getProperty("user.dir"));

    @SuppressWarnings("LeakingThisInConstructor")
    public ApplVisualPanel1(ApplWizardPanel1 panel) {
        initComponents();
        this.panel = panel;
        // Register listener on the textFields to make the automatic updates
        txBaseName.getDocument().addDocumentListener(this);
        txProfile.getDocument().addDocumentListener(this);
    }

    File getCreatedFile() {
        return FileUtil.normalizeFile(new File(txCreated.getText()).getAbsoluteFile());
    }

    void store(WizardDescriptor wd) {
        String baseName = txBaseName.getText().trim();
        String profile = txProfile.getText().trim();
        wd.putProperty(WIZ_BASE_NAME, baseName);
        wd.putProperty(WIZ_PROFILE, profile);
        wd.putProperty(WIZ_LOCATION, decodeLocation());
    }

    void read(WizardDescriptor wd) {
        boolean isTest = false;
        final String location = (String) wd.getProperty(ApplWizardIterator.WIZ_LOCATION);
        if (location != null) {
            isTest = location.equals("test");
        }
        final Project project = Templates.getProject(wd);
        if (project != null) {
            nbProj = project.getLookup().lookup(NbMavenProject.class);
            // this will in turn update the resourceFolder field
            cbLocation.setSelectedIndex(isTest ? 1 : 0);
        }
        String baseName = (String) wd.getProperty(ApplWizardIterator.WIZ_BASE_NAME);
        if (baseName == null) {
            baseName = "application";
        }
        this.txBaseName.setText(baseName);
        this.txBaseName.selectAll();
        this.txProfile.setText((String) wd.getProperty(ApplWizardIterator.WIZ_PROFILE));
    }

    private void updateResourceFolder(boolean isTest) {
        final URI[] resources = nbProj.getResources(isTest);
        if (resources.length > 0) {
            try {
                resourceFolder = FileUtil.archiveOrDirForURL(resources[0].toURL());
            } catch (MalformedURLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    /** This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lBaseName = new javax.swing.JLabel();
        txBaseName = new javax.swing.JTextField();
        lProfile = new javax.swing.JLabel();
        txProfile = new javax.swing.JTextField();
        chConfigSubd = new javax.swing.JCheckBox();
        lCreated = new javax.swing.JLabel();
        txCreated = new javax.swing.JTextField();
        lLocation = new javax.swing.JLabel();
        cbLocation = new javax.swing.JComboBox<>();

        org.openide.awt.Mnemonics.setLocalizedText(lBaseName, org.openide.util.NbBundle.getBundle(ApplVisualPanel1.class).getString("ApplVisualPanel1.lBaseName.text")); // NOI18N

        txBaseName.setColumns(15);

        org.openide.awt.Mnemonics.setLocalizedText(lProfile, org.openide.util.NbBundle.getBundle(ApplVisualPanel1.class).getString("ApplVisualPanel1.lProfile.text")); // NOI18N

        txProfile.setColumns(15);

        org.openide.awt.Mnemonics.setLocalizedText(chConfigSubd, org.openide.util.NbBundle.getBundle(ApplVisualPanel1.class).getString("ApplVisualPanel1.chConfigSubd.text")); // NOI18N
        chConfigSubd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chConfigSubdActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lCreated, org.openide.util.NbBundle.getBundle(ApplVisualPanel1.class).getString("ApplVisualPanel1.lCreated.text")); // NOI18N

        txCreated.setEditable(false);
        txCreated.setColumns(15);

        org.openide.awt.Mnemonics.setLocalizedText(lLocation, org.openide.util.NbBundle.getBundle(ApplVisualPanel1.class).getString("ApplVisualPanel1.lLocation.text")); // NOI18N

        cbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Source Resources", "Test Resources" }));
        cbLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lBaseName)
                    .addComponent(lProfile)
                    .addComponent(lCreated)
                    .addComponent(lLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txBaseName)
                    .addComponent(txProfile)
                    .addComponent(txCreated)
                    .addComponent(chConfigSubd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBaseName)
                    .addComponent(txBaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProfile)
                    .addComponent(txProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLocation)
                    .addComponent(cbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chConfigSubd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCreated)
                    .addComponent(txCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chConfigSubdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chConfigSubdActionPerformed
        updateTexts();
    }//GEN-LAST:event_chConfigSubdActionPerformed

    private void cbLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocationActionPerformed
        updateResourceFolder(cbLocation.getSelectedIndex() > 0);
        updateTexts();
    }//GEN-LAST:event_cbLocationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLocation;
    private javax.swing.JCheckBox chConfigSubd;
    private javax.swing.JLabel lBaseName;
    private javax.swing.JLabel lCreated;
    private javax.swing.JLabel lLocation;
    private javax.swing.JLabel lProfile;
    private javax.swing.JTextField txBaseName;
    private javax.swing.JTextField txCreated;
    private javax.swing.JTextField txProfile;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateTexts();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateTexts();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateTexts();
    }

    private String decodeLocation() {
        return cbLocation.getSelectedIndex() == 0 ? "main" : "test";
    }

    // Handles changes in the base name and profile
    private void updateTexts() {
        // Change in the project name
        String baseName = txBaseName.getText();
        String profile = txProfile.getText();
        StringBuilder sb = new StringBuilder(resourceFolder.getAbsolutePath());
        sb.append(File.separatorChar);
        if (chConfigSubd.isSelected()) {
            sb.append("config").append(File.separatorChar);
        }
        sb.append(baseName);
        if (!profile.isEmpty()) {
            sb.append('-').append(profile);
        }
        sb.append(".properties");
        txCreated.setText(sb.toString());
        // Notify that the panel changed
        panel.fireChangeEvent();
    }

    boolean valid(WizardDescriptor wizardDescriptor) {
        if (txBaseName.getText().isEmpty()) {
            // Base name not specified
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, "Base name cannot be empty!");
            return false;
        }
        File f = getCreatedFile();
        if (f.exists()) {
            // Existing file
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, "Application properties file exists!");
            return false;
        }
        wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, "");
        final FileObject targetFolder = FileUtil.toFileObject(f.getParentFile());
        Templates.setTargetFolder(wizardDescriptor, targetFolder);
        Templates.setTargetName(wizardDescriptor, f.getName());
        return true;
    }

}

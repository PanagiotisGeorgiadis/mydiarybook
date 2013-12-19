/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.MyDiaryBookController;
import controller.NewEntryImageController;
import controller.NewEntryTextController;
import controller.NewEntryVideoController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author Zarc
 */
public class MyDiaryBook extends javax.swing.JFrame {
    private File[] images;
    private String imageMode;
    private final String fSeparator = File.separator;
    private EmbeddedMediaPlayerComponent mediaPlayer2 =null;
    private String vlcPath = System.getProperty("user.dir")+fSeparator+"VLC"+fSeparator;

    /**
     * Creates new form MyDiaryBook
     */
    public MyDiaryBook() 
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }
        MyDiaryBook.setDefaultLookAndFeelDecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        entriesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        loadEntiesList();
        entriesList.setSelectedIndex(0);
        jScrollPane4.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane4.getHorizontalScrollBar().setUnitIncrement(20);
        System.setProperty("jna.library.path", vlcPath);
        loadImageButton.setVisible(false);
        loadAlbumButton.setVisible(false);
        imageListScrollPane.setVisible(false);
    }
    
    /** Displays the new Image Specified in 2 different modes: 
     * Album mode which can contain up to 30 images and
     * Single mode which can contain 1 image but scaled properly.
     * @param imagePath The path of the image.     
     * @param mode String "Album" for Album mode or a random string for 
     * Single mode
     */  
    public void displayNewImage(URI imagePath,String mode)
    {
        JLabel jlabel = new JLabel();
        ImageIcon icon = null;
        Image newimg = null;
        try 
        {
            icon = new ImageIcon(imagePath.toURL());
            Image img = icon.getImage();
            if(mode == "Album")
                newimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            else
                newimg = img.getScaledInstance(img.getWidth(jlabel), img.getWidth(jlabel), Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            imagePanel.add(jlabel);
            jlabel.setIcon(newIcon);
        } 
        catch (MalformedURLException ex) 
        {
            imagePanel.remove(jlabel);
        }        
    }
    
    public void displayVideo(String videoPath,String whatToDo)
    {
        EmbeddedMediaPlayerComponent mediaPlayer = mediaPlayer2;
                // ****** VlcJ framework  ******//
        if(whatToDo.equalsIgnoreCase("Display"))
        {
            Dimension d = videoPanel.getSize();
            mediaPlayer.setSize(d);
            videoPanel.add(mediaPlayer);
            mediaPlayer.getMediaPlayer().attachVideoSurface();
            mediaPlayer.getMediaPlayer().playMedia(videoPath); 
        }
        else if(whatToDo.equalsIgnoreCase("Pause"))
        {
            mediaPlayer.getMediaPlayer().pause();
        }
        else if(whatToDo.equalsIgnoreCase("Play"))
        {
            mediaPlayer.getMediaPlayer().play();
        }
        else
        {
            mediaPlayer.release(true);
            videoPanel.remove(mediaPlayer);
        }
    }
    
    public void loadEntiesList()
    {
        MyDiaryBookController controller = new MyDiaryBookController();
        DefaultListModel listModel = new DefaultListModel();
        try
        {
            String[] entries = controller.getEntriesList();
            for(int i=0;i<entries.length;i++)
            {
                listModel.addElement(entries[i]);    
            }
            entriesList.setModel(listModel);
        }
        catch(NullPointerException ex)
        {
            listModel.clear();
            entriesList.setModel(listModel);
            //logger
        }
    }    
    
    public void loadImageList()
    {
        MyDiaryBookController controller = new MyDiaryBookController();
        DefaultListModel listModel = new DefaultListModel();
        try
        {
            String[] images = controller.getImageList(entriesList.getSelectedValue().toString());
            for(int i=0;i<images.length;i++)
            {
                listModel.addElement(images[i]);    
            }
            imagesList.setModel(listModel);
            loadAlbumButton.setVisible(true);
        }
        catch(NullPointerException ex)
        {
            listModel.clear();
            imagesList.setModel(listModel);
            loadAlbumButton.setVisible(false);
            imageListScrollPane.setVisible(false);
            //logger
        }
    }
    
    public void loadEntryImages()
    {
        imageMode="Album";
        imagePanel.removeAll();
        GridLayout layout = new GridLayout();
        layout.setColumns(10);
        layout.setRows(3);
        imagePanel.setLayout(layout);
        NewEntryImageController controller = new NewEntryImageController();
        try{
            images = controller.getImageFiles(entriesList.getSelectedValue().toString());
            for(int i=0;i<images.length;i++)
            {
                displayNewImage(images[i].toURI(),imageMode);
            }
        }
        catch(NullPointerException ex)
        {
            //logger
        }
    }
    
    public void loadEntryImage()
    {
        imageMode="Single";
        imagePanel.removeAll();
        BorderLayout border = new BorderLayout();
        try
        {
            imagePanel.setLayout(border);
            String imageName = imagesList.getSelectedValue().toString();
            int i=0;
            while(!images[i].getName().equals(imageName))
            {
                i++;
            }
            File image = images[i];
            displayNewImage(images[i].toURI(),imageMode);
        }
        catch(NullPointerException ex)
        {
            //logger
        }
    }
    
    public void loadEntryText()
    {
        NewEntryTextController controller = new NewEntryTextController();
        try
        {
            entryTextArea.setText(controller.returnTextFile(entriesList.getSelectedValue().toString()));
        }
        catch(NullPointerException ex)
        {
            //logger
        }
    }
    
    public void loadEntryVideo()
    {
        NewEntryVideoController controller = new NewEntryVideoController();
        File video;
        try
        {
            video = controller.getVideo(entriesList.getSelectedValue().toString());
            mediaPlayer2 = new EmbeddedMediaPlayerComponent(); 
            displayVideo(video.toString(),"Display");
        }
        catch(NullPointerException ex)
        {
            //logger
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        displayEntryPane = new javax.swing.JTabbedPane();
        textPanel = new javax.swing.JPanel();
        entryTextAreaScrollPane = new javax.swing.JScrollPane();
        entryTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        entriesList = new javax.swing.JList();
        entryTitleField = new javax.swing.JTextField();
        entryTitleLabel = new javax.swing.JLabel();
        newEntryButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        imagePanelContainer = new javax.swing.JPanel();
        imageListScrollPane = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        imagePanel = new javax.swing.JPanel();
        loadImageButton = new javax.swing.JButton();
        loadAlbumButton = new javax.swing.JButton();
        videoPanel = new javax.swing.JPanel();
        alexPanel = new javax.swing.JPanel();
        favouritesPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        entryMenu = new javax.swing.JMenu();
        newEntry = new javax.swing.JMenuItem();
        editEntry = new javax.swing.JMenuItem();
        deleteSelectedEntry = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Diary Book v0.5!");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        entryTextAreaScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        entryTextArea.setEditable(false);
        entryTextArea.setColumns(20);
        entryTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entryTextArea.setLineWrap(true);
        entryTextArea.setRows(50);
        entryTextArea.setWrapStyleWord(true);
        entryTextAreaScrollPane.setViewportView(entryTextArea);

        entriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                entriesListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(entriesList);

        entryTitleField.setEditable(false);

        entryTitleLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        entryTitleLabel.setText("Entry Title");

        newEntryButton.setText("Save");
        newEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newEntryButton)
                            .addComponent(jButton1)))
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(entryTitleLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                .addComponent(entryTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(newEntryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addContainerGap())
        );

        displayEntryPane.addTab("Text", textPanel);

        imagesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                imagesListValueChanged(evt);
            }
        });
        imageListScrollPane.setViewportView(imagesList);

        imagePanel.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane4.setViewportView(imagePanel);

        loadImageButton.setText("View Image..");
        loadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageButtonActionPerformed(evt);
            }
        });

        loadAlbumButton.setText("View Album..");
        loadAlbumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadAlbumButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanelContainerLayout = new javax.swing.GroupLayout(imagePanelContainer);
        imagePanelContainer.setLayout(imagePanelContainerLayout);
        imagePanelContainerLayout.setHorizontalGroup(
            imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelContainerLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadImageButton)
                    .addComponent(loadAlbumButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imagePanelContainerLayout.setVerticalGroup(
            imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagePanelContainerLayout.createSequentialGroup()
                        .addComponent(loadImageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadAlbumButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                        .addComponent(imageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane4)))
        );

        displayEntryPane.addTab("Images", imagePanelContainer);

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        displayEntryPane.addTab("Video", videoPanel);

        javax.swing.GroupLayout alexPanelLayout = new javax.swing.GroupLayout(alexPanel);
        alexPanel.setLayout(alexPanelLayout);
        alexPanelLayout.setHorizontalGroup(
            alexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
        alexPanelLayout.setVerticalGroup(
            alexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout favouritesPanelLayout = new javax.swing.GroupLayout(favouritesPanel);
        favouritesPanel.setLayout(favouritesPanelLayout);
        favouritesPanelLayout.setHorizontalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
        favouritesPanelLayout.setVerticalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        entryMenu.setText("Entries");

        newEntry.setText("New..");
        newEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryActionPerformed(evt);
            }
        });
        entryMenu.add(newEntry);

        editEntry.setText("Edit..");
        entryMenu.add(editEntry);

        deleteSelectedEntry.setText("Delete Selected..");
        entryMenu.add(deleteSelectedEntry);

        jMenuBar.add(entryMenu);

        jMenu2.setText("Personal Goals");
        jMenuBar.add(jMenu2);

        jMenu3.setText("Favourites");
        jMenuBar.add(jMenu3);

        jMenu4.setText("Important Momments");
        jMenuBar.add(jMenu4);

        jMenu1.setText("Search..");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Entries By Name");
        jMenu1.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Entries By Date");
        jMenu1.add(jRadioButtonMenuItem2);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayEntryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 785, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(favouritesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(favouritesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(displayEntryPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_entriesListValueChanged
        try{
        loadEntryText();
        loadImageList();
        entryTitleField.setText(entriesList.getSelectedValue().toString());
        }catch(NullPointerException ex){
            //logger
            entriesList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_entriesListValueChanged

    private void newEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryButtonActionPerformed
        loadEntryImages();
        loadEntryVideo();
    }//GEN-LAST:event_newEntryButtonActionPerformed

    private void imagesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imagesListValueChanged
        loadEntryImage();
    }//GEN-LAST:event_imagesListValueChanged

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageButtonActionPerformed
        imagesList.setSelectedIndex(0);
        loadEntryImage();
        loadAlbumButton.setVisible(true);
        loadImageButton.setVisible(false);
        imageListScrollPane.setVisible(true);
    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void loadAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAlbumButtonActionPerformed
        loadEntryImages();
        loadImageButton.setVisible(true);
        loadAlbumButton.setVisible(false);
        imageListScrollPane.setVisible(false);
    }//GEN-LAST:event_loadAlbumButtonActionPerformed

    private void newEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryActionPerformed
        NewEntryView newEntry = new NewEntryView();
        newEntry.setVisible(true);
        newEntry.requestFocusInWindow();
        this.setFocusable(false);
    }//GEN-LAST:event_newEntryActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Are You Sure? ");
        if(ret == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MyDiaryBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDiaryBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDiaryBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDiaryBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyDiaryBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alexPanel;
    private javax.swing.JMenuItem deleteSelectedEntry;
    private javax.swing.JTabbedPane displayEntryPane;
    private javax.swing.JMenuItem editEntry;
    private javax.swing.JList entriesList;
    private javax.swing.JMenu entryMenu;
    private javax.swing.JTextArea entryTextArea;
    private javax.swing.JScrollPane entryTextAreaScrollPane;
    private javax.swing.JTextField entryTitleField;
    private javax.swing.JLabel entryTitleLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel favouritesPanel;
    private javax.swing.JScrollPane imageListScrollPane;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel imagePanelContainer;
    private javax.swing.JList imagesList;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton loadAlbumButton;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JMenuItem newEntry;
    private javax.swing.JButton newEntryButton;
    private javax.swing.JPanel textPanel;
    private javax.swing.JPanel videoPanel;
    // End of variables declaration//GEN-END:variables
}

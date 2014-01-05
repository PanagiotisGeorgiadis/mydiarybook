/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.DeleteImageController;
import controller.DeleteTextController;
import controller.DeleteVideoController;
import controller.LoadEntriesController;
import controller.MyDiaryBookController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import model.Entry;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author Zarc
 */
public class MyDiaryBook extends javax.swing.JFrame {

    private List<URI> images;
    private String imageMode;
    private final String fSeparator = File.separator;
    private EmbeddedMediaPlayerComponent mediaPlayer2 = null;
    private String vlcPath = System.getProperty("user.dir") + fSeparator + "VLC" + fSeparator;
    private Entry entry;

    /**
     * Creates new form MyDiaryBook
     */
    public MyDiaryBook() {
        initComponents();
        this.setLocationRelativeTo(null);
        entriesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        loadEntriesList();
        imagePanelScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        imagePanelScrollPane.getHorizontalScrollBar().setUnitIncrement(20);
        System.setProperty("jna.library.path", vlcPath);
        loadImageButton.setVisible(false);
        loadAlbumButton.setVisible(false);
        imageListScrollPane.setVisible(false);
        welcomeLabel.setText("Welcome, " + model.Login.getUsername());
        saveEditButton.setVisible(false);
        cancelEditButton.setVisible(false);
        deleteImageAlbumButton.setVisible(false);
        deleteImageButton.setVisible(false);

        //entriesList.setSelectedIndex(0);
        //entry = new Entries(entriesList.getSelectedValue().toString());
    }

    /**
     * Displays the new Image Specified in 2 different modes: Album mode which
     * can contain up to 30 images and Single mode which can contain 1 image but
     * scaled properly.
     *
     * @param imagePath The path of the image.
     * @param mode String "Album" for Album mode or a random string for Single
     * mode
     */
    public void displayNewImage(URI imagePath, String mode) {
        JLabel jlabel = new JLabel();
        ImageIcon icon = null;
        Image newimg = null;
        try {
            icon = new ImageIcon(imagePath.toURL());
            Image img = icon.getImage();
            if (mode == "Album") {
                newimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            } else {
                newimg = img.getScaledInstance(img.getWidth(jlabel), img.getWidth(jlabel), Image.SCALE_SMOOTH);
            }
            ImageIcon newIcon = new ImageIcon(newimg);
            imagePanel.add(jlabel);
            jlabel.setIcon(newIcon);
        } catch (MalformedURLException ex) {
            imagePanel.remove(jlabel);
        }
    }

    public void displayVideo(String videoPath, String whatToDo) {
        EmbeddedMediaPlayerComponent mediaPlayer = mediaPlayer2;
        // ****** VlcJ framework  ******//
        if (whatToDo.equalsIgnoreCase("Display")) {
            Dimension d = videoPanel.getSize();
            mediaPlayer.setSize(d);
            videoPanel.add(mediaPlayer);
            mediaPlayer.getMediaPlayer().attachVideoSurface();
            mediaPlayer.getMediaPlayer().playMedia(videoPath);
        } else if (whatToDo.equalsIgnoreCase("Pause")) {
            mediaPlayer.getMediaPlayer().pause();
        } else if (whatToDo.equalsIgnoreCase("Play")) {
            mediaPlayer.getMediaPlayer().play();
        } else {
            mediaPlayer.release(true);
            videoPanel.remove(mediaPlayer);
        }
    }

    public void loadEntriesList() {
        LoadEntriesController controller = new LoadEntriesController();
        DefaultListModel listModel = new DefaultListModel();
        try {
            String[] entries = controller.getEntriesList();
            for (int i = 0; i < entries.length; i++) {
                listModel.addElement(entries[i]);
            }
            entriesList.setModel(listModel);
        } catch (NullPointerException ex) {
            listModel.clear();
            entriesList.setModel(listModel);
            //TODO: Add Logger
        }
    }

    public void loadImageList() {
        DefaultListModel listModel = new DefaultListModel();
        try {
            String[] imageNames = entry.getImageList(); //controller.getImageList(entriesList.getSelectedValue().toString());
            for (int i = 0; i < imageNames.length; i++) {
                listModel.addElement(imageNames[i]);
            }
            imagesList.setModel(listModel);
            loadAlbumButton.setVisible(true);
        } catch (NullPointerException ex) {
            listModel.clear();
            imagesList.setModel(listModel);
            loadAlbumButton.setVisible(false);
            imageListScrollPane.setVisible(false);
            imagePanel.removeAll();
            loadImageButton.setVisible(false);
            //TODO: Add Logger
        }
    }

    public void loadEntryImages() {
        imageMode = "Album";
        imagePanel.removeAll();
        GridLayout layout = new GridLayout();
        layout.setColumns(10);
        layout.setRows(3);
        imagePanel.setLayout(layout);
        try {
            images = entry.getEntryImages();
            for (int i = 0; i < images.size(); i++) {
                displayNewImage(images.get(i), imageMode);
            }
        } catch (NullPointerException ex) {
            //TODO: Add Logger
        }
    }

    public void loadEntryImage() {
        imageMode = "Single";
        imagePanel.removeAll();
        BorderLayout border = new BorderLayout();
        try {
            imagePanel.setLayout(border);
            String imageName = imagesList.getSelectedValue().toString();
            int i = 0;

            while (!images.get(i).toString().contains(imageName)) {
                i++;
            }
            displayNewImage(images.get(i), imageMode);
        } catch (NullPointerException ex) {
            //TODO: Add Logger
        }
    }

    public void loadEntryText() {
        String text = entry.getEntryText();
        if (!text.equals("")) {
            entryTextArea.setText(entry.getEntryText());
        }
    }

    public void loadEntryVideo() {
        File video;
        try {
            video = entry.getEntryVideo();
            mediaPlayer2 = new EmbeddedMediaPlayerComponent();
            displayVideo(video.toString(), "Display");
        } catch (NullPointerException ex) {
            //TODO: Add Logger
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
        entriesListScrollPane = new javax.swing.JScrollPane();
        entriesList = new javax.swing.JList();
        entryTitleField = new javax.swing.JTextField();
        entryTitleLabel = new javax.swing.JLabel();
        saveEditButton = new javax.swing.JButton();
        cancelEditButton = new javax.swing.JButton();
        deleteTextButton = new javax.swing.JButton();
        imagePanelContainer = new javax.swing.JPanel();
        imageListScrollPane = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList();
        imagePanelScrollPane = new javax.swing.JScrollPane();
        imagePanel = new javax.swing.JPanel();
        loadImageButton = new javax.swing.JButton();
        loadAlbumButton = new javax.swing.JButton();
        deleteImageAlbumButton = new javax.swing.JButton();
        deleteImageButton = new javax.swing.JButton();
        videoPanel = new javax.swing.JPanel();
        deleteVideoButton = new javax.swing.JButton();
        alexPanel = new javax.swing.JPanel();
        favouritesPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        entryMenu = new javax.swing.JMenu();
        newEntry = new javax.swing.JMenuItem();
        editEntry = new javax.swing.JMenuItem();
        deleteSelectedEntry = new javax.swing.JMenuItem();
        personalGoalMenu = new javax.swing.JMenu();
        newPersonalGoal = new javax.swing.JMenuItem();
        favoritesMenu = new javax.swing.JMenu();
        newFavorites = new javax.swing.JMenuItem();
        viewFavorites = new javax.swing.JMenuItem();
        importantMommentsMenu = new javax.swing.JMenu();
        searchMenu = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Diary Book v0.5!");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

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
        entriesListScrollPane.setViewportView(entriesList);

        entryTitleField.setEditable(false);

        entryTitleLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        entryTitleLabel.setText("Entry Title");

        saveEditButton.setText("Save");
        saveEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditButtonActionPerformed(evt);
            }
        });

        cancelEditButton.setText("Cancel");

        deleteTextButton.setLabel("Delete Text");
        deleteTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entriesListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(saveEditButton)
                                    .addComponent(cancelEditButton)
                                    .addComponent(deleteTextButton))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(entryTitleLabel)))
                .addContainerGap())
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
                        .addComponent(saveEditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelEditButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteTextButton)
                        .addGap(239, 239, 239)
                        .addComponent(entriesListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addContainerGap())
        );

        deleteTextButton.getAccessibleContext().setAccessibleName("deleteTextButton");

        displayEntryPane.addTab("Text", textPanel);

        imagesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                imagesListValueChanged(evt);
            }
        });
        imageListScrollPane.setViewportView(imagesList);

        imagePanel.setLayout(new java.awt.GridLayout(1, 0));
        imagePanelScrollPane.setViewportView(imagePanel);

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

        deleteImageAlbumButton.setText("Delete Album");
        deleteImageAlbumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImageAlbumButtonActionPerformed(evt);
                deleteImageButtonActionPerformed(evt);
            }
        });

        deleteImageButton.setText("Delete Image");
        deleteImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanelContainerLayout = new javax.swing.GroupLayout(imagePanelContainer);
        imagePanelContainer.setLayout(imagePanelContainerLayout);
        imagePanelContainerLayout.setHorizontalGroup(
            imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelContainerLayout.createSequentialGroup()
                .addComponent(imagePanelScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loadImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadAlbumButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteImageAlbumButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteImageAlbumButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteImageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                        .addComponent(imageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(imagePanelScrollPane)))
        );

        displayEntryPane.addTab("Images", imagePanelContainer);

        deleteVideoButton.setText("Delete Video");
        deleteVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVideoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoPanelLayout.createSequentialGroup()
                .addContainerGap(668, Short.MAX_VALUE)
                .addComponent(deleteVideoButton)
                .addGap(19, 19, 19))
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoPanelLayout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(deleteVideoButton)
                .addGap(245, 245, 245))
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

        welcomeLabel.setText("Welcome, ");

        entryMenu.setText("Entries");

        newEntry.setText("New Entry..");
        newEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryActionPerformed(evt);
            }
        });
        entryMenu.add(newEntry);

        editEntry.setText("Edit Entry..");
        entryMenu.add(editEntry);

        deleteSelectedEntry.setText("Delete Selected..");
        entryMenu.add(deleteSelectedEntry);

        jMenuBar.add(entryMenu);

        personalGoalMenu.setText("Personal Goals");

        newPersonalGoal.setText("New Personal Goal..");
        newPersonalGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPersonalGoalActionPerformed(evt);
            }
        });
        personalGoalMenu.add(newPersonalGoal);

        jMenuBar.add(personalGoalMenu);

        favoritesMenu.setText("Favourites");

        newFavorites.setText("New Favorite..");
        newFavorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFavoritesActionPerformed(evt);
            }
        });
        favoritesMenu.add(newFavorites);

        viewFavorites.setText("View Favorites");
        viewFavorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFavoritesActionPerformed(evt);
            }
        });
        favoritesMenu.add(viewFavorites);

        jMenuBar.add(favoritesMenu);

        importantMommentsMenu.setText("Important Momments");
        jMenuBar.add(importantMommentsMenu);

        searchMenu.setText("Search..");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Entries By Name");
        searchMenu.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Entries By Date");
        searchMenu.add(jRadioButtonMenuItem2);

        jMenuBar.add(searchMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayEntryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 785, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addGap(57, 57, 57)
                        .addComponent(displayEntryPane))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(favouritesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_entriesListValueChanged
        MyDiaryBookController controller = new MyDiaryBookController();
        entry = controller.getEntry(entriesList.getSelectedValue().toString());
        try {
            entryTitleField.setText(entriesList.getSelectedValue().toString());
            loadEntryText();
            loadImageList();
        } catch (NullPointerException ex) {
            //TODO: Add Logger
            entriesList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_entriesListValueChanged

    private void saveEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditButtonActionPerformed
        loadEntryImages();
        loadEntryVideo();
    }//GEN-LAST:event_saveEditButtonActionPerformed

    private void imagesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imagesListValueChanged
        loadEntryImage();
    }//GEN-LAST:event_imagesListValueChanged

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageButtonActionPerformed
        imagesList.setSelectedIndex(0);
        loadEntryImage();
        loadAlbumButton.setVisible(true);
        loadImageButton.setVisible(false);
        imageListScrollPane.setVisible(true);
        deleteImageAlbumButton.setVisible(false);
        deleteImageButton.setVisible(true);
        imageMode = "Single";
    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void loadAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAlbumButtonActionPerformed
        loadEntryImages();
        loadImageButton.setVisible(true);
        loadAlbumButton.setVisible(false);
        imageListScrollPane.setVisible(false);
        deleteImageAlbumButton.setVisible(true);
        deleteImageButton.setVisible(false);
        imageMode = "Album";
    }//GEN-LAST:event_loadAlbumButtonActionPerformed

    private void newEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryActionPerformed
        NewEntryView newEntry = new NewEntryView();
        newEntry.setVisible(true);
    }//GEN-LAST:event_newEntryActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Are You Sure? ");
        if (ret == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void newPersonalGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPersonalGoalActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        PersonalGoalForm theView = new PersonalGoalForm();

        theView.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }//GEN-LAST:event_newPersonalGoalActionPerformed

    private void newFavoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFavoritesActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        FavoritesForm theView = new FavoritesForm();

        theView.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }//GEN-LAST:event_newFavoritesActionPerformed

    private void viewFavoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewFavoritesActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ViewFavorites theView = new ViewFavorites();

        theView.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }//GEN-LAST:event_viewFavoritesActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        loadEntriesList();
    }//GEN-LAST:event_formFocusGained

    private void deleteImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImageButtonActionPerformed
     
        MyDiaryBookController controller = new MyDiaryBookController();
        Entry entry = controller.getEntry(entriesList.getSelectedValue().toString());   
        DeleteImageController imageDelete = new DeleteImageController(entry);
        int dialog = JOptionPane.showConfirmDialog(this, "Are You sure for this delete?", "Confirm Message",JOptionPane.OK_CANCEL_OPTION);
        if (imageMode == "Single") {

            
            if(dialog == JOptionPane.YES_OPTION){
              try {

                        
                        imageDelete.deleteAElementFromImageList( imagesList.getSelectedValue().toString());
                        entriesListValueChanged(null); // tha mpei to idio gia to textlistdelete
                       loadImageButtonActionPerformed(evt);
                        
//                  }
//                     break;
//                 }
                        JOptionPane.showConfirmDialog(this, imageDelete.showSuccess(), "Success", JOptionPane.CANCEL_OPTION);
                        
            } catch (NullPointerException ex) {

                JOptionPane.showConfirmDialog(this, imageDelete.showNoFileFound(), "This File not exist", JOptionPane.CANCEL_OPTION);

            } catch (Exception ex) {

                JOptionPane.showConfirmDialog(this, imageDelete.showError(), "There was a Error", JOptionPane.CANCEL_OPTION);

            } 
            }
        } else {
            if(dialog == JOptionPane.YES_OPTION){
                
            try {
                imageDelete.deleteImageAlbum(entry.getEntryImage());
                loadAlbumButtonActionPerformed(evt);
                JOptionPane.showConfirmDialog(this, imageDelete.showSuccess(), "Success", JOptionPane.CANCEL_OPTION);
            } catch (NullPointerException ex) {

                JOptionPane.showConfirmDialog(this, imageDelete.showNoFileFound(), "This File not exist", JOptionPane.CANCEL_OPTION);

            } catch (Exception ex) {

                JOptionPane.showConfirmDialog(this, imageDelete.showError(), "There was a Error", JOptionPane.CANCEL_OPTION);

            }
            }

        }
        if(imagesList.isSelectionEmpty())
            imageDelete.deleteImageAlbum(entry.getEntryImage());
        
            
    }//GEN-LAST:event_deleteImageButtonActionPerformed

    private void deleteImageAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImageAlbumButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteImageAlbumButtonActionPerformed

    private void deleteTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTextButtonActionPerformed
        DeleteTextController textDelete = new DeleteTextController();
       

        
        try {                                        
                        
                        textDelete.deleteAElementFromTextList(entry.getEntryTitle(), entriesList.getSelectedValue().toString());
                        entriesListValueChanged(null);
                        JOptionPane.showConfirmDialog(this, textDelete.showSuccess(), "Success", JOptionPane.CANCEL_OPTION);
                        // Prepei na ginei to listModel private wste na mporw na to xrisimopoihsw
                    
        }catch (NullPointerException ex) {

                JOptionPane.showConfirmDialog(this, textDelete.showNoFileFound(), "This File not exist", JOptionPane.CANCEL_OPTION);

            } catch (Exception ex) {

                JOptionPane.showConfirmDialog(this, textDelete.showError(), "There was a Error", JOptionPane.CANCEL_OPTION);

            }
        if(entriesList.isSelectionEmpty()){
          //   textDelete.deleteTextAlbum(model.Login.getUsername(), entry.getEntryTitle() );
          textDelete.deleteTextAlbum( entry.getEntryTitle() ); // dokimastiko

        }
    }//GEN-LAST:event_deleteTextButtonActionPerformed

    private void deleteVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVideoButtonActionPerformed
        DeleteVideoController controller = new DeleteVideoController();
        
         try {                                        
                        
                        controller.deleteVideoAlbum(entry.getEntryVideo());
                        entriesListValueChanged(null);
                        JOptionPane.showConfirmDialog(this, controller.showSuccess(), "Success", JOptionPane.CANCEL_OPTION);
                        // Prepei na ginei to listModel private wste na mporw na to xrisimopoihsw
                    
        }catch (NullPointerException ex) {

                JOptionPane.showConfirmDialog(this, controller.showNoFileFound(), "This File not exist", JOptionPane.CANCEL_OPTION);

            } catch (Exception ex) {

                JOptionPane.showConfirmDialog(this, controller.showError(), "There was a Error", JOptionPane.CANCEL_OPTION);

            }
    }//GEN-LAST:event_deleteVideoButtonActionPerformed

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
    private javax.swing.JButton cancelEditButton;
    private javax.swing.JButton deleteImageAlbumButton;
    private javax.swing.JButton deleteImageButton;
    private javax.swing.JMenuItem deleteSelectedEntry;
    private javax.swing.JButton deleteTextButton;
    private javax.swing.JButton deleteVideoButton;
    private javax.swing.JTabbedPane displayEntryPane;
    private javax.swing.JMenuItem editEntry;
    private javax.swing.JList entriesList;
    private javax.swing.JScrollPane entriesListScrollPane;
    private javax.swing.JMenu entryMenu;
    private javax.swing.JTextArea entryTextArea;
    private javax.swing.JScrollPane entryTextAreaScrollPane;
    private javax.swing.JTextField entryTitleField;
    private javax.swing.JLabel entryTitleLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenu favoritesMenu;
    private javax.swing.JPanel favouritesPanel;
    private javax.swing.JScrollPane imageListScrollPane;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel imagePanelContainer;
    private javax.swing.JScrollPane imagePanelScrollPane;
    private javax.swing.JList imagesList;
    private javax.swing.JMenu importantMommentsMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JButton loadAlbumButton;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JMenuItem newEntry;
    private javax.swing.JMenuItem newFavorites;
    private javax.swing.JMenuItem newPersonalGoal;
    private javax.swing.JMenu personalGoalMenu;
    private javax.swing.JButton saveEditButton;
    private javax.swing.JMenu searchMenu;
    private javax.swing.JPanel textPanel;
    private javax.swing.JPanel videoPanel;
    private javax.swing.JMenuItem viewFavorites;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}

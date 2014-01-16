/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.LoadEntriesController;
import controller.MyDiaryBookController;
import controller.PersonalGoalController;
import controller.PersonalGoalImageController;
import controller.PersonalGoalLoadController;
import controller.PersonalGoalTextController;
import dao.PersonalGoalTxtDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import model.Entry;
import model.PersonalGoalModel;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import validators.AnnouncementValidator;
import validators.LocationValidator;
import validators.TitleValidator;
import validators.WhenDateValidator;
import validators.WithPersonValidator;

/**
 *
 * @author Zarc
 */
public class MyDiaryBook extends javax.swing.JFrame {
    private List<URI> images;
    private String imageMode;
    private final String fSeparator = File.separator;
    private EmbeddedMediaPlayerComponent mediaPlayer2 = null;
    private String vlcPath = System.getProperty("user.dir")+fSeparator+"VLC"+fSeparator;
    private Entry entry;
    private PersonalGoalModel personalGoal;
    /**
     * Creates new form MyDiaryBook
     */
    public MyDiaryBook() 
    {
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
        
        //entriesList.setSelectedIndex(0);
        //entry = new Entries(entriesList.getSelectedValue().toString());
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
    
    public void loadEntriesList()
    {
        LoadEntriesController controller = new LoadEntriesController();
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
            //TODO: Add Logger
        }
    }    
    
    
            
     
    
    public void loadImageList()
    {
        DefaultListModel listModel = new DefaultListModel();
        try
        {
            String[] imageNames = entry.getImageList(); //controller.getImageList(entriesList.getSelectedValue().toString());
            for(int i=0;i<imageNames.length;i++)
            {
                listModel.addElement(imageNames[i]);    
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
            imagePanel.removeAll();
            loadImageButton.setVisible(false);
            //TODO: Add Logger
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
        try{
            images = entry.getEntryImages();
            for(int i=0;i<images.size();i++)
            {
                displayNewImage(images.get(i),imageMode);
            }
        }
        catch(NullPointerException ex)
        {
            //TODO: Add Logger
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
            
            while(!images.get(i).toString().contains(imageName))
            {
                i++;
            }
            displayNewImage(images.get(i),imageMode);
        }
        catch(NullPointerException ex)
        {
            //TODO: Add Logger
        }
    }
    
    public void loadEntryText()
    {
        String text = entry.getEntryText();
        if(!text.equals(""))
            entryTextArea.setText(entry.getEntryText());
        
    }
    
    public void loadEntryVideo()
    {
        File video;
        try
        {
            video =  entry.getEntryVideo();
            mediaPlayer2 = new EmbeddedMediaPlayerComponent(); 
            displayVideo(video.toString(),"Display");
        }
        catch(NullPointerException ex)
        {
            //TODO: Add Logger
        }
    }
    /**
     * load list of personal goals
     */
     public void loadListOfPersonalGoal()
    {
        PersonalGoalLoadController controller = new PersonalGoalLoadController();
        DefaultListModel listModel = new DefaultListModel();
        try
        {            
            String[] personalGoal = controller.getListOfPesronalGoal();
            for(int i=0;i<personalGoal.length;i++)
            {
                listModel.addElement(personalGoal[i]);    
            }
            personalGoalList.setModel(listModel);
        }
        catch(NullPointerException ex)
        {
            listModel.clear();
            personalGoalList.setModel(listModel);
           
        }
    }  
     
     public void loadPersonalGoalTitle()
    {
        String text = personalGoal.getPersonalGoalTitle();
        if(!text.equals(""))
            entryTextArea.setText(personalGoal.getPersonalGoalTitle());
        
    }
       public void loadPersonalGoalLocation()
    {
        String textLocation = personalGoal.getPersonalGoalLocation();
        if(!textLocation.equals(""))
            locationTextField.setText(personalGoal.getPersonalGoalLocation());
        
    }
       public void loadPersonalGoalWithPerson()
    {
        String textWithPerson = personalGoal.getPersonalGoalWithPerson();
        if(!textWithPerson.equals(""))
            withPersonTextField.setText(personalGoal.getPersonalGoalLocation());
        
    }
         public void loadPersonalGoalwhenDate()
    {
        String textWithPerson = personalGoal.getPersonalGoalWithPerson();
        if(!textWithPerson.equals(""))
            withPersonTextField.setText(personalGoal.getPersonalGoalLocation());
        
    }
       
       public void loadPersonalGoalAnnouncement()
    {
        String textAnnouncement = personalGoal.getPersonalGoalAnnouncement();
        if(!textAnnouncement.equals(""))
            announcementEditorPane.setText(personalGoal.getPersonalGoalAnnouncement());
        
    }
       
       public void displayImagePersonalGoal(){
           String fileName = personalGoal.getPersonalGoalImage();
        
        File file = new File(fileName);
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(PersonalGoalForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        int w = imageLabel.getWidth();
        int h = imageLabel.getHeight();

        int type = img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : img.getType();

        BufferedImage resizedImg = new BufferedImage(w, h, type);
        Graphics g = resizedImg.createGraphics();
        g.drawImage(img, 0, 0, w, h, null);
        g.dispose();
        imageLabel.setIcon(new ImageIcon(resizedImg));
        boolean ifImageExist =true;
        
         
        
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
        imagePanelContainer = new javax.swing.JPanel();
        imageListScrollPane = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList();
        imagePanelScrollPane = new javax.swing.JScrollPane();
        imagePanel = new javax.swing.JPanel();
        loadImageButton = new javax.swing.JButton();
        loadAlbumButton = new javax.swing.JButton();
        videoPanel = new javax.swing.JPanel();
        personalGoalPanel = new javax.swing.JPanel();
        personalGoalListScrollPane = new javax.swing.JScrollPane();
        personalGoalList = new javax.swing.JList();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        locationLabel = new javax.swing.JLabel();
        locationTextField = new javax.swing.JTextField();
        withPersonLabel = new javax.swing.JLabel();
        withPersonTextField = new javax.swing.JTextField();
        WhenDate = new javax.swing.JLabel();
        whenDateSpinner = new javax.swing.JSpinner();
        AnnouncementLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        announcementEditorPane = new javax.swing.JEditorPane();
        pestonalGoalListLabel = new javax.swing.JLabel();
        checkFieldTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        favouritesPanel = new javax.swing.JPanel();
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

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entriesListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(saveEditButton)
                            .addComponent(cancelEditButton)))
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
                        .addGap(280, 280, 280)
                        .addComponent(entriesListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE))
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

        javax.swing.GroupLayout imagePanelContainerLayout = new javax.swing.GroupLayout(imagePanelContainer);
        imagePanelContainer.setLayout(imagePanelContainerLayout);
        imagePanelContainerLayout.setHorizontalGroup(
            imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelContainerLayout.createSequentialGroup()
                .addComponent(imagePanelScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 954, Short.MAX_VALUE)
                        .addComponent(imageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(imagePanelScrollPane)))
        );

        displayEntryPane.addTab("Images", imagePanelContainer);

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1178, Short.MAX_VALUE)
        );

        displayEntryPane.addTab("Video", videoPanel);

        personalGoalList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                personalGoalListValueChanged(evt);
            }
        });
        personalGoalList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                personalGoalListFocusGained(evt);
            }
        });
        personalGoalListScrollPane.setViewportView(personalGoalList);

        titleLabel.setText("Title:");

        titleTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleTextFieldFocusLost(evt);
            }
        });

        locationLabel.setText("Location:");

        locationTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                locationTextFieldFocusLost(evt);
            }
        });

        withPersonLabel.setText("With Person:");

        withPersonTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                withPersonTextFieldFocusLost(evt);
            }
        });

        WhenDate.setText("WhenDate");

        whenDateSpinner.setModel(new javax.swing.SpinnerDateModel());
        whenDateSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        whenDateSpinner.setEditor(new javax.swing.JSpinner.DateEditor(whenDateSpinner, "dd/MM/yyyy"));
        whenDateSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                whenDateSpinnerFocusLost(evt);
            }
        });

        AnnouncementLabel.setText("Announcement");

        announcementEditorPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                announcementEditorPaneFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(announcementEditorPane);

        pestonalGoalListLabel.setText("Click for see the List");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel1.setText("Personal Goal");

        imageLabel.setToolTipText("");
        imageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout personalGoalPanelLayout = new javax.swing.GroupLayout(personalGoalPanel);
        personalGoalPanel.setLayout(personalGoalPanelLayout);
        personalGoalPanelLayout.setHorizontalGroup(
            personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(locationLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalGoalPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)))
                        .addGap(22, 22, 22)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(locationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(titleTextField)))
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(withPersonLabel)
                            .addComponent(WhenDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(withPersonTextField)
                            .addComponent(whenDateSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AnnouncementLabel)))
                .addGap(18, 18, 18)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkFieldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pestonalGoalListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personalGoalListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton1))
                    .addComponent(jLabel1))
                .addContainerGap(359, Short.MAX_VALUE))
            .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(personalGoalPanelLayout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        personalGoalPanelLayout.setVerticalGroup(
            personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(locationLabel)
                        .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pestonalGoalListLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalGoalPanelLayout.createSequentialGroup()
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(withPersonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(withPersonLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(whenDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WhenDate))
                        .addGap(32, 32, 32)
                        .addComponent(AnnouncementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addComponent(personalGoalListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkFieldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(cancelButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(personalGoalPanelLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        welcomeLabel.setText("Welcome, ");

        javax.swing.GroupLayout favouritesPanelLayout = new javax.swing.GroupLayout(favouritesPanel);
        favouritesPanel.setLayout(favouritesPanelLayout);
        favouritesPanelLayout.setHorizontalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        favouritesPanelLayout.setVerticalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

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
                    .addComponent(displayEntryPane, javax.swing.GroupLayout.PREFERRED_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(favouritesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(661, 661, 661)
                                .addComponent(exitButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(personalGoalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeLabel)
                        .addGap(57, 57, 57)
                        .addComponent(displayEntryPane))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(personalGoalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(favouritesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(403, 403, 403)
                        .addComponent(exitButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_entriesListValueChanged
        MyDiaryBookController controller = new MyDiaryBookController();
        entry = controller.getEntry(entriesList.getSelectedValue().toString());
        try{
            entryTitleField.setText(entriesList.getSelectedValue().toString());
            loadEntryText();
            loadImageList();
        }catch(NullPointerException ex){
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
    }//GEN-LAST:event_newEntryActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Are You Sure? ");
        if(ret == JOptionPane.YES_OPTION)
            System.exit(0);
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

    private void personalGoalListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_personalGoalListValueChanged
     
      MyDiaryBookController controller = new MyDiaryBookController();
     
      personalGoal = controller.getPersonalGoal(personalGoalList.getSelectedValue().toString());
      try{
      titleTextField.setText(personalGoalList.getSelectedValue().toString());
      
            loadPersonalGoalLocation();
            loadPersonalGoalWithPerson();
            loadPersonalGoalAnnouncement();
            displayImagePersonalGoal();
            
            
        }catch(NullPointerException ex){
            //fix this
            entriesList.setSelectedIndex(0);
       
       
        }
    }//GEN-LAST:event_personalGoalListValueChanged

    private void titleTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleTextFieldFocusLost
        TitleValidator newTitle = new TitleValidator();
        boolean isValid = newTitle.titleIsValid(titleTextField.getText());
        saveButton.setEnabled(isValid);
        if (!isValid) {

            titleTextField.setForeground(Color.red);
        } else {

            titleTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_titleTextFieldFocusLost

    private void locationTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationTextFieldFocusLost
        LocationValidator newLocation = new LocationValidator();
        boolean isValid = newLocation.locationIsValid(locationTextField.getText());
        if (!isValid) {

            locationTextField.setForeground(Color.red);
        } else {

            locationTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_locationTextFieldFocusLost

    private void withPersonTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_withPersonTextFieldFocusLost
        WithPersonValidator withPerson = new WithPersonValidator();
        boolean isValid = withPerson.withPersonIsValid(withPersonTextField.getText());
        if (!isValid) {

            withPersonTextField.setForeground(Color.red);
        } else {

            withPersonTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_withPersonTextFieldFocusLost

    private void whenDateSpinnerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_whenDateSpinnerFocusLost
        WhenDateValidator whenDate = new WhenDateValidator();
        boolean isValid = whenDate.whenDateIsValid(whenDateSpinner.getName().toString());
        if (!isValid) {

            locationTextField.setForeground(Color.red);
        } else {

            locationTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_whenDateSpinnerFocusLost

    private void announcementEditorPaneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_announcementEditorPaneFocusLost
        AnnouncementValidator announcement = new AnnouncementValidator();
        boolean isValid = announcement.announcementIsValid(announcementEditorPane.getText());
        if (!isValid) {

            withPersonTextField.setForeground(Color.red);
        } else {

            withPersonTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_announcementEditorPaneFocusLost

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String title = titleTextField.getText();
        String location = locationTextField.getText();
        String withPerson = withPersonTextField.getText();
        String whenDate = whenDateSpinner.getValue().toString();
        String announcement = announcementEditorPane.getText();

        PersonalGoalController newController = new PersonalGoalController();
        PersonalGoalImageController newImageController = new PersonalGoalImageController();
        //check if all Field is correct and return if is all ok success or tha name the wrong value.
        String allFieldSuccess = newController.createPersonalGoal(titleTextField.getText(), locationTextField.getText(), withPersonTextField.getText(), whenDateSpinner.getValue().toString(), announcementEditorPane.getText());

        if ("success".equals(allFieldSuccess)) {

            PersonalGoalTextController newTextController = new PersonalGoalTextController();
            PersonalGoalTxtDao newTxtDao = new PersonalGoalTxtDao();

            boolean Success = newTextController.createTextFile(titleTextField.getText(), locationTextField.getText(), withPersonTextField.getText(), whenDateSpinner.getValue().toString(), announcementEditorPane.getText());
            //if(ifImageExist =true){
                //newImageController.saveImage(titleTextField.getText(), browseFotoTextField.getText());

                //}
            if (Success) {
                checkFieldTextField.setText("success");
                checkFieldTextField.setForeground(Color.green);
            }
        } else {

            checkFieldTextField.setText(allFieldSuccess + " is incorect!");
            checkFieldTextField.setForeground(Color.red);

        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void personalGoalListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_personalGoalListFocusGained
      loadListOfPersonalGoal();
    }//GEN-LAST:event_personalGoalListFocusGained

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButton1ActionPerformed

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
    private javax.swing.JLabel AnnouncementLabel;
    private javax.swing.JLabel WhenDate;
    private javax.swing.JEditorPane announcementEditorPane;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton cancelEditButton;
    private javax.swing.JTextField checkFieldTextField;
    private javax.swing.JMenuItem deleteSelectedEntry;
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
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane imageListScrollPane;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel imagePanelContainer;
    private javax.swing.JScrollPane imagePanelScrollPane;
    private javax.swing.JList imagesList;
    private javax.swing.JMenu importantMommentsMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadAlbumButton;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JMenuItem newEntry;
    private javax.swing.JMenuItem newFavorites;
    private javax.swing.JMenuItem newPersonalGoal;
    private javax.swing.JList personalGoalList;
    private javax.swing.JScrollPane personalGoalListScrollPane;
    private javax.swing.JMenu personalGoalMenu;
    private javax.swing.JPanel personalGoalPanel;
    private javax.swing.JLabel pestonalGoalListLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveEditButton;
    private javax.swing.JMenu searchMenu;
    private javax.swing.JPanel textPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JPanel videoPanel;
    private javax.swing.JMenuItem viewFavorites;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JSpinner whenDateSpinner;
    private javax.swing.JLabel withPersonLabel;
    private javax.swing.JTextField withPersonTextField;
    // End of variables declaration//GEN-END:variables
}
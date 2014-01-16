/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.DeleteImageController;
import controller.DeletePersonalGoalController;
import controller.DeleteTextController;
import controller.DeleteVideoController;
import controller.EditTextEntryController;
import controller.EditTitleEntryController;
import controller.LoadEntriesController;
import controller.LoggedInController;
import controller.MyDiaryBookController;
import controller.PersonalGoalLoadController;
import dao.NewEntryDao;
import static dao.PersonalGoalDao.getPersonalGoalByTitle;
import dao.ViewFavoritesDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Entry;
import model.Login;
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
public class MyDiaryBook extends javax.swing.JFrame implements IMyDiaryBook {
    private List<URI> images;
    private String imageMode;
    private final String fSeparator = File.separator;
    private EmbeddedMediaPlayerComponent mediaPlayer2 = null;
    private String vlcPath = System.getProperty("user.dir")+fSeparator+"VLC"+fSeparator;
    private Entry entry;
    private File video;
    private String pauseOrPlay = "Pause";
    private PersonalGoalModel personalGoal;
    private String editMode;
    private String previousEntryTitle;
    /**
     * Creates new form MyDiaryBook
     */
    public MyDiaryBook() 
    {
        initComponents();
        entriesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        loadEntriesList();
        imagePanelScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        imagePanelScrollPane.getHorizontalScrollBar().setUnitIncrement(20);
        System.setProperty("jna.library.path", vlcPath);
        loadImageButton.setVisible(false);
        loadAlbumButton.setVisible(false);
        imageListScrollPane.setVisible(false);
        welcomeLabel.setText("Welcome, " + Login.getUsername());
        saveEditButton.setVisible(false);
        cancelEditButton.setVisible(false);
        playVideoButton.setVisible(false);
        pauseOrPlayVideoButton.setVisible(false);
        lastModifiedLabel.setVisible(false);
        this.entryDateLabel.setVisible(false);
        entriesList.setSelectedIndex(0);
        //Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setSize(d);
        this.setSize(1350, 730);
        loadListOfPersonalGoal();
        loadFavorites();
        personalGoalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        personalGoalList.setSelectedIndex(0);
        deleteImageAlbumButton.setVisible(false);
        deleteImageButton.setVisible(false);
        deleteVideoButton.setVisible(false);
        deletePersonalGoalButton.setVisible(false);
        editEntryTitleLabel.setVisible(false);
        
        this.setLocationRelativeTo(null);
    }
    
    /** Displays the new Image Specified in 2 different modes: 
     * Album mode which can contain up to 30 images and
     * Single mode which can contain 1 image but scaled properly.
     * @param imagePath The path of the image.     
     * @param mode String "Album" for Album mode or a random string for 
     * Single mode
     */  
    @Override
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
    
    @Override
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
            pauseOrPlay = "Play";
        }
        else if(whatToDo.equalsIgnoreCase("Play"))
        {
            mediaPlayer.getMediaPlayer().play();
            pauseOrPlay = "Pause";
        }
        else
        {
            mediaPlayer.release(true);
            videoPanel.remove(mediaPlayer);
        }
    }
    
    @Override
    public void loadEntriesList()
    {
        LoadEntriesController controller = new LoadEntriesController();
        DefaultListModel listModel = new DefaultListModel();
        try
        {            
            String[] entries = controller.getEntriesList();
            if(entries!=null)
            {
                for(int i=0;i<entries.length;i++)
                {
                    listModel.addElement(entries[i]);    
                }
                entriesList.setModel(listModel);
            }
        }
        catch(NullPointerException ex)
        {
            listModel.clear();
            entriesList.setModel(new DefaultListModel());
        }
    }    
    
    @Override
    public void loadImageList()
    {
        DefaultListModel listModel = new DefaultListModel();
        if(entry.getImageList()!=null)
        {
            String[] imageNames = entry.getImageList();
            for(int i=0;i<imageNames.length;i++)
            {
                listModel.addElement(imageNames[i]);    
            }
            imagesList.setModel(listModel);
            loadAlbumButton.setVisible(true);
            deleteImageAlbumButton.setVisible(true);
        }
        else
        {
            listModel.clear();
            imagesList.setModel(listModel);
            loadAlbumButton.setVisible(false);
            imageListScrollPane.setVisible(false);
            imagePanel.removeAll();
            loadImageButton.setVisible(false);
            deleteImageAlbumButton.setVisible(false);
            deleteImageButton.setVisible(false);
            //TODO: Add Logger
        }
    }
    
    @Override
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
    
    @Override
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
    
    @Override
    public void loadEntryText()
    {
        String text = entry.getEntryText();
        if(text.equals(""))
            entryTextArea.setText("");
        else
        {
            entryTextArea.setText(entry.getEntryText());
            deleteTextButton.setVisible(true);
        }
    }
    
    @Override
    public void loadEntryVideo()
    {
        if(entry.getEntryVideo()!= null)
        {
            video = entry.getEntryVideo();
            mediaPlayer2 = new EmbeddedMediaPlayerComponent(); 
            playVideoButton.setVisible(true);
            deleteVideoButton.setVisible(true);
        }
        else
        {
            playVideoButton.setVisible(false);
            pauseOrPlayVideoButton.setVisible(false);
            deleteVideoButton.setVisible(false);
        }
    }
    
    @Override
    public void pauseOrPlayVideo()
    {
        displayVideo(video.toString(),pauseOrPlay);
    }
    
    public void loadEntryDateLabel()
    {
        NewEntryDao entryDao = new NewEntryDao();
        entryDateLabel.setText(entryDao.getEntryLastModified(entriesList.getSelectedValue().toString()));
        lastModifiedLabel.setVisible(true);
        entryDateLabel.setVisible(true);
    }
    
    @Override
    public void refreshEntries()
    {
        entriesListValueChanged(null);
        loadEntriesList();
    }
    
    @Override
    public void loadFavorites()
    {
        LoggedInController controller = new LoggedInController();
        ViewFavoritesDao dao = new ViewFavoritesDao();
        if(controller.loggedIn())
            favoritesTextArea.setText(dao.viewFavorites(Login.getUsername()));
    }
    
    /**
     * function for load list of personal goals
     */
    public void loadListOfPersonalGoal() {
        PersonalGoalLoadController controller = new PersonalGoalLoadController();
        DefaultListModel listModel = new DefaultListModel();
        try {

            Login lgn = new Login();
            String userName = lgn.getUsername();
            String[] personalGoal = controller.getListOfPesronalGoal(userName);
            for (int i = 0; i < personalGoal.length; i++) {
                listModel.addElement(personalGoal[i]);
            }
            personalGoalList.setModel(listModel);
        } catch (NullPointerException ex) {
            listModel.clear();
            personalGoalList.setModel(listModel);

        }
    }

    /**
     * function for loadPersonalGoalTitle
     */
    public void loadPersonalGoalTitle() {
        String text = personalGoal.getPersonalGoalTitle();
        if (!text.equals("")) {
            entryTextArea.setText(personalGoal.getPersonalGoalTitle());
        }

    }

    /**
     * function for loadPersonalGoalLocation
     */
    public void loadPersonalGoalLocation() {
        String textLocation = personalGoal.getPersonalGoalLocation();
        if (!textLocation.equals("")) {
            locationTextField.setText(personalGoal.getPersonalGoalLocation());
        }

    }

    /**
     * function for loadPersonalGoalWithPerson
     */
    public void loadPersonalGoalWithPerson() {
        String textWithPerson = personalGoal.getPersonalGoalWithPerson();
        if (!textWithPerson.equals("")) {
            withPersonTextField.setText(personalGoal.getPersonalGoalWithPerson());
        }

    }

    /**
     * function for loadPersonalGoalwhenDate
     */
    public void loadPersonalGoalwhenDate() {
        String textWithPerson = personalGoal.getPersonalGoalWhenDate();
        if (!textWithPerson.equals("")) {
            whenDateTextField.setText(personalGoal.getPersonalGoalWhenDate());
        }

    }

    /**
     * function for loadPersonalGoalAnnouncement
     */
    public void loadPersonalGoalAnnouncement() {
        String textAnnouncement = personalGoal.getPersonalGoalAnnouncement();
        if (!textAnnouncement.equals("")) {
            announcementEditorPane.setText(personalGoal.getPersonalGoalAnnouncement());
        }

    }
    
    public void emptyPersonalTextField() {
        titleTextField.setText("");
        locationTextField.setText("");
        withPersonTextField.setText("");
        announcementEditorPane.setText("");
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
        entryDateLabel = new javax.swing.JLabel();
        lastModifiedLabel = new javax.swing.JLabel();
        deleteTextButton = new javax.swing.JButton();
        editEntryTitleLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
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
        playVideoButton = new javax.swing.JButton();
        alexPanel = new javax.swing.JPanel();
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
        personalGoalLabel = new javax.swing.JLabel();
        checkFieldTextField = new javax.swing.JTextField();
        deletePersonalGoalButton = new javax.swing.JButton();
        editCheckBox = new javax.swing.JCheckBox();
        whenDateTextField = new javax.swing.JTextField();
        showPersonalGoalImageButton = new javax.swing.JButton();
        favouritesPanel = new javax.swing.JPanel();
        favoritesScrollPane = new javax.swing.JScrollPane();
        favoritesTextArea = new javax.swing.JTextArea();
        welcomeLabel = new javax.swing.JLabel();
        pauseOrPlayVideoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        deleteVideoButton = new javax.swing.JButton();
        myDiaryBookMenu = new javax.swing.JMenuBar();
        entryMenu = new javax.swing.JMenu();
        newEntry = new javax.swing.JMenuItem();
        editEntryTitle = new javax.swing.JMenuItem();
        deleteSelectedEntry = new javax.swing.JMenuItem();
        personalGoalMenu = new javax.swing.JMenu();
        newPersonalGoal = new javax.swing.JMenuItem();
        deletePersonalGoalMenu = new javax.swing.JMenuItem();
        favoritesMenu = new javax.swing.JMenu();
        newFavorites = new javax.swing.JMenuItem();
        editFavorites = new javax.swing.JMenuItem();
        importantMommentsMenu = new javax.swing.JMenu();
        newImportantMoment = new javax.swing.JMenuItem();
        deleteImportantMoment = new javax.swing.JMenuItem();
        changePassword = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Diary Book v1.0!");
        setPreferredSize(new java.awt.Dimension(1300, 750));

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
        entryTitleField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                entryTitleFieldFocusLost(evt);
            }
        });

        entryTitleLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        entryTitleLabel.setText("Entry Title");

        saveEditButton.setText("Save");
        saveEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditButtonActionPerformed(evt);
            }
        });

        cancelEditButton.setText("Cancel");
        cancelEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditButtonActionPerformed(evt);
            }
        });

        entryDateLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        entryDateLabel.setText("Date Label");

        lastModifiedLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        lastModifiedLabel.setText("Date Created:");

        deleteTextButton.setLabel("Delete Text");
        deleteTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTextButtonActionPerformed(evt);
            }
        });

        editEntryTitleLabel.setText("Dont Leave Empty The Title!");

        editButton.setText("Edit Text");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entriesListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveEditButton)
                            .addComponent(cancelEditButton)
                            .addComponent(deleteTextButton)
                            .addComponent(editButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editEntryTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lastModifiedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(textPanelLayout.createSequentialGroup()
                .addComponent(entryTitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(entryTitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editEntryTitleLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastModifiedLabel)
                        .addComponent(entryDateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(saveEditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelEditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteTextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addGap(217, 217, 217)
                        .addComponent(entriesListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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

        deleteImageAlbumButton.setText("Delete Album");
        deleteImageAlbumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImageAlbumButtonActionPerformed(evt);
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
                .addGroup(imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagePanelContainerLayout.createSequentialGroup()
                        .addGroup(imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loadImageButton)
                            .addComponent(loadAlbumButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanelContainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(imagePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteImageButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteImageAlbumButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
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
                        .addGap(42, 42, 42)
                        .addComponent(deleteImageAlbumButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteImageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                        .addComponent(imageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(imagePanelScrollPane)))
        );

        displayEntryPane.addTab("Images", imagePanelContainer);

        playVideoButton.setText("Play Video");
        playVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playVideoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoPanelLayout.createSequentialGroup()
                .addContainerGap(689, Short.MAX_VALUE)
                .addComponent(playVideoButton)
                .addContainerGap())
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playVideoButton)
                .addContainerGap(562, Short.MAX_VALUE))
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

        titleTextField.setEnabled(false);
        titleTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleTextFieldFocusLost(evt);
            }
        });

        locationLabel.setText("Location:");

        locationTextField.setEnabled(false);
        locationTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                locationTextFieldFocusLost(evt);
            }
        });

        withPersonLabel.setText("With Person:");

        withPersonTextField.setEnabled(false);
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

        personalGoalLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        personalGoalLabel.setText("Personal Goal");

        checkFieldTextField.setEnabled(false);

        deletePersonalGoalButton.setText("Delete Goal");
        deletePersonalGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePersonalGoalButtonActionPerformed(evt);
            }
        });

        editCheckBox.setText("Check For edit");
        editCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCheckBoxActionPerformed(evt);
            }
        });

        whenDateTextField.setEnabled(false);

        showPersonalGoalImageButton.setText("Show Image");
        showPersonalGoalImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPersonalGoalImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout personalGoalPanelLayout = new javax.swing.GroupLayout(personalGoalPanel);
        personalGoalPanel.setLayout(personalGoalPanelLayout);
        personalGoalPanelLayout.setHorizontalGroup(
            personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AnnouncementLabel)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalGoalPanelLayout.createSequentialGroup()
                                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(WhenDate))
                                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(withPersonLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(withPersonTextField)
                                    .addComponent(whenDateSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalGoalPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(whenDateTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalGoalPanelLayout.createSequentialGroup()
                                        .addComponent(locationLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalGoalPanelLayout.createSequentialGroup()
                                        .addComponent(titleLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(personalGoalLabel))
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkFieldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editCheckBox)))
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(showPersonalGoalImageButton)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personalGoalListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletePersonalGoalButton))
                .addGap(14, 14, 14))
        );
        personalGoalPanelLayout.setVerticalGroup(
            personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personalGoalLabel))
                .addGap(18, 18, 18)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personalGoalListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationLabel)
                            .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(withPersonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(withPersonLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(whenDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WhenDate)))
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(showPersonalGoalImageButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(whenDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(AnnouncementLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editCheckBox)
                            .addComponent(deletePersonalGoalButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkFieldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout alexPanelLayout = new javax.swing.GroupLayout(alexPanel);
        alexPanel.setLayout(alexPanelLayout);
        alexPanelLayout.setHorizontalGroup(
            alexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(personalGoalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        alexPanelLayout.setVerticalGroup(
            alexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(personalGoalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favoritesTextArea.setColumns(20);
        favoritesTextArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        favoritesTextArea.setRows(5);
        favoritesScrollPane.setViewportView(favoritesTextArea);

        javax.swing.GroupLayout favouritesPanelLayout = new javax.swing.GroupLayout(favouritesPanel);
        favouritesPanel.setLayout(favouritesPanelLayout);
        favouritesPanelLayout.setHorizontalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(favoritesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );
        favouritesPanelLayout.setVerticalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
            .addGroup(favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(favoritesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );

        welcomeLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        welcomeLabel.setText("Welcome, ");

        pauseOrPlayVideoButton.setText("Pause");
        pauseOrPlayVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseOrPlayVideoButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("My Favourite Links");

        deleteVideoButton.setText("Delete Video");
        deleteVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVideoButtonActionPerformed(evt);
            }
        });

        entryMenu.setText("Entries");

        newEntry.setText("New Entry..");
        newEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryActionPerformed(evt);
            }
        });
        entryMenu.add(newEntry);

        editEntryTitle.setText("Edit Entry Title..");
        editEntryTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEntryTitleActionPerformed(evt);
            }
        });
        entryMenu.add(editEntryTitle);

        deleteSelectedEntry.setText("Delete Selected Entry..");
        entryMenu.add(deleteSelectedEntry);

        myDiaryBookMenu.add(entryMenu);

        personalGoalMenu.setText("Personal Goals");

        newPersonalGoal.setText("New Personal Goal..");
        newPersonalGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPersonalGoalActionPerformed(evt);
            }
        });
        personalGoalMenu.add(newPersonalGoal);

        deletePersonalGoalMenu.setText("Delete Personal Goal..");
        deletePersonalGoalMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePersonalGoalMenuActionPerformed(evt);
            }
        });
        personalGoalMenu.add(deletePersonalGoalMenu);

        myDiaryBookMenu.add(personalGoalMenu);

        favoritesMenu.setText("Favourites");

        newFavorites.setText("New Favorite..");
        newFavorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFavoritesActionPerformed(evt);
            }
        });
        favoritesMenu.add(newFavorites);

        editFavorites.setText("Edit Favorites");
        editFavorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFavoritesActionPerformed(evt);
            }
        });
        favoritesMenu.add(editFavorites);

        myDiaryBookMenu.add(favoritesMenu);

        importantMommentsMenu.setText("Important Momments");

        newImportantMoment.setText("New Important Momment");
        newImportantMoment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newImportantMomentActionPerformed(evt);
            }
        });
        importantMommentsMenu.add(newImportantMoment);

        deleteImportantMoment.setText("Delete Important Momment");
        deleteImportantMoment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImportantMomentActionPerformed(evt);
            }
        });
        importantMommentsMenu.add(deleteImportantMoment);

        myDiaryBookMenu.add(importantMommentsMenu);

        changePassword.setText("Change Password");
        changePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePasswordMouseClicked(evt);
            }
        });
        myDiaryBookMenu.add(changePassword);

        setJMenuBar(myDiaryBookMenu);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alexPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pauseOrPlayVideoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteVideoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitButton)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(favouritesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(166, 166, 166))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(favouritesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pauseOrPlayVideoButton)
                                    .addComponent(exitButton)
                                    .addComponent(deleteVideoButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(welcomeLabel)
                                .addGap(40, 40, 40)
                                .addComponent(displayEntryPane)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_entriesListValueChanged
        MyDiaryBookController controller = new MyDiaryBookController();
        try{
            if(mediaPlayer2!=null)
            {
                videoPanel.remove(mediaPlayer2);
                mediaPlayer2.getMediaPlayer().stop();
                pauseOrPlayVideoButton.setVisible(false);
            }
            entry = controller.getEntry(entriesList.getSelectedValue().toString());
            entryTitleField.setText(entriesList.getSelectedValue().toString());
            imageListScrollPane.setVisible(false);
            loadImageButton.setVisible(false);
            loadAlbumButton.setVisible(false);
            deleteImageAlbumButton.setVisible(false);
            deleteImageButton.setVisible(false);
            deleteVideoButton.setVisible(false);
            imagePanel.removeAll();
            saveEditButton.setVisible(false);
            cancelEditButton.setVisible(false);
            editButton.setVisible(true);
            loadEntryText();
            loadEntryDateLabel();
            loadImageList();
            loadEntryVideo();
        }catch(NullPointerException ex){
            //TODO: Add Logger
            entriesList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_entriesListValueChanged

    private void saveEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditButtonActionPerformed
        EditTextEntryController editText = new EditTextEntryController();
        EditTitleEntryController editTitle = new EditTitleEntryController();
        
        if(saveEditButton.getText().equalsIgnoreCase("Save Title"))
        {
            if (entryTitleField.getText().trim().equals("") || entryTitleField.getText()==null) 
            {
                editEntryTitleLabel.setVisible(true);
            }
            else{
                    editTitle.editFileTitle(previousEntryTitle, entryTitleField.getText());
                    cancelEditButton.setVisible(false);
                    saveEditButton.setVisible(false);
                    editButton.setVisible(true);
                    refreshEntries();
            }
        }
        else
        {
            editText.writeStringToFile(entryTitleField.getText(),entryTextArea.getText());
            refreshEntries();
        } 
        
        entryTitleField.setEditable(false);
        entryTextArea.setEditable(false);
       
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
    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void loadAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAlbumButtonActionPerformed
        loadEntryImages();
        loadImageButton.setVisible(true);
        loadAlbumButton.setVisible(false);
        imageListScrollPane.setVisible(false);
        deleteImageAlbumButton.setVisible(true);
        deleteImageButton.setVisible(false);
    }//GEN-LAST:event_loadAlbumButtonActionPerformed

    private void newEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryActionPerformed
        NewEntryView theView = new NewEntryView();
        theView.setVisible(true);
        theView.setCallerForm(this);
    }//GEN-LAST:event_newEntryActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Are You Sure? ");
        if(ret == JOptionPane.YES_OPTION)
        {
            if(mediaPlayer2!=null)
                mediaPlayer2.getMediaPlayer().release();
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void newPersonalGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPersonalGoalActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        PersonalGoalForm theView = new PersonalGoalForm();

        PersonalGoalForm.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }//GEN-LAST:event_newPersonalGoalActionPerformed

    private void newFavoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFavoritesActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        FavoritesForm theView = new FavoritesForm();
        theView.setCallerForm(this);
        FavoritesForm.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }//GEN-LAST:event_newFavoritesActionPerformed

    private void editFavoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFavoritesActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        DeleteFavorites theView = new DeleteFavorites();
        theView.setCallerForm(this);
        DeleteFavorites.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);    
    }//GEN-LAST:event_editFavoritesActionPerformed

    private void playVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playVideoButtonActionPerformed
        displayVideo(video.toString(),"Display");
        playVideoButton.setVisible(false);
        pauseOrPlayVideoButton.setVisible(true);
    }//GEN-LAST:event_playVideoButtonActionPerformed

    private void pauseOrPlayVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseOrPlayVideoButtonActionPerformed
        pauseOrPlayVideo();
        pauseOrPlayVideoButton.setText(pauseOrPlay);
    }//GEN-LAST:event_pauseOrPlayVideoButtonActionPerformed

    private void personalGoalListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_personalGoalListValueChanged
        MyDiaryBookController controller = new MyDiaryBookController();

        Login lgn = new Login();
        String userName = lgn.getUsername();

        String selectedFile = personalGoalList.getSelectedValue().toString();
        personalGoal = controller.getPersonalGoal(selectedFile, userName);

        titleTextField.setText(personalGoalList.getSelectedValue().toString());
        try {
            loadPersonalGoalLocation();
            loadPersonalGoalWithPerson();
            loadPersonalGoalAnnouncement();
            loadPersonalGoalwhenDate();

        } catch (NullPointerException ex) {

            personalGoalList.setSelectedIndex(0);

        }
        
    }//GEN-LAST:event_personalGoalListValueChanged

    private void personalGoalListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_personalGoalListFocusGained
        loadListOfPersonalGoal();
    }//GEN-LAST:event_personalGoalListFocusGained

    private void titleTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleTextFieldFocusLost
        TitleValidator newTitle = new TitleValidator();
        boolean isValid = newTitle.titleIsValid(titleTextField.getText());
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

    private void changePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordMouseClicked
        ChangePassword changePasswd = new ChangePassword();
        changePasswd.setVisible(true);
    }//GEN-LAST:event_changePasswordMouseClicked

    private void newImportantMomentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newImportantMomentActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        momentsframe theView = new momentsframe();

        momentsframe.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }//GEN-LAST:event_newImportantMomentActionPerformed

    private void deleteImportantMomentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImportantMomentActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        DeleteImportantMomentsForm theView = new DeleteImportantMomentsForm();

        theView.setDefaultLookAndFeelDecorated(true);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }//GEN-LAST:event_deleteImportantMomentActionPerformed

    private void deleteTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTextButtonActionPerformed
        DeleteTextController textDelete = new DeleteTextController();
        int dialog = JOptionPane.showConfirmDialog(this, "Are You sure for this delete?", "Confirm Message", JOptionPane.OK_CANCEL_OPTION);

        if (dialog == JOptionPane.YES_OPTION) {

            try {

                textDelete.deleteAElementFromTextList(entriesList.getSelectedValue().toString());
                entryTextArea.setText("");
                refreshEntries();
            } catch (NullPointerException ex) {
               //TODO: Add Logger
            }
        }
    }//GEN-LAST:event_deleteTextButtonActionPerformed

    private void deletePersonalGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePersonalGoalButtonActionPerformed
        DeletePersonalGoalController controller = new DeletePersonalGoalController();
        if (titleTextField.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "First you have to Select a Personal Goal ", "Info" ,JOptionPane.DEFAULT_OPTION);
        } else {
            int dialog = JOptionPane.showConfirmDialog(this, "Are You sure for this delete?", "Confirm Message", JOptionPane.OK_CANCEL_OPTION);
            if (dialog == JOptionPane.YES_OPTION) {
                try {
                    controller.deleteElementFromList(model.Login.getUsername(), titleTextField.getText());
                    /*
                    NA DOUME GIA TI LISTA META TO DELETE
                    */

                    emptyPersonalTextField();
                    loadListOfPersonalGoal();
                    personalGoalListValueChanged(null);
                } catch (NullPointerException ex) {

                    //TODO: Add Logger
                }
            }
        }
    }//GEN-LAST:event_deletePersonalGoalButtonActionPerformed

    private void deleteImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImageButtonActionPerformed
        DeleteImageController imageDelete = new DeleteImageController();
        int dialog = JOptionPane.showConfirmDialog(this, "Are You sure for this delete?", "Confirm Message", JOptionPane.OK_CANCEL_OPTION);
        if (imageMode == "Single") {

            if (dialog == JOptionPane.YES_OPTION) {
                try {

                    imageDelete.deleteAElementFromImageList(entryTitleField.getText(), imagesList.getSelectedValue().toString());
                    refreshEntries();
                    //loadImageButtonActionPerformed(evt);


                } catch (NullPointerException ex) {


                } 
            }
        } else {
            if (dialog == JOptionPane.YES_OPTION) {

                try {
                    imageDelete.deleteImageAlbum(entryTitleField.getText());
                    loadAlbumButtonActionPerformed(evt);
                } catch (NullPointerException ex) {
                    //TODO: Add Logger
                }
            }

        }
    }//GEN-LAST:event_deleteImageButtonActionPerformed

    private void deleteVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVideoButtonActionPerformed
        DeleteVideoController controller = new DeleteVideoController();

        try {
            controller.deleteVideoAlbum(entry.getEntryVideo());
            refreshEntries();
        } catch (NullPointerException ex) {
            //TODO: Add Logger
        } 
    }//GEN-LAST:event_deleteVideoButtonActionPerformed

    private void deletePersonalGoalMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePersonalGoalMenuActionPerformed
        deletePersonalGoalButtonActionPerformed(evt);
    }//GEN-LAST:event_deletePersonalGoalMenuActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(!entryTextArea.getText().trim().equals(""))
        {
            entryTextArea.setEditable(true);
            saveEditButton.setVisible(true);
            editMode = "Save Text";
            saveEditButton.setText(editMode);
            cancelEditButton.setVisible(true);
            if(entryTextArea.requestFocusInWindow())
                entryTextArea.requestFocus();
            editButton.setVisible(false);
        }
        else
        {
            editButton.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void cancelEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditButtonActionPerformed
       editButton.setVisible(true); 
       entryTextArea.setEditable(false);
       entryTitleField.setEditable(false);
       saveEditButton.setVisible(false);
       cancelEditButton.setVisible(false);
       refreshEntries();
       entriesList.setSelectedIndex(0);
       loadEntryText();
    }//GEN-LAST:event_cancelEditButtonActionPerformed

    private void editEntryTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEntryTitleActionPerformed
        if(entryTitleField.getText()!=null && !entryTitleField.getText().trim().equals(""))
        {
            previousEntryTitle = entryTitleField.getText();
            entryTitleField.setEditable(true);
            editMode = "Save Title";
            saveEditButton.setText(editMode);
            editButton.setVisible(false);
            saveEditButton.setVisible(true);
            cancelEditButton.setVisible(true);
        }
    }//GEN-LAST:event_editEntryTitleActionPerformed

    private void entryTitleFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_entryTitleFieldFocusLost
        if(entryTitleField.getText().trim().equals(""))
        {
            editEntryTitleLabel.setVisible(true);
            editEntryTitleLabel.setText("Title Cannot Be Null!");
            saveEditButton.setVisible(false);
        }
                
        if(entryTitleField.getText().matches("\\w*") || entryTitleField.getText().matches("\\w*\\s\\w*") || entryTitleField.getText().matches("\\w*\\s\\w*\\s\\w*"))
        {
            editEntryTitleLabel.setVisible(false);
            saveEditButton.setVisible(true);
        }
        else
        {
            editEntryTitleLabel.setText("Title Length Must Be 3 Words Max!");
            editEntryTitleLabel.setVisible(true);
            saveEditButton.setVisible(false);
        }
        
    }//GEN-LAST:event_entryTitleFieldFocusLost

    private void editCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCheckBoxActionPerformed
        if(editCheckBox.isSelected())
        {
            titleTextField.setEnabled(true);
            locationTextField.setEnabled(true);
            withPersonTextField.setEnabled(true);
            announcementEditorPane.setEnabled(true);
            whenDateSpinner.setVisible(true);
            whenDateTextField.hide();

        }
        else
        {
            titleTextField.setEnabled(false);
            locationTextField.setEnabled(false);
            withPersonTextField.setEnabled(false);
            announcementEditorPane.setEnabled(false);
            whenDateSpinner.setVisible(false);
            whenDateTextField.setVisible(true);
        }

    }//GEN-LAST:event_editCheckBoxActionPerformed

    private void showPersonalGoalImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPersonalGoalImageButtonActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        showImagePersonalGoalForm imageForm = new showImagePersonalGoalForm();

        imageForm.setDefaultLookAndFeelDecorated(true);
        imageForm.setLocationRelativeTo(null);
        imageForm.setVisible(true);
        
        String userName = Login.getUsername();
        PersonalGoalModel personalGoal = getPersonalGoalByTitle(personalGoalList.getSelectedValue().toString(),userName );
        String fileName = personalGoal.getPersonalGoalImage();
         
        showImagePersonalGoalForm.urlTextField.setText(fileName);
    }//GEN-LAST:event_showPersonalGoalImageButtonActionPerformed

    private void deleteImageAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImageAlbumButtonActionPerformed
        deleteImageButtonActionPerformed(evt);
    }//GEN-LAST:event_deleteImageAlbumButtonActionPerformed

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
    private javax.swing.JPanel alexPanel;
    private javax.swing.JEditorPane announcementEditorPane;
    private javax.swing.JButton cancelEditButton;
    private javax.swing.JMenu changePassword;
    private javax.swing.JTextField checkFieldTextField;
    private javax.swing.JButton deleteImageAlbumButton;
    private javax.swing.JButton deleteImageButton;
    private javax.swing.JMenuItem deleteImportantMoment;
    private javax.swing.JButton deletePersonalGoalButton;
    private javax.swing.JMenuItem deletePersonalGoalMenu;
    private javax.swing.JMenuItem deleteSelectedEntry;
    private javax.swing.JButton deleteTextButton;
    private javax.swing.JButton deleteVideoButton;
    private javax.swing.JTabbedPane displayEntryPane;
    private javax.swing.JButton editButton;
    private javax.swing.JCheckBox editCheckBox;
    private javax.swing.JMenuItem editEntryTitle;
    private javax.swing.JLabel editEntryTitleLabel;
    private javax.swing.JMenuItem editFavorites;
    private javax.swing.JList entriesList;
    private javax.swing.JScrollPane entriesListScrollPane;
    private javax.swing.JLabel entryDateLabel;
    private javax.swing.JMenu entryMenu;
    private javax.swing.JTextArea entryTextArea;
    private javax.swing.JScrollPane entryTextAreaScrollPane;
    private javax.swing.JTextField entryTitleField;
    private javax.swing.JLabel entryTitleLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenu favoritesMenu;
    private javax.swing.JScrollPane favoritesScrollPane;
    private javax.swing.JTextArea favoritesTextArea;
    private javax.swing.JPanel favouritesPanel;
    private javax.swing.JScrollPane imageListScrollPane;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel imagePanelContainer;
    private javax.swing.JScrollPane imagePanelScrollPane;
    private javax.swing.JList imagesList;
    private javax.swing.JMenu importantMommentsMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastModifiedLabel;
    private javax.swing.JButton loadAlbumButton;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JMenuBar myDiaryBookMenu;
    private javax.swing.JMenuItem newEntry;
    private javax.swing.JMenuItem newFavorites;
    private javax.swing.JMenuItem newImportantMoment;
    private javax.swing.JMenuItem newPersonalGoal;
    private javax.swing.JButton pauseOrPlayVideoButton;
    private javax.swing.JLabel personalGoalLabel;
    private javax.swing.JList personalGoalList;
    private javax.swing.JScrollPane personalGoalListScrollPane;
    private javax.swing.JMenu personalGoalMenu;
    private javax.swing.JPanel personalGoalPanel;
    private javax.swing.JButton playVideoButton;
    private javax.swing.JButton saveEditButton;
    private javax.swing.JButton showPersonalGoalImageButton;
    private javax.swing.JPanel textPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JPanel videoPanel;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JSpinner whenDateSpinner;
    private javax.swing.JTextField whenDateTextField;
    private javax.swing.JLabel withPersonLabel;
    private javax.swing.JTextField withPersonTextField;
    // End of variables declaration//GEN-END:variables
}

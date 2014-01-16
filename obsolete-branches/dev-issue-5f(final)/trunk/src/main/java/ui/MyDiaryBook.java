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
import controller.EditTextEntryController;
import controller.EditTitleEntryController;
import dao.NewEntryDao;
import dao.PersonalGoalTxtDao;
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
import model.DefaultPath;
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
    private PersonalGoalModel personalGoalModel;
    private final EditTextEntryController editcontroller;
    private final EditTitleEntryController edittitlecontroller;
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
        editEntryTitleButton.setVisible(false);
        playVideoButton.setVisible(false);
        pauseOrPlayVideoButton.setVisible(false);
        lastModifiedLabel.setVisible(false);
        this.entryDateLabel.setVisible(false);
        entriesList.setSelectedIndex(0);
        this.editcontroller = new EditTextEntryController();
        this.edittitlecontroller = new EditTitleEntryController();
        //Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setSize(d);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setExtendedState(JFrame.NORMAL);
        loadListOfPersonalGoal();
        this.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(this, DefaultPath.getDefaultPath());
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
            //mediaPlayer.getMediaPlayer().pause();
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
    
    @Override
    public void loadImageList()
    {
        DefaultListModel listModel = new DefaultListModel();
//        try
//        {
        if(entry.getImageList()!=null)
        {
            String[] imageNames = entry.getImageList(); //controller.getImageList(entriesList.getSelectedValue().toString());
            for(int i=0;i<imageNames.length;i++)
            {
                listModel.addElement(imageNames[i]);    
            }
            imagesList.setModel(listModel);
            loadAlbumButton.setVisible(true);
        }
//        catch(NullPointerException ex)
        else
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
        if(!text.equals(""))
            entryTextArea.setText(entry.getEntryText());
        else
            entryTextArea.setText("");
    }
    
    @Override
    public void loadEntryVideo()
    {
        if(entry.getEntryVideo()!= null)
        {
            video = entry.getEntryVideo();
            mediaPlayer2 = new EmbeddedMediaPlayerComponent(); 
            playVideoButton.setVisible(true);
        }
        else
        {
            playVideoButton.setVisible(false);
            pauseOrPlayVideoButton.setVisible(false);
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
        String text = personalGoalModel.getPersonalGoalTitle();
        if(!text.equals(""))
            entryTextArea.setText(personalGoalModel.getPersonalGoalTitle());
        
    }
       public void loadPersonalGoalLocation()
    {
        String textLocation = personalGoalModel.getPersonalGoalLocation();
        if(!textLocation.equals(""))
            locationTextField.setText(personalGoalModel.getPersonalGoalLocation());
        
    }
       public void loadPersonalGoalWithPerson()
    {
        String textWithPerson = personalGoalModel.getPersonalGoalWithPerson();
        if(!textWithPerson.equals(""))
            withPersonTextField.setText(personalGoalModel.getPersonalGoalLocation());
        
    }
         public void loadPersonalGoalwhenDate()
    {
        String textWithPerson = personalGoalModel.getPersonalGoalWithPerson();
        if(!textWithPerson.equals(""))
            withPersonTextField.setText(personalGoalModel.getPersonalGoalLocation());
        
    }
       
       public void loadPersonalGoalAnnouncement()
    {
        String textAnnouncement = personalGoalModel.getPersonalGoalAnnouncement();
        if(!textAnnouncement.equals(""))
            announcementEditorPane.setText(personalGoalModel.getPersonalGoalAnnouncement());
        
    }
       
//       public void displayImagePersonalGoal(){
//           String fileName = personalGoal.getPersonalGoalImage();
//        
//        File file = new File(fileName);
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(file);
//        } catch (IOException ex) {
//            Logger.getLogger(PersonalGoalForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        int w = imageLabel.getWidth();
//        int h = imageLabel.getHeight();
//
//        int type = img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : img.getType();
//
//        BufferedImage resizedImg = new BufferedImage(w, h, type);
//        Graphics g = resizedImg.createGraphics();
//        g.drawImage(img, 0, 0, w, h, null);
//        g.dispose();
//        imageLabel.setIcon(new ImageIcon(resizedImg));
//        boolean ifImageExist =true;
//     }
    
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
        editButton = new javax.swing.JButton();
        editEntryTitleButton = new javax.swing.JButton();
        imagePanelContainer = new javax.swing.JPanel();
        imageListScrollPane = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList();
        imagePanelScrollPane = new javax.swing.JScrollPane();
        imagePanel = new javax.swing.JPanel();
        loadImageButton = new javax.swing.JButton();
        loadAlbumButton = new javax.swing.JButton();
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
        savePersonalGoalButton = new javax.swing.JButton();
        cancelPersonalGoalButton = new javax.swing.JButton();
        personalGoalLabel = new javax.swing.JLabel();
        checkFieldTextField = new javax.swing.JTextField();
        favouritesPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        pauseOrPlayVideoButton = new javax.swing.JButton();
        myDiaryBookMenu = new javax.swing.JMenuBar();
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
        entriesByNameRadioButton = new javax.swing.JRadioButtonMenuItem();
        entriesByDateRadioButton = new javax.swing.JRadioButtonMenuItem();
        personalGoalsRadioButton = new javax.swing.JRadioButtonMenuItem();
        changePassword = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Diary Book v1.0!");

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

        saveEditButton.setText("Save Changes");
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

        editButton.setText("Edit Entry");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        editEntryTitleButton.setText("Change the Entry's title");
        editEntryTitleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEntryTitleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entryTextAreaScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lastModifiedLabel)
                                .addGap(4, 4, 4))
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(entryTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(entryDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(editEntryTitleButton)
                        .addGap(216, 216, 216))
                    .addComponent(entriesListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cancelEditButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveEditButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entryTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastModifiedLabel)
                    .addComponent(entryDateLabel)
                    .addComponent(editEntryTitleButton)
                    .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(editButton)
                        .addGap(11, 11, 11)
                        .addComponent(saveEditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelEditButton)
                        .addGap(246, 246, 246)
                        .addComponent(entriesListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
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

        savePersonalGoalButton.setText("Save");
        savePersonalGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePersonalGoalButtonActionPerformed(evt);
            }
        });

        cancelPersonalGoalButton.setText("Cancel");
        cancelPersonalGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPersonalGoalButtonActionPerformed(evt);
            }
        });

        personalGoalLabel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        personalGoalLabel.setText("Personal Goal");

        javax.swing.GroupLayout personalGoalPanelLayout = new javax.swing.GroupLayout(personalGoalPanel);
        personalGoalPanel.setLayout(personalGoalPanelLayout);
        personalGoalPanelLayout.setHorizontalGroup(
            personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addComponent(locationLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addComponent(AnnouncementLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(personalGoalLabel))
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savePersonalGoalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelPersonalGoalButton))
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(personalGoalListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(checkFieldTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        personalGoalPanelLayout.setVerticalGroup(
            personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalGoalPanelLayout.createSequentialGroup()
                .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleLabel)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(personalGoalLabel))
                        .addGap(18, 18, 18)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationLabel)
                            .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(withPersonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(withPersonLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(whenDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WhenDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AnnouncementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalGoalPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(personalGoalListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkFieldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(personalGoalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savePersonalGoalButton)
                            .addComponent(cancelPersonalGoalButton))))
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

        welcomeLabel.setText("Welcome, ");

        pauseOrPlayVideoButton.setText("Pause");
        pauseOrPlayVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseOrPlayVideoButtonActionPerformed(evt);
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

        editEntry.setText("Edit Entry..");
        entryMenu.add(editEntry);

        deleteSelectedEntry.setText("Delete Selected..");
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

        myDiaryBookMenu.add(personalGoalMenu);

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

        myDiaryBookMenu.add(favoritesMenu);

        importantMommentsMenu.setText("Important Momments");
        myDiaryBookMenu.add(importantMommentsMenu);

        searchMenu.setText("Search..");

        entriesByNameRadioButton.setSelected(true);
        entriesByNameRadioButton.setText("Entries By Name");
        searchMenu.add(entriesByNameRadioButton);

        entriesByDateRadioButton.setSelected(true);
        entriesByDateRadioButton.setText("Entries By Date");
        searchMenu.add(entriesByDateRadioButton);

        personalGoalsRadioButton.setSelected(true);
        personalGoalsRadioButton.setText("Personal Goals");
        searchMenu.add(personalGoalsRadioButton);

        myDiaryBookMenu.add(searchMenu);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(favouritesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alexPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pauseOrPlayVideoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(favouritesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pauseOrPlayVideoButton)
                                .addComponent(exitButton))
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
            imagePanel.removeAll();
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
        boolean answer = editcontroller.checkEdit(entryTextArea.getText());
        boolean title = edittitlecontroller.editFileTitle(entryTitleField.getText());
        //if(("").equals(jTextArea1.getText()))
        if(answer==false)
            JOptionPane.showMessageDialog(this, "The entry is empty!");
        else {
            JOptionPane.showMessageDialog(this, "Successfully Edited!");
            loadEntryImages();
            loadEntryVideo();}
            saveEditButton.setVisible(false);
            cancelEditButton.setVisible(false);   
            editEntryTitleButton.setVisible(false);
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

        personalGoalModel = controller.getPersonalGoal(personalGoalList.getSelectedValue().toString());
        try{
            titleTextField.setText(personalGoalList.getSelectedValue().toString());

            loadPersonalGoalLocation();
            loadPersonalGoalWithPerson();
            loadPersonalGoalAnnouncement();
          //  displayImagePersonalGoal();

        }catch(NullPointerException ex){
            //fix this
            entriesList.setSelectedIndex(0);

        }
    }//GEN-LAST:event_personalGoalListValueChanged

    private void personalGoalListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_personalGoalListFocusGained
        loadListOfPersonalGoal();
    }//GEN-LAST:event_personalGoalListFocusGained

    private void titleTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleTextFieldFocusLost
        TitleValidator newTitle = new TitleValidator();
        boolean isValid = newTitle.titleIsValid(titleTextField.getText());
        savePersonalGoalButton.setEnabled(isValid);
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

    private void savePersonalGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePersonalGoalButtonActionPerformed
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
    }//GEN-LAST:event_savePersonalGoalButtonActionPerformed

    private void cancelPersonalGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPersonalGoalButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelPersonalGoalButtonActionPerformed

    private void changePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordMouseClicked
        ChangePassword changePasswd = new ChangePassword();
        changePasswd.setVisible(true);
    }//GEN-LAST:event_changePasswordMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        this.entryTextArea.setEditable(true);
        saveEditButton.setVisible(true);
        cancelEditButton.setVisible(true);
        editEntryTitleButton.setVisible(true);
        editButton.setVisible(false);
    }//GEN-LAST:event_editButtonActionPerformed

    private void cancelEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditButtonActionPerformed
        this.entryTextArea.setEditable(false);
        this.entryTitleField.setEditable(false);
    }//GEN-LAST:event_cancelEditButtonActionPerformed

    private void editEntryTitleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEntryTitleButtonActionPerformed
        this.entryTitleField.setEditable(true);
    }//GEN-LAST:event_editEntryTitleButtonActionPerformed

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
    private javax.swing.JButton cancelPersonalGoalButton;
    private javax.swing.JMenu changePassword;
    private javax.swing.JTextField checkFieldTextField;
    private javax.swing.JMenuItem deleteSelectedEntry;
    private javax.swing.JTabbedPane displayEntryPane;
    private javax.swing.JButton editButton;
    private javax.swing.JMenuItem editEntry;
    private javax.swing.JButton editEntryTitleButton;
    private javax.swing.JRadioButtonMenuItem entriesByDateRadioButton;
    private javax.swing.JRadioButtonMenuItem entriesByNameRadioButton;
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
    private javax.swing.JPanel favouritesPanel;
    private javax.swing.JScrollPane imageListScrollPane;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel imagePanelContainer;
    private javax.swing.JScrollPane imagePanelScrollPane;
    private javax.swing.JList imagesList;
    private javax.swing.JMenu importantMommentsMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastModifiedLabel;
    private javax.swing.JButton loadAlbumButton;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JMenuBar myDiaryBookMenu;
    private javax.swing.JMenuItem newEntry;
    private javax.swing.JMenuItem newFavorites;
    private javax.swing.JMenuItem newPersonalGoal;
    private javax.swing.JButton pauseOrPlayVideoButton;
    private javax.swing.JLabel personalGoalLabel;
    private javax.swing.JList personalGoalList;
    private javax.swing.JScrollPane personalGoalListScrollPane;
    private javax.swing.JMenu personalGoalMenu;
    private javax.swing.JPanel personalGoalPanel;
    private javax.swing.JRadioButtonMenuItem personalGoalsRadioButton;
    private javax.swing.JButton playVideoButton;
    private javax.swing.JButton saveEditButton;
    private javax.swing.JButton savePersonalGoalButton;
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
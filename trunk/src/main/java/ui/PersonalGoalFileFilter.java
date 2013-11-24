/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;
import javax.swing.filechooser.FileFilter;
  import java.io.File;
/**
 *
 * @author alex
 */

  


public class PersonalGoalFileFilter extends FileFilter {

    protected PersonalGoalLayoutFileFilter filter;

    protected String description;
    protected String[] extensions;

    public PersonalGoalFileFilter(PersonalGoalLayoutFileFilter filter) {
        this(filter.getDescription(), filter.getExtension());
        this.filter = filter;
    }

    public PersonalGoalFileFilter(String description, String extension) {
        this(description, new String[] {extension});
    }

    public PersonalGoalFileFilter(String description, String[] extensions) {
        if ((description == null) || (description.equals(""))) {
            this.description = extensions[0] + " {" + extensions.length + "}";
        } else {
            this.description = description;
        }
        this.extensions = (String[]) extensions.clone();
        toLower(this.extensions);
    }

    private void toLower(String[] extensions) {
        for (int i = 0, n = extensions.length; i < n; i++) {
            extensions[i].toLowerCase();
        }
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        } else {
            String path = file.getAbsolutePath().toLowerCase();
            for (int i = 0, n = extensions.length; i < n; i++) {
                String extension = extensions[i];
                if (path.endsWith(extension)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public PersonalGoalLayoutFileFilter getLayoutFileFilter() {
        return filter;
    }
}



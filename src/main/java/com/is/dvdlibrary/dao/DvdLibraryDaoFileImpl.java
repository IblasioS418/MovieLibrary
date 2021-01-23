/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.dvdlibrary.dao;

import com.is.dvdlibrary.dao.*;
import com.is.dvdlibrary.dto.Director;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ibby4
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    public static final String ROSTER_FILE = "library.txt";
    public static final String DELIMITER = "::";

    private Map<String, Director> titles = new HashMap<>();

    @Override
    public void addTitle(String title, Director directorName)
            throws DvdLibraryDaoException {
        loadLibrary();
        titles.put(directorName.getTitle(),directorName);
       //titles.put(title, directorName);
        writeLibrary();

    }

    @Override
    public List<Director> getAllDvds()
            throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList<Director>(titles.values());
    }

    @Override
    public Director getTitle(String title)
            throws DvdLibraryDaoException {
        loadLibrary();
        return titles.get(title);
    }

    @Override
    public Director removeTitle(String title)
            throws DvdLibraryDaoException {
        loadLibrary();
        Director removedTitle = titles.remove(title);
        writeLibrary();
        return removedTitle;
    }

    @Override
    public ArrayList<Director> searchTitle(String directorName)
            throws DvdLibraryDaoException {  
        ArrayList<Director> dvds = new ArrayList();
        
        List<Director> titleList = this.getAllDvds();
        for (Director it : titleList) {
           if (directorName.equalsIgnoreCase(it.getDirectorName())){
                dvds.add(it);
           }
        }
        return dvds;
    }
    
    
    private Director unmarshallDirector(String titleAsText) {
        String[] titleTokens = titleAsText.split(DELIMITER);

        Director titleFromFile = new Director();
        titleFromFile.setTitle(titleTokens[0]);
        titleFromFile.setDirectorName(titleTokens[1]);
        titleFromFile.setMpaaRating(titleTokens[2]);
        titleFromFile.setUserRating(titleTokens[3]);
        titleFromFile.setReleaseDate(titleTokens[4]);
        titleFromFile.setStudio(titleTokens[5]);

        return titleFromFile;
    }

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "Could not load data.", e);
        }
        String currentLine;
        Director currentTitle;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTitle = unmarshallDirector(currentLine);
            titles.put(currentTitle.getTitle(), currentTitle);
        }
        scanner.close();
    }

    private String marshallDirector(Director aTitle) {
        String titleAsText = "";
        titleAsText += aTitle.getTitle() + DELIMITER;
        titleAsText += aTitle.getDirectorName() + DELIMITER;
        titleAsText += aTitle.getMpaaRating() + DELIMITER;
        titleAsText += aTitle.getUserRating() + DELIMITER;
        titleAsText += aTitle.getReleaseDate() + DELIMITER;
        titleAsText += aTitle.getStudio() + DELIMITER;

        return titleAsText;
    }

    private void writeLibrary() throws DvdLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save data", e);
        }
        String titleAsText;
        List<Director> titleList = this.getAllDvds();
        for (Director currentTitle : titleList) {
            titleAsText = marshallDirector(currentTitle);
            out.println(titleAsText);
            out.flush();
        }
        out.close();
    }
}

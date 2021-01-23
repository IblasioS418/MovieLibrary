/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.dvdlibrary.ui;

import com.is.dvdlibrary.dto.Director;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibby4
 */
public class DvdLibraryView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List all DVD Titles");
        io.print("2. Add a DVD to collection");
        io.print("3. Edit existing DVD info");
        io.print("4. Remove a DVD from collection");
        io.print("5. Search DVD by Director");
        io.print("6. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 6);
    }

    public Director getNewTitleInfo() {        
        String title = io.readString("Please Enter Name of Title");
        String directorName = io.readString("Please Enter Director Name");
        String releaseDate = io.readString("Please Enter Release Date");
        String mpaaRating = io.readString("Please Enter MPAA Rating");
        String userRating = io.readString("Please Enter a User Rating");
        String Studio = io.readString("Please Enter Movie Studio");

        Director currentTitle = new Director();
        currentTitle.setTitle(title);
        currentTitle.setDirectorName(directorName);
        currentTitle.setMpaaRating(mpaaRating);
        currentTitle.setUserRating(userRating);
        currentTitle.setReleaseDate(releaseDate);
        currentTitle.setStudio(Studio);
        return currentTitle;
    }

    public void displayCreateTitleBanner() {
        io.print("=== Add new Title ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Title has been successfully added to database");
    }

    public void displayTitleList(List<Director> titleList) {
        for (Director currentTitle : titleList) {
            io.print(currentTitle.getTitle() + " Directed by "
                    + currentTitle.getDirectorName());
        }
        io.readString("Hit Enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Show All Titles ===");
    }

    public void displayDisplayDvdTitle() {
        io.print("=== Movie Titles by Director ===");
    }

    public String gettitleIdChoice() {
        return io.readString("Please Enter Movie Directors Name");
    }

    public void displayTitle(Director director) {
        if (director != null) {       
            io.print("Movie Title => " + director.getTitle());
            io.print("Release Date => " + director.getReleaseDate());
            io.print("Movie Studio => " + director.getStudio());
            io.print("MPAA Rating => " + director.getMpaaRating());
            io.print("User Rating => " + director.getUserRating());
            io.print("");
        } else {
            io.print("DVD not found.");
        }
        io.readString("Hit Enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Title successfully removed. Hit Enter to continue.");
    }

    public void displayExitBanner() {
        io.print("GOOD BYE");
    }

    public void displayUnknownCmdBanner() {
        io.print("Unknown Command");
    }

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);

    }
    public void displayEditBanner() {
        io.print("=== Edit DVD Information ===");
    }
    public void displayEditSuccess() {
        io.print("=== Information Edited ===");
    }
    public String getDvdIdChoice() {
        return io.readString("Please Enter Movie Title");
    }
    public Director getNewDvdInfo(String newTitle) {      
        String directorName = io.readString("Please Enter Director Name");
        String releaseDate = io.readString("Please Enter Release Date");
        String mpaaRating = io.readString("Please Enter MPAA Rating");
        String userRating = io.readString("Please Enter a User Rating");
        String Studio = io.readString("Please Enter Movie Studio");

        Director currentTitle = new Director();
        currentTitle.setTitle(newTitle);
        currentTitle.setDirectorName(directorName);
        currentTitle.setMpaaRating(mpaaRating);
        currentTitle.setUserRating(userRating);
        currentTitle.setReleaseDate(releaseDate);
        currentTitle.setStudio(Studio);
        return currentTitle;
    }
    public void displayDvdDirectors (ArrayList<Director> directorList) {
        for (Director director : directorList) {
                if (director != null) {            
            io.print("Movie Title => " + director.getTitle());
            io.print("Release Date => " + director.getReleaseDate());
            io.print("Movie Studio => " + director.getStudio());
            io.print("MPAA Rating => " + director.getMpaaRating());
            io.print("User Rating => " + director.getUserRating());
            io.print("");
        } else {
            io.print("DVD not found.");
        }    
    }io.readString("Hit Enter to Continue");       
    }
}

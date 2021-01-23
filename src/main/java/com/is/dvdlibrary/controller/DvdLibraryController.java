/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.dvdlibrary.controller;

import com.is.dvdlibrary.dao.DvdLibraryDao;
import com.is.dvdlibrary.dao.DvdLibraryDaoException;
import com.is.dvdlibrary.dto.Director;
import com.is.dvdlibrary.ui.DvdLibraryView;
import com.is.dvdlibrary.ui.UserIO;
import com.is.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibby4
 */
public class DvdLibraryController {

    private UserIO io = new UserIOConsoleImpl();
    DvdLibraryView view;
    DvdLibraryDao dao;

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvdTitles();
                        break;
                    case 2:
                        addDvdTitle();
                        break;
                    case 3:
                        editTitle();
                        break;
                    case 4:
                        removeTitle();
                        break;
                    case 5:
                        searchDvdTitles();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCmd();
                }

            }
            exitMessage();
        } catch (DvdLibraryDaoException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDvdTitle() throws DvdLibraryDaoException {
        view.displayCreateTitleBanner();
        Director newTitle = view.getNewTitleInfo();
        dao.addTitle(newTitle.getTitle(), newTitle);
        view.displayCreateSuccessBanner();
    }

    private void listDvdTitles() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Director> titleList = dao.getAllDvds();
        view.displayTitleList(titleList);

    }

    //Currently not working correctly will need to be fixed
    private void searchDvdTitles() throws DvdLibraryDaoException {
        view.displayDisplayDvdTitle();
        String directorName = view.gettitleIdChoice();        
        ArrayList<Director> directorList = dao.searchTitle(directorName);        
        view.displayDvdDirectors(directorList);
        // ----->   
    }

    public void removeTitle() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdIdChoice();
        dao.removeTitle(title);
        view.displayRemoveSuccessBanner();
    }
    public void editTitle() throws DvdLibraryDaoException {
        view.displayEditBanner();
        String newTitle = view.getDvdIdChoice();
        //Director title = dao.getTitle(newTitle);        
        Director newdvd = view.getNewDvdInfo(newTitle);
        dao.addTitle(newTitle, newdvd);
        view.displayEditSuccess();
    }

    private void unknownCmd() {
        view.displayUnknownCmdBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
}

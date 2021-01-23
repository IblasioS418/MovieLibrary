/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.dvdlibrary;


import com.is.dvdlibrary.controller.DvdLibraryController;
import com.is.dvdlibrary.dao.DvdLibraryDao;
import com.is.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.is.dvdlibrary.ui.DvdLibraryView;
import com.is.dvdlibrary.ui.UserIO;
import com.is.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author ibby4
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
    }   
}


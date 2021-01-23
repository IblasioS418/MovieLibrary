/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.dvdlibrary.dao;

import com.is.dvdlibrary.dao.*;
import com.is.dvdlibrary.dto.Director;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibby4
 */
public interface DvdLibraryDao {
    void addTitle(String titleId, Director title)throws DvdLibraryDaoException;
    List<Director> getAllDvds()throws DvdLibraryDaoException;
    Director getTitle(String titleId)throws DvdLibraryDaoException;
    Director removeTitle(String titleId)throws DvdLibraryDaoException;
    ArrayList<Director> searchTitle(String directorName)throws DvdLibraryDaoException;
}

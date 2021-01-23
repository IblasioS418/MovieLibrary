/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.dvdlibrary.dao;

/**
 *
 * @author ibby4
 */
public class DvdLibraryDaoException extends Exception {
    public DvdLibraryDaoException(String msg) {
        super(msg);
    }
    public DvdLibraryDaoException( String msg, Throwable cause){
        super(msg, cause);
    }
}

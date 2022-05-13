package com.information.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface CommonService {
    byte[] exportPdf2(String stunum) throws FileNotFoundException, JRException;
    byte[] exportPdf1(String stunum) throws FileNotFoundException, JRException;
}

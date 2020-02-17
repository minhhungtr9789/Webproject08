package vn.nlu.fit.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UploadFileHelper {

    public UploadFileHelper() {
        super();
    }

    public static List<String> uploadFile(String UPLOAD_DIR, HttpServletRequest request) {
        List<String> fileNames = new ArrayList<String>();
        try {
            List<Part> parts = (List<Part>) request.getParts();
            for (Part part : parts) {
                if (part.getName().equalsIgnoreCase("photos[]")) {
                    String fileName = getFileName(part);
                    fileNames.add(fileName);
                    String applicationPath = request.getServletContext().getRealPath("");
                    String basePath = applicationPath + UPLOAD_DIR + File.separator;
                    InputStream inputStream = null;
                    OutputStream outputStream = null;
                    try {
                        File outputFilePath = new File(basePath + fileName);
                        inputStream = part.getInputStream();
                        outputStream = new  FileOutputStream(outputFilePath);
                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        while ((read = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, read);
                        }
						outputStream.flush();
                    } catch (Exception ex) {
					} finally {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            fileNames = null;
        }
        return fileNames;
    }


    private static String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}

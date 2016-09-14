/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/files")
public class UploadController {

    private static final Logger LOG = Logger.getLogger(UploadController.class.getName());

    @Value(value = "#{stores['store.main']}")
    private String store;

    @RequestMapping(path = {"/"}, method = {RequestMethod.GET})
    public String getUploading() {
        return "upload";
    }

    @RequestMapping(path = "/upload", method = {RequestMethod.POST})
    public String postUploadFile(HttpServletRequest request, HttpServletResponse resp,
            @RequestParam CommonsMultipartFile file,
            RedirectAttributes rattr) throws IOException, ServletException {

        if (!file.isEmpty()) {
            try {
                file.transferTo(new File(store, file.getOriginalFilename()));
                
                rattr.addFlashAttribute("message", "Upload successfully!");
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, null, ex);
                rattr.addFlashAttribute("message", "Upload has errors!");
            }
        }
        
        return "redirect:/files/";
    }

//    @ResponseBody
//    @RequestMapping(path = "/upload")
//    public void getImage(HttpServletRequest request, HttpServletResponse resp,
//            @RequestParam("filename") String fileName) throws IOException, ServletException {
//        if (fileName == null || fileName.equals("")) {
//
//            throw new ServletException("File Name can't be null or empty");
//
//        }
//        
//        File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
//        
//        if (!file.exists()) {
//            throw new ServletException("File doesn't exists on server.");
//
//        }
//        System.out.println("File location on server::" + file.getAbsolutePath());
//        ServletContext ctx = request.getServletContext();
//        InputStream fis = new FileInputStream(file);
//        String mimeType = ctx.getMimeType(file.getAbsolutePath());
//        resp.setContentType(mimeType != null ? mimeType : "application/octet-stream");
//        resp.setContentLength((int) file.length());
//        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//        ServletOutputStream os = resp.getOutputStream();
//        byte[] bufferData = new byte[1024];
//        int read = 0;
//        while ((read = fis.read(bufferData)) != -1) {
//
//            os.write(bufferData, 0, read);
//
//        }
//        os.flush();
//        os.close();
//        fis.close();
//        System.out.println("File downloaded at client successfully");
//
//    }
}

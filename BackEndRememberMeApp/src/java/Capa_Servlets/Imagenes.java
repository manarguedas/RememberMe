/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Servlets;

import static com.google.common.base.CharMatcher.is;
import com.oreilly.servlet.MultipartRequest;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import static java.nio.file.StandardCopyOption.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author zeck
 */
public class Imagenes extends HttpServlet {

    final String SAVE_DIR = "/home/zeck/Documentos/home/zeck/Documentos/";
    static final int BUFFER_LENGTH = 4096;

    private boolean isMultipart;
    public String filePath = "C:\\Users\\MarcoNey\\Pictures";
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RecibirImagen(request,response);
        PrintWriter out = response.getWriter();
        out.println("Recibiendo process");
    }

    public void copiar(String pFuente, String pDestino) throws Exception {
        //String imageUrl = "http://www.avajava.com/images/avajavalogo.jpg";
        //String destinationFile = filePath + "\\image.jpg";
        //saveImage(imageUrl, destinationFile);

        saveImage(pFuente, pDestino);
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
//        URL url = new URL(imageUrl);
//
//        InputStream is = url.openStream();
        InputStream is = new FileInputStream(new File(imageUrl));
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

    public static long copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[2048];

        try {
            int contador = 3;
            while (true) {
                int numero = input.read();
                if (contador <= 0 || numero == -1) {
                    break;
                }
                char c = (char) numero;
                System.out.print(c);
                if (c == '\n') {
                    contador--;
                }
            }
            try {
                int bytesRead;
                //Image image = ImageIO.read(input);
                //ImageIO.write((RenderedImage) image, "jpg",new File("C:\\Users\\MarcoNey\\Pictures\\out.jpg"));
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                    //System.out.println(Arrays.toString(buffer));
                }
            } finally {
                output.close();
            }
        } finally {
            input.close();
        }
        return 0;
    }

    public void RecibirImagen(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        SingletonHttp.getInstance().AddEncabezados(response);
        PrintWriter out = response.getWriter();

        MultipartRequest m = new MultipartRequest(request, "C:\\Users\\MarcoNey\\Pictures\\");
//        try {
//            copiar("C:\\Users\\MarcoNey\\Pictures\\" + "image.jpg", "C:\\Users\\MarcoNey\\Pictures\\" + request.getRemoteAddr());
//        } catch (Exception ex) {
//            Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
//        }
        out.print("successfully uploaded");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Estoy en el get");
        try {
            RecibirImagen(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Estoy en el post");
        try {
            RecibirImagen(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Estoy en el put");
        try {
            copiar("C:\\Users\\MarcoNey\\Pictures\\" + request.getRemoteAddr(), "C:\\Users\\MarcoNey\\Pictures\\" + request.getParameter("nombre"));
        } catch (Exception ex) {
            Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

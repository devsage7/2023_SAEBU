package com.mycompany.saebu.logica.clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public abstract class PDF {
    public PDF(){}
    
    public final void generarPDF(){
        Document documento = new Document();
        FileOutputStream archivo;
        Paragraph titulo, titulo2;
        titulo = new Paragraph("UNSL - SAEBU");
        titulo2 = new Paragraph("Asuntos Estudiantiles");  
        String nom= nomarchivo();
        int j=0;
        try {
            String nombre = nom + colocarAlumno() + "-" + numero() + ".pdf";
            archivo = new FileOutputStream(nombre);
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            if(nom.equals("Triplicado")){
                j=1;
            }
            for (int i=j; i <= 1; i++) {
                titulo.setAlignment(1);
                documento.add(titulo);
                titulo2.setAlignment(1);
                documento.add(titulo2);
                documento.add(Chunk.NEWLINE);
                documento.add(new Paragraph(paragraph()));
                LineSeparator linea = new LineSeparator();
                linea.setLineWidth(3);
                linea.setLineColor(BaseColor.BLACK);
                documento.add(Chunk.NEWLINE);
                documento.add(linea);
                documento.add(Chunk.NEWLINE);
                documento.add(new Paragraph(tipo()));
                documento.add(new Paragraph(hora()));
                documento.add(new Paragraph(linea2()));
                documento.add(new Paragraph("Operador: " + nombreoperador()));
                documento.add(Chunk.NEWLINE);
                documento.add(linea);
                documento.add(Chunk.NEWLINE);
                documento.add(new Paragraph(colocarAlumno()));
                documento.add(new Paragraph("Disciplina: " + nombredisciplina()));
                documento.add(new Paragraph(linea3()));
                documento.add(Chunk.NEWLINE);
                documento.add(linea);
                documento.add(Chunk.NEWLINE);
                documento.add(new Paragraph("Valor: $" + importe()));
                documento.add(Chunk.NEWLINE);
                documento.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                documento.add(Chunk.NEWLINE);
            }
            documento.close();
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + nombre);
            } catch (IOException evvv) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FileNotFoundException | DocumentException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public abstract String nomarchivo();
    public abstract String colocarAlumno();
    public abstract int numero();
    public abstract String paragraph();
    public abstract String tipo();
    public abstract String hora();
    public abstract String nombreoperador();
    public abstract String nombredisciplina();
    public abstract String linea2();
    public abstract float importe();
    public abstract String linea3();
}

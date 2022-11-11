/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.relatorioPDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Klesia
 */
public class RelatorioPdf {

    public void gerarRelatorio(String total, String Maculino, String Femenino) {

        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("src\\relatorioPDF Jail_ts2022.pdf"));
            documento.open();
            documento.setPageSize(PageSize.A4);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("    ******  RELATÓRIO  ****** "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"));
            documento.add(new Paragraph(" | Masculino: " + Maculino + "|"));
            documento.add(new Paragraph(" |____________________________|"));
            documento.add(new Paragraph(" | Feminino:  " + Femenino + "|"));
            documento.add(new Paragraph(" |----------------------------|"));
            documento.add(new Paragraph("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ "));
            documento.add(new Paragraph("   Total de Usarios :  " + total));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" Requerente: "));

         //   documento.add(new Paragraph("Data: " + sdf.format(data) + "  Local: * Maputo-Moçambique, Jail_ts2022 "));
        } catch (DocumentException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar documento.\nERRO: " + ex);
        } finally {
            documento.close();
        }
    }

}

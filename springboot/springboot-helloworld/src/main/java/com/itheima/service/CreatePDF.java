package com.itheima.service;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.kernel.pdf.navigation.PdfExplicitDestination;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class CreatePDF {

    public static void main1(String args[]) throws Exception {
        // 1、Creating a PdfWriter
        String dest = "/Users/xuweiqiang/Desktop/sample.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // 2、Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);

        // 3、Adding an empty page
        pdfDoc.addNewPage();

        // 4、Creating a Document
        Document document = new Document(pdfDoc);

        // 5、Closing the document
        document.close();
        System.out.println("PDF Created");
    }



    public static void main2(String args[]) throws Exception {
        // 1、Creating a PdfWriter
        String dest = "/Users/xuweiqiang/Desktop/sample.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // 2、Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);
        try {

            pdfDoc.addNewPage();


            // 创建一个空的PDF文档
            Document document = new Document(pdfDoc);
            // 添加内容到PDF文档
            document.add(new Paragraph("Chapter 1: Introduction"));
            document.add(new Paragraph("Chapter 2: Getting Started"));
            document.add(new Paragraph("Chapter 3: Advanced Topics"));

            pdfDoc.addNewPage();
            pdfDoc.addNewPage();
            pdfDoc.addNewPage();

            System.out.println("PDF Created");

            // 保存PDF文档
            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) throws Exception {
        // 1、Creating a PdfWriter
        String dest = "/Users/xuweiqiang/Desktop/sample.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // 2、Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();
        // 创建一个空的PDF文档
        Document document = new Document(pdfDoc);
        // 添加内容到PDF文档
        document.add(new Paragraph("Chapter 1: Introduction"));
        document.add(new Paragraph("Chapter 2: Getting Started"));
        document.add(new Paragraph("Chapter 3: Advanced Topics"));
        pdfDoc.addNewPage();
        pdfDoc.addNewPage();
        pdfDoc.addNewPage();
        System.out.println("PDF Created");
        // 添加书签
        PdfPage page = pdfDoc.getPage(1);
        //获取根书签
        PdfOutline baseOutline = pdfDoc.getOutlines(false);
        //设置书签动作
        PdfAction action = PdfAction.createGoTo(PdfExplicitDestination.createFitH(page, 0));
        PdfOutline pageOutline = baseOutline.addOutline( "第一页");
        //是默认展开
        pageOutline.setOpen(false);
        //添加动作到书签对象
        pageOutline.addAction(action);
        // 设置导航项的标题
        PdfOutline outlines = pdfDoc.getOutlines(false);
        outlines.setTitle("Introduction");
        // 添加带有标签的内容
        document.add(new Paragraph("This is a tagged PDF document."));
        // 保存PDF文档
        document.close();
        writer.close();
    }
}

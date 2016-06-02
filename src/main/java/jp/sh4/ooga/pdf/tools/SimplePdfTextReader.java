package jp.sh4.ooga.pdf.tools;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by sh-ogawa on 2016/06/02.
 */
public class SimplePdfTextReader {

    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("コマンドライン引数にファイルを指定してください");
            System.exit(0);
        }

        SimplePdfTextReader simplePdfTextReader = new SimplePdfTextReader();
        Path path = Paths.get(args[0]);
        simplePdfTextReader.read(path.toFile());


    }

    public void read(File file){
        PDDocument pdf = null;
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            PDFParser pdfParser = new PDFParser(randomAccessFile);
            pdfParser.parse();
            pdf = pdfParser.getPDDocument();
            int pageNums = pdf.getNumberOfPages();

            PDFTextStripper textStripper = new PDFTextStripper();
            System.out.println(textStripper.getText(pdf));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

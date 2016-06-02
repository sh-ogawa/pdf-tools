package jp.sh4.ooga.pdf.tools;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by sh-ogawa on 2016/06/02.
 */
public class SimplePdfTextReaderTest {

    @Test
    public void readTest(){

        SimplePdfTextReader reader = new SimplePdfTextReader();
        Path outPath = Paths.get("src/test/resources/jp/sh4/ooga/pdf/tools/E05760-03.pdf");
        reader.read(outPath.toFile());

    }

}

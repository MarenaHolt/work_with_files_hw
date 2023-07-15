import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ArchiveTests {

    @Test
    void zipTest() throws Exception {
        try (ZipFile zipFile = new ZipFile("src/test/resources/example.zip")) {

            ZipEntry entryXls = zipFile.getEntry("heroes.xls");
            try (InputStream stream = zipFile.getInputStream(entryXls)) {
                XLS xls = new XLS(stream);
                Assertions.assertEquals("Holmes",
                        xls.excel.getSheetAt(0).
                                getRow(1)
                                .getCell(1)
                                .getStringCellValue());
            }

            ZipEntry entryPdf = zipFile.getEntry("Makoto.pdf");
            try (InputStream stream = zipFile.getInputStream(entryPdf)) {
                PDF pdf = new PDF(stream);
                System.out.println();
                Assertions.assertEquals("Makoto Shinkai is a Japanese animator, filmmaker, author, and manga artist.", pdf.text.trim());
            }

            ZipEntry entryCsv = zipFile.getEntry("bookone.csv");
            try (InputStream stream = zipFile.getInputStream(entryCsv)) {
                Reader reader = new InputStreamReader(stream);
                CSVReader csvReader = new CSVReader(reader);
                List<String[]> content = csvReader.readAll();

                Assertions.assertEquals(11, content.size());

                final String[] firstRow = content.get(0);
                final String[] secondRow = content.get(1);
                final String[] thirdRow = content.get(2);
                final String[] fourthRow = content.get(3);
                final String[] fifthRow = content.get(4);

                Assertions.assertArrayEquals(new String[]{"QuotaAmount", "StartDate", "OwnerName", "Username"}, firstRow);
                Assertions.assertArrayEquals(new String[]{"150000", "2016-01-01", "Chris Riley", "trailhead9.ub20k5i9t8ou@example.com"}, secondRow);
                Assertions.assertArrayEquals(new String[]{"150000", "2016-02-01", "Chris Riley", "trailhead9.ub20k5i9t8ou@example.com"}, thirdRow);
                Assertions.assertArrayEquals(new String[]{"150000", "2016-03-01", "Chris Riley", "trailhead9.ub20k5i9t8ou@example.com"}, fourthRow);
                Assertions.assertArrayEquals(new String[]{"150000", "2016-01-01", "Harold Campbell", "trailhead14.jibpbwvuy67t@example.com"}, fifthRow);
            }


        }
    }
}

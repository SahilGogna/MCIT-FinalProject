package util;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.util.stream.Collectors;

import hadoop.HdfsWriter;
import model.EnrichedStationInformation;
import org.apache.hadoop.fs.Path;

public class FileWriter {

    static String localFilePath = "/Users/sahilgogna/Documents/Big Data College/sprint2.csv";

    private static void writeToHdfs() throws IOException {
        String outputFolderPath = "/user/fall2019/sahilgogna/sprint2";

        org.apache.hadoop.fs.FileSystem fileSystem = HdfsWriter.getHdfs();

        boolean contains = fileSystem.exists(new org.apache.hadoop.fs.Path(outputFolderPath));
        if (contains) {
            fileSystem.delete(new Path(outputFolderPath), true);
        }
        fileSystem.mkdirs(new Path(outputFolderPath));
        fileSystem.copyFromLocalFile(new Path(localFilePath), new Path(outputFolderPath));
    }

    public static void writeToLocalFs(java.util.Map<String, EnrichedStationInformation> map) throws IOException {
        java.io.File file = new java.io.File(localFilePath);
        java.io.FileWriter fileWriter = new java.io.FileWriter(file);
        CSVWriter writer = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);

        String[] csvSchema = {
                "station_id",
                "external_id",
                "name",
                "short_name",
                "lat",
                "lon",
                "rental_methods",
                "capacity",
                "electric_bike_surcharge_waiver",
                "is_charging",
                "eightd_has_key_dispenser",
                "has_kiosk",
                "system_id",
                "language",
                "system_name",
                "system_short_name",
                "operator",
                "url",
                "start_date",
                "phone_number",
                "email",
                "license_url",
                "timezone"
        };

        writer.writeNext(csvSchema);
        for (String key : map.keySet()) {
            EnrichedStationInformation entry = map.get(key);
            String[] data = {
                    entry.getStationInformationEntity().getStation_id(),
                    entry.getStationInformationEntity().getExternal_id(),
                    entry.getStationInformationEntity().getName(),
                    entry.getStationInformationEntity().getShort_name(),
                    String.valueOf(entry.getStationInformationEntity().getLat()),
                    String.valueOf(entry.getStationInformationEntity().getLon()),
//                    entry.getStationInformationEntity().getRental_methods().toString(),
                    entry.getStationInformationEntity().getRental_methods().stream().collect(Collectors.joining("|", "", "")),
                    String.valueOf(entry.getStationInformationEntity().getCapacity()),
                    String.valueOf(entry.getStationInformationEntity().isElectric_bike_surcharge_waiver()),
                    String.valueOf(entry.getStationInformationEntity().isIs_charging()),
                    String.valueOf(entry.getStationInformationEntity().isEightd_has_key_dispenser()),
                    String.valueOf(entry.getStationInformationEntity().isHas_kiosk()),
                    String.valueOf(entry.getSystemInformationEntity().getSystem_id()),
                    String.valueOf(entry.getSystemInformationEntity().getLanguage()),
                    String.valueOf(entry.getSystemInformationEntity().getName()),
                    String.valueOf(entry.getSystemInformationEntity().getShort_name()),
                    String.valueOf(entry.getSystemInformationEntity().getOperator()),
                    String.valueOf(entry.getSystemInformationEntity().getUrl()),
                    String.valueOf(entry.getSystemInformationEntity().getStart_date()),
                    String.valueOf(entry.getSystemInformationEntity().getPhone_number()),
                    String.valueOf(entry.getSystemInformationEntity().getEmail()),
                    String.valueOf(entry.getSystemInformationEntity().getLicense_url()),
                    String.valueOf(entry.getSystemInformationEntity().getTimezone())
            };
            writer.writeNext(data);
        }
        writer.close();
        writeToHdfs();
    }
}

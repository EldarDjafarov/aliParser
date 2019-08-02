package parser.massParser;

import parser.connector.ConnectorToAliexpress;
import parser.connector.IConnector;
import parser.mapper.CsvMapper;
import parser.mapper.IMapper;
import parser.mapper.JsonAliexpressMapper;
import parser.reader.AliexpressReader;
import parser.reader.IReader;

public class AliexpressMassParser {
    private IConnector connector = new ConnectorToAliexpress();
    private IReader reader = new AliexpressReader(connector);
    private IMapper mapper = new JsonAliexpressMapper(reader);
    private CsvMapper csvMapper = new CsvMapper(mapper);

    public void massParse(int n){
        for (int i = 0; i <n ; i++) {
            csvMapper.writeToCSV();
            //every +12 offset give us 12 more products. P.S. see ConnectorToAliexpress class;
          connector.setOffset(connector.getOffset()+12);


        }

    }
}

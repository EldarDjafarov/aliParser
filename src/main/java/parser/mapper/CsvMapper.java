package parser.mapper;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import parser.goods.Product;

import java.io.FileWriter;

public class CsvMapper {

    private IMapper mapper;
    private static final String CSV_SEPARATOR = ",";
    public   void writeToCSV(){
    // name of generated csv
    final String CSV_LOCATION = "/home/el/Downloads/ProductList2.csv ";

        try {

        // Creating writer class to generate
        // csv file
        FileWriter writer = new
                FileWriter(CSV_LOCATION);
        // Create Mapping Strategy to arrange the
        // column name in order
        ColumnPositionMappingStrategy mappingStrategy=
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Product.class);

        // Arrange column name as provided in below array.
        String[] columns = new String[]
                { "productId", "sellerId", "sellerId", "productDetailUrl",
                "productTitle", "minPrice", "maxPrice", "oriMinPrice", "oriMaxPrice", "discount",
                "promotionId", "startTime", "endTime", "phase", "orders", "shopUrl", "trace","shopName", "totalStock",
                        "stock", "soldout"};
        mappingStrategy.setColumnMapping(columns);

        // Createing StatefulBeanToCsv object
        StatefulBeanToCsvBuilder<Product> builder=
                new StatefulBeanToCsvBuilder(writer);
        StatefulBeanToCsv beanWriter =
                builder.withMappingStrategy(mappingStrategy).build();

        // Write list to StatefulBeanToCsv object
        beanWriter.write(mapper.makeListOfProductsFromString());

        // closing the writer object
        writer.close();
    }
        catch (Exception e) {
        e.printStackTrace();
    }

}
    public CsvMapper(IMapper mapper) {
        this.mapper = mapper;
    }
}
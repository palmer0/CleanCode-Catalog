package es.ulpgc.eite.cleancode.catalog.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CatalogRepository implements RepositoryContract {

  List<String> categories = Arrays.asList(
      "Actividades de aventura",
      "Excursiones Guiadas",
      "Excursiones en barco",
      "Parques temáticos"
  );

  List<List<String>> products = Arrays.asList(
      Arrays.asList(
          "Alquiler de kayaks en Gran Canaria",
          "Alquiler de motos de agua",
          "Pesca deportiva en barco",
          "Paseo submarino con escafandra",
          "Paseo en caballo",
          "Excursión en camello",
          "Excursión en jeep"
      ),
      Arrays.asList(
          "Autobús turístico",
          "VIP Tour en minibus",
          "Visita al mercadillo",
          "Excursión al Loro Parque"
      ),
      Arrays.asList(
          "Excursión para ver delfines en catamaran",
          "Viaje en el submarino amarillo",
          "Pesca deportiva en barco",
          "Excursión en barco chill out",
          "Fiesta en catamaran"
      ),
      Arrays.asList(
          "Sioux City",
          "Palmitos Park Maspalomas",
          "Parque acuático Maspalomas"
      )

  );

  List<List<String>> details = Arrays.asList(
      Arrays.asList(
          "Pasea en kayak por la costa de Gran Canaria visitando las cuevas y acantilados cercanos a las playas de Taurito y Mogán.",
          "Alquila una moto de agua y disfruta surcando las olas y descargando adrenalina en las relajantes playas de Taurito y Mogan.",
          "Disfruta de un emocionante día de pesca en Gran Canaria para capturar marlins, atunes, barracudas, besugos, bonitos,...",
          "Explora el mundo submarino de manera fácil y segura, sin la necesidad de invertir tiempo en entrenamiento especializado y llévate un recuerdo para toda la vida.",
          "Disfruta al montar a caballo por agradables rutas en Gran Canaria, atravesando senderos que llegan hasta montañas y hasta la misma playa.",
          "Disfruta de un agradable paseo de una hora por el impresionante Barrando de Fataga en un ambiente en el que se mezclan la relajación y la diversión.",
          "Disfruta de un día de aventura y naturaleza con nuestra excursión en jeep y conoce lugares y paisajes sólo accesibles en 4x4."
      ),
      Arrays.asList(
          "Descubre Las Palmas de Gran Canaria a tu ritmo, subiéndote y bajándote del autobús en los lugares que más te interesen para conocer los lugares emblemáticos de la ciudad.",
          "Descubre en minibus lugares emblemáticos de Gran Canaria y rincones preciosos inaccesibles para las excursiones en autobús.",
          "Disfruta de una excursión al centro de la isla para conocer Teror y San Mateo y disfrutar de sus mercadillos",
          "Conoce y disfruta de Loro Parque de la manera más rápida, cómodo y tranquila desde la puerta de tu hotel de Gran Canaria."
      ),
      Arrays.asList(
          "Disfruta de una excursión en uno de los catamaranes mejores del mundo para ver delfines y otros cetáceos en Gran Canaria. Avistamiento garantizado.",
          "Disfruta en el Submarino Amarillo de un emocionante viaje a 20 metros de profundidad.",
          "Disfruta de un emocionante día de pesca en Gran Canaria para capturar marlins, atunes, barracudas, besugos, bonitos,...",
          "Disfruta de uno de los mejores momentos de tus vacaciones en Gran Canaria en una excursión relajante por la costa y una preciosa puesta de sol",
          "Disfruta de la mejor fiesta en barco de Gran Canaria organizada por las discotecas Pacha y Mtv, con capacidad máxima de 240 personas."
      ),
      Arrays.asList(
          "Pasa un inolvidable día en una ciudad del oeste americano. Disfruta de espectáculos durante todo el día.",
          "Disfruta de impresionantes espectáculos de delfines, aves exóticas y rapaces, papagayos y una amplia variedad de mamíferos, aves, reptiles y peces.",
          "Diviértete pasando un día en el mejor parque acuático de Gran Canaria. Tírate por los 40 toboganes, relájate en el rio lento y disfruta en la piscina con olas."
      )
  );
  
  private static CatalogRepository INSTANCE;

  private final List<CategoryItem> itemList = new ArrayList<>();

  public static RepositoryContract getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogRepository();
    }

    return INSTANCE;
  }

  private CatalogRepository() {
    // Add some sample items.
    for (int index = 0; index < categories.size(); index++) {
      addCategory(createCategory(index));
    }
  }

  private CategoryItem createCategory(int position) {

    CategoryItem item = new CategoryItem(position, categories.get(position));

    for (int index = 0; index <  products.get(position).size(); index++) {
      addProduct(item.items, createProduct(item.id, index));
    }

    return item;
  }


  private ProductItem createProduct(int index, int position) {
    String content = products.get(index).get(position);

    return new ProductItem(
        position, content, details.get(index).get(position)
    );

  }


  @Override
  public List<ProductItem> getProductList(int id) {
    for (int index = 0; index < categories.size(); index++) {
      CategoryItem item = itemList.get(index);

      if(item.id == id) {
        return item.items;
      }
    }

    return new ArrayList<>();
  }

  @Override
  public List<CategoryItem> getCategoryList() {
    return itemList;
  }


  private void addCategory(CategoryItem item) {
    itemList.add(item);
  }


  private void addProduct(List<ProductItem> itemList, ProductItem item) {
    itemList.add(item);
  }

}

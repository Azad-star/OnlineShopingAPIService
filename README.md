🛒 Online Shopping API Service

Bu proje, modern bir e-ticaret sisteminin temel ihtiyaçlarını karşılamak üzere geliştirilmiş, Spring Boot tabanlı bir RESTful API servisidir. Proje kapsamında kullanıcı yönetimi, satıcı ve dükkan ilişkileri, ürün yönetimi ve güvenlik katmanları entegre edilmiştir.


🚀 Kullanılan Teknolojiler

      Java 25 & Spring Boot 3.5.x

      Spring Data JPA (PostgreSQL veritabanı yönetimi için)

      Spring Security & JWT (Güvenli kimlik doğrulama ve yetkilendirme)

      Lombok (Boilerplate kodları azaltmak için)

      Maven (Bağımlılık yönetimi)

      SWAGER (Servis ve URL adresleri görüntüleme ve çalıştırma) NEW!!!

      PostgreSQL (İlişkisel veritabanı)



🏗️ Veritabanı Mimarisi
Sistemde nesneler arasındaki ilişkiler (One-to-Many, Many-to-Many) titizlikle kurgulanmıştır. Temel tablolar şunlardır:

    1. Kullanıcı ve Yetkilendirme (Identity)
      User: Sisteme giriş yapabilen tüm kullanıcıların (Username, Password, CreateTime) temel          bilgilerini tutan ana tablo.

      Customer (Müşteri): Alışveriş yapan son kullanıcıları temsil eder. Her müşteri, kendine          ait bir Basket (Sepet) ile ilişkilendirilmiştir.

      Seller (Satıcı): Ürün tedarik eden ve dükkan yöneten profesyonel kullanıcılar. Satıcılar,        birden fazla dükkan ile SellerShop üzerinden ilişkilidir.

    2. Dükkan ve Satış Yönetimi
      Shop (Dükkan): Ürünlerin sergilendiği sanal mağazalar.

      SellerShop: Satıcılar ile dükkanlar arasındaki ilişkiyi yöneten ara tablo. Bir satıcının         birden fazla dükkanı, bir dükkanın ise birden fazla ortağı/satıcısı olabilir.

      ShopProduct: Dükkanlar ve ürünler arasındaki "Many-to-Many" ilişkiyi kuran kritik tablo.         Hangi ürünün hangi dükkanda yer aldığı bilgisini tutar.

    3. Ürün ve Katalog Yönetimi
      Product (Ürün): Ürün adı, fiyatı, stok durumu ve kategori bilgilerini içeren temel tablo.

      Category (Kategori): Ürünlerin hiyerarşik olarak gruplandırılmasını sağlar.

    4. Sepet ve Sipariş Öncesi Süreç
     Basket (Sepet): Her müşteriye özel olarak oluşturulan ve alışveriş sürecini yöneten merkez.

     BasketProduct: Sepetler ile ürünler arasındaki ilişkiyi yöneten ara tablo. Müşterinin            sepetine eklediği her bir ürünü takip eder.


🔑 Öne Çıkan Özellikler

      Gelişmiş İlişki Yönetimi: JPA ve Hibernate kullanarak kurulan One-to-Many (Kullanıcı-            Sepet) ve Many-to-Many (Sepet-Ürün, Dükkan-Ürün) ilişkileri ile karmaşık veritabanı şeması       yönetimi.

      Transaction Yönetimi: Ürün ekleme ve sepet işlemlerinde veri bütünlüğünü korumak için            @Transactional kullanımı.
      
      Güvenli Şifreleme: Satıcı şifreleri BCryptPasswordEncoder ile hash'lenerek güvenli bir           şekilde saklanır.

      Dinamik Hata Yönetimi: Projeye özel BaseException ve MessageType yapısı ile hata mesajları       yönetilir.

      DTO Tasarım Kalıbı: Entity nesnelerinin doğrudan dış dünyaya açılmasını önlemek için DTO         (Data Transfer Object) kullanımı.

      Validasyon Kontrolleri: Ürün ekleme işlemlerinde sellerId, shopId ve şifre doğrulaması           gibi iş mantığı kontrolleri.



🛠️ Kurulum ve Çalıştırma

      1. Projeyi klonlayın:

            Bash

            git clone https://github.com/Azad-star/OnlineShopingAPIService.git

      2. src/main/resources/application.properties dosyasındaki PostgreSQL bağlantı bilgilerini
       kendinize göre güncelleyin.

      3. Maven bağımlılıklarını yükleyin:

            Bash

            mvn clean install

      4. Uygulamayı çalıştırın.
